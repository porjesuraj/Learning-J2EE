package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import pojo.voters;

public interface IVoterDao {

	
	voters validateUser(String email,String pwd);  
	
}
