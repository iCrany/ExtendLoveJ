<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link href="${pageContext.request.contextPath}/styles/common/mycss.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/styles/common/bootstrap.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/styles/common/bootstrap-theme.css" rel="stylesheet">
		
		<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/js/collapse.js" type="text/javascript" charset="utf-8"></script>
		
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
					<li  class="active">
						归档
					</li>					
				</ol>
<!-- 				这里就是显示所有文章以时间的月份来进行分类显示 -->
				<div class="content">
					<div class="panel panel-default">
						<div class="panel-heading">
							<div class="row">
								<div class="col-md-6 col-sm-6">
									<h3 class="panel-title" id="title"><strong>文章归档</strong>
									</h3>
								</div>
							</div>
						</div>
						<div class="panel-body">
<%-- 							<c:forEach items="${ articles }" var="article" varStatus="itemStatus"> --%>
								<div id="myCollapsibleExample">
									+ <a href="#demo+'${ itemStatus.index }'" data-toggle="collapse"> <fmt:formatDate value="${ article.createTime }" pattern="yyyy年MM月"/></a>
								</div>
								<div id="demo+'${ itemStatus.index }'" class="collapse">
									<ul>
										<c:forEach items="${ articleForMonths }" var="articleForMonth" varStatus="secondItemStatus">
											<li>
												<fmt:formatDate value="${ articleForMonth.postTime }" pattern="dd日"/>
												<a href="${pageContext.request.contextPath}/jsp/blog/blog_view?id=${article.id}#comments">${ articleForMonth.title }</a>(${ articleForMonth.commentCount }条评论)
											</li>
										</c:forEach>
									</ul>
								</div>								
<%-- 							</c:forEach> --%>
						</div>
					</div>
				</div>				
			</div>
			
			<!-- 隔壁的一些框框 侧边栏 -->
			<div class="sidebar-offcanvas col-xs-6 col-xs-4" id="sidebar"> <!-- sidebar-offcanvas -->
				<%@ include file="common/blog_sider.jsp"%>
			</div>
		</div>
		<%@ include file="common/blog_footer.jsp" %>
	</body>
</html>