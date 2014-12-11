package com.icrany.vo;

import org.kidding.orm.entity.POJO;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 文章类
 * @author Administrator
 *
 */
@Table(name="article")
public class Article extends POJO implements Serializable{

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

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getView() {
		return view;
	}

	public void setView(Integer view) {
		this.view = view;
	}

	public Boolean getTrash() {
		return trash;
	}

	public void setTrash(Boolean trash) {
		this.trash = trash;
	}

	public Date getTopTime() {
		return topTime;
	}

	public void setTopTime(Date topTime) {
		this.topTime = topTime;
	}

	public String getArticleType() {
		return articleType;
	}

	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getMenuOrder() {
		return menuOrder;
	}

	public void setMenuOrder(Integer menuOrder) {
		this.menuOrder = menuOrder;
	}

	@Id
	private Integer id;
	
	private String content;//文章的内容
	
	private Date modifyTime;//最近的修改时间
	
	private Date postTime;//文章发表的时间
	
	private String status;//文章状态

	private String summary;//文章的总结

	private String title;//文章的名字
	
	private Integer view;//浏览数
	
	private Boolean trash;//是否被删除
	
	private Date topTime;//置顶时间
	
	private String articleType;//判断是普通文章还是独立页面或者是模版     1：nav_menu_item 首页的导航条部分 2：page 独立页面 3：post 普通文章
	
	private Integer parentId;//该文章的父文章，用于文章的分类
	
	private Integer menuOrder;//若是独立页面，在导航条中的显示循序

}
