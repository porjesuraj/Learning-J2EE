package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import pojos.Customer;

import static utils.DBUtils.fetchConnection;

public class CustomerDaoImpl implements ICustomerDao {

	
	private Connection cn; 
	private PreparedStatement pst1; 
	
	public CustomerDaoImpl() throws Exception {
		// TODO Auto-generated constructor stub
		
		this.cn = fetchConnection(); 
		
		this.pst1 = cn.prepareStatement("select * from my_customers where email=? and password=?");
		System.out.println("customer dao created ...");
	}
	
	@Override
	public Customer authenticateCustomer(String email, String password) throws Exception {
		
		pst1.setString(1, email);
		pst1.setString(2, password);
	
		try(ResultSet rs = pst1.executeQuery())
		{
			if(rs.next())
				return new Customer(rs.getInt("id"),email,password,rs.getDouble(4),rs.getDate(5)); 		
		}
		
	return null;
	}
	
	
	public void cleanUp() throws Exception{
		
		if(pst1 != null)
			this.pst1.close();
		
		if(this.cn != null)
			this.cn.close();
		
		System.out.println("customer dao cleaned up ... ");
	}

}
