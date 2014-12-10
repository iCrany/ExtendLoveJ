package com.icrany.pojo;

import java.util.Date;

/**
 * 友情连接
 * @author Administrator
 *
 */
public class Link {
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isTrash() {
		return trash;
	}

	public void setTrash(boolean trash) {
		this.trash = trash;
	}

	private int id;
	
	private Date createTime;
	
	private String description;
	
	private String name;
	
	private String site;
	
	private String status;
	
	private boolean trash;
	
	
}
