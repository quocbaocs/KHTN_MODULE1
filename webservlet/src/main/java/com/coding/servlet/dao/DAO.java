package com.coding.servlet.dao;



import java.util.List;

import javax.sql.DataSource;

public interface DAO<T> {
	
	// CRUD methods
	void insert(T vo);

	void update(T vo);

	void delete(T vo);

	T get(long vo);

	List<T> list();
	
	void setDataSource(DataSource ds);

}
