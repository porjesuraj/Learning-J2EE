package test;
import org.hibernate.*;

import dao.SupplierDaoImpl;
import pojos.Supplier;

import static utils.HibernateUtils.getSf;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class TestSupplierList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	List<Supplier> sup = null;
		
		try(SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in))
		{
			System.out.println("please enter \n registered date in 'yyyy-MM-dd' format and registered amount \n to get supplier list ");

			SupplierDaoImpl dao = new SupplierDaoImpl();
			
			sup  = dao.getAllSupplier(LocalDate.parse(sc.next()), sc.nextDouble()); 
			
			for(Supplier s : sup)
			{
				System.out.println(s);
			}
			
			
		}catch (Exception e){
			
			e.printStackTrace();
		}
		
		
		
		
	}

}
