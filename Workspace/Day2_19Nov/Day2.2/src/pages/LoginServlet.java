package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDaoImpl;
import pojos.Customer;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = "/authenticate",loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CustomerDaoImpl dao ;
	/**
	 * @see Servlet#init()
	 */
	// overriding form of the method cannot add any new or Broader checked exception
	public void init() throws ServletException {
		
		try {
			
			// create dao instance 
			this.dao = new CustomerDaoImpl();
			
			
		} catch (Exception e) {
            // Centrelized error Handling in servlets
			// Inform web container init has failed : so that WC wont continue with remaining life cycle of the servlet 
		
			// how : throw servlet exc to WC
			throw new ServletException("error in init" + getClass().getName(),e);
		
		}
		
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		
		try {
			dao.cleanUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println();
		
		throw new RuntimeException("in destroy of " + getClass().getName() + "err : ",e);
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/// SET CONTENT TYPE
		response.setContentType("text/html");
     try(PrintWriter pw = response.getWriter())
     {
    	 // get request para
    	 
    	 String email = request.getParameter("em"); 
    	 String password = request.getParameter("pass"); 
    	 // servlet ---> DAO method for customer validation 
    	 Customer customer = dao.authenticateCustomer(email, password);
               if(customer == null)
               {// invalid login => send a message n link to retry
            	pw.print("<h3> Invalid Login,Please <a href='login.html'> Retry </a> </h3> " );   
            	   
               }else
               {
            	   // create a cookie to hold validated customer details 
            	   
            	   Cookie c1 = new Cookie("customer_details",customer.toString()); 
            	   // send cookie from server to client using response header 
            	   response.addCookie(c1);
                                	   
            	   
            	   response.sendRedirect("category");// web container send immediate temp redirect response 
            	  //SC 302 | location = http://host:port/Day2.2/category.setcookie : cookie details | body Empty 
            	   
               }
     
     }catch(Exception e)
     {
    	 throw new ServletException("error in do-post of " + getClass().getName() + "err : ",e);
     }
	
	}

}
