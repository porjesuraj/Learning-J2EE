package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import com.mysql.cj.xdevapi.SessionFactory;

import dao.UserDaoImpl;

import org.hibernate.*;

public class SaveImage {

	public static void main(String[] args) {
		
		// Testing bootstrapping of hibernate configuration (creating singleton n 
		// immutable instance of SessionFactory(sf)
		
		try(org.hibernate.SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			
			// dao instance 
			
			UserDaoImpl dao = new UserDaoImpl(); 
			
			
			System.out.println("Enter User id and File Name along with path");
			
			System.out.println(dao.saveImage(sc.nextInt(), sc.next()));
			
			System.out.println("cntd");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
