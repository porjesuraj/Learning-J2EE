package dao;

import pojos.Role;
import pojos.User;

import org.apache.commons.io.FileUtils;
import org.hibernate.*;
import org.hibernate.dialect.identity.SybaseAnywhereIdentityColumnSupport;

import static utils.HibernateUtils.getSf;

import java.io.File;
import java.util.Date;
import java.util.List;

public class UserDaoImpl implements IUserDao {

	
	@Override
	public String registerUser(User user) {
	
		String msg = "User reg failed";
		
		// instance of  user  :TRANSIENT (not in L1 cache and not in DB) :EXISTS  only in java heap 
		
		
		//1 .get session from sf  :openSession 
		Session session = getSf().getCurrentSession();   // new session , empty cache 
	    Session session2 = getSf().getCurrentSession();
	    
	    System.out.println(session == session2); // true  
		//2. start/begin  transaction  , managed by programmer
		
	  Transaction tx = session.beginTransaction(); 
	  // db conn is pooled out and wrapped in session n returned to the caller 
	  // Empty L1 cache is created, empty 
 System.out.println("after begin tx : session open "+session.isOpen()+" conn "+session.isConnected());//true true
	  
	  // 3.try catch block for trans
	  
	  try {
		  // insert new users info 
		 
		Integer id =  (Integer) session.save(user); // user : PERSISTENT (only added in L1 cache  : not yet part of DB  
		  System.out.println("generated id " + id);
		  
		  tx.commit(); //at the time of commit, Hibernate performs : automatic dirty checking(check state of L1, DB)
		  //after check as user ref not in db: insert query fired: to synch state of L1 cache with DB 
		  // session is implicitely closed here i.e db conn returns to pool and L1 cache is destroyed
		msg = "User registered with ID" + id; 
	System.out.println("after commit tx : session open "+session.isOpen()+" conn "+session.isConnected());// false false 
	} catch (HibernateException e) {
		// TODO: handle exception
		// roolback trx n re throw the exc to the caller 
	
		
		if(tx != null)
		{
			tx.rollback();
			// session is implicitely closed here i.e db conn returns to pool and L1 cache is destroyed
		}
		throw e; 
	}
	  System.out.println(" before returning from dao : session open "+session.isOpen()+" conn "+session.isConnected());//false false 
	  
	  
		return msg; // user : DETACHED : here L1 cache user is destroyed , but it exists in DB
	}

	@Override
	public User fetchUserDetails(int userId) {
	    User u = null; // u  :Not applicable 
		// get session 
		
		Session session = getSf().getCurrentSession(); 
		
		 Transaction tx = session.beginTransaction(); 
		
		 try {
			 // Session API : Tget(Class<T> class,Serializable id) 
			 u = session.get(User.class,userId); // int datatype of userId : --> Integer(auto boxing) ---> Serializable (up casting)
			 // u: in case of valid id, u : PERSISTENT 
			 
			 u = session.get(User.class,userId);
			 
			 u = session.get(User.class,userId);
			 
			 tx.commit();
			// perform auto dirty checking, and L! and DB same : no queries fired , db conn returns the pool iand L1 cache is destroyed
		} catch (HibernateException e) {
			// TODO: handle exception
			
			if(tx != null)
			tx.rollback();// db conn returns to the pool and L1 cache is destroyed
			throw e; 
		}
		 
		return u; // u  :DETACHED
	}

	@Override
	public List<User> fetchAllUserDetails() {
		
		// getting session from session factory 
		
		String jpql = "select u from User u ";
		List<User> users = null; // ussers  :null
		Session session = getSf().getCurrentSession();
		
		// begin trans 
		Transaction tx = session.beginTransaction();
		
		try {
			// create query from session and execute the same 
			users = session.createQuery(jpql, User.class).getResultList(); 
			// users : list of Persistent pojo  
			/*
			 * users = session.createQuery(jpql, User.class).getResultList(); users =
			 * session.createQuery(jpql, User.class).getResultList();
			 */
			// here 3 times select is called , not take it from L1 cache 
			tx.commit(); // 
			
		} catch (Exception e) {
			// TODO: handle exception
			
			if(tx != null)
				tx.rollback(); // l1 cache destroed and db conn returned to pool
		}
		
		return users;// users  : list of Detached pojos  : i.e detached from l1 cache that is destroyed on commit 
	}

	// Display all users registered between strt date n end date & under a specific role
		@Override
		public List<User> fetchSelectedUserDetails(Date strtDate, Date endDate, Role userRole) {
			List<User> users = null;
			String jpql = "select u from User u where u.regDate between :start and :end and u.role=:rl";
			// get session from SF
			Session session = getSf().getCurrentSession();
			// begin tx
			Transaction tx = session.beginTransaction();
			try {
				users = session.createQuery(jpql, User.class)
						.setParameter("start", strtDate).
						setParameter("end", endDate)
						.setParameter("rl", userRole).getResultList();
				// users : list of persistent pojos/entities
				tx.commit();
			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();// db cn rets to the pool n L1 cache is destroyed.
				throw e;
			}
			return users;
		}
		
		
	@Override
	public List<String> fetchSelectedUserName(Date strtDate, Date endDate, Role userRole) {

		// getting session from session factory 
		List<String> users = null;
		/*
		 * this.name = name; this.email = email; this.password = password;
		 * this.confirmPassword = confirmPassword; this.role = role; this.regAmount =
		 * regAmount; this.regDate = regDate;
		 */
		
		String jpql = "select u.name from User u where u.regDate between :start and :end and u.role=:rl";
				Session session = getSf().getCurrentSession();
				
				// begin trans 
				Transaction tx = session.beginTransaction();
				
				try {
					users = session.createQuery(jpql, String.class).setParameter("start", strtDate).setParameter("end", endDate).setParameter("rl", userRole).getResultList(); 
					
					// user : list of persistent pojos /entites 
					
					
					tx.commit();
				} catch (Exception e) {
					// TODO: handle exception
					
					if(tx != null)
						tx.rollback();
				}
				
				return users;
	}

	@Override
	public List<User> fetchSelectedDetails(Date strtDate, Date endDate, Role userRole) {
		List<User> users = null;
		String jpql = "select new pojos.User(name,regAmount,regDate) from User u where u.regDate between :start and :end and u.role=:rl";
		// get session from SF
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, User.class).setParameter("start", strtDate).
					setParameter("end", endDate)
					.setParameter("rl", userRole).getResultList();
			// users : list of persistent pojos/entities
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();// db cn rets to the pool n L1 cache is destroyed.
			throw e;
		}
		return users;//users : list of detached pojos/entities
	}
	
	@Override
	public String changePassword(String email, String oldPwd, String newPwd) {
		
		String msg = "password change failed";
		
		String jpql = "select u from User u where u.email=:em and u.password=:pass";
		// session 
		
		Session session = getSf().getCurrentSession(); 
		
		// begin  trans
		User u =  null;
		Transaction tx = session.beginTransaction(); 
		
		try {
			// create session query  ,set IN params ,get single result 
			
			 u = session.createQuery(jpql, User.class)
					.setParameter("em", email)
					.setParameter("pass", oldPwd)
					.getSingleResult();
			
			// in case of valid credentials method returns : PERSISTENT POJO reference 
			
			// no null checking is required : since methods throws exception in case no reuslt found 
			// u : PERSISTENT : exist in L1 cache , exist in DB
			u.setPassword(newPwd); // abcd : modifying state of Persistent POJo 
			
		
			tx.commit(); // hb  perform auto dirty checking : detects change : update,session close 
			// db conn returnds to the pool, L1 cache is destroyed 
			
			msg = "password changed successfully"; 
			
			
		} catch (Exception e) {
			if(tx != null)
		    tx.rollback();
		}
		
		// u: DETACHED : hibernate does not propogate the changes done to state of detached pojo 
		u.setPassword(newPwd.toUpperCase()); // ABCD 
		
		return msg;
	}
	
	@Override
	public String unsubscribeUser(String email, String password) {
		String mesg="User un subscription failed...";
		// add jpql : to authenticate user
		String jpql = "select u from User u where u.email=:em and u.password=:pass";
		// session
		Session session = getSf().getCurrentSession();
		// tx
		Transaction tx = session.beginTransaction();
		try {
			// validate user
			User u = session.createQuery(jpql, User.class).setParameter("em", email).
					setParameter("pass", password)
					.getSingleResult();
			//u : PERSISTENT
			//Session API : public void delete(Object o)
			session.delete(u);//u : is marked for removal, neither  gone from L1 cache nor DB : REMOVED
			tx.commit();//dirty chking : delete query , session is closed : db cn rets to the pool , L1 cache is destroyed 
			//entity is removed from cache
			mesg="User "+u.getName()+" un subscribed...";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();// session closed
			// --db cn rets to the pool , L1 cache is destroyed
			throw e;
		}
		// u : TRANSIENT : exists only in java heap
		return mesg;
	}// user object is marked for garbage collection

	@Override
	public String bulkUpdateUsers(Date date, double discount) {
		String mesg="bulk updation failed...";
		//1 : update jpql
		String jpql="update User u set u.regAmount=u.regAmount-:disc where u.regDate < :dt";
		//session
		Session session=getSf().getCurrentSession();
		//tx
		Transaction tx=session.beginTransaction();
		try {
			int updateCount=session.createQuery(jpql).
					setParameter("disc", discount).setParameter("dt", date).executeUpdate();
			tx.commit();//update query , empty L1 cache is destroyed , cn rets to the pool.
			mesg=updateCount+" users updated...";
		}catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();// session closed
			// --db cn rets to the pool , L1 cache is destroyed
			throw e;
		}
		return mesg;
	}
	
	@Override
	public String testSessionApi(User user) {
String msg = "User reg failed";
		
		// instance of  user  :TRANSIENT (not in L1 cache and not in DB) :EXISTS  only in java heap 
		
		
		//1 .get session from sf  :openSession 
		Session session = getSf().getCurrentSession();   // new session , empty cache 
	   
	  Transaction tx = session.beginTransaction(); 
	  
	  // 3.try catch block for trans
	  
	  try {
		  // insert new users info 
		 
		//session.persist(user);; // user : PERSISTENT (only added in L1 cache  : not yet part of DB  
		  session.saveOrUpdate(user);
		  
		  System.out.println("generated id " + user.getUserId());
		  
		  tx.commit(); 
		  
		msg = "User registered with ID" + user.getUserId(); 
	
	} catch (RuntimeException e) {
		// TODO: handle exception
		// roolback trx n re throw the exc to the caller 
	
		
		if(tx != null)
		{
			tx.rollback();
			// session is implicitely closed here i.e db conn returns to pool and L1 cache is destroyed
		}
		throw e; 
	}
	
	  
	  
		return msg; // user : DETACHED : here L1 cache user is destroyed , but it exists in DB
	}
	
	
	@Override
	public String saveImage(int userId, String fileName) throws Exception {
		String msg="Saving image failed....";
		//validate file : check if its readable existing data file 
		// create instance of java.io.File 
		
		File file = new File(fileName); 
		
		if(file.exists() && file.isFile() && file.canRead())
		{
			
			//session
			Session session=getSf().getCurrentSession();
			//tx
			Transaction tx=session.beginTransaction();
			try {
				User user = session.get(User.class,userId);
				
				if(user != null)
				{
					// user : Pers
					// method : read binary file and return s content it byte[] n closes file 
					user.setImage(FileUtils.readFileToByteArray(file));// modifying state of persistent pojo
					
					msg = "image saved to db ...";
				}
				
				tx.commit(); // hibernate perform  auto dirty check : update query  :close session --> conn returnds to pool
			}catch (RuntimeException e) {
				if (tx != null)
					tx.rollback();// session closed
				// --db cn rets to the pool , L1 cache is destroyed
				throw e;
			}
			
		}
		
		
		return msg;
	}
	@Override
	public String restoreImage(int userId, String fileName) throws Exception {
		String mesg = "Restoring image failed....";
		//Session
		Session session=getSf().getCurrentSession();
		//tx
		Transaction tx=session.beginTransaction();
		try {
			//get user details from id
			User user=session.get(User.class, userId);
			if(user != null) {
				//user : PESRSISTENT
				//gets image from user POJO in byte[] form n creates a new file if none exists n write bin data to it.
				FileUtils.writeByteArrayToFile(new File(fileName), user.getImage());
				mesg="Restored image succefully....";
			}
			tx.commit();
			
		} catch (Exception e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}
	
	
	
}
	
	


  















