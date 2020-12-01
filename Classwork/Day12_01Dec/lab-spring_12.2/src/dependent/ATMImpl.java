package dependent;


import dependency.HttpTransport;
import dependency.TestTransport;
import dependency.Transport;

public class ATMImpl implements ATM {
	/* private TestTransport myTransport = new TestTransport(); */
	/* private Transport myTransport = new HttpTransport(); */
	private Transport myTransport;
	public ATMImpl() {
		System.out.println("in cnstr of " +getClass().getName()+" "+ myTransport);
		
	}
	
	@Override
	public void deposit(double amt) {
		System.out.println("depositing "+amt);
		byte[] data=("depositing "+amt).getBytes();
		myTransport.informBank(data);

	}

	@Override
	public void withdraw(double amt) {
		System.out.println("withdrawing "+amt);
		byte[] data=("withdrawing "+amt).getBytes();
		myTransport.informBank(data);
	}


	public void setMyTransport(Transport myTransport) {
		System.out.println("in set transport setter ");
		this.myTransport = myTransport;
	}
	
	// init stype method 
	
		public void myInit() {
			System.out.println("in my init of " + getClass().getName() + "dependency " + myTransport);
		}
		// destory style method
		

	public void myDestroy() {
		
		System.out.println("in my destroy of " + getClass().getName() + "dependency " + myTransport);
		
	}
	
	
	
	
	
	
}
