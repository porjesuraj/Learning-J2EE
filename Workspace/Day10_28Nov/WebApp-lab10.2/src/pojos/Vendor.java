package pojos;

//id(Integer),name,email(unique),password,reg amount,reg date (LocalDate),role (enum --vendor / admin)
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "vendors_tbl")
public class Vendor {
	@Id //PK 
	@GeneratedValue(strategy = GenerationType.IDENTITY) //strategy = AUTO will be replaced : auto_increment
	@Column(name = "vendor_id")
	private Integer vendorId;
	@Column(length = 30)
	private String name;
	@Column(length = 30,unique = true)
	private String email;
	@Column(length = 30)
	private String password;
	@Column(name="reg_amount")
	private double regAmount;
	@Column(name = "reg_date")
	private LocalDate regDate;//col type=date
	@Enumerated(EnumType.STRING)
	@Column(name="user_role",length = 20)
	private Role userRole;
	
	// one to many : bi directional asso between entities : here parent , one sode , inverse side
	
	@OneToMany(mappedBy = "accountOwner",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<BankAccount> bankAccounts = new ArrayList<BankAccount>(); 
	
	
	
	//def ctor : mandatory
	public Vendor() {
		System.out.println("in vendor ctor");
	}
	//add parametrized constr
	public Vendor(String name, String email, String password, double regAmount, LocalDate regDate, Role userRole) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.regDate = regDate;
		this.userRole = userRole;
	}
	
	
	
	//add all getters n setters
	
	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}
	public void setBankAccounts(List<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}
	
	public Integer getVendorId() {
		return vendorId;
	}
	
	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
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
	public Role getUserRole() {
		return userRole;
	}
	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}
	@Override
	public String toString() {
		return "Vendor [vendorId=" + vendorId + ", name=" + name + ", email=" + email + ", regAmount=" + regAmount
				+ ", regDate=" + regDate + ", userRole=" + userRole + "]";
	}
	
	// add helper method 
	
	public void addAccount(BankAccount b)
	{
		bankAccounts.add(b);
		
		b.setAccountOwner(this);
	}
	

	public void removeAccount(BankAccount b)
	{
		bankAccounts.remove(b);
		b.setAccountOwner(null);
	}

}
