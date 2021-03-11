package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pojos.Book;

import static utils.DBUtils.fetchConnection;

public class BookDaoImpl implements IBookDao {

	private Connection cn; 
	
	private PreparedStatement pst1,pst2,pst3; 
	
	public BookDaoImpl() throws Exception {
	
		cn = fetchConnection(); 
		// for getting all categories 
				pst1 = cn.prepareStatement("select distinct category from dac_books"); 
				// pst2 : to fetch all book from a selected category 
				pst2 = cn.prepareStatement("select *  from dac_books where category=?");
				
				// pst: to fetch actul books details selected by user (from the cart)
				pst3 = cn.prepareStatement("select  * from dac_books where id=?"); 
				  System.out.println("book dao created... ");

	}
	
	public void cleanUp() throws Exception {
		
		if(this.pst1 != null)
			pst1.close();
			
			if(this.pst2 != null)
			pst2.close();
			
				if(this.pst3 != null)
				pst3.close();
				
					if(this.cn != null)
			         cn.close();
			
			System.out.println("book dao clean up");
	}
	
	@Override
	public List<String> getAllCategories() throws Exception {
		// create empty ArrayList to hold the category names
		 
				List<String> categories = new ArrayList<>(); 
				
				try(ResultSet rs = pst1.executeQuery())
				{
					while(rs.next())
					{
						//categories.add(rs.getString("category"));
						categories.add(rs.getString(1));
					}
	}
				return categories;
	}

	@Override
	public List<Book> getAllBookByCategory(String category) throws Exception {
		
		// set IN parameter 
				List<Book> books = new ArrayList<>(); 
				
				pst2.setString(1, category);

				try(ResultSet rs = pst2.executeQuery())
				{
					while(rs.next())
					books.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), category, rs.getDouble(5)));
				}
				
				return books;
	}

	@Override
	public Book getBookDetails(int bookid) throws Exception {
		
		pst3.setInt(1, bookid);
		
		Book book = null; 
		
		try(ResultSet rs = pst3.executeQuery())
		{
			if(rs.next())
				book = new Book(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getDouble(5));	
		}
		return book;
	}

}
