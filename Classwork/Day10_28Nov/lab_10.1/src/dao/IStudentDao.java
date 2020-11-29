package dao;

import pojos.Address;
import pojos.Student;

public interface IStudentDao {

	String cancelStudentAdmission(String studentEmail,String courseName); 
	
	// to fetch student details 
	
	Student getStudentDetails(int student_id); 
	
	// assigning address to existing  student 
	
	String assignAddressToStudent(String email,Address address); 
	
	
	// fetch complete student details 
	
	Student fetchCompleteStudentDetails(String email); 
	
}
