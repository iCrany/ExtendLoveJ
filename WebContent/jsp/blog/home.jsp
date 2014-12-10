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
		
		<script>
// 			$('readMore')
		</script>
		
		<title>iCrany</title>
	</head>

	<body class="container" >
		<div class="head">
			<%@ include file="common/blog_head.jsp"%>
		</div>
		
		<div class="nav">
			<%@ include file="common/blog_nav.jsp"%>
		</div>
		
<!-- 		<div class="btn-group-vertical pull-right" id="scrollGroup"> -->
<!-- 			<button type="button" class="btn btn-default scrollToTop"><span class="glyphicon glyphicon-circle-arrow-up"></span></button> -->
<!-- 			<button type="button" class="btn btn-default Refresh"><span class="glyphicon glyphicon-refresh"></span></button> -->
<!-- 			<button type="button" class="btn btn-default scrollToBottom"><span class="glyphicon glyphicon-circle-arrow-down"></span></button> -->
<!-- 		</div>			 -->
		
		<div class="row">
			<div class="col-sm-8 blog-main"> <!--  col-md-6 -->
<!-- 				面包屑功能的开发 -->
				<br>
				<ol class="breadcrumb">
					<li class="active">
						<a href="${pageContext.request.contextPath}">
							<span class="glyphicon glyphicon-home"></span>
						</a>
					</li>
				</ol>
				<%@ include file="common/blog_body.jsp" %>
			</div>
			
			<!-- 隔壁的一些框框 侧边栏 -->
			<div class="sidebar-offcanvas col-xs-6 col-xs-4" id="sidebar"> <!-- sidebar-offcanvas -->
				<%@ include file="common/blog_sider.jsp"%>
			</div>
		
		</div>

		<%@ include file="common/blog_footer.jsp" %>

	</body>
</html>