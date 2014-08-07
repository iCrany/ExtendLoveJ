package com.icrany.system;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.servlet.http.HttpServlet;

import org.directwebremoting.util.Logger;

import com.icrany.pojo.Article;
import com.icrany.pojo.SiteConfig;
import com.icrany.pojo.User;
import com.icrany.service.ArticleService;
import com.icrany.service.SiteConfigService;
import com.icrany.service.UserService;
import com.icrany.service.imp.ArticleServiceImp;
import com.icrany.service.imp.SiteConfigServiceImp;
import com.icrany.service.imp.UserServiceImp;

/**
 * Servlet implementation class SystemInitServlet
 */
public class SystemInitServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	private static final Logger logger = Logger.getLogger(SystemInitServlet.class);
	
	@Override
	public void init(){
		Properties pro = new Properties();
		InputStream inStream = null;
		
		inStream = this.getClass().getResourceAsStream("/ExtendLoveJ.properties");
		
		try {
			pro.load(inStream);
			Set keySet = pro.keySet();
			//这里是获取这个配置文件中的 key 这里是默认存在一个使用的用户
			for(Iterator it = keySet.iterator();it.hasNext();){
				String key = (String)it.next();
				String value = pro.getProperty(key);
				System.out.println(key+" = "+value);
				SystemConfig.getSystemConfig().put(key, value);
			}
			
			//最后就是数据库中的一些初始化工作了
			try {
				initDataBase();
				initPageTemplate();
			} catch (ParseException e) {
				logger.error("初始数据库的日期转换出错了 "+e.getStackTrace());
				e.printStackTrace();
			}
			
			logger.info("================================系统配置成功！！！！========================");
		} catch (IOException e) {
			logger.error("系统初始化出错 "+e.getStackTrace());
			e.printStackTrace();
		}
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SystemInitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
     * 这里用来初始化不同的独立页面模版 这里暂时只支持 关于我  留言板  文章归档 三种不同的独立页面 AboutMe ReaderWalls SiteMap 
     */
    public void initPageTemplate(){
    	ArticleService articleService = new ArticleServiceImp();
    	
    	List<Article> articleList = articleService.findPage();
    	
    	//现在只支持三种不同的页面模版，若数据库中少于三种 先删除，然后从新生成
    	if(articleList == null || articleList.size() < 3){
    		logger.debug("开始创建三个模版页面了");
    		articleService.deleteAllPage();//先删了
    		
    		Article aboutMe = new Article();
    		prepareSomeData(aboutMe,"AboutMe","page");
    		aboutMe.setContent("this is about me");
    		
    		Article readerWalls = new Article();
    		prepareSomeData(readerWalls,"ReaderWalls","page");
    		readerWalls.setContent("this is readerWalls");
    		
    		Article siteMap = new Article();
    		prepareSomeData(siteMap,"SiteMap","page");
    		siteMap.setContent("this is site map");
    		
    		articleService.insert(aboutMe);
    		articleService.insert(readerWalls);
    		articleService.insert(siteMap);
    	}
    }
    
    /**
     * 为文章做一些初始化的准备
     * @param article
     * @param title
     * @param articleType
     */
    public void prepareSomeData(Article article,String title,String articleType){
    	article.setMenuOrder(1);
    	article.setView(0);
    	article.setPostTime(new Date());
    	article.setTopTime(new Date());
    	article.setModifyTime(new Date());
    	article.setTitle(title);
    	article.setArticleType(articleType);
    }
    
    /**
     * 初始化数据库中的 用户 等信息
     * @throws ParseException
     */
    public void initDataBase() throws ParseException{
    	
    	//这里数据库首先尝试的是直接使用 new 来获取相对应的对象，看看会有什么情况发生
    	UserService userService = new UserServiceImp();
    	List<User> userList = userService.findAllUser();
    	
    	/**
    	 * 就是一开时的时候数据库中还没有任何的数据时， 默认添加一个管理员用户
    	 */
    	if(userList.size() < 1 || userList == null){
    		User user = new User();
    		user.setUsername(SystemConfig.getSystemConfig().get("ExtendLoveJ.user.uername"));
    		user.setPassword(SystemConfig.getSystemConfig().get("ExtendLoveJ.user.password"));
    		user.setNickname(SystemConfig.getSystemConfig().get("ExtendLoveJ.user.nickname"));
    		
    		user.setAge(Integer.parseInt(SystemConfig.getSystemConfig().get("ExtendLoveJ.user.age")));
    		user.setQq(SystemConfig.getSystemConfig().get("ExtendLoveJ.user.qq"));
    		user.setEmail(SystemConfig.getSystemConfig().get("ExtendLoveJ.user.email"));
    		user.setDescription(SystemConfig.getSystemConfig().get("ExtendLoveJ.user.description"));
    		user.setGender(Boolean.parseBoolean(SystemConfig.getSystemConfig().get("ExtendLoveJ.user.gender")));
    		user.setRoleType(Integer.parseInt(SystemConfig.getSystemConfig().get("ExtendLoveJ.user.roleType")));
    		
    		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			user.setBirthday(format.parse(SystemConfig.getSystemConfig().get("ExtendLoveJ.user.birthday")));
			Date createTime = new Date();
			user.setCreateTime(createTime);
			
			userService.insert(user);
    	}
    	
    	
    	/**
    	 * 从配置文件中获取 siteConfig 的配置内容
    	 */
    	SiteConfigService siteConfigService = new SiteConfigServiceImp();
    	SiteConfig siteConfig = new SiteConfig();
    	
    	siteConfig = siteConfigService.findAllSiteConfig();
    	//如果数据库中没有任何的信息才出读取配置文件的相关信息并且保存到数据库中去
    	if(siteConfig == null ){
    		SiteConfig entity = new SiteConfig();
    		entity.setAbout(SystemConfig.getSystemConfig().get("ExtendLoveJ.siteConfig.about"));
    		entity.setContactDescription(SystemConfig.getSystemConfig().get("ExtendLoveJ.siteConfig.contactDescription"));
    		entity.setIcp(SystemConfig.getSystemConfig().get("ExtendLoveJ.siteConfig.icp"));
    		entity.setName(SystemConfig.getSystemConfig().get("ExtendLoveJ.siteConfig.name"));
    		entity.setUrl(SystemConfig.getSystemConfig().get("ExtendLoveJ.siteConfig.url"));
    		
    		siteConfigService.insert(entity);
    	}
    }


}
