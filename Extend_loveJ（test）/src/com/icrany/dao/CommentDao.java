package com.icrany.dao;

import java.util.List;

import com.icrany.pojo.Comment;

public interface CommentDao {
	public boolean insert(Comment entity);
	public boolean delete(Comment entity);
	public Comment findById(int id);
	public List<Comment> findAllComment();
	public List<Comment> findNewestComment();
	public List<Comment> findByArticleId(int articleId);
	public boolean update(Comment entity);
	public boolean updateAttribute(String name,Comment entity);
}
