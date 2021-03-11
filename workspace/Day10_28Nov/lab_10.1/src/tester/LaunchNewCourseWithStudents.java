package tester;
// create courses with student 
import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.*;

import dao.CourseDaoImpl;
import pojos.Course;
import pojos.Student;

import static java.time.LocalDate.parse;

public class LaunchNewCourseWithStudents {

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
			
			// accept 3 students details , who want to enroll in this course 
			
			
			for (int i = 0; i < 3; i++) {
				
				System.out.println("Enter student detials : email and name ");
				
				Student s = new Student(sc.next(), sc.next());
				
				// add student  reference in arraylist 
				/*
				 * c1.getStudents().add(s); // course ---> student
				 * 
				 * s.setSelectedCourse(c1); // student ---> course
				 */		
				
				c1.addStudent(s); // invoking helper /convinience method 
				
				
				
			}
			
			System.out.println("status " + courseDao.launchCourse(c1));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

            