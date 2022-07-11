package com.coding.mvc.controller;

import java.util.Map;

import javax.sql.DataSource;

import com.coding.servlet.blogger.dao.BloggerDAO;
import com.coding.servlet.vo.BloggerVO;

public class BloggerJoinController implements Controller, ObjectDAO<BloggerDAO>, DataBinding{

	private BloggerDAO dao;

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BloggerJoinController");
		if (model.get("blogger") == null) {
			System.out.println("dang nam oi join");
			return ("/jsp/blogger/join.jsp");
		} else {
			System.out.println("Dng nam o day");
			// BloggerDAO dao = new BloggerDAO();
//			dao = (BloggerDAO) model.get("bloggerDao");
			dao.insert((BloggerVO) model.get("blogger"));
			// save into DB
			return ("redirect:/blogger/list.do");
		}

		// return "redirect:/blogger/list.do"
	}

	@Override
	public Controller setObjectDao(BloggerDAO bloggerDao) {
		// TODO Auto-generated method stub
		this.dao = bloggerDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		// TODO Auto-generated method stub
		return new Object[] {"blogger", BloggerVO.class};
	}

}
