package com.icrany.vo;

import org.kidding.orm.entity.POJO;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 文章的评论类
 * @author Administrator
 */
@Table(name="comment")
public class Comment extends POJO implements Serializable {
	public Boolean getTrash() {
		return trash;
	}

	public void setTrash(Boolean trash) {
		this.trash = trash;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
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

	@Id
	private Integer id;
	
	private Integer articleId;
	
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
	private Boolean trash;
	
	
}
