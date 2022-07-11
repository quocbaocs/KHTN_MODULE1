package com.coding.servlet.blogger.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.coding.servlet.dao.DAO;
import com.coding.servlet.vo.BloggerVO;

public class BloggerDAO implements DAO<BloggerVO> {

	private DataSource ds;
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	private final String BLOGGER_INSERT = "insert into tbl_users (name,email, psswd) values (?,?,?)";
	private final String BLOGGER_UPDATE = "update tbl_users set name=?, passwd=?, email=? where uid=?";
	private final String BLOGGER_DELETE = "delete tbl_users where uid=?";// use primary key
	private final String BLOGGER_GET = "select * from tbl_users where uid=?";
	private final String BLOGGER_LIST = "select * from tbl_users order by uid desc";

	@Override
	public void insert(BloggerVO vo) {

		try {
			con = ds.getConnection();
			stmt = con.prepareStatement(BLOGGER_INSERT);
			stmt.setString(1, vo.getName());
			stmt.setString(2, vo.getEmail());
			stmt.setString(3, vo.getPasswd());
			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	@Override
	public void update(BloggerVO vo) {

		try {
			con = ds.getConnection();
			stmt = con.prepareStatement(BLOGGER_UPDATE);
			stmt.setString(1, vo.getName());
			stmt.setString(2, vo.getPasswd());
			stmt.setString(3, vo.getEmail());
			stmt.setInt(4, vo.getUid());
			stmt.executeUpdate();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	@Override
	public void delete(BloggerVO vo) {

		try {
			con = ds.getConnection();
			stmt = con.prepareStatement(BLOGGER_DELETE);
			stmt.setInt(1, vo.getUid());
			stmt.executeUpdate();// insert, update,delete
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	@Override
	public BloggerVO get(long uid) {

		BloggerVO blogger = null;
		try {
			con = ds.getConnection();
			stmt = con.prepareStatement(BLOGGER_GET);
			stmt.setInt(1, (int) uid);
			rs = stmt.executeQuery();// select
			if (rs.next()) {
				// has result
				// Object Relation Mapping
				blogger = new BloggerVO();
				blogger.setUid(rs.getInt(1));
				blogger.setName(rs.getString(2));
				blogger.setPasswd(rs.getString(3));
				blogger.setEmail(rs.getString(4));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return blogger;
	}

	@Override
	public List<BloggerVO> list() {

		List<BloggerVO> list = new ArrayList<BloggerVO>();
		try {
			con = ds.getConnection();
			stmt = con.prepareStatement(BLOGGER_LIST);
			rs = stmt.executeQuery();// select
			while (rs.next()) {
				// has result
				// Object Relation Mapping
				BloggerVO blogger = new BloggerVO();
				blogger.setUid(rs.getInt(1));
				blogger.setName(rs.getString(2));
				blogger.setPasswd(rs.getString(3));
				blogger.setEmail(rs.getString(4));

				list.add(blogger);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public void setDataSource(DataSource ds) {
		// TODO Auto-generated method stub
		this.ds = ds;
	}

}
