package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CandidateDaoImpl;
import dao.VoterDaoImpl;
import pojos.Voter;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = "/authenticate", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VoterDaoImpl voterDao;
	private CandidateDaoImpl candidateDao;

	/**
	 * @see Servlet#init()
	 */
	// overriding form of the method can't add any NEW or BROADER checked excs
	public void init() throws ServletException {
		// create dao instances
		try {
			voterDao = new VoterDaoImpl();
			candidateDao = new CandidateDaoImpl();
		} catch (Exception e) {
			// Centralized err handling in servlets
			// Inform WC that init has failed : so that WC won't continue with remaining
			// life cycle of the servlet
			// HOW : throw servlet exc to WC
			throw new ServletException("err in init of " + getClass().getName(), e);

		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			voterDao.cleanUp();
			candidateDao.cleanUp();
		} catch (Exception e) {
			// System.out.println("in destroy of "+getClass().getName()+" err "+e);
			throw new RuntimeException("in destroy of " + getClass().getName() + " err ", e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// set cont type
		response.setContentType("text/html");
		// get PW
		try (PrintWriter pw = response.getWriter()) {
			// get request params : email n password
			String email = request.getParameter("em");
			String password = request.getParameter("pass");
			// servlet ---> DAO's method for customer validation
			Voter validUser = voterDao.authenticateVoter(email, password);
			if (validUser == null) // => invalid login --send a mesg n link to retry
				pw.print("<h5>Invalid Login , Please <a href='login.html'>Retry</a></h5>");
			else // => valid login --

			{
				// get HttpSession object from WC
				HttpSession session = request.getSession();
				// save validated user details under session scope
				session.setAttribute("user_details", validUser);
				session.setAttribute("voter_dao", voterDao);
				session.setAttribute("candidate_dao", candidateDao);
				// chk role
				if (validUser.getRole().equals("voter")) {
					// chk voting status
					if (validUser.isStatus()) // true => voter has alrdy voted : voter status page
						response.sendRedirect("voter_status");
					else // false => voter has not yet voted : redirect clnt to candidate list page
						response.sendRedirect("candidate_list");

				} else {
					// admin user has logged in. : redirect the clnt to admin status page
					response.sendRedirect("admin_status");

				}

			}

		} catch (Exception e) {
			// inform WC
			throw new ServletException("err in do-post of " + getClass().getName(), e);
		}
	}

}
