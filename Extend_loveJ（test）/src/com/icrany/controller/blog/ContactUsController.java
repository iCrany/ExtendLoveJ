package com.icrany.controller.blog;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.directwebremoting.util.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.icrany.pojo.Article;
import com.icrany.pojo.User;
import com.icrany.service.ArticleService;
import com.icrany.service.CategoryService;
import com.icrany.service.CommentService;
import com.icrany.service.LinkService;
import com.icrany.service.SiteConfigService;
import com.icrany.service.TagService;
import com.icrany.service.UserService;
import com.icrany.service.imp.ArticleServiceImp;
import com.icrany.service.imp.CategoryServiceImp;
import com.icrany.service.imp.CommentServiceImp;
import com.icrany.service.imp.LinkServiceImp;
import com.icrany.service.imp.SiteConfigServiceImp;
import com.icrany.service.imp.TagServiceImp;
import com.icrany.service.imp.UserServiceImp;

@Controller
@RequestMapping("/jsp/blog/")
public class ContactUsController {
	
	private static final Logger logger = Logger.getLogger(ContactUsController.class);
	
	private static final String CONTACT_BLOG = "/jsp/blog/blog_contact";
	
	private static UserService userService = new UserServiceImp();
	
	private static SiteConfigService siteConfigService = new SiteConfigServiceImp();
	
	private static LinkService linkService = new LinkServiceImp();
	
	private static CommentService commentService = new CommentServiceImp();
	
	private static ArticleService articleService = new ArticleServiceImp();
	
	private static CategoryService categoryService = new CategoryServiceImp();
	
	private static TagService tagService = new TagServiceImp();	
	
	
	/**
	 * 这个类是用来处理 类型之间的转换的问题，如 date --> String 之间的转换
	 * @param binder
	 */
	@InitBinder
	private void dateBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
	    binder.registerCustomEditor(Date.class, editor);
	}
	
	@RequestMapping(value="/blog_contact")
	public String showContactUs(Map<String,Object> map,HttpServletRequest request){
		int articleId = Integer.parseInt(request.getParameter("id"));//TODO:自己预先定义一个默认的 联系人 页面的 id,这个问题还没有解决
//		logger.debug("articleId = " + articleId);
		System.out.println("articleId = " + articleId);
		createReferenceData(map,articleId);
		return CONTACT_BLOG;
	}
	
	//准备视图相关的一些数据
	private void createReferenceData(Map<String,Object> map,int articleId){
		User user = new User();
		map.put("user", userService.find(user));//默认是只有一个用户的，这个参数是没有起作用的
		map.put("siteConfig", siteConfigService.findAllSiteConfig());//默认只有一个站点信息
		map.put("article", articleService.queryById(articleId));
		
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
