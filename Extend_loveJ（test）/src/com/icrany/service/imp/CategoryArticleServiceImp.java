package com.icrany.service.imp;

import org.directwebremoting.util.Logger;

import com.icrany.dao.CategoryArticleDao;
import com.icrany.dao.imp.CategoryArticleDaoImp;
import com.icrany.pojo.CategoryArticle;
import com.icrany.service.CategoryArticleService;

public class CategoryArticleServiceImp implements CategoryArticleService{

	private static final Logger logger = Logger.getLogger(CategoryArticleServiceImp.class);
	
	private static CategoryArticleDao categoryArticleDao = new CategoryArticleDaoImp();
	
	@Override
	public int insert(CategoryArticle entity) {
		// TODO Auto-generated method stub
		return categoryArticleDao.insert(entity);
	}
	
	/**
	 * 用来添加一组int类型数据的分类 和 一个 文章之间的对应关系
	 * @param array
	 * @param articleId
	 * @return
	 */
	public boolean insertArray(int[] array,int articleId){
		for(int i=0;i<array.length;i++){
			CategoryArticle entity = new CategoryArticle();
			entity.setArticleId(articleId);
			entity.setCategoryId(array[i]);
			if(categoryArticleDao.insert(entity) == -1){
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * 用来添加一组String类型的数组的分类 和 一个 文章之间的对应关系
	 * @param array
	 * @param articleId
	 * @return
	 */
	public boolean insertArray(String[] array,int articleId){
		int[] newArray = new int[array.length];
		for(int i = 0; i< array.length ;i++){
			newArray[i] = Integer.parseInt(array[i]);
		}
		return insertArray(newArray,articleId);
	}

}
