package com.app.dao;

import java.time.LocalDate;
import java.util.List;

import com.app.pojos.Vendor;

public interface IVendorDao {
	//register vendor
//	String registerVendor(Vendor v);
	//Vendor Login : to do
	
Vendor authenticateUser(String email,String password); 
	
	
	//List all vendors , registered after specific reg date & reg amount < specified amt.
	//List<Vendor> listSpecificVendors(LocalDate regDate,double amount);
	//Offer discount to all vendors registered before specific date
	//List<Vendor> applyDiscount(double discount,LocalDate date);

// add method to list all vendors
 
 List<Vendor> listAllVendors();
 
 String deleteVendorDetails(int vendorId); 
 
 // add a method to register new vendor 
 String addVendor(Vendor vendor); // i/p : transient POJO 
 
 
}
