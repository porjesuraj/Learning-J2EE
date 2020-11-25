package dao;

import pojos.User;

import static utils.HibernateUtils.getSf;
import org.hibernate.*;
// below is native hibernate based DAO layer (completely hibernate specific ) 



public class UserDaoImpl implements IUserDao {

	@Override
	public String registerUser(User user) {
	
		String message = "User registration failed...";
		// 1. get hibernate session from session Factory: opensession / getCurrentSession()
		
		Session session = getSf().openSession(); 

		// 2. begin a transaction : as recommended as any operation in hb should be in transaction
		
		Transaction tx = session.beginTransaction(); // pools out DB connection,wraps db conn in Session 
		// L1 cache associated with session : created in empty manner 
		
		
		try {
			// operation save : insert
			session.save(user); 
			// success : commit transaction  
			tx.commit(); // automatic dirty checking 
			message = "user registeration  successfully with ID" + user.getUserId(); 
			
		} catch (HibernateException e) {
			
			if(tx != null)
			tx.rollback();
			// inform /alert the caller about exception  :rethrow the same exception to caller(main() tester)
			 throw e; 
			
		}finally {
			if(session != null)
			session.close(); // L1 cache destroyed and n pooled out DB conn returnds to conn pool 
			// so that same DB connection can be reused for another request 
			
			
		}
		return message;
		
		
		
	}
}
