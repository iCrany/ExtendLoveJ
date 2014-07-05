package com.icrany.controller.blog;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.directwebremoting.util.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping(value="/jsp/blog")
public class HomeController {
	
	private static Logger logger = Logger.getLogger(HomeController.class);
	
	private static final String HOME = "home";
	
	private static CategoryService categoryService = new CategoryServiceImp();

	private static TagService tagService = new TagServiceImp();
	
	private static CommentService commentService = new CommentServiceImp();
	
	private static SiteConfigService siteConfigService = new SiteConfigServiceImp();
	
	private static LinkService linkService = new LinkServiceImp();
	
	private static UserService userService = new UserServiceImp();
	
	private static ArticleService articleService = new ArticleServiceImp();
	
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
	
	@RequestMapping(value="/home")
	public String home(Map<String,Object> map,User user){
		createReferenceData(map,user);
		return HOME;
	}
	
	/**
	 * 保存相关主页面的信息
	 * @param map
	 * @param user
	 */
	private void createReferenceData(Map<String,Object> map,User user){
		
		map.put("user", userService.find(user));//默认是只有一个用户的，这个参数是没有起作用的
		map.put("tags", tagService.getAllTag());
		map.put("categorys", categoryService.findAllCategory());
		map.put("siteConfig", siteConfigService.findAllSiteConfig());//默认只有一个站点信息
		map.put("articles",articleService.getAllArticle());
		
		//TODO:最新的五篇文章
		map.put("newestArticle", articleService.findNewestArticle());
		
		//TODO:最新的五篇评论
		map.put("newestComment",commentService.findNewestComment());
		
		//TODO:最新的五个友情链接
		map.put("newestLink", linkService.findNewestLink());
	}
}
