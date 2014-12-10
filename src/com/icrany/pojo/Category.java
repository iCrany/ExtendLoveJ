package com.icrany.pojo;

import java.util.Date;

/**
 * 分类目录
 * @author Administrator
 *
 */
public class Category {

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public boolean isTrash() {
		return trash;
	}

	public void setTrash(boolean trash) {
		this.trash = trash;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private int id;
	
	private int articleId;
	
	private int parentId;
	
	private Date createTime;
	
	private String description;
	
	private String name;
	
	private int priority;
	
	private boolean trash;
	
	private String type;
	
	
	
}
