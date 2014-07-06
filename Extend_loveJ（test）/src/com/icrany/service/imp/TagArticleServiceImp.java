package com.icrany.service.imp;

import java.util.List;

import org.directwebremoting.util.Logger;

import com.icrany.dao.TagArticleDao;
import com.icrany.dao.imp.TagArticleDaoImp;
import com.icrany.pojo.CategoryArticle;
import com.icrany.pojo.TagArticle;
import com.icrany.service.TagArticleService;

public class TagArticleServiceImp implements TagArticleService {

	private static final Logger logger = Logger.getLogger(TagArticleServiceImp.class);
	
	private static TagArticleDao tagArticleDao = new TagArticleDaoImp();
	
	@Override
	public int insert(TagArticle entity) {
		return tagArticleDao.insert(entity);
	}
	
	/**
	 * 用来添加一组int类型数据的标签 和 一个 文章之间的对应关系
	 * @param array
	 * @param articleId
	 * @return
	 */
	public boolean insertArray(int[] array,int articleId){
		for(int i=0;i<array.length;i++){
			TagArticle entity = new TagArticle();
			entity.setArticleId(articleId);
			entity.setTagId(array[i]);
			if(tagArticleDao.insert(entity) == -1){
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * 用来添加一组String类型的数组的标签 和 一个 文章之间的对应关系
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

	@Override
	public List<Integer> queryByArticleId(int articleId) {
		return tagArticleDao.queryByArticleId(articleId);
	}

	@Override
	public List<Integer> queryByTagId(int tagId) {
		return tagArticleDao.queryByTagId(tagId);
	}

}
