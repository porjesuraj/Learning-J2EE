package beans;

import dao.VendorDaoImpl;
import pojos.Role;
import pojos.Vendor;

public class VendorBean {
	// properties
	private String email, password;
	// manage dao
	private VendorDaoImpl vendorDao;
	// add a property to stored validated user details
	private Vendor validatedDetails;
	// add a property to indicate status
	private String message;

	// def constr
	public VendorBean() {
		System.out.println("in constr of " + getClass().getName());
		// create dao instance
		vendorDao = new VendorDaoImpl();
	}

	// s/g
	public String getEmail() {
		return email;
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

	public String getMessage() {
		return message;
	}

	// add B.L method : to authenticate user n return dynamic navigational outcome
	public String validateUser() {
		System.out.println("in validate user " + email + " " + password);
		// invoke dao's method : chk for runtime exception
		try {
			validatedDetails = vendorDao.authenticateUser(email, password);
			// valid login : chk role
			message="Login successful";
			if (validatedDetails.getUserRole().equals(Role.ADMIN))
				return "admin";
			return "vendor_details";
		} catch (RuntimeException e) {
			System.out.println("err in bean " + e);
			// => invalid login
			message = "Invalid Login , Please retry....";
			return "login";
		}

	}

}
