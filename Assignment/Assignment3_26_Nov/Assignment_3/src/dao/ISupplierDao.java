package dao;

import pojos.*;

public interface ISupplierDao {

	Supplier authenticate(String email,String pwd); 
	

}
