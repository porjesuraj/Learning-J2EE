package tester;
import static utils.HibernateUtils.getSf;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.hibernate.*;

import dao.UserDaoImpl;

public class BulkUpdateUsers {

	public static void main(String[] args) {
		// Testing bootstrapping of hibernate configuration (creating singleton n
		// immutable singleton instance of SessionFactory (SF)
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try(SessionFactory sf=getSf();Scanner sc=new Scanner(System.in))
		{
			//dao instance 
			UserDaoImpl dao=new UserDaoImpl();
			System.out.println("Enter reg date n discount");
			System.out.println(dao.bulkUpdateUsers(sdf.parse(sc.next()), sc.nextDouble()));
			System.out.println("cntd....");
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}

            