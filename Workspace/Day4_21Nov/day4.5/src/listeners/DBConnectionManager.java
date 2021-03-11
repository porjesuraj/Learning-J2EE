package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import static utils.DBUtils.*;

import java.sql.SQLException;
/**
 * Application Lifecycle Listener implementation class DBConnectionManager
 *
 */
@WebListener
public class DBConnectionManager implements ServletContextListener {

   

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	 System.out.println("in context destroy");
    	 
    	 try {
			
    	  claenUp();
    	 } catch (Exception e) {
			System.out.println("err in ctx destroy " + e);
		}
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         System.out.println("in context init");
         // create singleton instance of db connection 
         // how to get db config details : via context params 
         // how to get context param: via servlet xcontext 
         // how to get servlet context : ServletContextEvent.getServletContext();
         
         ServletContext ctx = sce.getServletContext();
         
         try {
			createSingletonDBConnection(ctx.getInitParameter("drvr_cls"),ctx.getInitParameter( "db_url"),ctx.getInitParameter("user_nm"),ctx.getInitParameter("password"));
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("err in ctx init " + e);
			e.printStackTrace();
		}
         
         
    }
	
}
