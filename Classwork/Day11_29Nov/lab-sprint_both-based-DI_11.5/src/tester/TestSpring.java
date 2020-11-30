package tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dependent.ATMImpl;

public class TestSpring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//start spring container in java app: using xml based instruction stored under runtime class path 
		
		// o.s.c.s.ClassPathXmlApplicationContext : clas
		// BeanFactory <== ApplicationContext <=== ClassPathXMlApplicationContext
		
		try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml")) {
			
			System.out.println("SC booted");
			// 1st demand : tell SC to supply located--loaded---instantiated (defauld constr) -- D.I--bean Instance
			// API : o.s.b.BeanFactory: T getBean(String beanId,Class<T> beanClass) throws BeanException 
		ATMImpl atm1 = ctx.getBean("atm_bean", ATMImpl.class);
		
		// B.L 
		atm1.deposit(1000);
		
		ATMImpl atm2 = ctx.getBean("atm_bean", ATMImpl.class);
		ATMImpl atm3 = ctx.getBean("atm_bean", ATMImpl.class);
		
		
		System.out.println(atm1 == atm2);
		
		System.out.println(atm1 == atm3);
		
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		
	}

}
