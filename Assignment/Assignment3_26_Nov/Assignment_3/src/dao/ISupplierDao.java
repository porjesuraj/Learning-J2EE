package dao;

import java.time.LocalDate;
import java.util.List;

import pojos.*;

public interface ISupplierDao {

	Supplier authenticate(String email,String pwd); 
	
	
	List<Supplier> getAllSupplier(LocalDate date,double regAmount); 

	 //Offer discount to all vendors registered before specific date
	 //i/p reg date n discount amount
	
	List<Supplier> applyDiscount(double discount,LocalDate regDate); 
}
