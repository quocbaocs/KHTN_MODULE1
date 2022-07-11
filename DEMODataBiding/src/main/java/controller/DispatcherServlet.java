package controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Account;



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
			}

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



}
