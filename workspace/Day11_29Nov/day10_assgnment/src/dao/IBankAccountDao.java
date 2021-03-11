package dao;

import java.util.List;

import pojos.BankAccount;
import pojos.Vendor;

public interface IBankAccountDao {
//add method to list all bank account for a vendor
	List<BankAccount> getAllAccountsByVendorId(int vendorId);

	// create new account
	String createAccount(Vendor v, BankAccount a);
	//close account
	String closeAccount(Vendor v,int acctNo);
}
