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
                            <table class="table">
                                <tr>
                                    <td>#</td>
                                    <td>名称</td>
                                    <td>URL</td>
                                    <td>操作</td>
                                </tr>
                                <c:forEach items="${ links }" var="link" varStatus="itemStatus">
                                	<tr>
                                		<td><c:out value="${ itemStatus.index+1 }"></c:out></td>
                                		<td><c:out value="${ link.name }"/></td>
                                		<td><c:out value="${ link.site }"/></td>
                                		<td><a href="${pageContext.request.contextPath}/jsp/admin/content/link_update?id=${ link.id }">编辑</a>
                                			/<a href="${pageContext.request.contextPath}/jsp/admin/content/link_delete?id=${ link.id }">删除</a>
                                		</td>
                                	</tr>
                                </c:forEach>                                
                            </table>
						</div>
					</div>
				</div>
			</div>
			

		</div>
	</body>
</html>