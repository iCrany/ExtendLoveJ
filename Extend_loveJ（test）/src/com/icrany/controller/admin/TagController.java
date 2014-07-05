package com.icrany.controller.admin;

import java.util.List;
import java.util.Map;

import org.directwebremoting.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.icrany.pojo.Tag;
import com.icrany.service.TagService;
import com.icrany.service.imp.TagServiceImp;

@Controller
@RequestMapping("/jsp/admin/content")
public class TagController {
	
	public static final Logger logger = Logger.getLogger(TagController.class);
	
	@Autowired
	public static TagService tagService = new TagServiceImp();
	
	public static final String CONTROL_TAG = "tag_control";
	
	public static final String UPDATE_TAG = "tag_update";
	
	public static final String CREATE_TAG = "tag_create";
	
	@RequestMapping(value="/tag_control")
	public String control(Map<String,Object> map,Tag tag){
		
		List<Tag> tagList = tagService.getAllTag();
		map.put("tags",tagList);
		
		return CONTROL_TAG;
	}
	
	@RequestMapping(value="/tag_create",method=RequestMethod.GET)
	public String createMethodGet(Map<String,Object> map,Tag tag){
		
		return CREATE_TAG;
	}
	
	@RequestMapping(value="/tag_create",method=RequestMethod.POST)
	public String createMethodPost(Map<String,Object> map,Tag tag){
		
		createDataPrepare(map,tag);
		if(tagService.insert(tag)) System.out.println("标签添加成功了");
		else System.out.println("标签添加失败了");
		return "redirect:"+CONTROL_TAG;
	}
	
	@RequestMapping(value="/tag_update",method=RequestMethod.GET)
	public String updateMethodGet(@RequestParam(value="id",required=true) Integer id,Map<String,Object> map,Tag tag){
		logger.info("updateMethodGet()");
		
		tag = tagService.getById(id);
		
		map.put("tag", tag);
		
		return UPDATE_TAG;
	}
	
	@RequestMapping(value="/tag_update",method=RequestMethod.POST)
	public String updateMethodPost(Map<String,Object> map,Tag tag){
		logger.info("updateMethodPost()");
		
		if(tagService.update(tag)) System.out.println("标签更新成功了");
		else System.out.println("标签更新失败了");
		
		return "redirect:"+CONTROL_TAG;
	}
	
	@RequestMapping(value="/tag_delete")
	public String delete(Map<String,Object> map,Tag tag){
		
		if(tagService.delete(tag)) System.out.println("标签删除成功了");
		else System.out.println("标签删除失败了");
		
		return "redirect:"+CONTROL_TAG;
	}
	
	public void createDataPrepare(Map<String,Object> map,Tag tag){
		
		boolean trash = false;
		
		System.out.println(" tag name = "+ tag.getName());
		tag.setTrash(trash);
		
	}
}
