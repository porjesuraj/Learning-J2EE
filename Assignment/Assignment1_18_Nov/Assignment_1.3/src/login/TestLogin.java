package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VoterdaoTest;
import pojo.voters;

/**
 * Servlet implementation class TestLogin
 */
@WebServlet(description = "using JDBC", urlPatterns = { "/login" })
public class TestLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		
		try(PrintWriter pw = response.getWriter())
		{
			
		   VoterdaoTest test = new VoterdaoTest();
		   
		   
		   String email = request.getParameter("email");
		   
		   String password = request.getParameter("password"); 
		   
		   
		   voters voter = test.validateUser(email,password );
		   
		   if(voter != null)
		   {
			   pw.println("voter found");
			   pw.println(voter.toString());
		   }else
		   {
			   pw.println("voter not found");
		   }
		   
		   
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
