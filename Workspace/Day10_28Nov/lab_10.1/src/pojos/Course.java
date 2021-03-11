package pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/*
 * id,name(unique),capacity,strt_date,end_date,fees
+
List<Student> students;
 */
@Entity
@Table(name = "courses_tbl")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cid")
	private Integer courseId;
	@Column(length = 20,unique = true)
	private String name;
	private int capacity;
	@Column(name="start_date")
	private LocalDate startDate;
	@Column(name="end_date")
	private LocalDate endDate;
	private double fees;
	
	// one to many : , bi directional association  between two entities : onse sid eof asso : 
	// parent : and non -owning (inverse ) side of association 
	@OneToMany(mappedBy ="selectedCourse", cascade = CascadeType.ALL,orphanRemoval = true /*,fetch = FetchType.EAGER*/)
	private List<Student> students=new ArrayList<>();
	//def constr
	public Course() {
		System.out.println("in course cnstr");
	}
	public Course(String name, int capacity, LocalDate startDate, LocalDate endDate, double fees) {
		super();
		this.name = name;
		this.capacity = capacity;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fees = fees;
	}
	//add all s/g
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	// add helper method : for two reasons :
	//1. to support adding (student details ) 
	// 2. to remove (student details)
	// Optional : Recommended
	
	// add student detial to a course 
	public void addStudent(Student s)
	{
		students.add(s); // adding parent ---> child
		
		s.setSelectedCourse(this); // child ---> parent 
		
	}
	
	// remove student details 
	public void removeStudent(Student s)
	{
		students.remove(s); // removing  parent ---> child
		
		s.setSelectedCourse(null);// removing child ---> parent
		
	}
	
	
	
	
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", name=" + name + ", capacity=" + capacity + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", fees=" + fees + "]";
	}
	
	
	
	
	
}

            