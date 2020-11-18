package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServlateDemo
 */

public class ServlateDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		System.out.println("in get : " + Thread.currentThread());
		
		resp.setContentType("text/html");
		
		try(PrintWriter writer = resp.getWriter())
		{
			writer.print("Hello from Server : @" + LocalDateTime.now() );
		}
	}

	@Override
	public void destroy() {
		System.out.println("in destroy : " + this.getClass().getName() + " " + Thread.currentThread());
	}

	@Override
	public void init() throws ServletException {
		System.out.println("in init : " + this.getClass().getName() + " " + Thread.currentThread());
	}
       
}
