package tester;
import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.*;

import dao.UserDaoImpl;

public class RestoreImage {

	public static void main(String[] args) {
		// Testing bootstrapping of hibernate configuration (creating singleton n
		// immutable singleton instance of SessionFactory (SF)
		try(SessionFactory sf=getSf();Scanner sc=new Scanner(System.in))
		{
			//dao instance 
			UserDaoImpl dao=new UserDaoImpl();
			System.out.println("Enter User id n image file name along with path , to restore image from DB");
			System.out.println(dao.restoreImage(sc.nextInt(), sc.next()));
			System.out.println("cntd....");
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}

            