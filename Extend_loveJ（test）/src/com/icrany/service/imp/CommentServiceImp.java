package com.icrany.service.imp;

import java.util.List;

import org.directwebremoting.util.Logger;

import com.icrany.dao.CommentDao;
import com.icrany.dao.imp.CommentDaoImp;
import com.icrany.pojo.Comment;
import com.icrany.service.CommentService;

public class CommentServiceImp implements CommentService {

	private static final Logger logger = Logger.getLogger(CommentServiceImp.class);
	
	private static CommentDao commentDao = new CommentDaoImp();
	
	@Override
	public boolean insert(Comment entity) {
		return commentDao.insert(entity);
	}

	@Override
	public boolean delete(Comment entity) {
		return commentDao.delete(entity);
	}

	@Override
	public Comment findById(int id) {
		return commentDao.findById(id);
	}

	@Override
	public List<Comment> findAllComment() {
		return commentDao.findAllComment();
	}

	@Override
	public boolean update(Comment entity) {
		return commentDao.update(entity);
	}

	@Override
	public boolean updateAttribute(String name, Comment entity) {
		return commentDao.updateAttribute(name, entity);
	}

	@Override
	public List<Comment> findNewestComment() {
		return commentDao.findNewestComment();
	}

}
