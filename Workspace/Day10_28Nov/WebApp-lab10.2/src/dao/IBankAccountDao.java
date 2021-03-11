package dao;

import java.util.List;

import pojos.BankAccount;

public interface IBankAccountDao {

	// add method to list all bank account for a vendor 
	
	List<BankAccount> getAllAccountsByVendorId(int vendorId); 
	
	
	
}
