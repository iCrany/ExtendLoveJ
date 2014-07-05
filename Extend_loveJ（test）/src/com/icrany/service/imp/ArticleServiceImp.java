package com.icrany.service.imp;

import java.util.List;

import com.icrany.dao.ArticleDao;
import com.icrany.dao.CategoryArticleDao;
import com.icrany.dao.CategoryDao;
import com.icrany.dao.CommentDao;
import com.icrany.dao.imp.ArticleDaoImp;
import com.icrany.dao.imp.CategoryArticleDaoImp;
import com.icrany.dao.imp.CategoryDaoImp;
import com.icrany.dao.imp.CommentDaoImp;
import com.icrany.pojo.Article;
import com.icrany.pojo.Comment;
import com.icrany.service.ArticleService;

public class ArticleServiceImp implements ArticleService{
	
	private static ArticleDao articleDao = new ArticleDaoImp();
	
	private static CommentDao commentDao = new CommentDaoImp();
	
	private static CategoryDao categoryDao = new CategoryDaoImp();
	
	private static CategoryArticleDao categoryArticleDao = new CategoryArticleDaoImp();
	
	public int insert(Article entity){
		return articleDao.insert(entity);
	}
	
	public boolean delete(Article entity){
		return articleDao.delete(entity);
	}
	
	public Article queryById(int id){
		return articleDao.findById(id);
	}
	
	public boolean update(Article entity){
		return articleDao.update(entity);
	}
	
	/**
	 * 这里在查询的过程当中还进行了将对应的文章的评论数一起查询出来
	 */
	public List<Article> getAllArticle(){
		List<Article> articleList = articleDao.findAllArticle();
		
		//这里设置相应的文章中的附件信息，如评论数组，分类数组，标签数组，附件数组等
		for(int i = 0 ; i < articleList.size() ; i++){
			int articleId = articleList.get(i).getId();
			List<Comment> commentList = commentDao.findByArticleId(articleId);//根据文章获取对应的评论
			articleList.get(i).setCommentList(commentList);
			articleList.get(i).setCommentCount(commentList.size());
			List<Integer> categoryIdList = categoryArticleDao.queryByArticleId(articleId);//TODO:处理一个多对多的查询，比较麻烦
		}
		return articleList;
	}

	@Override
	public List<Article> findNewestArticle() {
		return articleDao.findNewestArticle();
	}
}
