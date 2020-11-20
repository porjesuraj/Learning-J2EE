package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDaoImpl;
import pojos.Book;
import pojos.Customer;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		try(PrintWriter pw = response.getWriter())
		{
			
			// get httpsesion 
		  HttpSession session = request.getSession();
			
			System.out.println("from Logout HS " + session.isNew());// false 
			
			System.out.println("session id " + session.getId());
			
			// retrieve customer details from session scope 
			
		Customer	c = (Customer) session.getAttribute("user_details");
			
		if(c != null) {
			pw.print("<h5> Hello " + c.getEmail() + "</h5>");
			
			// retrieve cart from sessio nscope 
			
			 List<Integer> cart = (List<Integer>) session.getAttribute("shopping_cart"); 
			 
	        BookDaoImpl bookDao = (BookDaoImpl) session.getAttribute("book_dao");
	       pw.print("<h3> Cart Contents  </h3> ");
	        double totalCartvalue = 0; 
	        for(int id : cart)
	        {
	        	// get book details 
	   
	        	Book book = bookDao.getBookDetails(id);
	        	
	         	pw.print("<h5>" + book + "</h5>");
	      totalCartvalue += book.getPrice(); 
	        }
	        pw.print("<h4> total price : " + totalCartvalue + "</h4>" );
		}
		
		else
		pw.print("<h3> No cookies found : Session tracking failed ... </h3>");
			
		//invalidate http session 
		session.invalidate();
			
			
			
			
	pw.print("<h3> you have logged out... </h3> ");
			
	// send a link for user to visit again 
			
	pw.print("<h5> <a href='login.html'> Visit Again </a> </h5> " );
			
			
			/*
			 * // get cookies from client req header
			 * 
			 * Cookie[] cookies = request.getCookies();
			 * 
			 * if(cookies != null) { // retrieve user details from cookie
			 * 
			 * for(Cookie c : cookies) { if(c.getName().equals("customer_details")) {
			 * 
			 * pw.print("<h5> User Details : in logout page " + c.getValue() + "</h5>"); //
			 * inform web browser to set cookie age : 0 for delete , 1: perist , -1 : keep
			 * for session c.setMaxAge(0);
			 * 
			 * response.addCookie(c);
			 * 
			 * } }
			 * 
			 * }else {
			 * pw.print("<h3> No cookies found : Session tracking failed ... </h3>"); }
			 */
			/*
			 * pw.print("<h3> you have logged out... </h3> ");
			 * 
			 * // send a link for user to visit again
			 * 
			 * pw.print("<h5> <a href='login.html'> Visit Again </a> </h5> " );
			 */
			
		}catch (Exception e) {
			throw new ServletException("err in do-get of " + getClass().getName(), e);
		}
	}

}
