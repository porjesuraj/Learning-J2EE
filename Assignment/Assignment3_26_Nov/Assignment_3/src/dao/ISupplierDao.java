package dao;

import java.time.LocalDate;
import java.util.List;

import pojos.*;

public interface ISupplierDao {

	Supplier authenticate(String email,String pwd); 
	
	
	List<Supplier> getAllSupplier(LocalDate date,double regAmount); 

}
