package pages;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddToCart
 */
@WebServlet("/add_to_cart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get selected book ids from request params : sent by client 
		
		 String[] booksId = request.getParameterValues("book_id");
		 
		 HttpSession session = request.getSession(); 
		 
		 // get cart from session scope 
		 
		 
		 List<Integer> cart = (List<Integer>) session.getAttribute("shopping_cart"); 
		
		 for(String s : booksId)
		 {
			 cart.add(Integer.parseInt(s)); // iny --> Integer (auto boxing)
			
		 }
		 System.out.println("cart contents  " + cart);
		 // redirect the clnt to Category page in the next request 
		 response.sendRedirect("category");
		 
	}

}














