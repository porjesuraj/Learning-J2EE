package beans;

import dao.VendorDaoImpl;
import pojos.Role;
import pojos.Vendor;

public class VendorBean {

	
	private String email; 
	
	private String password;
	
	// manage dao 
	private VendorDaoImpl vendorDao;
	
	// add a property to stored validated user details 
	private Vendor validatedDetails; 
	
	// add a property to incdicate status 
	
	private String message;
	
	// default constructor 
	
	public VendorBean() {
	System.out.println("in constructor  of" + getClass().getName());	
	vendorDao = new VendorDaoImpl(); 
	}
	// setter and getter
	
	
	
	
	
	public String getEmail() {
		return email;
	}

	public String getMessage() {
		return message;
	}





	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public VendorDaoImpl getVendorDao() {
		return vendorDao;
	}

	public void setVendorDao(VendorDaoImpl vendorDao) {
		this.vendorDao = vendorDao;
	}

	public Vendor getValidatedDetails() {
		return validatedDetails;
	}

	public void setValidatedDetails(Vendor validatedDetails) {
		this.validatedDetails = validatedDetails;
	}
	

	// Add B.L method  :to authenticate user and return dynamic navigational outcome 
	
	
	public String validateUser() {
		
		System.out.println("in validate user " + email + password);
	
		// invode dao method : check for runtime exception 
		try {
			validatedDetails =  vendorDao.authenticateUser(email, password);
			
			// valid Login : check role 
			
			message = "Login successful";
			if(validatedDetails.getUserRole().equals(Role.ADMIN))
				return "admin" ; 
			
			return "vendor_details"; 
			
			
		} catch (RuntimeException e) {
			System.out.println("error in bean " + e);
		 // => implies invalid login 
			
			message = "Invalid Login,Please retry ... ";
			return "login"; 
		}
		
		
		
	
	
	 
	
	}
	
	
}
