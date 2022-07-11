
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import entity.Account;

public class AccountDAO implements DAO<Account> {

	private DataSource ds;
	private Connection conn = null;
	private PreparedStatement stmt = null;// compile(make) sql
	private ResultSet rs = null;
	// SQL
	private final String account_INSERT = "insert into user (username, password) values (?,?)";
	private final String account_UPDATE = "update user set username=?, password=? where id=?";
	private final String account_DELETE = "delete user where id=?";// use primary key
	private final String account_GET = "select * from user where id=?";
	private final String account_LIST = "select * from user order by id desc";

	// CRUD methods
	@Override
	public void insert(Account vo) {
		// SQL, NULL, NOTFOUNT
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(account_INSERT);
			stmt.setString(1, vo.getUsername());
			stmt.setString(2, vo.getPassword());
			stmt.executeUpdate();// insert, update,delete
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// memory free, close

			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	@Override
	public void update(Account vo) {

		try {
			// TODO: why to Template in JDBCUtils
			conn = ds.getConnection();
			stmt = conn.prepareStatement(account_UPDATE);
			stmt.setString(1, vo.getUsername());
			stmt.setString(2, vo.getPassword());
			stmt.executeUpdate();// insert, update,delete
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

	@Override
	public void delete(Account vo) {

		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(account_DELETE);
			stmt.setLong(1, vo.getId());
			stmt.executeUpdate();// insert, update,delete
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

	@Override
	public Account get(long aid) {

		Account account = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(account_GET);
			stmt.setInt(1, (int) aid);
			rs = stmt.executeQuery();// select
			if (rs.next()) {
				// has result
				// Object Relation Mapping
				account = new Account();
				account.setUsername(rs.getString("username"));
				account.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e2) {
				// TODO: handle exception
			}

		}
		return account;
	}

	@Override
	public List<Account> list() {
		List<Account> list = new ArrayList<Account>();
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(account_LIST);
			rs = stmt.executeQuery();// select
			while (rs.next()) {
				// has result
				// Object Relation Mapping
				Account account = new Account();
				account.setUsername(rs.getString("username"));
				account.setPassword(rs.getString("password"));
				list.add(account);
			}
			return list;
		} catch (Exception e) {
			// error handling
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return null;
	}

	@Override
	public void setDataSource(DataSource ds) {
		// TODO Auto-generated method stub
		this.ds = ds;
	}

}
