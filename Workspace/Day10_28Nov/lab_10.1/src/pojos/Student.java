package pojos;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import dao.EducationalQualifications;

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
	@ManyToOne(fetch = FetchType.LAZY) /* (fetch = FetchType.LAZY) */ // fetch policy:  eager by default 
	@JoinColumn(name = "c_id",nullable = false) // constraint : Not null : optional but recommended
	private Course selectedCourse;
	
	@OneToOne(mappedBy = "stud", cascade = CascadeType.ALL ) // Eager
	private Address studentAdr; 
	
	
	
	
	// one to one association between entity and value type
	
	@Embedded //OPTIONAL added only for understanding it is embedded 
	private AdharCard card;
	 
	public Student() {
		System.out.println("in student cnstr");
	}
	public Student(String email, String name) {
		super();
		this.email = email;
		this.name = name;
	}
	
	
	// one to many asso between entity and collection of value types : it is Uni directional 
	
	@ElementCollection // mandetory  : if not : mapping exception 
	@CollectionTable(name = "hobbies_tbl",joinColumns = @JoinColumn(name = "s_id") ) // optional but recommended
	@Column(name = "hobby",length = 20)
	private List<String> hobbies = new ArrayList<>(); 
	
	
	
	// one to many asocation between entity n value type : uni directional(entity--> value type)
	
	@ElementCollection
	@CollectionTable(name = "edu_qualifications",joinColumns = @JoinColumn(name = "s_id"))
	private List<EducationalQualifications> qualifications= new ArrayList<>(); 
	
	
	//all s/g
	
	
	
	
	
	public List<EducationalQualifications> getQualifications() {
		return qualifications;
	}
	public void setQualifications(List<EducationalQualifications> qualifications) {
		this.qualifications = qualifications;
	}
	
	public AdharCard getCard() {
		return card;
	}
	
	public void setCard(AdharCard card) {
		this.card = card;
	}
	public List<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
	
	public Address getStudentAdr() {
		return studentAdr;
	}
	public void setStudentAdr(Address studentAdr) {
		this.studentAdr = studentAdr;
	}
	
	
	
	
	
	
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
	// add helper methods to assign address 
	public void addAddress(Address a) {
		
		this.studentAdr = a;
		
		a.setStud(this);
		
	}
	
	public void removeAddress(Address a) {
		this.studentAdr = null;
		
		a.setStud(null);
	}
	
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", email=" + email + ", name=" + name + "]";
	}
	
	
	

}

            