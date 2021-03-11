package beans;

import java.util.List;

import dao.BankAccountImpl;
import pojos.BankAccount;

public class BankAccountBean {

	// dao 
	// add a property to represent vendor Id
	
	private int vendorId;
	
	private BankAccountImpl acctDao;
	
	
	
	
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public BankAccountBean() {
	
		System.out.println("in acct bean constr");
		
	// create dao instance
		acctDao = new BankAccountImpl();
		// TODO Auto-generated constructor stub
	}
	
	// add B.L method to fetch acct for logged in vendor 
	
	public List<BankAccount> fetchAccounts(){
		// invode account dao method 
		
		return acctDao.getAllAccountsByVendorId(vendorId); 
	}
}













