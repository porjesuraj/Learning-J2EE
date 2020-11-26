package test;
import org.hibernate.*;

import dao.SupplierDaoImpl;
import pojos.Supplier;

import static utils.HibernateUtils.getSf;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class TestDiscount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	List<Supplier> sup = null;
		
		try(SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in))
		{
			System.out.println("please enter \n  discount amount \n  registered date in 'yyyy-MM-dd' format \n to get supplier discounted list ");

			SupplierDaoImpl dao = new SupplierDaoImpl();
			
			

			sup = dao.applyDiscount(sc.nextDouble(), LocalDate.parse(sc.next())); 
			
			for(Supplier s : sup)
			{
				System.out.println(s);
			}
			
			
		}catch (Exception e){
			
			e.printStackTrace();
		}
		
		
		
		
	}

}
