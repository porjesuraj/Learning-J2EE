package org.app.dao;

import org.app.pojos.Vendor;
import org.hibernate.SessionFactory;



public class VendorDaoImpl implements IVendorDao {

	
	private SessionFactory factory  ;
	
	@Override
	public Vendor authenticateUser(String email, String password) {
		
		Vendor v =null;
		String jpql = "select v from Vendor where v.email=:em and v.password=:pass"; 
		
		v = factory.getCurrentSession()	
				.createQuery(jpql, Vendor.class)
				.setParameter("em", email)
                .setParameter("pass", password)	
                .getSingleResult(); 
		
		
		
		
		return v;// dao layer is returning PERSISTENT vendor pojo to service 
	}

}
