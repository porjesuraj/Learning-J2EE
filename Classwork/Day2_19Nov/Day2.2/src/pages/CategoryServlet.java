package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			
			// get cookies sent from client --> server , using req header
			
			          Cookie[] cookies = request.getCookies();
			
			          if(cookies != null)
			          {
			        	  for(Cookie c : cookies)
			        	  {
			        		  if(c.getName().equals("customer_details")) {
			        			  pw.print("<h3> Customer details from cookie : " + c.getValue() + "</h5>");
			        		  }
			        	  }
			        		
			          }else
			          {
			        	  pw.print("<h3> No Cookies,session tracking failed </h3>");
			          }
			          
			          // send logout link to client 
		
			          pw.print("<h5> <a href='logout'> LogOut </a> </h5>");
		}
	}

}
