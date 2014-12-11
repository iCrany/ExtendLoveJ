package com.icrany.vo;

import org.kidding.orm.entity.POJO;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 
 * @author Administrator
 *
 */
@Table(name="contact")
public class Contact extends POJO implements Serializable {
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Boolean isTrash() {
		return trash;
	}

	public void setTrash(Boolean trash) {
		this.trash = trash;
	}

	@Id
	private Integer id;
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
	
	private Boolean trash;
	
	
}
