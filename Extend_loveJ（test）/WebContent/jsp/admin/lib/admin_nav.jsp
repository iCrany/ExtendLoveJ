<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
	
<ul class="nav nav-pills">
  <li class="active"><a href="<%=request.getContextPath()%>/jsp/admin/index.jsp">首页</a></li>
  <li><a href="<%=request.getContextPath()%>/jsp/admin/content/article_control">基本管理</a></li>
  <li><a href="<%=request.getContextPath()%>/jsp/admin/user/user_updatebase">用户管理</a></li>
  <li><a href="<%=request.getContextPath()%>/jsp/admin/site/config_control">系统管理</a></li>  
  <li><a href="<%=request.getContextPath()%>/jsp/login">退出系统</a></li>
</ul> 