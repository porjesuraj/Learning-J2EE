package tester;

import static utils.HibernateUtils.getSf;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.mysql.cj.xdevapi.SessionFactory;

import dao.UserDaoImpl;
import pojos.Role;
import pojos.User;

import org.hibernate.*;

public class TestSessionApi {

	public static void main(String[] args) {
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		
		try(org.hibernate.SessionFactory sf = getSf() ; Scanner sc = new Scanner(System.in);)
		{
			System.out.println("Enter user details : name,email,password,confirmPassword,role,regAmount,regdate");
			
			// create a transient POJO (not yet persistent )
			User u1 = new User(sc.next(), sc.next(), sc.next(), sc.next(), Role.valueOf(sc.next().toUpperCase()), sc.nextDouble(),sdf.parse(sc.next()) ); 
			// u1 : exists in java Heap : TRANSIENT 
			// create dao instance n invoke method 
		  
			// u1 id : null
			u1.setUserId(222);
			
			//u1.setUserId(1234); // not existing in DB 
			
			
			
			System.out.println("user id " + u1.getUserId()); // null 
			UserDaoImpl dao = new UserDaoImpl();

			System.out.println("session api status " + dao.testSessionApi(u1));
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
