package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ClientDemo
 */
@WebServlet("/client")
public class ClientDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		response.setContentType("text/html");
		
		try(PrintWriter writer = response.getWriter())
		{ 
			writer.print("<h2>  name : " + request.getParameter("name") + "</h2>");
			writer.print("<h2> color : " + request.getParameter("color")  + "</h2>");
			writer.print("<h2> browser : " + request.getParameter("browser")  + "</h2>");
			writer.print("<h2> city : " + request.getParameter("city")  + "</h2>");
			
		}
	}

}
