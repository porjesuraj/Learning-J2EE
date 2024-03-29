package tester;

import static utils.HibernateUtils.getSf;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.hibernate.*;

import dao.UserDaoImpl;
import pojos.Role;

public class GetSelectedPartialUserDetails {

	public static void main(String[] args) {

			// for parsing string ---Date : use SimpleDateFormat
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			// Testing bootstrapping of hibernate configuration (creating singleton n
			// immutable instance of SessionFactory (SF)
			try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
				System.out.println("Enter begin date end date n role");
				// dao instance
				UserDaoImpl dao = new UserDaoImpl();
				System.out.println("Selected  User Details : ");
				dao.fetchSelectedDetails(sdf.parse(sc.next()), sdf.parse(sc.next()),
						Role.valueOf(sc.next().toUpperCase())).forEach(u -> 
						System.out.println(u.getName()+" "+u.getRegAmount()+" reged on "+u.getRegDate()));
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

}

            