<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link href="${pageContext.request.contextPath}/styles/common/mycss.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/styles/common/bootstrap.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/styles/common/bootstrap-theme.css" rel="stylesheet">
		<!-- DC iMenu CSS -->
		<link type="text/css" rel="stylesheet" href="../../styles/blog/menus/imenu/css/dc_imenu.css" />
		
		<title>iCrany</title>
	</head>

	<body class="container" >
		<div class="head">
			<%@ include file="lib/admin_head.jsp"%>
		</div>
		<div class="nav">
			<%@ include file="lib/admin_nav.jsp"%>
			<hr>
		</div>
		<div class="row">
			<!-- 隔壁的一些框框 侧边栏 -->
			<div class="sidebar-offcanvas col-xs-2" id="sidebar"> <!-- sidebar-offcanvas -->
				<ul class="nav nav-pills">
				  <li class="active"><a href="${pageContext.request.contextPath}">首页</a></li>
				</ul>
			</div>
			
			<div class="col-sm-8 blog-main"> <!--  col-md-6 -->
<!-- 				面包屑功能的开发 -->
				<br>
				<ol class="breadcrumb">
					<li class="active">
						<a href="#"><span class="glyphicon glyphicon-home"></span></a>
					</li>
				</ol>
				<div class="content">
					<div class="panel panel-default">
						<div class="panel-body">
							<p>
								该系统后台是由 jsp servlet 进行开发
								前端是由  各种js框架    bootstrap前端框架 
								数据库 mysql 
								不适用于 ie 内核的浏览器，建议使用 chrome firefox salrif等浏览器  
								欢迎大家交流学习
							</p>
						</div>
					</div>
				</div>
			</div>
			

		</div>
	</body>
</html>