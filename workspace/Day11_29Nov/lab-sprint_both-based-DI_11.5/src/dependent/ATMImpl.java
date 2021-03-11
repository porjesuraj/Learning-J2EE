package dependent;

import dependency.NotificationService;
import dependency.Transport;

public class ATMImpl implements ATM {
	private Transport myTransport;
	private NotificationService[] customerNotification;
	private double cash;

	public ATMImpl(double cash123) {
		cash=cash123;
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
	//add 2 setters for setter based D.I
	public void setMyTransport(Transport myTransport) {
		System.out.println("in set transport");
		this.myTransport = myTransport;
	}

	public void setCustomerNotification(NotificationService[] customerNotification) {
		System.out.println("in set cust notification");
		this.customerNotification = customerNotification;
	}

	public void destroy123() {
		System.out.println("in destroy " + myTransport);
	}

}

            