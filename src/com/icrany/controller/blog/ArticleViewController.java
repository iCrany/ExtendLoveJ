package com.icrany.controller.blog;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.icrany.service.*;
import com.icrany.view.ArticleView;
import org.directwebremoting.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.icrany.vo.Article;
import com.icrany.vo.User;


@Controller
@RequestMapping(value="/jsp/blog")
public class ArticleViewController {
	
	private static final Logger logger = Logger.getLogger(ArticleViewController.class);
	
	private static final String VIEW_BLOG = "blog_view";
	
	@Autowired
	private CategoryService categoryService ;

	@Autowired
	private TagService tagService ;
	
	@Autowired
	private CommentService commentService ;
	
	@Autowired
	private SiteConfigService siteConfigService ;
	
	@Autowired
	private LinkService linkService ;
	
	@Autowired
	private UserService userService ;
	
	@Autowired
	private ArticleService articleService ;
	
	/**
	 * 这个类是用来处理 类型之间的转换的问题，如 date --> String 之间的转换
	 * @param binder
	 */
	@InitBinder
	private void dateBinder(WebDataBinder binder) {
	            //The date format to parse or output your dates
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	            //Create a new CustomDateEditor
	    CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
	            //Register it as custom editor for the Date type
	    binder.registerCustomEditor(Date.class, editor);
	}
	
	@RequestMapping(value="/blog_view")
	public String blogView(Map<String,Object> map, ArticleView article){
		
		article = articleService.queryById(article.getId());
		//点击一次就自增一个文章的浏览数
		article.setView(article.getView()+1);
		articleService.update(article);
		
		map.put("article", article);
		
		createReferenceData(map,article.getId());
		return VIEW_BLOG;
	}
	
	/**
	 * 保存相关主页面的信息
	 * @param map
	 * @param articleId
	 */
	private void createReferenceData(Map<String,Object> map , int articleId){
		User user = new User();//虚设的一个实例，没有任何的用处
		map.put("user", userService.find(user));//默认是只有一个用户的，这个参数是没有起作用的
		map.put("tags", tagService.getAllTag());
		map.put("categorys", categoryService.findAllCategory());
		map.put("siteConfig", siteConfigService.findAllSiteConfig());//默认只有一个站点信息
		
		//TODO:还要存放这篇文章下的所有评论
		map.put("comments", commentService.findByArticleId(articleId));
		
		//TODO:最新的五篇文章
		map.put("newestArticle", articleService.findNewestArticle());
		
		//TODO:最新的五篇评论
		map.put("newestComment",commentService.findNewestComment());
		
		//TODO:最新的五个友情链接
		map.put("newestLink", linkService.findNewestLink());

		//这里是处理页面中的导航条的部分 对应的List 为 navItems , 类型值为 List<Article>
		List<Article> navItems = articleService.findPage();
		map.put("navItems", navItems);		
		
	}	
}
