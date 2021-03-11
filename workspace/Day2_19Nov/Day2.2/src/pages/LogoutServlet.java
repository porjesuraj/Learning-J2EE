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
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		try(PrintWriter pw = response.getWriter())
		{
			// get cookies from client req header
			
			Cookie[] cookies  = request.getCookies();
			
			if(cookies != null)
			{
				// retrieve user details from cookie 
				
				for(Cookie c : cookies)
				{
					if(c.getName().equals("customer_details")) {
						
						pw.print("<h5> User Details : in logout page " + c.getValue() + "</h5>");
						// inform web browser to set cookie age : 0 for delete , 1: perist , -1 : keep for session 
						c.setMaxAge(0);
						
						response.addCookie(c);
        						
					}
				}
				
 			}else
 			{
 				pw.print("<h3> No cookies found : Session tracking failed ... </h3>");
 			}
			pw.print("<h3> you have logged out... </h3> ");
			
			// send a link for user to visit again 
			
			pw.print("<h5> <a href='login.html'> Visit Again </a> </h5> " );
			
		}
	}

}
