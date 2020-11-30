package tester;

import static utils.HibernateUtils.getSf;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.hibernate.*;

import dao.UserDaoImpl;
import pojos.Role;

public class GetSelectedUsers {

	public static void main(String[] args) {
		// for parsing string ---Date : use SimpleDateFormat
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		// Testing bootstrapping of hibernate configuration (creating singleton n
		// immutable instance of SessionFactory (SF)
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter begin date end date n role");
			// dao instance
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println("Selected  Users : ");
			dao.fetchSelectedUserDetails(sdf.parse(sc.next()), sdf.parse(sc.next()),
					Role.valueOf(sc.next().toUpperCase())).forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

            