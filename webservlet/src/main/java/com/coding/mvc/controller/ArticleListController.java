package com.coding.mvc.controller;

import java.util.List;
import java.util.Map;

import com.coding.servlet.article.dao.ArticleDAO;
import com.coding.servlet.vo.ArticleVO;

public class ArticleListController implements Controller, ObjectDAO<ArticleDAO> {

	private ArticleDAO dao;

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		List<ArticleVO> list = dao.list();
		model.put("articleList", list);
		return ("/jsp/article/list.jsp");
	}

	@Override
	public Controller setObjectDao(ArticleDAO articleDao) {
		// TODO Auto-generated method stub
		this.dao = articleDao;
		return this;
	}
}
