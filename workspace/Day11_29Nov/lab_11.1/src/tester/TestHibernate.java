package tester;

import static utils.HibernateUtils.getSf;

import com.mysql.cj.xdevapi.SessionFactory;

import org.hibernate.*;

public class TestHibernate {

	public static void main(String[] args) {
		
		// Testing bootstrapping of hibernate configuration (creating singleton n 
		// immutable instance of SessionFactory(sf)
		
		try(org.hibernate.SessionFactory sf = getSf()) {
			
			System.out.println("hibernate up and running ");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
