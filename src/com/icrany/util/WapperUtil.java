package com.icrany.util;

import com.icrany.view.ArticleView;
import com.icrany.vo.Article;

/**
 * Created by iCrany on 14/12/11.
 * 封装类，将 vo 类转换成相应 view 类
 */
public class WapperUtil {

    /**
     * 将 article 类转换成 articleView 类
     * @param entity
     * @return
     */
    public static ArticleView wapperArticle2View(Article entity){
        ArticleView articleView = new ArticleView();
        articleView.setId(entity.getId());
        articleView.setArticleType(entity.getArticleType());
        articleView.setContent(entity.getContent());
        articleView.setView(entity.getView());
        articleView.setTopTime(entity.getTopTime());
        articleView.setMenuOrder(entity.getMenuOrder());
        articleView.setTrash(entity.getTrash());
        articleView.setTitle(entity.getTitle());
        articleView.setSummary(entity.getSummary());
        articleView.setStatus(entity.getStatus());
        articleView.setPostTime(entity.getPostTime());
        articleView.setParentId(entity.getParentId());
        articleView.setModifyTime(entity.getModifyTime());
        return articleView;
    }
}
