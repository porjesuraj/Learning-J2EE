package org.app.service;

import org.app.dao.IVendorDao;
import org.app.pojos.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service // mandetory annotation to tell SC that what follows is B.L
@Transactional // mandetory : annotation to tell SC to 
// call tx manager bean for automatically  handle tx
public class VendorServiceImpl implements IVendorService{

	@Autowired
	private IVendorDao vendorDao; 
	
	@Override
	public Vendor authenticateUser(String email, String password) {
		
		
		return vendorDao.authenticateUser(email, password);
	}

	
}
