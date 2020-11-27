package pojos;
import javax.persistence.*;

@Entity
@Table(name="students_tbl")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private Integer studentId;
	@Column(length = 20,unique = true)
	private String email;
	@Column(length = 20)
	private String name;
	
	// bi - directional association between entities 
	// many side of association  and owning side(since it has FK column) 
	@ManyToOne
	@JoinColumn(name = "c_id",nullable = false) // constraint : Not null : optional but recommended
	private Course selectedCourse;
	public Student() {
		System.out.println("in student cnstr");
	}
	public Student(String email, String name) {
		super();
		this.email = email;
		this.name = name;
	}
	//all s/g
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Course getSelectedCourse() {
		return selectedCourse;
	}
	public void setSelectedCourse(Course selectedCourse) {
		this.selectedCourse = selectedCourse;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", email=" + email + ", name=" + name + "]";
	}
	
	
	

}

            