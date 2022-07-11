package com.coding.mvc.controller;

import java.util.Map;

import com.coding.servlet.article.dao.ArticleDAO;
import com.coding.servlet.vo.ArticleVO;

public class ArticleEditController implements Controller, ObjectDAO<ArticleDAO> {

	private ArticleDAO dao;

	private String doGet(Map<String, Object> model) {
		String id = (String) model.get("id");
		ArticleVO article = dao.get(Long.parseLong(id));
		model.put("article", article);
		return "/jsp/article/form-edit.jsp";
	}

	private String doPost(Map<String, Object> model) {
		String id = (String) model.get("id");
		String title = (String) model.get("title");
		String name = (String) model.get("name");
		String content = (String) model.get("content");
		ArticleVO article = new ArticleVO(Long.parseLong(id), title, content, name);
		dao.update(article);
		return "redirect:/article/view?id=" + article.getAid();
	}

	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		String id = (String) model.get("id");
		String title = (String) model.get("title");
		String viewUrl = "/error.jsp";
		if (title == null || title.isEmpty()) {
			if (id != null && !id.isEmpty()) {
				viewUrl = doGet(model);
			}
		} else {
			viewUrl = doPost(model);
		}
		return viewUrl;

	}

	@Override
	public Controller setObjectDao(ArticleDAO object) {
		// TODO Auto-generated method stub
		this.dao = object;
		return this;
	}

}
