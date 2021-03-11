package com.app.service;

import java.util.List;

import com.app.pojos.Vendor;

public interface IVendorService {

	Vendor authenticateUser(String email,String password); 
    List<Vendor> listAllVendors();
    
    String deleteVendorDetails(int vendorId); 
   
    String addVendor(Vendor vendor);
}
