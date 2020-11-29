package listerners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import utils.HibernateUtils;

/**
 * Application Lifecycle Listener implementation class SessionFactoryManager
 *
 */
@WebListener
public class SessionFactoryManager implements ServletContextListener {

   
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
        System.out.println("context destroyed");
        HibernateUtils.getSf().close();
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         
    	System.out.println("contenxt inited");
    	
    	HibernateUtils.getSf();
    }
	
}
