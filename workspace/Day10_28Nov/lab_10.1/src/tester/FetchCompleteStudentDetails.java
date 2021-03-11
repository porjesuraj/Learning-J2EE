package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;
import pojos.Student;

public class FetchCompleteStudentDetails {

	public static void main(String[] args) {
		
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			StudentDaoImpl studentDao=new StudentDaoImpl();
			System.out.println("Enter student's email id ");
			
	Student	details	=  studentDao.fetchCompleteStudentDetails(sc.next()); 
			
			System.out.println("Student detials");
			System.out.println(details);
			
			System.out.println("address details");
			System.out.println(details.getStudentAdr());
			
			System.out.println("Enrolled in ");
			System.out.println(details.getSelectedCourse());
			
			
			} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

            