package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.*;

import dao.CourseDaoImpl;
import dao.StudentDaoImpl;
import pojos.Course;
import static java.time.LocalDate.parse;

public class CancelStudentAdmission {

	public static void main(String[] args) {
		// Testing bootstrapping of hibernate configuration (creating singleton n
		// immutable instance of SessionFactory (SF)
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
		
			StudentDaoImpl dao = new StudentDaoImpl(); 
			System.out
					.println("Enter students email and course name , to cancel admission ");
			// create transient pojo n pass it to dao layer for auto persistence
			
			System.out.println("status " + dao.cancelStudentAdmission(sc.next(), sc.next()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

            