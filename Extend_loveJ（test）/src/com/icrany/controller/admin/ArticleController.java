package com.icrany.controller.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.icrany.pojo.Article;
import com.icrany.pojo.Category;
import com.icrany.pojo.Tag;
import com.icrany.service.ArticleService;
import com.icrany.service.CategoryArticleService;
import com.icrany.service.CategoryService;
import com.icrany.service.TagArticleService;
import com.icrany.service.TagService;
import com.icrany.service.imp.ArticleServiceImp;
import com.icrany.service.imp.CategoryArticleServiceImp;
import com.icrany.service.imp.CategoryServiceImp;
import com.icrany.service.imp.TagArticleServiceImp;
import com.icrany.service.imp.TagServiceImp;

@Controller
@RequestMapping("/jsp/admin/content")
public class ArticleController {
	
	private static final Logger logger = Logger.getLogger(ArticleController.class);
	
	private static String CREATE_ARTICLE = "article_create";
	
	private static String UPDATE_ARTICLE = "article_update";
	
	private static String CONTROL_ARTICLE = "article_control";

	@Autowired
	private static ArticleService articleService = new ArticleServiceImp();
	
	@Autowired
	private static CategoryService categoryService = new CategoryServiceImp();
	
	@Autowired
	private static TagService tagService = new TagServiceImp();
	
	@Autowired
	private static CategoryArticleService categoryArticleService = new CategoryArticleServiceImp();
	
	@Autowired
	private static TagArticleService tagArticleService = new TagArticleServiceImp();	
	
	ArticleController(){
//		这里有成功的初始化
		System.out.println("ArticleController 初始化成功");
	}
	
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
	 * 这里相应的解决直接在浏览器中输入 url 的 get 请求的处理
	 * @param request
	 * @param map
	 * @param article
	 * @return
	 */
	@RequestMapping(value="/article_create",method=RequestMethod.GET)
	public String createMethodGet(HttpServletRequest request, Map<String, Object> map, Article article){
		logger.info("createMethodGet()");
		createReferenceData(article,map);
		return CREATE_ARTICLE;
	}
	
	/**
	 * 这里处理相应的  post 请求,以及相应的处理将文章的内容保存到数据库中去
	 * 注：入参中有一个参数为 map<String,Object> 的参数，但是 SpringMvc并不会将视图的参数绑定在里面
	 * @param request
	 * @param map
	 * @param article
	 * @return
	 */
	@RequestMapping(value="/article_create",method=RequestMethod.POST)
	public String createMethodPost(HttpServletRequest request,Article article,Map<String,Object> map){
		logger.info("createMethodPost()");
		
		//获取 Category 和 tag 的选择结果
		String[] categorys = request.getParameterValues("categorys");
		String[] tags = request.getParameterValues("tags");
		createDataPrepare(article,map);
		int articleId = articleService.insert(article);
		
		categoryArticleService.insertArray(categorys, articleId);
		tagArticleService.insertArray(tags, articleId);
		
		return CREATE_ARTICLE;
	}
	
	/**
	 * 保存文章前的数据的初始化
	 * @param request
	 * @param article
	 */
	public void createDataPrepare(Article article,Map<String,Object> map){
		Date postTime = new Date();
		Date modifyTime = new Date();
		Date topTime = new Date();
		String summary = article.getContent().length() > 6 ? article.getContent().substring(0,6) : article.getContent();
		
		article.setPostTime(postTime);
		article.setModifyTime(modifyTime);
		article.setTopTime(topTime);
		article.setView(0);
		article.setSummary(summary);
		article.setTrash(false);//文章创建的时候 这个 trash 属性都是默认的为 false, 即没有被删除
		article.setArticleType("post");//默认的文章发表类型都为这个 post 类型
		createReferenceData(article,map);
	}
	
	/**
	 * 准备相关的 分类 标签等相关信息
	 * @param article
	 * @param map
	 */
	public void createReferenceData(Article article,Map<String,Object> map){
		//这里是添加分类 和 标签的 相关信息
		List<Category> categoryList = categoryService.findAllCategory();
		
		List<Tag> tagList = tagService.getAllTag();
		
		map.put("categorys", categoryList);
		map.put("tags", tagList);
	}
	
	@RequestMapping(value="/article_control")
	public String control(Map<String,Object> map){
		logger.info("control()");
		if(articleService== null) logger.info("articleService 是空的");
		List<Article> articles = articleService.getAllArticle();
		map.put("articles", articles);//springMvc 自动会将这个放入模型中
		return CONTROL_ARTICLE;
	}
	
	
	/**
	 * 根据文章的 id 来修改 文章的内容
	 * 这个 id 最好设置成为一个 类 的类型，因为首次访问这个链接的时候是不知道这个id的值，或者说这个id 的值是为空的。
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="article_update", method=RequestMethod.GET)
	public String updateMethodGet(@RequestParam(value="id",required=false) Integer id, Map<String,Object> map){
		logger.info("updateArticleMethodGet()");
		System.out.println(" id = "+id); 
		if(id == null){
			return UPDATE_ARTICLE;
		}
		map.put("article", articleService.queryById(id));
		
		return UPDATE_ARTICLE;
	}
	
	@RequestMapping(value="article_update",method=RequestMethod.POST)
	public String updateMethodPost(@RequestParam(value="id",required=true) Integer id,Article article,Map<String,Object> map){
		logger.info("updateArticleMethodPost()");
		
		System.out.println(" id = "+id);
		System.out.println(" article id = " + article.getId());
		Date modifyTime = new Date();
		
		//TODO:这个文章的摘要算法还要解决文章中保存了 html 源码的时候怎么把 html 标签一起显示出来的问题
		String summary = article.getContent().length() > 6 ? article.getContent().substring(0,6) : article.getContent();
		article.setModifyTime(modifyTime);
		article.setSummary(summary);
		if(articleService.update(article)) logger.info("文章更新成功了");
		else logger.info("更新文章失败了");
		
		return UPDATE_ARTICLE;
	}
	
	@RequestMapping(value="article_delete")
	public String delete(@RequestParam(value="id") Integer id, Map<String,Object> map){
		logger.info("delete()");
		
		logger.info(" id = "+id);
		Article article = new Article();
		article.setId(id);
		articleService.delete(article);
		logger.info("删除文章成功了！！！！！");
		return "redirect:" + CONTROL_ARTICLE;
	}
}
