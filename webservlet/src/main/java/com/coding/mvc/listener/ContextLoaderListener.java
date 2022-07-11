package com.coding.mvc.listener;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import com.coding.mvc.controller.ArticleEditController;
import com.coding.mvc.controller.ArticleListController;
import com.coding.mvc.controller.ArticleNewController;
import com.coding.mvc.controller.ArticleViewController;
import com.coding.mvc.controller.BloggerJoinController;
import com.coding.mvc.controller.BloggerListController;
import com.coding.servlet.article.dao.ArticleDAO;
import com.coding.servlet.blogger.dao.BloggerDAO;

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
			BloggerDAO bloggerDao = new BloggerDAO();
			bloggerDao.setDataSource(ds);
//			context.setAttribute("dao", bloggerDao);
			//context.setAttribute("bloggerDao", bloggerDao);
			context.setAttribute("/blogger/list.do", new BloggerListController().setObjectDao(bloggerDao));
			context.setAttribute("/blogger/join.do", new BloggerJoinController().setObjectDao(bloggerDao));
			
			ArticleDAO articleDao = new ArticleDAO();
			articleDao.setDataSource(ds);
			
			context.setAttribute("/article/list.do", new ArticleListController().setObjectDao(articleDao));
			context.setAttribute("/article/new.do", new ArticleNewController().setObjectDao(articleDao));
			context.setAttribute("/article/edit.do", new ArticleEditController().setObjectDao(articleDao));
			context.setAttribute("/article/view.do", new ArticleViewController().setObjectDao(articleDao));
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
