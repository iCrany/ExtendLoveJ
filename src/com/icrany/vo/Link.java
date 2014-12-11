package com.icrany.vo;

import org.kidding.orm.entity.POJO;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 友情连接
 * @author Administrator
 *
 */
@Table(name="link")
public class Link extends POJO implements Serializable {
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Boolean isTrash() {
		return trash;
	}

	public void setTrash(Boolean trash) {
		this.trash = trash;
	}

	@Id
	private Integer id;
	
	private Date createTime;
	
	private String description;
	
	private String name;
	
	private String site;
	
	private String status;
	
	private Boolean trash;
	
	
}
