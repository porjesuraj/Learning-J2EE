package tester;

import dependency.SoapTransport;
import dependent.ATMImpl;

public class TestATM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// create dependent object , create dependency , inject dependency/ies and invoke B.L 
		
		ATMImpl atm = new ATMImpl();
		atm.setMyTransport(new SoapTransport());
		atm.deposit(1000);

	}

}
