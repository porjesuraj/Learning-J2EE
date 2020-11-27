package dao;

import org.hibernate.*;

import pojos.Course;
import pojos.Student;

import static utils.HibernateUtils.getSf;
public class StudentDaoImpl implements IStudentDao{

	@Override
	public String cancelStudentAdmission(String studentEmail, String courseName) {
		  String msg = "Cancelling admission failed"; 
		
		  String jpqlStudent = "select s from Student s where s.email=:email";
		  
		  String jpqlCourse = "select c from Course c where c.name=:nm"; 
		  
		  
		Session session = getSf().getCurrentSession();
			
			// begin trans 
		       
	        	 Transaction tx = session.beginTransaction(); 
			
	        	 try {
	        		 
	        		 
	        		 // get student details from its email 
	        		 
	        		 Student s = session.createQuery(jpqlStudent,Student.class)
	        				 .setParameter("email", studentEmail)
	        				 .getSingleResult(); 
	        		 
	        		 // s: persistent 
	        		 
	        		 // get course details from its name 
	        		 
	        		 Course c = session.createQuery(jpqlCourse,Course.class)
	        				 .setParameter("nm", courseName)
	        		         .getSingleResult(); 
	        		 
	        		//  c : PERSISTENT 
	        		 
	        		 c.removeStudent(s);// helper method to delink bi dir association between course and student 
	        		 
	        		 
	        		 
	        		 
	        		 
	        		 
	        		 
	        		 tx.commit();
	        		 msg = s.getName()  + "'s admission cancelled ... "; 
					
				} catch (RuntimeException e) {
					
					if(tx != null)
				    tx.rollback();
				 throw e; 
				} 
	        	 
			
			
			
			return msg;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
