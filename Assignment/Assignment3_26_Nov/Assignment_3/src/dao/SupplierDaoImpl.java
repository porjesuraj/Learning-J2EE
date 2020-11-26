package dao;

import pojos.Supplier;

import org.hibernate.*;

import static utils.HibernateUtils.getSf;

public class SupplierDaoImpl implements ISupplierDao {

	@Override
	public Supplier authenticate(String email, String pwd) {
		Supplier sup = null;
		
	String jpql = "select s from Supplier s where s.email=:em and s.password=:pass";
	// get session from sf 
	    Session session = getSf().getCurrentSession();
	
	    // begin trans 
	    
	  Transaction tx = session.beginTransaction(); 
	 
	  try {
		  
		  sup = session.createQuery(jpql, Supplier.class)
				  .setParameter("em", email)
                  .setParameter("pass", pwd)
                  .getSingleResult();
				  
		  
		  tx.commit();
		
	} catch (HibernateException e) {
		// TODO: handle exception
		
		if(tx != null)
			tx.rollback();
		
		throw e; 
	}
		
		
		return sup;
	}

}
