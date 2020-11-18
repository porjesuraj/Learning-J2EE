package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URl = "jdbc:mysql://localhost:3306/j2ee_Assignment1";
	private static final String USER = "dac";
	private static final String PASSWORD = "password";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName(DRIVER);
		
		return DriverManager.getConnection(URl, USER, PASSWORD);
	}
	
}
