package pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

/*
  Create Vendor/Supplier  POJO
id(Integer),name,email(unique),password,reg amount,reg date (LocalDate),role (enum --vendor / admin)
Add JPA annotations. (For LocalDate : no @Temporal annotation is required)
Add mapping entry in config file.
 */

@Entity
@Table(name = "suppliers")

public class Supplier {

	private Integer id ;
	
	private String email,password;
	private double regAmount; 
	private LocalDate regDate; 
	private Role role; 
	
	
	public Supplier() {
		System.out.println("in supplier constr");
	}

	public Supplier(Integer id, String email, String password, double regAmount, LocalDate regDate,Role role) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.regDate = regDate;
		this.role = role;
	}

	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 20,unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
	@Column(length = 20)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}
	
	
@Enumerated(EnumType.STRING)
@Column(length = 20)
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Supplier id=" + id + ", email=" + email + ", password=" + password + ", regAmount=" + regAmount
				+ ", regDate=" + regDate + "\n";
	}
	
	
}

















