package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.*;

import dao.CourseDaoImpl;
import pojos.Course;
import static java.time.LocalDate.parse;

public class LaunchNewCourse {

	public static void main(String[] args) {
		// Testing bootstrapping of hibernate configuration (creating singleton n
		// immutable instance of SessionFactory (SF)
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			CourseDaoImpl courseDao = new CourseDaoImpl();
			System.out
					.println("Enter course details : name,capacity,strt_date,end_date(yr-mon-day with 0 prefix),fees");
			// create transient pojo n pass it to dao layer for auto persistence
			Course c1 = new Course(sc.next(), sc.nextInt(), parse(sc.next()), 
					parse(sc.next()), sc.nextDouble());
			System.out.println("status " + courseDao.launchCourse(c1));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

            