package dao;

import org.hibernate.*;

import pojos.Address;
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

	
	
	@Override
	public Student getStudentDetails(int student_id) {
	
		
		Student s=null;
		Session session=getSf().getCurrentSession();
		//begin tx
		Transaction tx=session.beginTransaction();
		try {
			s=session.load(Student.class,student_id);
			// invoke non id getter to trigger select query 
			s.getEmail(); 
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return s;
	}
	
	
	
	@Override
	public String assignAddressToStudent(String email, Address address) {
		  String msg = "Assigning address failed"; 
			
		  String jpqlStudent = "select s from Student s where s.email=:em"; 
		  
		Session session = getSf().getCurrentSession();
			
			// begin trans 
		       
	        	 Transaction tx = session.beginTransaction(); 
			
	        	 try {
	        		 
	        		 Student s = session.createQuery(jpqlStudent, Student.class)
	        				 .setParameter("em", email)
	        				 .getSingleResult();
	        // s : Persistent 
	        		 s.addAddress(address);
	        		 tx.commit(); // auto dirty checking : state of student is modified + enabled cascading : insertion of address record
	        		msg = "Address linked to student" + s.getName(); 
					
				} catch (RuntimeException e) {
					
					if(tx != null)
				    tx.rollback();
				 throw e; 
				} 
	        	 
			
			
			
			return msg;
	}
	
	
	@Override
	public Student fetchCompleteStudentDetails(String email) {

	String jpql = "select s from Student s join fetch s.selectedCourse join fetch s.studentAdr where s.email=:em "; 
	Student s = null;
		
	       Session session = getSf().getCurrentSession();
		
		// begin trans 
	       
     	 Transaction tx = session.beginTransaction(); 
		
     	 try {
     		 
     		 s = session.createQuery(jpql, Student.class).setParameter("em", email).getSingleResult();
     		 
     		 
     		 
     		 tx.commit();
				
			} catch (RuntimeException e) {
				
				if(tx != null)
			    tx.rollback();
			 throw e; 
			} 
     	 
		
		
		
		return s;
	}
	
	
	
	
}
