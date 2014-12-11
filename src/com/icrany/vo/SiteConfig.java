package com.icrany.vo;

import org.kidding.orm.entity.POJO;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 备案信息类
 * @author Administrator
 *
 */
@Table(name="site_config")
public class SiteConfig extends POJO implements Serializable {
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getContactDescription() {
		return contactDescription;
	}

	public void setContactDescription(String contactDescription) {
		this.contactDescription = contactDescription;
	}

	public String getIcp() {
		return icp;
	}

	public void setIcp(String icp) {
		this.icp = icp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Id
	private Integer id;
	
	private String about;
	
	private String contactDescription;
	
	private String icp;
	
	private String name;
	
	private String url;
}
