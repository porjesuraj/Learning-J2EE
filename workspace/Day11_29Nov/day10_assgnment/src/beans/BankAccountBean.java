package beans;

import java.time.LocalDate;
import java.util.List;

import dao.BankAccountDaoImpl;
import pojos.AcType;
import pojos.BankAccount;
import pojos.Vendor;

public class BankAccountBean {
	private String acType;
	private double balance;
	private String creationDate;
	private int acctId;
	private String message;

	// dao
	private BankAccountDaoImpl acctDao;

	public BankAccountBean() {
		System.out.println("in acct bean constr");
		// create dao instance
		acctDao = new BankAccountDaoImpl();
	}
	// setter
	public void setAcType(String acType) {
		this.acType = acType;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	//add a method to get all acct types
	public AcType[] getAcTypes()
	{
		return AcType.values();
	}
	
	

	public String getMessage() {
		return message;
	}
	public void setAcctId(int acctId) {
		this.acctId = acctId;
	}
	// add B.L method to fetch all acct for logged in vendor
	public List<BankAccount> fetchAccounts(int vendorId) {
		// invoke acct dao's method
		return acctDao.getAllAccountsByVendorId(vendorId);
	}
	//add B.L method to create account
	
	public String createAccount(Vendor v)
	{
		BankAccount a=new BankAccount(AcType.valueOf(acType), balance, LocalDate.parse(creationDate));
		System.out.println("vendor "+v);
		System.out.println("bank acct "+a);

		message=acctDao.createAccount(v,a);
		return "vendor_details";
	}
	//add B.L method to close a/c
	public String closeAccount(Vendor v)
	{
		System.out.println("in JB : close a/c "+v+" "+acctId);
		message=acctDao.closeAccount(v, acctId);
		return "vendor_details";
	}

}
