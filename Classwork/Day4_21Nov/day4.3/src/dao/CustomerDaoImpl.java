package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojos.Customer;
import static utils.DBUtils.fetchDBConnection;


public class CustomerDaoImpl implements ICustomerDao {
	//data members : instance vars
	private Connection cn;
	private PreparedStatement pst1;
	
	// constr
		public CustomerDaoImpl(String drvr,String url,String name,String pwd) throws ClassNotFoundException, SQLException {
			// get cn
			cn = fetchDBConnection(drvr,url,name,pwd);
			pst1 = cn.prepareStatement("select * from my_customers where email=? and password=?");
			System.out.println("cust dao created...");
		}

	

	@Override
	public Customer authenticateCustomer(String email, String pwd) throws Exception {
		// set IN params
		pst1.setString(1, email);
		pst1.setString(2, pwd);
		try(ResultSet rst=pst1.executeQuery())
		{
			if(rst.next())
				return new Customer(rst.getInt(1), email, pwd, rst.getDouble(4), rst.getDate(5));
		}
		return null;
	}
	
	//cleaning  up of DB resources
	public void cleanUp() throws Exception
	{
		if(pst1 != null)
			pst1.close();

		if(cn != null)
			cn.close();
		System.out.println("customer dao cleaned up...");
	}
	

}
