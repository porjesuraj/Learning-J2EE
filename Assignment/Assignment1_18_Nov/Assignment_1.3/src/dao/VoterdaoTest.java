package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import pojo.voters;
import utils.DBUtils;

public class VoterdaoTest implements IVoterDao{

	
	Connection connection = null;
	
	PreparedStatement stmlLogin; 
	
	public VoterdaoTest() throws SQLException, ClassNotFoundException {
		
		this.connection = DBUtils.getConnection(); 
		
		this.stmlLogin = this.connection.prepareStatement("select * from voters where email=? and password=?");
	}
	
	/*
	 * public static void main(String[] args) throws SQLException,
	 * ClassNotFoundException {
	 * 
	 * VoterdaoTest test = new VoterdaoTest(); String email = "rama@gmail.com";
	 * String pwd = "ram#123"; voters v = test.validateUser(email, pwd) ; if(v !=
	 * null) {
	 * 
	 * System.out.println("user found"); System.out.println(v.toString()); }else
	 * System.out.println("user not fount");
	 * 
	 * 
	 * }
	 */

	@Override
	public voters validateUser(String email, String pwd) {
		
		
		voters v  = null;
		 
		    //ResultSet rs;
			try {
				this.stmlLogin.setString(1, email);
				this.stmlLogin.setString(2, pwd);
				//rs = this.stmlLogin.executeQuery();
			try(ResultSet rs = this.stmlLogin.executeQuery())
			{
				while(rs.next())
				{
					 v  = new voters(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getString("password"),rs.getBoolean("status"),rs.getString("role")); 
					
					
				}
				
			}
				return v; 
				  
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			return null; 
		  
		   
	}

}
