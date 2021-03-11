package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.*;

import dao.CourseDaoImpl;
import pojos.Course;
import static java.time.LocalDate.parse;

public class CancelCourse {

	public static void main(String[] args) {
		// Testing bootstrapping of hibernate configuration (creating singleton n
		// immutable instance of SessionFactory (SF)
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			CourseDaoImpl courseDao = new CourseDaoImpl();
			System.out
					.println("Enter course id to be cancelled");
			// create transient pojo n pass it to dao layer for auto persistence
			
			System.out.println("status " + courseDao.cancelCourse(sc.nextInt()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

            