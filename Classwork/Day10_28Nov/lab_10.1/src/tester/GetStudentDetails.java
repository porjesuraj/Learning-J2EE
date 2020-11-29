package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;
import pojos.Student;

public class GetStudentDetails {

	public static void main(String[] args) {
		// Testing bootstrapping of hibernate configuration (creating singleton n
		// immutable instance of SessionFactory (SF)
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			StudentDaoImpl studentDao=new StudentDaoImpl();
			System.out.println("Enter student's id to fetch details");
			
	Student	details	=  studentDao.getStudentDetails(sc.nextInt());
			
			
			
			if(details != null ) {
				
				System.out.println(details.getClass().getName());
				
				System.out.println("Student details " + details);
				/*
				 * System.out.println("Enrolled in ");
				 * System.out.println(details.getSelectedCourse());
				 */
				
			}
			
			
			} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

            