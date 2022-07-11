package com.coding.servlet.article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.coding.servlet.dao.DAO;
import com.coding.servlet.vo.ArticleVO;

public class ArticleDAO implements DAO<ArticleVO> {
	private DataSource ds;
	private Connection conn = null;
	private PreparedStatement stmt = null;// compile(make) sql
	private ResultSet rs = null;
	// SQL
	private final String ARTICLE_INSERT = "insert into tbl_article (title,content,name) values (?,?,?)";
	private final String ARTICLE_UPDATE = "update tbl_article set title=?, content=?, name=? where aid=?";
	private final String ARTICLE_DELETE = "delete tbl_article where aid=?";// use primary key
	private final String ARTICLE_GET = "select * from tbl_article where aid=?";
	private final String ARTICLE_LIST = "select * from tbl_article order by aid desc";

	// CRUD methods
	@Override
	public void insert(ArticleVO vo) {
		// SQL, NULL, NOTFOUNT
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(ARTICLE_INSERT);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setString(3, vo.getName());
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
	public void update(ArticleVO vo) {

		try {
			// TODO: why to Template in JDBCUtils
			conn = ds.getConnection();
			stmt = conn.prepareStatement(ARTICLE_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setString(3, vo.getName());
			stmt.setLong(4, vo.getAid());
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
	public void delete(ArticleVO vo) {

		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(ARTICLE_DELETE);
			stmt.setLong(1, vo.getAid());
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
	public ArticleVO get(long aid) {

		ArticleVO article = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(ARTICLE_GET);
			stmt.setInt(1, (int) aid);
			rs = stmt.executeQuery();// select
			if (rs.next()) {
				// has result
				// Object Relation Mapping
				article = new ArticleVO();
				article.setAid(rs.getLong("AID"));
				article.setTitle(rs.getString("TITLE"));
				article.setContent(rs.getString("CONTENT"));
				article.setName(rs.getString("NAME"));
				article.setWdate(rs.getDate("WDATE"));
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
		return article;
	}

	@Override
	public List<ArticleVO> list() {
		List<ArticleVO> list = new ArrayList<ArticleVO>();
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(ARTICLE_LIST);
			rs = stmt.executeQuery();// select
			while (rs.next()) {
				// has result
				// Object Relation Mapping
				ArticleVO article = new ArticleVO();
				article.setAid(rs.getLong("AID"));
				article.setTitle(rs.getString("TITLE"));
				article.setContent(rs.getString("CONTENT"));
				article.setName(rs.getString("NAME"));
				article.setWdate(rs.getDate("WDATE"));

				list.add(article);
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
