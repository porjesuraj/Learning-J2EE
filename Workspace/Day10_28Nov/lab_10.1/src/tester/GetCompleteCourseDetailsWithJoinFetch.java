package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.*;

import dao.CourseDaoImpl;
import pojos.Course;
import static java.time.LocalDate.parse;

public class GetCompleteCourseDetailsWithJoinFetch {

	public static void main(String[] args) {
		
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			CourseDaoImpl courseDao = new CourseDaoImpl();
			System.out
					.println("Enter course name to view the details with inner join ");
			Course c=courseDao.getCompleteCourseDetailsWithJoin(sc.next());
			System.out.println("Course Details ");
			System.out.println(c);
			System.out.println("Student Details for Course "+c.getName());
			c.getStudents().forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

            