package com.icrany.service.imp;

import java.util.List;

import org.directwebremoting.util.Logger;
import org.springframework.stereotype.Service;

import com.icrany.dao.ArticleDao;
import com.icrany.dao.CategoryArticleDao;
import com.icrany.dao.CategoryDao;
import com.icrany.dao.CommentDao;
import com.icrany.dao.TagArticleDao;
import com.icrany.dao.TagDao;
import com.icrany.dao.imp.ArticleDaoImp;
import com.icrany.dao.imp.CategoryArticleDaoImp;
import com.icrany.dao.imp.CategoryDaoImp;
import com.icrany.dao.imp.CommentDaoImp;
import com.icrany.dao.imp.TagArticleDaoImp;
import com.icrany.dao.imp.TagDaoImp;
import com.icrany.pojo.Article;
import com.icrany.pojo.Category;
import com.icrany.pojo.Comment;
import com.icrany.pojo.Tag;
import com.icrany.service.ArticleService;

@Service
public class ArticleServiceImp implements ArticleService{
	
	private static final Logger logger = Logger.getLogger(ArticleServiceImp.class);
	
	private static ArticleDao articleDao = new ArticleDaoImp();
	
	private static CommentDao commentDao = new CommentDaoImp();
	
	private static CategoryDao categoryDao = new CategoryDaoImp();
	
	private static CategoryArticleDao categoryArticleDao = new CategoryArticleDaoImp();
	
	private static TagDao tagDao = new TagDaoImp();
	
	private static TagArticleDao tagArticleDao = new TagArticleDaoImp();
	
	public int insert(Article entity){
		return articleDao.insert(entity);
	}
	
	public boolean delete(Article entity){
		return articleDao.delete(entity);
	}
	
	/**
	 * 根据文章的 id 来搜索相对应的文章
	 */
	public Article queryById(int id){
		
		int articleId = id;
		Article article = articleDao.findById(id);
		//1:设置相应的评论
		List<Comment> commentList = commentDao.findByArticleId(articleId);//根据文章获取对应的评论
		article.setCommentList(commentList);
		article.setCommentCount(commentList.size());
		
		//2：获取相应的文章分类信息
		List<Integer> categoryIdList = categoryArticleDao.queryByArticleId(articleId);//TODO:处理一个多对多的查询，比较麻烦
		//根据 这个 categoryId 来查找对应的分类信息
		for(int j = 0 ;j < categoryIdList.size() ; j++){
			int categoryId = categoryIdList.get(j);
			
			Category category = categoryDao.findById(categoryId);
			article.getCategoryList().add(category);//将这个 category的相关信息保存到 对应的文章的结构中
		}
		
		//3：获取相应的文章标签信息
		List<Integer> tagIdList = tagArticleDao.queryByArticleId(articleId);
		
		for(int j = 0 ;j < tagIdList.size() ; j++){
			int tagId = tagIdList.get(j);
			
			Tag tag = tagDao.findById(tagId);
			article.getTagList().add(tag);
		}
		
		//4:获取该文章的上一篇和下一篇的文章id，顺序是按发表时间的先后顺序来进行排序
		List<Integer> articleIdList = articleDao.findAllArticleId();
		//预处理的将每一篇文章之间的 id 号都关联起来，方便后面实现上一篇和下一篇的功能
		for(int i = 0 ;i < articleIdList.size() ;i++) {
			if( articleIdList.get(i) == article.getId() && i - 1  >= 0 ) {
				int preArticleId = articleIdList.get(i-1);
				article.setPreArticleId(preArticleId);
			}
			if( articleIdList.get(i) == article.getId() &&  i + 1 < articleIdList.size() ){
				int nextArticleId = articleIdList.get(i + 1);
				article.setNextArticleId(nextArticleId);
			}
		}
		
		return article;
	}
	
	public boolean update(Article entity){
		return articleDao.update(entity);
	}
	
	/**
	 * 这里在查询的过程当中还进行了将对应的文章的评论数一起查询出来
	 */
	public List<Article> getAllArticle(){
		
		List<Article> articleList = articleDao.findAllArticle();
		
		return getReferenceData2Article(articleList);
	}

	@Override
	public List<Article> findNewestArticle() {
		return articleDao.findNewestArticle();
	}

	@Override
	public List<Article> findByFuzzyName(String key) {
		List<Article> articleList = articleDao.findByFuzzyName(key);
		return getReferenceData2Article(articleList);
	} 
	
	/**
	 * 把文章中相关的 全部信息拿出来
	 * @param articleList
	 * @return
	 */
	public List<Article> getReferenceData2Article(List<Article> articleList){
		
		//这里设置相应的文章中的附件信息，如评论数组，分类数组，标签数组，附件数组等
		for(int i = 0 ; i < articleList.size() ; i++){
			
			int articleId = articleList.get(i).getId();//对应的文章 id
			
			//1:设置相应的评论
			List<Comment> commentList = commentDao.findByArticleId(articleId);//根据文章获取对应的评论
			articleList.get(i).setCommentList(commentList);
			articleList.get(i).setCommentCount(commentList.size());
			
			//2：获取相应的文章分类信息
			List<Integer> categoryIdList = categoryArticleDao.queryByArticleId(articleId);//TODO:处理一个多对多的查询，比较麻烦
			
			//根据 这个 categoryId 来查找对应的分类信息
			for(int j = 0 ;j < categoryIdList.size() ; j++){
				int categoryId = categoryIdList.get(j);
				
				Category category = categoryDao.findById(categoryId);
				articleList.get(i).getCategoryList().add(category);//将这个 category的相关信息保存到 对应的文章的结构中
			}
			
			//3：获取相应的文章标签信息
			List<Integer> tagIdList = tagArticleDao.queryByArticleId(articleId);
			
			for(int j = 0 ;j < tagIdList.size() ; j++){
				int tagId = tagIdList.get(j);
				
				Tag tag = tagDao.findById(tagId);
				articleList.get(i).getTagList().add(tag);
			}
		}
		
		return articleList;
	}

	@Override
	public List<Article> findPage() {
		return articleDao.findPage();
	}

	@Override
	public List<Article> findNavMenuItem() {
		return articleDao.findNavMenuItem();
	}
	
	@Override
	public boolean deleteAllPage(){
		return articleDao.deleteAllPage();
	}
}
