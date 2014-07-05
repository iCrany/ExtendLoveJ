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

import com.icrany.pojo.Link;
import com.icrany.service.LinkService;
import com.icrany.service.imp.LinkServiceImp;

@Controller
@RequestMapping("/jsp/admin/content")
public class LinkController {
	
	public static final Logger logger = Logger.getLogger(LinkController.class);
	
	@Autowired
	public static LinkService linkService = new LinkServiceImp();
	
	public static final String CONTROL_LINK = "link_control";
	
	public static final String UPDATE_LINK = "link_update";
	
	public static final String CREATE_LINK = "link_create";
	
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
	
	@RequestMapping(value="/link_control")
	public String control(Map<String,Object> map,Link link){
		
		List<Link> linkList = linkService.findAllLink();
		map.put("links", linkList);
		return CONTROL_LINK;
	}
	
	/**
	 * 这里的参数如果多了一个 @RequestParam(value="id") Integer id 的话就会报400错误？
	 *  The request sent by the client was syntactically incorrect.
	 * @param map
	 * @param link
	 * @return
	 */
	@RequestMapping(value="/link_create",method=RequestMethod.GET)
	public String createMethodPut(Map<String,Object> map,Link link){
		
		List<Link> linkList = linkService.findAllLink();
		map.put("links", linkList);
		return CREATE_LINK;
	}
	
	@RequestMapping(value="/link_create",method=RequestMethod.POST)
	public String createMethodPost(Map<String,Object> map,Link link){
		
		System.out.println("name = "+link.getName());
		System.out.println("description = "+link.getDescription());
		System.out.println("site = "+link.getSite());
		createDataPrepare(map,link);
		if(linkService.insert(link)) System.out.println("链接添加成功了");
		else System.out.println("链接添加失败了");
		
		return "redirect:"+CONTROL_LINK;
	}

	@RequestMapping(value="/link_update",method=RequestMethod.GET)
	public String updateMethodGet(@RequestParam(value="id",required=true) Integer id,Map<String,Object> map,Link link){
		
		link = linkService.findById(id);
		map.put("link", link);
		return UPDATE_LINK;
	}
	
	@RequestMapping(value="/link_update",method=RequestMethod.POST)
	public String updateMethodPost(@RequestParam(value="id",required=true) Integer id,Map<String,Object> map,Link link){
		
		System.out.println("link site = "+link.getSite());
		System.out.println("link description = "+link.getDescription());
		System.out.println("link name = "+link.getName());
		
		if(linkService.update(link)) System.out.println("链接更新成功");
		else System.out.println("链接更新失败----");
		
		return "redirect:"+CONTROL_LINK;
	}
	
	@RequestMapping(value="/link_delete")
	public String delete(Map<String,Object> map,Link link){
		
		if(linkService.delete(link)) System.out.println("链接删除成功");
		else System.out.println("链接删除失败了");
		
		return  "redirect:"+CONTROL_LINK;
	}
	
	public void createDataPrepare(Map<String,Object> map,Link link){
		Date createTime = new Date();
		boolean trash = false;
		String status = null;
		link.setTrash(trash);
		link.setStatus(status);
		link.setCreateTime(createTime);
	}
}
