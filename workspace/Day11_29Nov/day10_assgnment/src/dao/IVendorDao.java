package dao;

import java.time.LocalDate;
import java.util.List;

import pojos.Vendor;

public interface IVendorDao {
	//register vendor
	String registerVendor(Vendor v);
	//Vendor Login 
	Vendor authenticateUser(String email,String password);
	//List all vendors , registered after specific reg date & reg amount < specified amt.
	List<Vendor> listSpecificVendors(LocalDate regDate,double amount);
	//Offer discount to all vendors registered before specific date
	List<Vendor> applyDiscount(double discount,LocalDate date);
}
