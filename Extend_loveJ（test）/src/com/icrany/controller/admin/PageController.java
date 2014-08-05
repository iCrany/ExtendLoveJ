package com.icrany.controller.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.directwebremoting.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.icrany.pojo.Article;
import com.icrany.service.ArticleService;
import com.icrany.service.imp.ArticleServiceImp;

@Controller
@RequestMapping("/jsp/admin/content")
public class PageController {
	
	private static final Logger logger = Logger.getLogger(PageController.class);
	
	private static final String CREATE_PAGE = "page_create";
	
	@Autowired
	private static ArticleService articleService = new ArticleServiceImp();
	
	/**
	 * 这个类是用来处理 类型之间的转换的问题，如 date --> String 之间的转换
	 * @param binder
	 */
	@InitBinder
	private void dateBinder(WebDataBinder binder) {
	            //The date format to parse or output your dates
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	            //Create a new CustomDateEditor
	    CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
	            //Register it as custom editor for the Date type
	    binder.registerCustomEditor(Date.class, editor);
	}
	
	/**
	 * post 请求 创建一个新的独立页面
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/page_create" ,method=RequestMethod.POST)
	public String createMethodPost(HttpServletRequest request,Map<String,Object> map,Article article){
		String articleType = request.getParameter("IndePage");
		article.setArticleType(articleType);
		createDataPrepare(map,article);
		return CREATE_PAGE;
	}
	
	/**
	 * get 请求 用于显示的一个 独立页面的 ui
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/page_create",method=RequestMethod.GET)
	public String createMethodGet(Map<String,Object> map){
		
		return CREATE_PAGE;
	}
	
	/**
	 * 相关数据的准备
	 * @param map
	 */
	public void createDataPrepare(Map<String,Object> map,Article article){
		Date postTime = new Date();
		Date modifyTime = new Date();
		Date topTime = new Date();
		
		article.setPostTime(postTime);
		article.setModifyTime(modifyTime);
		article.setTopTime(topTime);
		article.setView(0);
		article.setTrash(false);//文章创建的时候 这个 trash 属性都是默认的为 false, 即没有被删除
		
		articleService.insert(article);
		map.put("pages", articleService.findPage());
	}

}
