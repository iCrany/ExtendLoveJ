package com.icrany.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.icrany.dao.*;
import com.icrany.util.WapperUtil;
import com.icrany.view.ArticleView;
import com.icrany.vo.*;
import org.directwebremoting.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService{
	
	private static final Logger logger = Logger.getLogger(ArticleService.class);
	
	@Autowired
	private ArticleDao articleDao ;
	
	@Autowired
	private CommentDao commentDao ;
	
	@Autowired
	private CategoryDao categoryDao ;
	
	@Autowired
	private CategoryArticleDao categoryArticleDao ;
	
	@Autowired
	private TagDao tagDao ;
	
	@Autowired
	private TagArticleDao tagArticleDao ;
	
	public Integer insert(Article entity){
		try{
			if(articleDao == null) System.out.println("articleDao is null");
			return articleDao.insert(entity);
		}catch(Exception e){
			logger.error("fail to insert article!!!,e");
		}
		return -1;
	}
	
	public Integer delete(Article entity) throws SQLException {
		return articleDao.delete(entity);
	}
	
	/**
	 * 根据文章的 id 来搜索相对应的文章
	 */
	public ArticleView queryById(Integer articleId){

		Article entity = articleDao.findById(articleId);
		ArticleView articleView = WapperUtil.wapperArticle2View(entity);

		//1:设置相应的评论
		List<Comment> commentList = commentDao.findByArticleId(articleId);//根据文章获取对应的评论
		articleView.setCommentList(commentList);
		articleView.setCommentCount(commentList.size());

		//2：获取相应的文章分类信息
		List<CategoryArticle> categoryIdList = categoryArticleDao.queryByArticleId(articleId);//TODO:处理一个多对多的查询，比较麻烦
		//根据 这个 categoryId 来查找对应的分类信息
		for(int j = 0 ;j < categoryIdList.size() ; j++){
			int categoryId = categoryIdList.get(j).getCategoryId();

			Category category = categoryDao.findById(categoryId);
			articleView.getCategoryList().add(category);//将这个 category的相关信息保存到 对应的文章的结构中
		}

		//3：获取相应的文章标签信息
		List<TagArticle> tagIdList = tagArticleDao.queryByArticleId(articleId);

		for(int j = 0 ;j < tagIdList.size() ; j++){
			int tagId = tagIdList.get(j).getTagId();

			Tag tag = tagDao.findById(tagId);
			articleView.getTagList().add(tag);
		}

		//4:获取该文章的上一篇和下一篇的文章id，顺序是按发表时间的先后顺序来进行排序
		List<Article> articleIdList = articleDao.findAllArticleId();
//		List<Integer> articleIdList = articleDao.findAllArticleId();
		//预处理的将每一篇文章之间的 id 号都关联起来，方便后面实现上一篇和下一篇的功能
		for(int i = 0 ;i < articleIdList.size() ;i++) {
			if( articleIdList.get(i).getId() == articleView.getId() && i - 1  >= 0 ) {
				int preArticleId = articleIdList.get(i-1).getId();
				articleView.setPreArticleId(preArticleId);
			}
			if( articleIdList.get(i).getId() == articleView.getId() &&  i + 1 < articleIdList.size() ){
				int nextArticleId = articleIdList.get(i + 1).getId();
				articleView.setNextArticleId(nextArticleId);
			}
		}

		return articleView;
	}
	
	public Integer update(Article entity){
		return articleDao.update(entity);
	}
	
	/**
	 * 这里在查询的过程当中还进行了将对应的文章的评论数一起查询出来
	 */
	public List<ArticleView> getAllArticle(){
		
		List<Article> articleList = articleDao.findAllArticle();
		
		return getReferenceData2Article(articleList);
	}

	public List<Article> findNewestArticle() {
		return articleDao.findNewestArticle();
	}

	public List<ArticleView> findByFuzzyName(String key) {
		List<Article> articleList = articleDao.findByFuzzyName(key);
		return getReferenceData2Article(articleList);
	} 
	
	/**
	 * 把文章中相关的 全部信息拿出来,组织到 articleView 视图中
	 * @param articleList
	 * @return
	 */
	public List<ArticleView> getReferenceData2Article(List<Article> articleList){
		List<ArticleView> result = new ArrayList<ArticleView>(articleList.size());
		Article article = null;

		for(Integer i = 0 ; i < articleList.size() ; i++){
			article = articleList.get(i);
			ArticleView articleView  = WapperUtil.wapperArticle2View(article);
			Integer articleId = article.getId();

			//1:设置相应的评论
			List<Comment> commentList = commentDao.findByArticleId(articleId);//根据文章获取对应的评论
			articleView.setCommentList(commentList);
			articleView.setCommentCount(commentList.size());

			//2：获取相应的文章分类信息
			List<CategoryArticle> categoryIdList = categoryArticleDao.queryByArticleId(articleId);//TODO:处理一个多对多的查询，比较麻烦

			//根据 这个 categoryId 来查找对应的分类信息
			for(int j = 0 ;j < categoryIdList.size() ; j++){
				int categoryId = categoryIdList.get(j).getCategoryId();

				Category category = categoryDao.findById(categoryId);
				articleView.getCategoryList().add(category);//将这个 category的相关信息保存到 对应的文章的结构中
			}

			//3：获取相应的文章标签信息
			List<TagArticle> tagIdList = tagArticleDao.queryByArticleId(articleId);

			for(int j = 0 ;j < tagIdList.size() ; j++){
				int tagId = tagIdList.get(j).getTagId();

				Tag tag = tagDao.findById(tagId);
				articleView.getTagList().add(tag);
			}
			result.add(articleView);
		}
		return result;
	}

	public List<Article> findPage() {
		return articleDao.findPage();
	}

	public List<Article> findNavMenuItem() {
		return articleDao.findNavMenuItem();
	}
	
	public Integer deleteAllPage(){
		return articleDao.deleteAllPage();
	}
}
