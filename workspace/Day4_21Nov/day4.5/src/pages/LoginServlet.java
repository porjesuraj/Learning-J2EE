package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jws.soap.InitParam;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDaoImpl;
import pojos.Customer;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDaoImpl dao;



	@Override
	// overriding form of the method CAN'T add any BROADER checked excs.
	public void init() throws ServletException {
	
		
		try {
			dao = new CustomerDaoImpl(); 
			
			
		}
		
		catch (Exception e) {
			// Inform WC that init() has failed --so DON'T proceed to service
			throw new ServletException("err in init of " + getClass().getName(), e);

		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	@Override
	// overrding form of the method CAN'T add any NEW checked excs.
	public void destroy() {
		try {
			dao.cleanUp();
			System.out.println("in login destroy ");
		} catch (Exception e) {
			// since it's invoked @ end of life cycle : may not inform it's details to WC
			// System.out.println("err in destroy "+e);
			throw new RuntimeException("err in destroy of " + getClass().getName(), e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in do-get of "+getClass().getName()+" invoked by "+Thread.currentThread());
		// set cont type
		response.setContentType("text/html");
		// pw
		try (PrintWriter pw = response.getWriter()) {
			// get req params
			String email = request.getParameter("em");
			String password = request.getParameter("pass");
			// invoke DAO's method for validation
			Customer authenticateCustomer = dao.authenticateCustomer(email, password);
			if (authenticateCustomer == null)
				pw.print("<h5>Invalid Login , Please <a href='login.html'>Retry</a></h5>");
			else {

				// success
				// get HttpSession from WC
				HttpSession session = request.getSession();
				// display new user / old
				System.out.println("from login servlet New User " + session.isNew());
				// display session id for a client " value of jsessionid cookie
				System.out.println("Sesison ID " + session.getId());
				// store validated cust details under session scope
				session.setAttribute("clnt_info", authenticateCustomer);
				response.sendRedirect("category");
				// what will be URL of the NEXT req : http://host:port/day4.1/category
			}

		} catch (Exception e1) {
			throw new ServletException("err in do-get of " + getClass().getName(), e1);
		}
	}

}
