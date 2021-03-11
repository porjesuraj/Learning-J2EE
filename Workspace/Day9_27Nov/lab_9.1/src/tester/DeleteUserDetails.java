package tester;
import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.*;

import dao.UserDaoImpl;

public class DeleteUserDetails {

	public static void main(String[] args) {
		// Testing bootstrapping of hibernate configuration (creating singleton n
		// immutable singleton instance of SessionFactory (SF)
		try(SessionFactory sf=getSf();Scanner sc=new Scanner(System.in))
		{
			//dao instance 
			UserDaoImpl dao=new UserDaoImpl();
			System.out.println("Enter User email n pwd");
			System.out.println(dao.unsubscribeUser(sc.next(), sc.next()));
			System.out.println("cntd....");
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}

            