package pojos;

import java.sql.Date;

// id | email           | password | reg_amt | reg_date 
public class Customer {

	private int id;
	private String email;
	private String password;
	private double reg_amt;
	private Date reg_date;

	public Customer() {
	}

	public Customer(int id, String email, String password, double reg_amt, Date reg_date) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.reg_amt = reg_amt;
		this.reg_date = reg_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public double getReg_amt() {
		return reg_amt;
	}

	public void setReg_amt(double reg_amt) {
		this.reg_amt = reg_amt;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", email=" + email + ", password=" + password + ", reg_amt=" + reg_amt
				+ ", reg_date=" + reg_date + "]";
	}

}
