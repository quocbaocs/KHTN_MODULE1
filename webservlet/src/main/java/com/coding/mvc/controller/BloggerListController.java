package com.coding.mvc.controller;

import java.util.List;
import java.util.Map;

import com.coding.servlet.blogger.dao.BloggerDAO;
import com.coding.servlet.vo.ArticleVO;
import com.coding.servlet.vo.BloggerVO;

public class BloggerListController implements Controller, ObjectDAO<BloggerDAO> {

	private BloggerDAO dao;

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		System.out.println("BloggerListController");
//		BloggerDAO dao = new BloggerDAO();
//		dao = (BloggerDAO) model.get("bloggerDao");
		List<BloggerVO> list = dao.list();
		model.put("userList", list);
		System.out.println("Data biding BloggerListController");
		return ("/jsp/blogger/list.jsp");
	}

	@Override
	public Controller setObjectDao(BloggerDAO bloggerDao) {
		// TODO Auto-generated method stub
		this.dao = bloggerDao;
		return this;
	}

}
