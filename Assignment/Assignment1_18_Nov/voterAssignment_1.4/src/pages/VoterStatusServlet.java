package pages;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class VoterStatusServlet
 */
@WebServlet("/voter_status")
public class VoterStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			
			//get HS from WC 
			HttpSession session=request.getSession();
			//get voter details, both of daos 
			CandidateDaoImpl candidateDao = (CandidateDaoImpl) session.getAttribute("candidate_dao");
			VoterDaoImpl voterDao=(VoterDaoImpl) session.getAttribute("voter_dao");
			Voter voter = (Voter) session.getAttribute("user_details");
			//chk if voter has alrdy cast the vote ?
			if(voter.isStatus())
			{
				//alrdy voted
				pw.print("<h5> You have already voted....</h5>");
			} else
			{
				//casted a vote just now....
				//incr votes
				int candidateId=Integer.parseInt(request.getParameter("cid"));
				String message = candidateDao.incrementVotes(candidateId);
				//change the voting status
				String updateVotingStatus = voterDao.updateVotingStatus(voter.getVoterId());
				pw.print("<h5>Status "+updateVotingStatus+"</h5>");
				pw.print("<h5>Message  :"+message+"</h5>");
			}
			//invalidate session
			session.invalidate();
			pw.println("You have logged out....");
	
		} catch (Exception e) {
			throw new ServletException("err in do-get of "+getClass().getName(), e);
		}
	}

}
