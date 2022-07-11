package controller;

import java.util.Map;

import dao.AccountDAO;
import entity.Account;

public class AccountNewController implements Controller, DataBinding {
	private AccountDAO dao;

	@Override
	public Object[] getDataBinders() {
		// TODO Auto-generated method stub
		System.out.println("Biding user inssert");
		return new Object[] { "user", Account.class };
	}

	private String doPost(Map<String, Object> model) {
		Account account = (Account) model.get("user");
		System.out.println(account.toString());
		dao.insert(account);
		return "redirect:/account/list.do";
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		String viewUrl = "/jsp/new.jsp";
		System.out.println("ArticleNewController");
		if (model.get("username") != null) {
			viewUrl = doPost(model);
		}
		return viewUrl;
	}

	public Controller setAccountDao(AccountDAO accountDao) {
		// TODO Auto-generated method stub
		this.dao = accountDao;
		return this;
	}

}
