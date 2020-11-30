package tester;

import static utils.HibernateUtils.getSf;

import java.util.List;

import com.mysql.cj.xdevapi.SessionFactory;

import dao.UserDaoImpl;
import pojos.User;

import org.hibernate.*;

public class GetAllUsers {

	public static void main(String[] args) {
		
		// Testing bootstrapping of hibernate configuration (creating singleton n 
		// immutable instance of SessionFactory(sf)
		
		try(org.hibernate.SessionFactory sf = getSf()) {
			
			
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println("Existing user details ");
	dao.fetchAllUserDetails().forEach(System.out::println); 
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
