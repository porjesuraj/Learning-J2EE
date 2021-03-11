package dao;

import java.util.List;

import pojos.Book;

public interface IBookDao {

	// add a method to fetch all distinct category names from DB :called by Category Servlet
	
	
		List<String> getAllCategories() throws Exception; 
		
		// add a method to fetch all book from a  selected category : called by Category Details Servlet 
		List<Book> getAllBookByCategory(String category ) throws Exception; 
		// add a method to fetch actual book details selected by user : called by ShowCard Servlet and Checkout
	        Book getBookDetails(int bookid) throws Exception;
		
	    
}
