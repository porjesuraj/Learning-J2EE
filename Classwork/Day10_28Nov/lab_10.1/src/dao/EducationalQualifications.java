package dao;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EducationalQualifications {

	@Column(name = "qualification_type",length = 40,unique = true)
	private String type; 
	@Column(name = "passing_date")
	private LocalDate date;
	private double gpa; 
	
	
	public EducationalQualifications() {
		// TODO Auto-generated constructor stub
		System.out.println("in contr of edu qualification");
	}


	public EducationalQualifications(String type, LocalDate date, double gpa) {
		super();
		this.type = type;
		this.date = date;
		this.gpa = gpa;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public double getGpa() {
		return gpa;
	}


	public void setGpa(double gpa) {
		this.gpa = gpa;
	}


	@Override
	public String toString() {
		return "EducationalQualifications  details : type=" + type + ", date=" + date + ", gpa=" + gpa + "";
	}
	
	
	
	
}
