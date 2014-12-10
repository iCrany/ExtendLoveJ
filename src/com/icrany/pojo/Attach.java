package com.icrany.pojo;

/**
 * 一个属于附件的类
 * @author Administrator
 *
 */
public class Attach {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDownload() {
		return download;
	}

	public void setDownload(int download) {
		this.download = download;
	}

	private int id;
	
	private int articleId;
	
	private String description;
	
	private int download;
	
}
