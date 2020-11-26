package test;
import org.hibernate.*;

import dao.SupplierDaoImpl;
import pojos.Supplier;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

public class TestAuthenticate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try(SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in))
		{
			SupplierDaoImpl dao = new SupplierDaoImpl(); 
			
			System.out.println("please enter email and password for login ");
			
		Supplier s	= dao.authenticate(sc.next(), sc.next()); 
			
		if(s != null)
		{
			System.out.println(s.getEmail() + "  Successfully logged in " );
		}else
		System.out.println("log in failed , try again !!!");
			
		}catch (Exception e){
			
			e.printStackTrace();
		}
		
		
		
		
	}

}
