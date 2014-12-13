package com.icrany.controller.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.icrany.vo.Comment;
import com.icrany.vo.Tag;
import com.icrany.service.CommentService;

@Controller
@RequestMapping("/jsp/admin/content")
public class CommentController {
	
	private static final Logger logger = Logger.getLogger(ArticleController.class);
	
	@Autowired
	private CommentService commentService ;
	
	private static String CREATE_COMMENT = "comment_create";
	
	private static String CONTROL_COMMENT = "comment_control";
	
	private static String RESPONSE_COMMENT = "comment_response";

	@InitBinder
	private void dateBinder(WebDataBinder binder) {
	            //The date format to parse or output your dates
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	            //Create a new CustomDateEditor
	    CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
	            //Register it as custom editor for the Date type
	    binder.registerCustomEditor(Date.class, editor);
	}
	
	@RequestMapping(value="/comment_control")
	public String control(Map<String,Object> map,Comment comment){
		
		List<Comment> commentList = commentService.findAllComment();
		map.put("comments",commentList);
		
		return CONTROL_COMMENT;
	}
	
	@RequestMapping(value="/comment_create",method=RequestMethod.GET)
	public String createMethodGet(Map<String,Object> map,Tag tag){
		
		return CREATE_COMMENT;
	}
	
	@RequestMapping(value="/comment_create",method=RequestMethod.POST)
	public String createMethodPost(Map<String,Object> map,Comment comment){
		
		createDataPrepare(map,comment);
		if(commentService.insert(comment) >= 0) System.out.println("标签添加成功了");
		else System.out.println("评论添加失败了");
		return "redirect:"+CONTROL_COMMENT;
	}
	
//	@RequestMapping(value="/comment_update",method=RequestMethod.GET)
//	public String updateMethodGet(@RequestParam(value="id",required=true) Integer id,Map<String,Object> map,Comment comment){
//		logger.info("updateMethodGet()");
//		
//		comment = commentService.findById(id);
//		
//		map.put("comment", comment);
//		
//		return UPDATE_TAG;
//	}
	
	@RequestMapping(value="/comment_approve")
	public String approveMethodPost(Map<String,Object> map,Comment comment,@RequestParam("name") String name){
		logger.info("approveMethodPost()");
		
		System.out.println("approveMethodPost() name = "+name);
		System.out.println(" comment id = "+comment.getId());
		System.out.println(" comment trash = "+comment.getTrash());
		System.out.println(" comment name = "+comment.getName());
		
		if(commentService.updateAttribute(name,comment)) System.out.println("标签更新某个属性成功了");
		else System.out.println("标签更新某个属性失败了");
		
		return "redirect:"+CONTROL_COMMENT;
	}
	
	@RequestMapping(value="/comment_delete")
	public String delete(Map<String,Object> map,Comment comment,@RequestParam(value="id") Integer id){
		
		if(commentService.delete(comment) >= 0) System.out.println("评论删除成功了");
		else System.out.println("评论删除失败了");
		
		return "redirect:"+CONTROL_COMMENT;
	}
	
	/**
	 * 这里的回复 是打算 重定向到 blog 的页面中，直接在文章的评论中进行评论的回复
	 * TODO:这里的功能还没有完成，以及可以的话实现评论都额嵌套功能的实现
	 * @param map
	 * @param comment
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/comment_response")
	public String response(Map<String,Object> map,Comment comment,@RequestParam(value="id") Integer id){
		
		return "redirect:"+ RESPONSE_COMMENT;
	}
	
	public void createDataPrepare(Map<String,Object> map,Comment comment){
		//TODO: 这里还要记得处理客户端的 ip 地址问题
		Date postTime = new Date();
		String postIP = null;
		String status = null;
		
		System.out.println(" tag name = "+ comment.getName());
		
		
	}	
	
}
