package dao;

import pojos.Course;

public interface ICourseDao {

	
	// add  a method to launch new course 
	String launchCourse(Course c); 
	
	String cancelCourse(int courseId); 
	// get course details 
	Course getCourseDetails(String courseName); 
	// get course and associated Student details  : by accessing size : using 2 queries 
	Course getCompleteCourseDetails(String courseName); 
	
	
	// get course and associated Student details  : using single join query
		Course getCompleteCourseDetailsWithJoin(String courseName); 
}
