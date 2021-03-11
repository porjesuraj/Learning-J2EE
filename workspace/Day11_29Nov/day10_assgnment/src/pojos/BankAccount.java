package pojos;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name = "accts_tbl")
public class BankAccount {
	@Id //PK 
	@GeneratedValue(strategy = GenerationType.IDENTITY) //strategy = AUTO will be replaced : auto_increment
	@Column(name = "acct_id")
	private Integer acctNo;
	@Enumerated(EnumType.STRING)
	@Column(name="ac_type",length = 20)
	private AcType acType;
	private double balance;
	@Column(name="creation_date")
	private LocalDate creationDate;
	//many to one association between entities : owning side
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="vendor_id",nullable = false)
	private Vendor accountOwner;
	public BankAccount() {
		System.out.println("in cnstr of "+getClass().getName());
	}
	public BankAccount(AcType acType, double balance, LocalDate creationDate) {
		super();
		this.acType = acType;
		this.balance = balance;
		this.creationDate = creationDate;
	}
	public Integer getAcctNo() {
		return acctNo;
	}
	public void setAcctNo(Integer acctNo) {
		this.acctNo = acctNo;
	}
	public AcType getAcType() {
		return acType;
	}
	public void setAcType(AcType acType) {
		this.acType = acType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	
	public Vendor getAccountOwner() {
		return accountOwner;
	}
	public void setAccountOwner(Vendor accountOwner) {
		this.accountOwner = accountOwner;
	}
	@Override
	public String toString() {
		return "BankAccount [acctNo=" + acctNo + ", acType=" + acType + ", balance=" + balance + ", creationDate="
				+ creationDate + "]";
	}
	

}
