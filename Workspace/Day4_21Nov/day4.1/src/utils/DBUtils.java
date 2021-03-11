package utils;

import java.sql.*;

public class DBUtils {
	// add static method to get FIXED DB connection from D.M
	public static Connection fetchDBConnection(String drvr,String url,String name,String pwd) throws ClassNotFoundException, SQLException {
		// load
		Class.forName(drvr);
		// cn
		return DriverManager.getConnection(url,name,pwd);
	}

}
