package dao;

import pojos.Course;
import static utils.HibernateUtils.getSf;

import org.hibernate.*;

public class CourseDaoImpl implements ICourseDao {

	@Override
	public String launchCourse(Course c) {
		

		// session 
		
	       Session session = getSf().getCurrentSession();
		
	       String msg = "Launching course failed";
		// begin trans 
	       
        	 Transaction tx = session.beginTransaction(); 
		
        	 try {
        		 // c : Transient 
        		 session.persist(c); // Persistent 
                           		 
        		 
        		 tx.commit(); // dirty checking : check : insert query fired , session closed 
				
        		 msg = " Launched course with course id " + c.getCourseId(); 
        		 
			} catch (RuntimeException e) {
				
				if(tx != null)
			    tx.rollback();
			 throw e; 
			} 
		return msg;
	}

	@Override
	public String cancelCourse(int courseId) {
		
		String msg = "Course cancellation failed"; 
	       Session session = getSf().getCurrentSession();
		
		// begin trans 
	       
     	 Transaction tx = session.beginTransaction(); 
		
     	 try {
     		 // get course detail from course id
     		 
     	Course c = session.get(Course.class, courseId); 
     		 
     	if(c != null)
     	{
     		// delete course details 
     		session.delete(c); // REMOVED (not yet gone from L1 cache or DB ) : simply marked for removal 
     		
     	}
     	
     	
     		 tx.commit(); // delete query 
				
     		msg = "Course with name " + c.getName() + "cancelled ... "; 
     		 
			} catch (RuntimeException e) {
				
				if(tx != null)
			    tx.rollback();
			 throw e; 
			} 
     	 
		
		
		
		return msg;
	}
	
	
	
	
}
