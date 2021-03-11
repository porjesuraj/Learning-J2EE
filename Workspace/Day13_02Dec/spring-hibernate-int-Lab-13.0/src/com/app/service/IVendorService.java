package com.app.service;

import com.app.pojos.Vendor;

public interface IVendorService {

	
	Vendor authenticateUser(String email,String password); 
	
}
