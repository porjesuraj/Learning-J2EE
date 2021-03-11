package dao;

import pojos.Customer;

public interface ICustomerDao {

	
	// add method for customer validation 
	
	Customer authenticateCustomer(String email,String pwd) throws Exception;
}
