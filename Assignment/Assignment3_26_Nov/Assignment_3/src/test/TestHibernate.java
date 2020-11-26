package test;
import org.hibernate.*;
import static utils.HibernateUtils.getSf;

public class TestHibernate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try(SessionFactory sf = getSf())
		{
			System.out.println("hibernate up and running ");
			
			
			
		}catch (Exception e){
			
			e.printStackTrace();
		}
		
		
		
		
	}

}
