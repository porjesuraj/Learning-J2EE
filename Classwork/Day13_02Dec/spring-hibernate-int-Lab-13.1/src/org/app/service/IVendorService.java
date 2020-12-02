package org.app.service;

import org.app.pojos.Vendor;

public interface IVendorService {

	
	Vendor authenticateUser(String email,String password); 
	
}
