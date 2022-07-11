package listener;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;



import controller.AccountListController;
import controller.AccountNewController;
import dao.AccountDAO;

/**
 * Application Lifecycle Listener implementation class ContextLoaderListener
 *
 */
@WebListener
public class ContextLoaderListener implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public ContextLoaderListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		ServletContext context = arg0.getServletContext();
		// DB init with Tomcat Connection Pooling
		InitialContext initcontext;
		try {
			initcontext = new InitialContext();
			DataSource ds = (DataSource) initcontext.lookup("java:comp/env/jdbc/mysql");
			AccountDAO accountDao = new AccountDAO();
			accountDao.setDataSource(ds);
//			context.setAttribute("dao", bloggerDao);
			//context.setAttribute("bloggerDao", bloggerDao);
			context.setAttribute("/account/list.do", new AccountListController().setAccountDao(accountDao));
			context.setAttribute("/account/join.do", new AccountNewController().setAccountDao(accountDao));
			
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
