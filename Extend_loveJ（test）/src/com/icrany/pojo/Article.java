package com.icrany.pojo;

import java.util.Date;
import java.util.List;

/**
 * 文章类
 * @author Administrator
 *
 */
public class Article {
	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	public List<Attach> getAttachList() {
		return attachList;
	}

	public void setAttachList(List<Attach> attachList) {
		this.attachList = attachList;
	}

	public List<Tag> getTagList() {
		return tagList;
	}

	public void setTagList(List<Tag> tagList) {
		this.tagList = tagList;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

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

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
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

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public boolean isTrash() {
		return trash;
	}

	public void setTrash(boolean trash) {
		this.trash = trash;
	}

	public Date getTopTime() {
		return topTime;
	}

	public void setTopTime(Date topTime) {
		this.topTime = topTime;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}
	
	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}	

	private int id;
	
	private String content;
	
	private Date modifyTime;
	
	private Date postTime;
	
	private String quote;
	
	private String status;//
	
	private String summary;//文章的总结
	
	private String title;//文章的名字
	
	private int view;//浏览数
	
	private boolean trash;//是否被删除
	
	private Date topTime;//置顶时间
	
	private int categoryId;//TODO:这个也是没有用的了，只是还没有删除
	
	private int tagId;//TODO:这个也是没有用的了，只是还没有删除
	
	//======================================以下属性在 article 表中都不存在 =============================================

	private int commentCount;//评论数
	
	private List<Comment> commentList ;//评论数组
	
	private List<Attach> attachList;//附件数组
	
	private List<Tag> tagList;//标签数组
	
	private List<Category> categoryList;//分类数组

}
