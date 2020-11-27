package dao;

import pojos.Course;

public interface ICourseDao {

	
	// add  a method to launch new course 
	String launchCourse(Course c); 
	
	String cancelCourse(int courseId); 
}
