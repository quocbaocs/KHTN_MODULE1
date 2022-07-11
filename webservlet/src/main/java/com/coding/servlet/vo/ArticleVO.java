package com.coding.servlet.vo;

import java.util.Date;

//entity is vo
public class ArticleVO {
	private Long aid;
	private String title;
	private String content;
	private String name;// writer
	private Date wdate;

	public Long getAid() {
		return aid;
	}

	public void setAid(Long aid) {
		this.aid = aid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getWdate() {
		return wdate;
	}

	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}

	public ArticleVO(Long aid, String title, String content, String name, Date wdate) {
		super();
		this.aid = aid;
		this.title = title;
		this.content = content;
		this.name = name;
		this.wdate = wdate;
	}

	public ArticleVO() {
		super();
	}

	public ArticleVO(long parseLong, String title2, String content2, String name2) {
		// TODO Auto-generated constructor stub
		this.aid = aid;
		this.title = title;
		this.content = content;
		this.name = name;
	}

}
