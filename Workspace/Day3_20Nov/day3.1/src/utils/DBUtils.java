package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {

	private static String DRIVER = "com.mysql.cj.jdbc.Driver"; 
	private static String USER = "dac"; 
	private static String URL = "jdbc:mysql://localhost:3306/day2"; 
	private static String PASSWORD = "password"; 
	
	public static Connection fetchConnection() {
		
		try {
			Class.forName(DRIVER);
			
			return DriverManager.getConnection(URL, USER, PASSWORD);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
}
