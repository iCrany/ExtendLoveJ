<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
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
			<%@ include file="/jsp/admin/lib/admin_head.jsp"%>
		</div>
		<div class="nav">
			<%@ include file="/jsp/admin/lib/admin_nav.jsp"%>
			<hr>
		</div>
		<div class="row">
			<!-- 隔壁的一些框框 侧边栏 -->
			<div class="sidebar-offcanvas col-xs-2" id="sidebar"> <!-- sidebar-offcanvas -->
				<%@ include  file="/jsp/admin/lib/admin_contentsider.jsp" %>
			</div>
			
			<div class="col-sm-8 blog-main"> <!--  col-md-6 -->
<!-- 				面包屑功能的开发 -->
				<br>
				<ol class="breadcrumb">
					<li class="active"><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				</ol>
				<div class="content">
					<div class="panel panel-default">
						<div class="panel-body">
							<h3>Tag well:</h3>
                           <div class="well">
                               	<a href="${link.site }"><c:out value="${ link.name }"/></a>:<c:out value="${ link.description }"/>
                           </div>
                           
 							<form action="link_update" class="form-horizontal" role="form" method="Post" name="form" id="form">
	                             <div class="input-group" >
	                                 <input type="text" class="form-control" size=100 name="name" placeholder="键入链接名">
	                             </div>
	                             <div class="input-group" >
	                                 <input type="text" class="form-control" size=100 name="description" placeholder="键入链接描述">
	                             </div>	                             
	                             <div class="input-group">
	                             	<input type="text" class="form-control" name="site" placeholder="键入链接地址，如： http://www.example.com">
	                             	<span class="input-group-btn"><button class="btn btn-default" type="button" onclick="javascript:submit()">添加</button></span>
	                             </div>
	                             <input type="hidden" name="id" value="${ link.id }">
	                             <input type="hidden" name="createTime" value="${ link.createTime }">
	                             <input type="hidden" name="status" value="${ link.status }">
	                             <input type="hidden" name="trash" value="${ link.trash }">
	                             
	                       </form>
	                       
						</div>
					</div>
				</div>
			</div>
			

		</div>
	</body>
</html>