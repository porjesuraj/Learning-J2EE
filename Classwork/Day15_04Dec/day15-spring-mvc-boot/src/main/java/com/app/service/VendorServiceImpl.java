package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IVendorDao;
import com.app.pojos.Vendor;

@Service // mandetory annotation to tell SC whatever follows contains B.L 
@Transactional // Mandetory : annotation to tell SC to use tx mgr bean for
// automatically handlin txs. 
public class VendorServiceImpl implements IVendorService {

	// dependency : DAO layer 
	@Autowired
	private IVendorDao vendorDao ; 
	
	@Override
	public Vendor authenticateUser(String email, String password) {
		// simply invoke dao's method for user authentication 
		
		
		
		return vendorDao.authenticateUser(email, password);
	}

	@Override
	public List<Vendor> listAllVendors() {
		
		
		return vendorDao.listAllVendors();
	}

	@Override
	public String deleteVendorDetails(int vendorId) {
		
		return vendorDao.deleteVendorDetails(vendorId);
	}

	@Override
	public String addVendor(Vendor vendor) {
		
		return vendorDao.addVendor(vendor);
	} // JPA implementor with Spring : (Hibernate) : performs auto dirty checking : 
	// insert query fired , entity manager : closed 

}
