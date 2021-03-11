package com.app.dao;

import java.util.List;
import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.app.pojos.Role;
import com.app.pojos.Vendor;

@Repository // spring bean containing data access logic : DI ,auto wiring supported
public class VendorDaoImpl implements IVendorDao {
// DAO : dependent Obj,dependency : javax.persistence.EntityManager
	//(equivalent to org.hibernate.SessionFactory)
	//@PersistenceContext 
	@Autowired
	private EntityManager entityManager; 
	
	@Override
	public Vendor authenticateUser(String email, String password) {
		Vendor v = null;
		String jpql = "select v from Vendor  v  where v.email=:em and v.password=:pass"; 

			v =  entityManager.createQuery(jpql, Vendor.class)
					.setParameter("em", email)
					.setParameter("pass", password)
					.getSingleResult(); 				
		return v; // dao layer is returning PERSISTENT vendor pojo to service 
	}


	@Override
	public List<Vendor> listAllVendors() {
		
		String jpql = "select v from Vendor v where v.userRole=:role ";
		
return entityManager.createQuery(jpql, Vendor.class).setParameter("role", Role.VENDOR).getResultList();

	}


	@Override
	public String deleteVendorDetails(int vendorId) {
		// first get PERSISTENT POJO ref from its id 
		// public T find(T class,Object uniqueId)
		String msg ="failed to Delete Vendor... ";
		Vendor v = entityManager.find(Vendor.class, vendorId); 
		
		if(v != null)
		{ 
			// v :PERSISTENT 
		// use Entity Manager : public void delete(Object persistent pojo reference) 
		
		entityManager.remove(v);
		}
		return "Successfully Deleted Vendor ...";
	}


	@Override
	public String addVendor(Vendor vendor) {
		// vendor : TRANSIENT : 
		
		 entityManager.persist(vendor); // PERSISTENT  part of L1 cache 
		 
		 return "Vendor successfully registered";
	}

}
