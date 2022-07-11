package com.coding.mvc;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coding.mvc.controller.BloggerJoinController;
import com.coding.mvc.controller.BloggerListController;
import com.coding.mvc.controller.Controller;
import com.coding.mvc.controller.DataBinding;
import com.coding.servlet.vo.ArticleVO;
import com.coding.servlet.vo.BloggerVO;

/**
 * is not servlet normal Class
 * 
 * role of DispatcherServlet
 * 
 * 1. receive all request call "Font Controller" + URL ? + select controller 2.
 * logic --> delegate to Controller.execute() with Interface + if need data,
 * pass data to controller + return result , view (jsp) 3.response +view ->
 * response
 * 
 * 
 * @author Virus
 *
 */
@WebServlet(description = "front controller", urlPatterns = { "*.do" })
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DispatcherServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * dispatching follow request URL
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Dispatcher -->");
		// korean, eng, vietnamese <-- standard
		response.setContentType("text/html; charset=UTF-8");
		String servletPath = request.getServletPath();
		ServletContext ctx = request.getServletContext();

		Controller controller = (Controller) ctx.getAttribute(servletPath);
		try {
			HashMap<String, Object> model = new HashMap<String, Object>();
			String viewUrl = null;
			// check request URL
			// model.put("bloggerDao",
			// request.getServletContext().getAttribute("bloggerDao"));
			if (controller instanceof DataBinding) {
				bindRequestData(request, model, (DataBinding) controller);

//				Object[] o = ((DataBinding) controller).getDataBinders();
//				System.out.println("----");
//				for (Object s : o) {
//					System.out.println(String.valueOf(s));
//				}
//				System.out.println("----");
			}
//			if ("/article/list.do".equals(servletPath)) {
//
//			} else if ("/article/view.do".equals(servletPath)) {
//				model.put("id", request.getParameter("id"));
//
//			} else if ("/article/edit.do".equals(servletPath)) {
//				System.out.println(request.getMethod());
//				if (request.getMethod().equals("GET")) {
//					model.put("id", request.getParameter("id"));
//					model.put("title", null);
//				} else {
//					model.put("id", request.getParameter("id"));
//					model.put("title", request.getParameter("title"));
//					model.put("name", request.getParameter("name"));
//					model.put("content", request.getParameter("content"));
//
//				}
//
//			} else if ("/article/new.do".equals(servletPath)) {
//				System.out.println(request.getMethod());
//				if (request.getMethod().equals("POST")) {
//					model.put("id", request.getParameter("id"));
//					model.put("id", request.getParameter("id"));
//					model.put("title", request.getParameter("title"));
//					model.put("name", request.getParameter("name"));
//					model.put("content", request.getParameter("content"));
//
//				}
//
//			} else 
//				if ("/blogger/list.do".equals(servletPath)) {
//				// processing, what result ?
//				// controller = new BloggerListController();
//			} else if ("/blogger/join.do".equals(servletPath)) {
//				// controller = new BloggerJoinController();
//				model.put("session", request.getSession());
//				if (request.getParameter("uname") != null) {
//					// from join
//					BloggerVO blogger = new BloggerVO();
//					blogger.setName(request.getParameter("uname"));
//					blogger.setEmail(request.getParameter("uemail"));
//					blogger.setPasswd(request.getParameter("upass"));
//					model.put("blogger", blogger); // join jsp
//				} else {
//					model.put("blogger", null); // join jsp
//				}
//			}
			// response to client, who views
			viewUrl = controller.execute(model);
			
			// model has result data ( more and more )
			for (String key : model.keySet()) {
				request.setAttribute(key, model.get(key));
				//System.out.println(key + "-->"+model.get(key));
			}
		
			if (viewUrl.startsWith("redirect:")) {
				// return ("redirect:/jsp/blogger/list.do");
				response.sendRedirect(request.getContextPath() + viewUrl.substring(9));
			} else {
				// forward view
				// return "redirect:/blogger/list.do"
				RequestDispatcher rd = request.getRequestDispatcher(viewUrl);
				rd.forward(request, response);
				
			}
		} catch (Exception e) {
			// change URL by client
			response.sendRedirect(request.getContextPath() + "/error.jsp");
		}

	}

	private void bindRequestData(HttpServletRequest request, HashMap<String, Object> model, DataBinding controller)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		Object[] databinders = controller.getDataBinders();
		String dataName = null;
		Class<?> dataType = null;
		Object dataObj = null; // instance of dataType
		for (int i = 0; i < databinders.length; i += 2) {
			dataName = (String) databinders[i];
			dataType = (Class<?>) databinders[i + 1];
			// create instance of dataType
			dataObj = ServletRequestDataBinder.bind(request, dataType, dataName);
			model.put(dataName, dataObj); // to controller
		}

	}
//	public static void main(String[] args) {
//		System.out.println(Integer.class.getName());
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

//	@Override
//	protected void service1(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		
//		System.out.println("Dispatcher -->");
//		//korean, eng, vietnamese <-- standard
//		response.setContentType("text/html; charset=UTF-8");
//		String servletPath = request.getServletPath();
//		System.out.println(servletPath);
//	}

	// --------------------------------------------------------------------------------------
//	@Override
//	protected void service2(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		System.out.println("Dispatcher -->");
//		// korean, eng, vietnamese <-- standard
//		response.setContentType("text/html; charset=UTF-8");
//		String servletPath = request.getServletPath();
//		// check request URL
//		if ("/blogger/list.do".equals(servletPath)) {
//			// processing, what result ?
//			Controller controller = new BloggerListController();
//			HashMap<String, Object> model = new HashMap<String, Object>();
//			String viewUrl;
//			try {
//				viewUrl = controller.execute(model);
//				
//				// response to client, who views
//				//model has result data ( more and more )
//				for(String key: model.keySet()) {
//					request.setAttribute(key, model.get(key));
//				}
//				
//				RequestDispatcher rd = request.getRequestDispatcher("/jsp/blogger/list.jsp");
//				rd.forward(request, response);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		}
//	}

	// ------------------------------------
//	@Override
//	protected void service(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		System.out.println("Dispatcher -->");
//		// korean, eng, vietnamese <-- standard
//		response.setContentType("text/html; charset=UTF-8");
//		String servletPath = request.getServletPath();
//		Controller controller = null;
//
//		try {
//			HashMap<String, Object> model = new HashMap<String, Object>();
//			String viewUrl = null;
//			// check request URL
//			if ("/blogger/list.do".equals(servletPath)) {
//				// processing, what result ?
//				controller = new BloggerListController();
//			} else if ("/blogger/join.do".equals(servletPath)) {
//				controller = new BloggerJoinController();
//				if(request.getParameter("uname")!=null) {
//					//from join
//					BloggerVO blogger = new BloggerVO();
//					blogger.setName(request.getParameter("uname"));
//					blogger.setEmail(request.getParameter("uemail"));
//					blogger.setPasswd(request.getParameter("upass"));
//					model.put("blogger", blogger); //join jsp
//				}else {
//					model.put("blogger", null); //join jsp
//				}
//			}
//			// response to client, who views
//			viewUrl = controller.execute(model);
//
//			// model has result data ( more and more )
//			for (String key : model.keySet()) {
//				request.setAttribute(key, model.get(key));
//			}
//			RequestDispatcher rd = request.getRequestDispatcher(viewUrl);
//			rd.forward(request, response);
//
//		} catch (Exception e) {
//			// change URL by client
//			response.sendRedirect(request.getContextPath() + "/error.jsp");
//		}
//
//	}

	// -------------------------------------------
//	@Override
//	protected void service(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		System.out.println("Dispatcher -->");
//		// korean, eng, vietnamese <-- standard
//		response.setContentType("text/html; charset=UTF-8");
//		String servletPath = request.getServletPath();
//		Controller controller = null;
//
//		try {
//			HashMap<String, Object> model = new HashMap<String, Object>();
//			String viewUrl = null;
//			// check request URL
//			if ("/blogger/list.do".equals(servletPath)) {
//				// processing, what result ?
//				controller = new BloggerListController();
//			} else if ("/blogger/join.do".equals(servletPath)) {
//				controller = new BloggerJoinController();
//				if (request.getParameter("uname") != null) {
//					// from join
//					BloggerVO blogger = new BloggerVO();
//					blogger.setName(request.getParameter("uname"));
//					blogger.setEmail(request.getParameter("uemail"));
//					blogger.setPasswd(request.getParameter("upass"));
//					model.put("blogger", blogger); // join jsp
//				} else {
//					model.put("blogger", null); // join jsp
//				}
//			}
//			// response to client, who views
//			viewUrl = controller.execute(model);
//
//			// model has result data ( more and more )
//			for (String key : model.keySet()) {
//				request.setAttribute(key, model.get(key));
//			}
//
//			if (viewUrl.startsWith("redirect:")) {
//				// return ("redirect:/jsp/blogger/list.do");
//				response.sendRedirect(request.getContextPath()+viewUrl.substring(9));
//			} else {
//				// forward view
//				// return "redirect:/blogger/list.do"
//				RequestDispatcher rd = request.getRequestDispatcher(viewUrl);
//				rd.forward(request, response);
//			}
//		} catch (Exception e) {
//			// change URL by client
//			response.sendRedirect(request.getContextPath() + "/error.jsp");
//		}
//
//	}

}
