package com.icrany.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class KindEditorUploadServlet
 */
public class KindEditorUploadServlet extends HttpServlet {
	
	private final Logger logger = Logger.getLogger(this.getClass());

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KindEditorUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
//		在这里  kindEditor 会发送一个 get 请求，连接请求类似于：    kindEditorUpload?dir=image
		
		String dirName = request.getParameter("dir");
		
		if(dirName == null){
			dirName = "image";
		}
		
//		这里设置保存上传文件的硬盘中位置
		String savePath = request.getServletContext().getRealPath(this.getServletInfo())+"/attact/"+dirName +'/' ;
		
//		这里获取在这个 web 应用中的位置，应为直接在磁盘中的路径来获取的话是被系统保护的，不可以以类似 c:\ddd\ddd.jpg 的方式来直接获取资源
		String saveUrl = request.getContextPath()+"/attact/"+dirName +'/' ;
		
		System.out.println("savePath = "+savePath);
		System.out.println("saveUrl = "+saveUrl);
		long maxSize = 10240;
		
//		这里设置返回页面的类型 contentType
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		if(!ServletFileUpload.isMultipartContent(request)){
			out.println(getError("请选择文件。"));
			return;
		}
		//检查目录
		File uploadDir = new File(savePath);
		if(!uploadDir.isDirectory()){
			uploadDir.mkdirs();
			//out.println(getError("上传目录不存在。"));
			//return;
		}
		//检查目录写权限
		if(!uploadDir.canWrite()){
			out.println(getError("上传目录没有写权限。"));
			return;
		}
		
		HashMap extMap = new HashMap();
		
//		if(!extMap.containsKey(dirName)){
//			out.println(getError("目录名不正确。"));
//			return;
//		}

		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		List<FileItem> items = new ArrayList<FileItem>();
		try {
			items = (List<FileItem>)upload.parseRequest(request);
		} catch (FileUploadException e1) {
			logger.error(e1.getMessage(), e1.getCause());
			//e1.printStackTrace();
		}
		Iterator<FileItem> itr = items.iterator();
		while (itr.hasNext()) {
			FileItem item = itr.next();
			String fileName = item.getName();
//			就是判断一个参数域是普通的表单输入域，还是文件上传域，如果该方法返回真的话，则是前者，如果为假，则是后者。是后者的情况下，就要对相应的域做相应的文件上传处理。
			if (!item.isFormField()) {
				//检查文件大小
				if(item.getSize() > maxSize){
					out.println(getError("上传文件大小超过限制。"));
					return;
				}
				//检查扩展名
				String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
//				if(!Arrays.<String>asList(extMap.get(dirName).split(",")).contains(fileExt)){
//					out.println(getError("上传文件扩展名是不允许的扩展名。\n只允许" + extMap.get(dirName) + "格式。"));
//					return;
//				}
				
				//给上传的文件内容设定一个新的名字
				SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
				String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
				try{
					File uploadedFile = new File(savePath, newFileName);
					item.write(uploadedFile);
				}catch(Exception e){
					out.println(getError("上传文件失败。"));
					return;
				}

				JSONObject obj = new JSONObject();
				obj.put("error", 0);
				obj.put("url", saveUrl + newFileName);
				out.println(obj.toJSONString());
			}
		}
		
		out.flush();
		out.close();
	}
	
	//以 JSON 的形式返回给 KindEditor 插件，以供其显示
	private String getError(String message) {
        JSONObject obj = new JSONObject();
        obj.put("error", 1);
        obj.put("message", message);
        return obj.toJSONString();
	}

}
