package com.icrany.dao;

import java.util.List;

import com.icrany.pojo.Article;

public interface ArticleDao {
	
	public int insert(Article entity);
	public boolean update(Article entity);
	public boolean delete(Article entity);
	public Article findById(int id);
	public List<Article> findAllArticle();
	public List<Article> findNewestArticle();
	public List<Article> findByFuzzyName(String key);
}
