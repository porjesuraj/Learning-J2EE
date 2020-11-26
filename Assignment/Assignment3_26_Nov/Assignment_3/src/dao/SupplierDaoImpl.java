package dao;

import pojos.Supplier;

import org.hibernate.*;

import static utils.HibernateUtils.getSf;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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

	@Override
	public List<Supplier> getAllSupplier(LocalDate date, double regAmount) {
	
		List<Supplier> suppliers = null;
	String jpql = "select s from Supplier s where s.regDate > :dt and s.regAmount < :amt"; 
		
		//String jpql = "select s from Supplier s where s.regAmount < amt"; 
		   Session session = getSf().getCurrentSession();
			
		    // begin trans 
		    
		  Transaction tx = session.beginTransaction(); 
		
		try {
			
			 
			suppliers = session.createQuery(jpql,Supplier.class)
			  .setParameter("dt",date )
			  .setParameter("amt",regAmount)
			  .getResultList();
			
			tx.commit();
		} catch (HibernateException e) {
		
			if(tx != null)
				tx.rollback();
			throw e; 
		}
		
		
		
		
		return suppliers;
	}

}
