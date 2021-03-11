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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in do-get of "+getClass().getName()+" invoked by "+Thread.currentThread());
		
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			pw.print("<h5>Login Successful </h5>");
			// get HttpSession from WC
			HttpSession hs = request.getSession();
			// display new user / old
			System.out.println("from category servlet New User " + hs.isNew());
			// display session id for a client
			System.out.println("Sesison ID " + hs.getId());
			// get cust details from session scope
			Customer c = (Customer) hs.getAttribute("clnt_info");
			if (c != null) // session tracking works!!!!!!
				pw.print("<h5> Customer Details via HS object on server " + c);

			else
				pw.print("<h5>No Session Tracking!!!!!</h5>");

			pw.print("<h5><a href='logout'>Log Me Out</a></h5>");
		}
	}

}
