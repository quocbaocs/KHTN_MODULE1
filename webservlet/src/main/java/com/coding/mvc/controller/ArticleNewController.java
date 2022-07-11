package com.coding.mvc.controller;

import java.util.Map;

import com.coding.servlet.article.dao.ArticleDAO;
import com.coding.servlet.vo.ArticleVO;

public class ArticleNewController implements Controller, ObjectDAO<ArticleDAO>, DataBinding {

	private ArticleDAO dao;

	private String doPost(Map<String, Object> model) {
		String id = (String) model.get("id");
		String title = (String) model.get("title");
		String name = (String) model.get("name");
		String content = (String) model.get("content");
		ArticleVO article = new ArticleVO(Long.parseLong(id), title, content, name);
		dao.insert(article);
		return "redirect:/article/list.do";
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		String viewUrl = "/jsp/article/form-new.jsp";
		System.out.println("ArticleNewController");
		if (model.get("title") != null) {
			viewUrl = doPost(model);
		}
		return viewUrl;
	}

	@Override
	public Controller setObjectDao(ArticleDAO articleDao) {
		// TODO Auto-generated method stub
		this.dao = articleDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		// TODO Auto-generated method stub
		return new Object[] {"article", ArticleVO.class		
		};
	}
}
