package com.icrany.controller.blog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.directwebremoting.util.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.icrany.pojo.Article;
import com.icrany.pojo.Pager;
import com.icrany.pojo.User;
import com.icrany.service.ArticleService;
import com.icrany.service.CategoryArticleService;
import com.icrany.service.CategoryService;
import com.icrany.service.CommentService;
import com.icrany.service.LinkService;
import com.icrany.service.SiteConfigService;
import com.icrany.service.TagArticleService;
import com.icrany.service.TagService;
import com.icrany.service.UserService;
import com.icrany.service.imp.ArticleServiceImp;
import com.icrany.service.imp.CategoryArticleServiceImp;
import com.icrany.service.imp.CategoryServiceImp;
import com.icrany.service.imp.CommentServiceImp;
import com.icrany.service.imp.LinkServiceImp;
import com.icrany.service.imp.SiteConfigServiceImp;
import com.icrany.service.imp.TagArticleServiceImp;
import com.icrany.service.imp.TagServiceImp;
import com.icrany.service.imp.UserServiceImp;

@Controller
@RequestMapping(value="/jsp/blog")
public class SearchController {
	
	private static final Logger logger = Logger.getLogger(SearchController.class);
	
	private static final String SEARCH_BLOG = "/jsp/blog/blog_search";
	
	private static CategoryService categoryService = new CategoryServiceImp();

	private static TagService tagService = new TagServiceImp();
	
	private static CommentService commentService = new CommentServiceImp();
	
	private static SiteConfigService siteConfigService = new SiteConfigServiceImp();
	
	private static LinkService linkService = new LinkServiceImp();
	
	private static UserService userService = new UserServiceImp();
	
	private static ArticleService articleService = new ArticleServiceImp();
	
	private static CategoryArticleService categoryArticleService = new CategoryArticleServiceImp();

	private static TagArticleService tagArticleService = new TagArticleServiceImp();
	
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
	
	@RequestMapping(value="/blog_search")
	public String serarch(Map<String,Object> map, HttpServletRequest request,HttpServletResponse response,Integer currentPage){
		//TODO:因为查找的话都应该是文章的一些内容，所以只要查找相应的文章即可,目前暂时只支持单个关键字的搜索，或者说是单个参数的搜索，以后改进
		List<Article> articleList = null;
		
		if(request.getParameter("articleId") != null){
			//TODO:貌似这个用途不大
			
		}else if(request.getParameter("categoryId") != null){
			//查找这个分类目录下的所有文章出来
			
			int categoryId = Integer.parseInt(request.getParameter("categoryId"));
			articleList = searchByCategoryId(categoryId);
			
		}else if(request.getParameter("tagId") != null){
			System.out.println("========= 正在根据 tagId 来查找文章  =========");
			//查找这个标签下的所有文章出来
			int tagId = Integer.parseInt(request.getParameter("tagId"));
			System.out.println("tagId = " + tagId);
			articleList = searchByTagId(tagId);
			
		}else if(request.getParameter("key") != null){
			//关键字的搜索
			String key = request.getParameter("key");
			articleList = searchByFuzzyName(key);
		}
		
		System.out.println("==================serarch=====================");
		//分页的处理
		Pager pager = new Pager();
		if(currentPage == null) currentPage = 1;
		String url = "";
		pager.setUrl(url);
		pager.doWithArticles(articleList, currentPage, request);
		map.put("articles",articleList);
		map.put("pager",pager);
		
		createReferenceData(map);
		
		return SEARCH_BLOG;
	}
	
	/**
	 * 处理搜索页面的分页处理
	 * @param map
	 * @param request
	 * @param response
	 * @param currentPage
	 * @return
	 */
	@RequestMapping(value="/blog_search/page/{currentPage}")
	public String searchPaging(Map<String,Object> map, HttpServletRequest request,HttpServletResponse response,@PathVariable Integer currentPage){
		
//		//分页的处理
//		Pager pager = new Pager();
//		if(currentPage == null) currentPage = 1;
//		pager.doWithArticles(articleList, currentPage, request);
//		map.put("articles",articleList);
//		map.put("pager",pager);
		
		createReferenceData(map);		
		
		return SEARCH_BLOG;
	}
	
	/**
	 * 查找这个分类目录下的所有文章出来
	 * @param id
	 * @return
	 */
	public List<Article> searchByCategoryId(int id){
		List<Article> articleList = new ArrayList<Article>();
		//处理多对多的查询
		List<Integer> articleIdList = categoryArticleService.queryByCategoryId(id);
		
		for(int i = 0 ;i< articleIdList.size(); i++){
			Article article = articleService.queryById(articleIdList.get(i));
			articleList.add(article);
		}
		
		return articleList;
	}
	
	/**
	 * 根据标签id 来查找对应的文章信息
	 * @param id
	 * @return
	 */
	public List<Article> searchByTagId(int id){
		List<Article> articleList = new ArrayList<Article>();
		
		List<Integer> articleIdList = tagArticleService.queryByTagId(id);
		
		for(int i = 0 ;i< articleIdList.size(); i++){
			Article article = articleService.queryById(articleIdList.get(i));
			articleList.add(article);
		}		
		return articleList;
	}
	
	/**
	 * 根据关键字来查询相应的文章
	 * @param key
	 * @return
	 */
	public List<Article> searchByFuzzyName(String key){
		List<Article> articleList = new ArrayList<Article>();
		
		//TODO:这里需要预处理一些这个 key
		articleList = articleService.findByFuzzyName(key);
		
		return articleList;
	}
	
	/**
	 * 保存相关主页面的信息
	 * @param map
	 * @param user
	 */
	private void createReferenceData(Map<String,Object> map){
		User user = new User();//虚设的一个实例，没有任何的用处
		map.put("user", userService.find(user));//默认是只有一个用户的，这个参数是没有起作用的
		map.put("tags", tagService.getAllTag());
		map.put("categorys", categoryService.findAllCategory());
		map.put("siteConfig", siteConfigService.findAllSiteConfig());//默认只有一个站点信息
		
		//TODO:最新的五篇文章
		map.put("newestArticle", articleService.findNewestArticle());
		
		//TODO:最新的五篇评论
		map.put("newestComment",commentService.findNewestComment());
		
		//TODO:最新的五个友情链接
		map.put("newestLink", linkService.findNewestLink());
	}	
	
	
}
