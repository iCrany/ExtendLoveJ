package com.icrany.pojo;

import java.util.Date;

/**
 * 文章的评论类
 * @author Administrator
 */
public class Comment {
	public boolean isTrash() {
		return trash;
	}

	public void setTrash(Boolean trash) {
		this.trash = trash;
	}

	public Boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostIP() {
		return postIP;
	}

	public void setPostIP(String postIP) {
		this.postIP = postIP;
	}

	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	private int id;
	
	private int articleId;
	
	private String content;
	
	private String email;
	
	private String name;
	
	private String postIP;
	
	private Date postTime;
	
	/**
	 * 用户的网址，可为空
	 */
	private String site;
	
	/**
	 * 是否通过审核
	 */
	private Boolean status;
	
	/**
	 * 是否为垃圾评论
	 */
	private boolean trash;
	
	
}
