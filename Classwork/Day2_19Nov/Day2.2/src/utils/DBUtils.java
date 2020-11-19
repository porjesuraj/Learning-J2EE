package utils;
import java.sql.*;
public class DBUtils {

	
	
	// add static method to return Fixed DB connection 
	public static Connection fetchConnection() throws ClassNotFoundException, SQLException {
		// load JDBC driver 
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		//get conn from driver manager 
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/day2","dac", "password"); 
	}
	
}
