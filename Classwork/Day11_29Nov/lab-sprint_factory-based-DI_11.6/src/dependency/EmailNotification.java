package dependency;

import java.time.LocalDateTime;

public class EmailNotification implements NotificationService {

	public EmailNotification() {
	System.out.println("in contr of" + getClass().getName());
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void notifyCustomer(String txType, double amount) {
		// TODO Auto-generated method stub

		System.out.println(" NOTIFYING CUSTOMER : Tx type "+ txType + " for amount " + amount + " @ " + LocalDateTime.now()  + "VIA EMAIL");
	}	

}
