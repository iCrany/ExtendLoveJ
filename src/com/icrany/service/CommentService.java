package com.icrany.service;

import java.util.List;

import com.icrany.dao.CommentDao;
import org.directwebremoting.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icrany.vo.Comment;
@Service
public class CommentService  {

	private static final Logger logger = Logger.getLogger(CommentService.class);
	
	@Autowired
	private CommentDao commentDao ;
	
	public Integer insert(Comment entity) {
		return commentDao.insert(entity);
	}

	public Integer delete(Comment entity) {
		return commentDao.delete(entity);
	}

	public Comment findById(int id) {
		return commentDao.findById(id);
	}

	public List<Comment> findAllComment() {
		return commentDao.findAllComment();
	}

	public Integer update(Comment entity) {
		return commentDao.update(entity);
	}

	public Boolean updateAttribute(String name, Comment entity) {
		return commentDao.updateAttribute(name, entity);
	}

	public List<Comment> findNewestComment() {
		return commentDao.findNewestComment();
	}

	public List<Comment> findByArticleId(int articleId) {
		return commentDao.findByArticleId(articleId);
	}

}
