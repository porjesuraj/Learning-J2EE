package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDaoImpl;
import dao.CustomerDaoImpl;
import pojos.Customer;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = "/authenticate",loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private CustomerDaoImpl customerDao;
	private BookDaoImpl bookDao; 
	
	
	@Override
	public void init() throws ServletException {
		
		try {
			
			this.customerDao = new CustomerDaoImpl();
			this.bookDao = new BookDaoImpl(); 
			
			
		} catch (Exception e) {
			// Centrelized error Handling in servlets
						// Inform web container init has failed : so that WC wont continue with remaining life cycle of the servlet 
					
						// how : throw servlet exc to WC
						throw new ServletException("error in init" + getClass().getName(),e);
					
		}
	}
	
	
	@Override
	public void destroy() {
		
		try {
			
			customerDao.cleanUp();
			bookDao.cleanUp();
			
			
			
		} catch (Exception e) {
			// System.out.println("in destroy of "+getClass().getName()+" err "+e);
			throw new RuntimeException("in destroy of " + getClass().getName() + " err ", e);		}
	}
	
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		try(PrintWriter pw = response.getWriter())
		{
			 // get request para
	    	 
	    	 String email = request.getParameter("em"); 
	    	 String password = request.getParameter("pass"); 
	    	 // servlet ---> DAO method for customer validation 
	    	 
	    	 
	    	 
	    	 Customer customer = customerDao.authenticateCustomer(email, password);
	    	 
	    	 
	    	 
	    	 
	    	 
	               if(customer == null)
	               {// invalid login => send a message n link to retry
	            	pw.print("<h3> Invalid Login,Please <a href='login.html'> Retry </a> </h3> " );   
	            	   
	               }else
	               {
	            	   
	            	   //get HttpSession object from WC
	   				HttpSession session = request.getSession();
	   				//confirm if session is new or old
	   				System.out.println("From login page HS "+session.isNew());
	   				//session id
	   				System.out.println("Session ID "+session.getId());
	   				//save validated user details under session scope
	   				session.setAttribute("user_details", customer);
	   				// In case of successful login : navigate the clnt to the next page in NEXT
	   				// request coming from the clnt browser
	   				
	   				// dao instances , empty cart : ArrayList<Integer> : list of selected book id 
	   				session.setAttribute("book_dao", bookDao);
	   				session.setAttribute("cust_dao", customerDao);

	   				session.setAttribute("shopping_cart", new ArrayList<Integer>());
	   				
	   				
	   				response.sendRedirect("category");// WC sends immediate temp redirect resp
	            	   
	   				// redirect response //SC 302 | location = http://host:port/Day2.2/category.setcookie : cookie 
	   				
	   				// name : JSESSIONID value:  
	   				// detail| body Empty
	                           	   
	            	 
	            	   
					/*cookie method 
					 * // create a cookie to hold validated customer details
					 * 
					 * Cookie c1 = new Cookie("customer_details",customer.toString()); 
					 * // send cookie from server to client using response header
					 *  response.addCookie(c1);
					 * 
					 * 
					 * response.sendRedirect("category");// web container send immediate temp
					 * redirect response //SC 302 | location =
					 * http://host:port/Day2.2/category.setcookie : cookie details | body Empty
					 */
	               }
	} catch (Exception e) {
		
		e.printStackTrace();
	}

}
}
