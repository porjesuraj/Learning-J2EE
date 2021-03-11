package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojos.Customer;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in do-get of "+getClass().getName()+" invoked by "+Thread.currentThread());
		
		response.setContentType("text/html");
		
			PrintWriter pw = response.getWriter();
			pw.print("<h5>Login Successful </h5>");
			
			
			// get cust details from current request scope 
			Customer c = (Customer) request.getAttribute("clnt_info");
			if (c != null) // session tracking works!!!!!!
				pw.print("<h5> Customer Details via request scoped object  on server " + c);

			else
				pw.print("<h5>Request dispatching failed!!!!!</h5>");

			
		
	}

}
