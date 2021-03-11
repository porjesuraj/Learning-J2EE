package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;
import pojos.Address;
import pojos.Student;

public class AssignStudentAddress {

	public static void main(String[] args) {
		// Testing bootstrapping of hibernate configuration (creating singleton n
		// immutable instance of SessionFactory (SF)
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			StudentDaoImpl studentDao=new StudentDaoImpl();
			System.out.println("Enter student's emailto assign Address");
			
			String email = sc.next(); 
			System.out.println("Enter address details : city,state,country and phone  ");

			//invoke dao method 
			System.out.println("status " + studentDao.assignAddressToStudent(email, new Address(sc.next(), sc.next(), sc.next(), sc.next())));
			
			
			
			} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

            