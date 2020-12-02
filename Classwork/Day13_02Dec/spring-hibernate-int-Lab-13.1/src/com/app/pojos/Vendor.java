package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vendors_tbl")
public class Vendor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vendor_id")
	private Integer vendorId;
	@Column(length = 30)
	private String name; 
	@Column(length = 30)
	private String email; 
	@Column(length = 30)
	private String password;
	
	@Column(name = "reg_amount")
	private double regAmount; 
	@Column(name = "reg_date")
	private LocalDate regDate; 
	
	@Enumerated(EnumType.STRING)
	@Column(name = "user_role",length = 20)
	private Role userRole; 
	
	// one vendor can have many bank account ,so 
	// one to many : bu  direction assoc between 
	// entity : parent ,inverse side
	
	@OneToMany(mappedBy = "accountOwner", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<BankAccount> bankAccounts = new ArrayList<>(); 
	
	public Vendor() {
	System.out.println("in constr of " + getClass().getName());
		// TODO Auto-generated constructor stub
	}

	public Vendor(String name, String email, String password, double regAmount, LocalDate regDate, Role userRole) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.regDate = regDate;
		this.userRole = userRole;
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

	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(List<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

	@Override
	public String toString() {
		return "Vendor [vendorId=" + vendorId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", regAmount=" + regAmount + ", regDate=" + regDate + ", userRole=" + userRole + ", bankAccounts="
				+ bankAccounts + "]";
	}
	
	// add helper method 
	
	
	
	
	
}
