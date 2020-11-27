package dao;


import java.io.IOException;
import java.util.Date;
import java.util.List;

import pojos.Role;
import pojos.User;

public interface IUserDao {

	
	//add a method for user registeration 
	
	String registerUser(User user); 
	// add a method to fetch user details by its ID 
	
	User fetchUserDetails(int userId);  
	
	// add a method to fetch all user details 
	
	List<User> fetchAllUserDetails(); 
	
	
	// add method to fetch selected user details 
	
	List<User> fetchSelectedUserDetails(java.util.Date strtDate,Date endDate,Role userRole); 
	
	
	// display all user names reg between strt date and end date and role 
	
	
	List<String> fetchSelectedUserName(java.util.Date strtDate,Date endDate,Role userRole); 
	
	
	// Display all user names,reg amount,reg date registered between strt date n end
		// date & under a specific role
		List<User> fetchSelectedDetails(Date strtDate, Date endDate, Role userRole);
	
	// change password : where user email , old password , new password 
		
		String changePassword(String email, String oldPwd,String newPwd); 
	
		// day 9
		
		
		//add method to  Un subscribe user : i/p  : email n password
		String unsubscribeUser(String email,String password);
		// Apply discount to reg amount , for all users , reged before a specific date. (via bulk update)
		String bulkUpdateUsers(Date date, double discount);

    // add method to understand save vs persist vs saveOrUpdate
		
		String testSessionApi(User user ); 

		
		// add method to store binary image for Existing user 
		
		// inputs : used id, file 
		
		String saveImage(int userId,String fileName) throws Exception; 
		
		
		
}



	
	
	
	

