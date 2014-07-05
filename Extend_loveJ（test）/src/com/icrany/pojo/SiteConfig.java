package com.icrany.pojo;

/**
 * 备案信息类
 * @author Administrator
 *
 */
public class SiteConfig {
	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	private int id;
	
	private String about;
	
	private String contactDescription;
	
	private String icp;
	
	private String name;
	
	private String url;
}
