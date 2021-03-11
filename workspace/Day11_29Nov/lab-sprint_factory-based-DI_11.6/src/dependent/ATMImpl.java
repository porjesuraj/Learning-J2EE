package dependent;

import dependency.NotificationService;
import dependency.Transport;

public class ATMImpl implements ATM {
	private Transport myTransport;
	private NotificationService[] customerNotification;
	private double cash;

	private ATMImpl(double cash123,Transport t,NotificationService[] service) {
		cash=cash123;
		myTransport = t ;
		customerNotification = service; 
		
		System.out.println("in cnstr of " + getClass().getName() + " " + myTransport+" "+customerNotification+" "+cash);
	}

	@Override
	public void deposit(double amt) {
		System.out.println("depositing " + amt);
		byte[] data = ("depositing " + amt).getBytes();
		myTransport.informBank(data);// dependent obj(ATM) is calling method of dependency(Tranport) : for informing
										// underlying bank
		// ATM ---> NoticationService for alerting the customer
		for (NotificationService service : customerNotification)
			service.notifyCustomer("Withdraw", amt);
	}

	@Override
	public void withdraw(double amt) {
		System.out.println("withdrawing " + amt);
		byte[] data = ("withdrawing " + amt).getBytes();
		myTransport.informBank(data);// dependent obj is calling method of dependency
		// ATM ---> NoticationService for alerting the customer
		for (NotificationService service : customerNotification)
			service.notifyCustomer("Withdraw", amt);

	}
	// add init n destroy style methods
	public void init123() {
		System.out.println("in init " + myTransport+" "+customerNotification+" "+cash);
	}
	// no  setters required
	
	// add a factory method : For demo of Factory based D.I 
	public static ATMImpl myFactory(double cash123,Transport t,NotificationService[] service) {
		
		System.out.println("in factory method ");
	 // invoke private constr   :to create the bean instance and return it to the caller 
		return new ATMImpl(cash123, t, service);
		
		
	}
      public void destroy123() {
		System.out.println("in destroy " + myTransport);
     	}
	
	

}

            