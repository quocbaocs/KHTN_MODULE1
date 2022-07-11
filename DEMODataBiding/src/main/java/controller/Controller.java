package controller;


/**
 * Controller pattern - interface to connect with DispatcherServlet
 * @return view name: JSP
 * @arg data to process
 * all type Object's child Object obj = new AnyClass();
 *  List<Object>	--> select one ? is difficult 
 *  for(){
 *  //element's type: String, Blogger, Article
 *  if(){}
 *  }
 */

public interface Controller {
	String execute(java.util.Map<String, Object> model) throws Exception ;
}
