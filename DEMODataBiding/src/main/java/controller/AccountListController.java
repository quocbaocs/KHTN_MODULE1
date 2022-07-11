package controller;

import java.util.Map;

import dao.AccountDAO;
import entity.Account;

public class AccountListController implements Controller {
	private AccountDAO dao;


	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		return "/jsp/list.jsp";
	}

	

	public Controller setAccountDao(AccountDAO accountDao) {
		// TODO Auto-generated method stub
		this.dao = accountDao;
		return this;
	}

}
