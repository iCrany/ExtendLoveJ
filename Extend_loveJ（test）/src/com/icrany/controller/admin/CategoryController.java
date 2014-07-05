package com.icrany.controller.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.directwebremoting.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.icrany.pojo.Category;
import com.icrany.service.CategoryService;
import com.icrany.service.imp.CategoryServiceImp;

/**
 * 暂且只支持没有父类的分类结构，以后完善
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/jsp/admin/content")
public class CategoryController {
	
	private static final Logger logger = Logger.getLogger(CategoryController.class);
	
	@Autowired
	private static CategoryService categoryService = new CategoryServiceImp();
	
	private static final String CONTROL_CATEGORY = "category_control";
	
	private static final String CREATE_CATEGORY = "category_create";
	
	private static final String UPDATE_CATEGORY = "category_update";
	
	private static final String DELETE_CATEGORY = "category_delete";
	
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
	 * 显示这些分类的一些信息，并且给出操作的按钮
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/category_control")
	public String control(Map<String,Object> map){
		logger.info("control()");
		
		List<Category> categoryList = categoryService.findAllCategory();
		map.put("categorys", categoryList);
		
		return CONTROL_CATEGORY;
	}
	
	/**
	 * 创建一个下的分类目录出来，相应的是 GET 请求
	 * @param map
	 * @param category
	 * @return
	 */
	@RequestMapping(value="/category_create",method=RequestMethod.GET)
	public String createMethodGet(Map<String,Object> map, Category category){
		logger.info("createMethodGet()");
		
		List<Category> categoryList = categoryService.findAllCategory();
		map.put("categorys",categoryList);
		
		return CREATE_CATEGORY;
	}
	
	/**
	 * 创建一个下的分类目录出来，相应的是 POST 请求
	 * @param map
	 * @param category
	 * @return
	 */
	@RequestMapping(value="/category_create",method=RequestMethod.POST)
	public String createMethodPost(Map<String,Object> map,Category category){
		logger.info("createMethodPost()");
		
		System.out.println(" category name = "+category.getName());
		System.out.println(" category description = "+ category.getDescription());
		
		createDataPrepare(category);
		if(categoryService.save(category)){
			System.out.println(" category 添加成功了");
		}
		else System.out.println("category 添加失败了");
		
		return "redirect:"+CONTROL_CATEGORY;
	}
	
	/**
	 * 创建分类钱的一些相关数据的设置和初始化
	 * @param category
	 */
	public void createDataPrepare(Category category){
		Date createTime = new Date();
		int priority = 0;
		boolean trash = false;
		String type = null;
		
		category.setCreateTime(createTime);
		category.setPriority(priority);
		category.setTrash(trash);
		category.setType(type);
		
	}
	
	/**
	 * 更改选定分类的名字， 相应 GET 请求
	 * @param map
	 * @param category
	 * @return
	 */
	@RequestMapping(value="/category_update",method=RequestMethod.GET)
	public String updateMethodGet(@RequestParam(value="id",required=true) Integer id,Map<String,Object> map, Category category){
		
		category = categoryService.findById(id);
		
		
		map.put("category", category);
		
		return UPDATE_CATEGORY;
	}
	
	/**
	 * 更改选定分类的名字， 相应 POST 请求
	 * @param map
	 * @param category
	 * @return
	 */
	@RequestMapping(value="/category_update",method=RequestMethod.POST)
	public String updateMethodPost(Map<String,Object> map, Category category){
		
		if(categoryService.update(category)) System.out.println("更新分类成功了");
		else System.out.println("更新分类失败了------");
		
		return "redirect:" + CONTROL_CATEGORY;
	}
	
	@RequestMapping(value="/category_delete")
	public String delete(Map<String,Object> map,Category category){
		
		if(categoryService.delete(category)) System.out.println("分类删除成功了");
		else System.out.println("分类删除失败了");
		
		return "redirect:" + CONTROL_CATEGORY;
	}
}
