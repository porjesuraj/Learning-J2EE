package utils;

import java.sql.*;

public class DBUtils {
	
	private static Connection cn; 
	
	// add static method to get FIXED DB connection from D.M
	public static void createSingletonDBConnection(String drvr,String url,String name,String pwd) throws ClassNotFoundException, SQLException {
		// load
		Class.forName(drvr);
		// cn
		cn = DriverManager.getConnection(url,name,pwd);

	}
	// clean up : close DB connection 
	public static void claenUp() throws Exception {
		
		if(cn!= null)
			cn.close();
	}
// add a static method to return already created SIngleton DB con instance 
	
	public static Connection fetchDBConnection() {
		return cn;
	}
}














