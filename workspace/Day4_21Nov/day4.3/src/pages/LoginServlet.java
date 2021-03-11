package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jws.soap.InitParam;
import javax.servlet.RequestDispatcher;
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

	public LoginServlet() {
		System.out.println("in def cnstr : " + getServletConfig());//null
	//System.out.println("in def constr ctx = "+ getServletContext());

	}

	@Override
	// overriding form of the method CAN'T add any BROADER checked excs.
	public void init() throws ServletException {
		
		ServletConfig config = getServletConfig(); 
		System.out.println("in def constr ctx = "+ getServletContext());
		System.out.println("in init " + config );// populated servlet config
		
		try {
			dao = new CustomerDaoImpl(config.getInitParameter("drvr_cls"),
					config.getInitParameter("db_url"),
					config.getInitParameter("user_nm"), 
					config.getInitParameter("pwd")); 
			
			
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
				pw.print("from login page ...");
             //   pw.flush(); // commiting the content to clnt  
				// errr : java.lang.IllegalStateException: Cannot forward after response has been committed
			
				// store validated cust details under request scope
				request.setAttribute("clnt_info", authenticateCustomer);
				 //client pull
				//response.sendRedirect("category"); // what will be URL of the NEXT req :
				//  http://host:port/day4.1/category
						
				
				
				// Server pull: forward Scenerio : Navigating the client from loginServlet --< category :
				// in same request
				// Step 1 :create a ReqDispatcher object to wrap the next page 
				
				RequestDispatcher rd = request.getRequestDispatcher("category"); 
				// 2. Forward the client from login --> category 
				
				rd.forward(request, response);
				// http://localhost:8080/day4.2/validate
               System.out.println("after forward...");
               pw.print("content after forward"); // content not printed 
				
			}

		} catch (Exception e1) {
			throw new ServletException("err in do-get of " + getClass().getName(), e1);
		}
	}

}
