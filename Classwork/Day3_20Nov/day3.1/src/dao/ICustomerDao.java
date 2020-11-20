package dao;

import pojos.Customer;

public interface ICustomerDao {

	
	Customer authenticateCustomer(String email,String password) throws Exception ;
	
}
