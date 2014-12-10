package com.icrany.pojo;

/**
 * 
 * @author Administrator
 *
 */
public class Contact {
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPostTime() {
		return postTime;
	}

	public void setPostTime(String postTime) {
		this.postTime = postTime;
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
	/**
	 * not null
	 */
	private String content;
	/**
	 * not null
	 */
	private String email;
	/**
	 * not null
	 */
	private String name;
	
	private String postIP;
	/**
	 * not null
	 */
	private String postTime;
	
	private String site;
	
	private String status;
	
	private boolean trash;
	
	
}
