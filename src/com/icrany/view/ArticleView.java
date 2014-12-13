package com.icrany.view;

import com.icrany.vo.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iCrany on 14/12/11.
 * 文章的视图层
 */
public class ArticleView extends Article{

    private Integer commentCount;//评论数

    private List<Comment> commentList = new ArrayList<Comment>();//评论数组


    private List<Attach> attachList = new ArrayList<Attach>();//附件数组

    private List<Tag> tagList = new ArrayList<Tag>();//标签数组

    private List<Category> categoryList = new ArrayList<Category>();//分类数组

    private Integer preArticleId = -1;//上一篇文章的 id

    private Integer nextArticleId = -1;//下一篇文章的 id

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public List<Attach> getAttachList() {
        return attachList;
    }

    public void setAttachList(List<Attach> attachList) {
        this.attachList = attachList;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public Integer getPreArticleId() {
        return preArticleId;
    }

    public void setPreArticleId(Integer preArticleId) {
        this.preArticleId = preArticleId;
    }

    public Integer getNextArticleId() {
        return nextArticleId;
    }

    public void setNextArticleId(Integer nextArticleId) {
        this.nextArticleId = nextArticleId;
    }

}
