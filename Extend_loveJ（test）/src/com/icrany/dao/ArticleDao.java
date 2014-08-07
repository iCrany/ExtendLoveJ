package com.icrany.dao;

import java.util.List;

import com.icrany.pojo.Article;

public interface ArticleDao {
	
	public int insert(Article entity);
	public boolean update(Article entity);
	public boolean delete(Article entity);
	public boolean deleteAllPage();
	public Article findById(int id);
	public List<Article> findPage();
	public List<Article> findAllArticle();
	public List<Article> findNavMenuItem();
	public List<Integer> findAllArticleId();
	public List<Article> findNewestArticle();
	public List<Article> findByFuzzyName(String key);
}
