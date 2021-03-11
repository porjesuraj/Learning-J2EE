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
import pojos.Customer;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		try(PrintWriter pw = response.getWriter())
		{
			pw.print("<h5> Successfully Login </h5>");
			// http proto stateless, so new request no data of pre request 
			
		 // get http session from WC 
			
			HttpSession session = request.getSession(); 
			
			System.out.println("from category page HS " + session.isNew());
         
			System.out.println("session id " + session.getId());// same session id 
			
			Customer customer = (Customer) session.getAttribute("user_details");
			// get book ao instance from session scope 
			
			BookDaoImpl bookdao = (BookDaoImpl) session.getAttribute("book_dao");
			
			// invoke bookdao method to fetch all categories
			List<String> categories = bookdao.getAllCategories();
			
			if(customer != null)
			{//implies that session tracking is working 
				pw.print("<h3> Customer details via  HS : " + customer.getEmail()+ "</h5>"); 
				
				pw.print(" <form action='category_details' >");
				pw.print("<label> Choose Category </label>");
				pw.print("<select name='cname'> ");
				
				for(String s : categories)
				{
					pw.print("<option value=" +s+ ">" +s+ "</option>");
					
				}
				pw.print("</select> <br>");
			 // add submit button to choose
				pw.print("<input type='submit' value='Choose'>"); // http://localhost:8080/Day3.1/category_details?cname=angular
				pw.print("</form>");
				
			}
			else
			{
				pw.print("<h3> No Cookies,session tracking failed !!! </h3>");
			}
			
			 // send logout link to client 
            pw.print("<h5> <a href='logout'> LogOut </a> </h5>");
			
			
			
			// get cookies sent from client --> server , using req header
			/*cookie based
			 * Cookie[] cookies = request.getCookies();
			 * 
			 * if(cookies != null) { for(Cookie c : cookies) {
			 * if(c.getName().equals("customer_details")) {
			 * pw.print("<h3> Customer details from cookie : " + c.getValue() + "</h5>"); }
			 * }
			 * 
			 * }else { pw.print("<h3> No Cookies,session tracking failed </h3>"); }
			 */
			          
			          // send logout link to client 
		            //pw.print("<h5> <a href='logout'> LogOut </a> </h5>");
		}catch (Exception e) {
			// TODO: handle exception
			throw new ServletException("err in do=get of " + getClass().getName() , e); 
		}
	}

}
