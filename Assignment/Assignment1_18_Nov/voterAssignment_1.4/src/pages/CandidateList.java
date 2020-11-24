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

import dao.CandidateDaoImpl;
import pojos.Candidate;
import pojos.Voter;

/**
 * Servlet implementation class CandidateList
 */
@WebServlet("/candidate_list")
public class CandidateList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// set cont type n PW
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			// HS
			HttpSession hs = request.getSession();
			// get candidate dao , voter details
			CandidateDaoImpl candidateDao = (CandidateDaoImpl) hs.getAttribute("candidate_dao");
			Voter voter = (Voter) hs.getAttribute("user_details");
			//invoke dao's method to get candidate list
			List<Candidate> allCandidates = candidateDao.getAllCandidates();
			// greeting mesg
			pw.print("<h5>Hello " + voter.getName()+"</h5>");
			pw.print("<h5> Candidate List </h5>");
			//dyn generation of the form
			pw.print("<form action='voter_status'>");
			for(Candidate c : allCandidates)
				pw.print("<input type='radio' name='cid' value="+c.getCandidateId()+">"+c.getName()+"<br>");
			pw.print("<input type='submit' value='Cast A Vote'>");
			pw.print("</form>");
			
		}catch (Exception e) {
			throw new ServletException("err in do-get of "+getClass().getName(), e);
		}

	}

}
