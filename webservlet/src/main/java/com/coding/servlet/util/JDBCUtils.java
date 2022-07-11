package com.coding.servlet.util;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Deprecated
public abstract class JDBCUtils {
	protected Connection conn;
	private Object factory;

	public JDBCUtils() {
		// TODO Auto-generated constructor stub
		try {
			Context ctx = new InitialContext();
			Context env = (Context) ctx.lookup("java:/comp/env");
			factory = env.lookup("jdbc/mysql");
//		return DataSource;

		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
