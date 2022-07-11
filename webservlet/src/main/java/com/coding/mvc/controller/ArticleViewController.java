package com.coding.mvc.controller;

import java.util.Map;

import com.coding.servlet.article.dao.ArticleDAO;
import com.coding.servlet.vo.ArticleVO;

public class ArticleViewController implements Controller, ObjectDAO<ArticleDAO> {

	private ArticleDAO dao;

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		String id = (String) model.get("id");
		long aid = Long.parseLong(id);
		ArticleVO article = dao.get(aid);
		model.put("article", article);
		return ("/jsp/article/detail.jsp");
	}

	@Override
	public Controller setObjectDao(ArticleDAO object) {
		// TODO Auto-generated method stub
		this.dao = object;
		return this;
	}

}
