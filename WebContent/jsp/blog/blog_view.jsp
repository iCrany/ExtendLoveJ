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
			<%@ include file="common/blog_head.jsp"%>
		</div>
		
		<div class="nav">
			<%@ include file="common/blog_nav.jsp"%>
		</div>
		
		<div class="row">
			<div class="col-sm-8 blog-main"> <!--  col-md-6 -->
<!-- 				面包屑功能的开发 -->	
				<br>
				<ol class="breadcrumb">
					<li>
						<a href="${pageContext.request.contextPath}">
							<span class="glyphicon glyphicon-home"></span>
						</a>
					</li>
					<li>
						<c:forEach items="${ article.categoryList }" var="category" varStatus="secondItemStatus">
							<a href="${pageContext.request.contextPath}/jsp/blog/blog_serarch?categoryId=${ category.id }"><c:out value="${ category.name }"/></a>
							<c:if test="${ secondItemStatus.last == false }">•</c:if>
						</c:forEach>
					</li>
					<li  class="active">
						正文
					</li>					
				</ol>
				<%@ include file="common/blog_single.jsp" %>
				<%@ include file="common/blog_comment.jsp" %>
			</div>
			
			<!-- 隔壁的一些框框 侧边栏 -->
			<div class="sidebar-offcanvas col-xs-6 col-xs-4" id="sidebar"> <!-- sidebar-offcanvas -->
				<%@ include file="common/blog_sider.jsp"%>
			</div>
		</div>

		<%@ include file="common/blog_footer.jsp" %>

	</body>
</html>