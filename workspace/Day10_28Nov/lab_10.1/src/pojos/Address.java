package pojos;

import javax.persistence.*;

@Entity 
@Table(name="address_tbl")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private Integer addressId; 
	
	@Column(length = 20)
	private String city; 
	@Column(length = 20)
	private String state ; 
	@Column(length = 20)
	private String country; 
	@Column(length = 20,unique = true)
	private String phoneNo; 
	
	// bi directional association between entities  :owning side
	
	@OneToOne 
	@JoinColumn(name = "stud_id", nullable = false)
	private Student stud ; 
	
	public Address() {
		// TODO Auto-generated constructor stub
		System.out.println("in address constr");
	}

	public Address(String city, String state, String country, String phoneNo) {
		super();
		this.city = city;
		this.state = state;
		this.country = country;
		this.phoneNo = phoneNo;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Student getStud() {
		return stud;
	}

	public void setStud(Student stud) {
		this.stud = stud;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", phoneNo=" + phoneNo + "]";
	}
	
	
	
}
