package tester;

import javax.persistence.ManyToOne;
import javax.swing.plaf.synth.SynthSplitPaneUI;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dependent.ATMImpl;

public class TestSpring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// start spring container : using xml based metadata instructions , placed in run time classpath 
		// class : o.s.c.s(.context.support).ClassPathXmlApplicationContext(String configFIle) throws BeansException
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml")){
			
			System.out.println("SC started ...");
			// get readymade springbean instance from SC , for invoking B.L
			System.out.println("making first demand");
			ATMImpl atmBean = ctx.getBean("my_atm", ATMImpl.class); 
			
			// B.L 
			atmBean.deposit(1000);
			System.out.println("making second demand");
			ATMImpl atmBean2 = ctx.getBean("my_atm", ATMImpl.class);
			
					System.out.println(atmBean == atmBean2);
		// System.out.println(atmBean..equals(atmBean2));
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	
}















