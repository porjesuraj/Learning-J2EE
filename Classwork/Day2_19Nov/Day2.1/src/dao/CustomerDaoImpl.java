package dao;

import pojos.Customer;
import java.sql.*;

import static utils.DBUtils.fetchConnection;
public class CustomerDaoImpl implements ICustomerDao {

	// data members : instance variable 
	private Connection connection ; 
	private PreparedStatement pst1; 
	
	// add constructor 
	
	public CustomerDaoImpl() throws Exception {
      // get cn from db utils
		this.connection = fetchConnection(); 
		
      // created prepared n pre compiled stmt to hold validate query
	     this.pst1 = connection.prepareStatement("select * from my_customers where email=? and password=?"); 
     System.out.println("customer dao created... ");
	}
	
	@Override
	public Customer authenticateCustomer(String email, String pwd) throws Exception {
	//set iN para 
	pst1.setString(1, email);
	pst1.setString(2, pwd);

	
	try(ResultSet rs = pst1.executeQuery())
	{
		if(rs.next())
		return new Customer(rs.getInt("id"),email,pwd,rs.getDouble(4),rs.getDate(5)); 	
		
	}
	return null; 
		
		
		
	}
	// clean up of DB resources
	public void cleanUp() throws Exception {
		
		if(pst1 != null)
		pst1.close();
		
		if(connection != null)
		connection.close();
		
	System.out.println("customer dao cleaned up ...");
		
	}

}
