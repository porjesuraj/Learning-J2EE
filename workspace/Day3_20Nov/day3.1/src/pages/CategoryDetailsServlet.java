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

import dao.BookDaoImpl;
import pojos.Book;

/**
 * Servlet implementation class CategoryDetailsServlet
 */
@WebServlet("/category_details")
public class CategoryDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// set cont type 
		response.setContentType("text/html");
		
		try(PrintWriter pw = response.getWriter())
		{ // get hs fro wc 
			
			HttpSession session = request.getSession(); 
			
			// get book dao  from hs
			
			BookDaoImpl bookdao = (BookDaoImpl) session.getAttribute("book_dao"); 
			
			if(bookdao != null)
			{
				// get the choosen category 
				// http://localhost:8080/Day3.1/category_details?cname=angular
			String cname = request.getParameter("cname"); 
				
			// pass to dao layer to invoke method to fetch all from choosen categories 
		 
			List<Book> choosenBooks = bookdao.getAllBookByCategory(cname);
			// display choosen category 
			pw.print("<h5> Books Under " + cname + " category </h5>");
			pw.print(" <form action='add_to_cart' >");
			
			// dyn gen checkboxes 
			
			
			
			for(Book b : choosenBooks)
			{
				pw.print("<input type='checkbox' name ='book_id' value=" + b.getId() + ">" + b + "<br>" );
				
			}
		 // add submit button to add to cart 
			pw.print("<input type='submit' value='Add_To_Cart'>"); // http://localhost:8080/Day3.1/category_details?cname=angular
			pw.print("</form>");
			
				
			}else
			{
				pw.print("<h5> No cookies,. session tracking failed </h5>");
			}
			
			
			
		}catch (Exception e) {
			// rethrow exec to wc 
			throw new ServletException("error in do get of" + this.getClass().getName(),e);
		}
	}

}
