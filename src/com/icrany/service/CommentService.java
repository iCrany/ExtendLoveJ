package com.icrany.service;

import java.util.List;

import com.icrany.pojo.Comment;
import com.icrany.pojo.Tag;

public interface CommentService {
	public boolean insert(Comment entity);
	public boolean delete(Comment entity);
	public Comment findById(int id);
	public List<Comment> findAllComment();
	public List<Comment> findNewestComment();
	public List<Comment> findByArticleId(int articleId);
	public boolean update(Comment entity);
	public boolean updateAttribute(String name,Comment entity);
}
