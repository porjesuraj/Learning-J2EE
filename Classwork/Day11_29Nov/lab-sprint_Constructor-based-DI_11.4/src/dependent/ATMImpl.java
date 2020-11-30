package dependent;


import dependency.HttpTransport;
import dependency.NotificationService;
import dependency.TestTransport;
import dependency.Transport;

public class ATMImpl implements ATM {
	/* private TestTransport myTransport = new TestTransport(); */
	/* private Transport myTransport = new HttpTransport(); */
	private Transport myTransport;
	
	private NotificationService[] customerNotification; 
	
	public ATMImpl(Transport t,NotificationService[] services) {
	     myTransport = t; 
		customerNotification = services; 
		
		System.out.println("in cnstr of " +getClass().getName()+" "+ myTransport + services);
		
	
		
	}
	
	@Override
	public void deposit(double amt) {
		System.out.println("depositing "+amt);
		byte[] data=("depositing "+amt).getBytes();
		myTransport.informBank(data); // dependent object calling method of dependency 
        // ATM---> NotificationService for alerting customer 
		for(NotificationService service : customerNotification)
		      service.notifyCustomer("deposit", amt);
	}

	@Override
	public void withdraw(double amt) {
		System.out.println("withdrawing "+amt);
		byte[] data=("withdrawing "+amt).getBytes();
		myTransport.informBank(data);  // dependent object calling method of dependency 
		for(NotificationService service : customerNotification)
	      service.notifyCustomer("withdraw", amt);
	}


	
	// init stype method : mandetory public ,void 
	//  called in both singleton and prototype scope 
	// for clean init and destroy code 
		public void myInit() {
			System.out.println("in my init of " + getClass().getName() + "dependency " + myTransport + " " +  customerNotification);
		}
		// destory style method  : mandetory public ,void 
		// called for only prototype method

	public void myDestroy() {
		
		System.out.println("in my destroy of " + getClass().getName() + "dependency " + myTransport + " " + customerNotification);
		
	}

	
	
	
	
	
	
	
}
