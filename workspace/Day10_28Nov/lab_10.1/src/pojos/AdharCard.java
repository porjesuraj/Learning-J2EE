package pojos;
// card no, location , date 

import java.time.LocalDate;

import javax.persistence.*;


@Embeddable // mandetory  : required to tel HB : that whatever follows is value type , 
// whic h does not have a standAlone existence and its detials must be embedded in owning entity
public class AdharCard {

@Column(name = "card_number",length = 20,unique = true)
	private String cardNumber ;
@Column(length = 50)
	private String location;
@Column(name = "created_on")
	private LocalDate createdOn; 
	
	public AdharCard() {
		// TODO Auto-generated constructor stub
		System.out.println("in aadhar contr");
	}

	public AdharCard(String cardNumber, String location, LocalDate createdOn) {
		super();
		this.cardNumber = cardNumber;
		this.location = location;
		this.createdOn = createdOn;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "AdharCard details : \n cardNumber=" + cardNumber + ", location=" + location + ", createdOn=" + createdOn + "";
	}
	
	
}
