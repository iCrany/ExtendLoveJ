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
                                    <td>昵称</td>
                                    <td>评论</td>
                                    <td>状态</td>
                                    <td>操作</td>
                                </tr>
                                <c:forEach items="${ comments }" var="comment" varStatus="itemStatus">
                                	<tr>
                                		<td><c:out value="${ itemStatus.index + 1 }"/></td>
                                		<td><c:out value="${ comment.name }"/></td>
                                		<td><c:out value="${ comment.content }"/></td>
                                		<td>
                                		<c:choose>
                                			<c:when test="${ comment.status == false }">
                                				<font color="red"><c:out value="待审核"/></font>
                                			</c:when>
                                			<c:otherwise>
                                				<font color="green"><c:out value="已审核"/></font>
                                			</c:otherwise>
                                		</c:choose>
                                		</td>
                                		<td>
                                			<a href="${pageContext.request.contextPath}/jsp/admin/content/comment_approve?id=${ comment.id }&name=status&status=true">批准</a>
                                			/<a href="${pageContext.request.contextPath}/jsp/admin/content/comment_approve?id=${ comment.id }&name=status&status=false">驳回</a>
                                			/<a href="${pageContext.request.contextPath}/jsp/admin/content/comment_response?id=${ comment.id }">回复</a>
                                			/<a href="${pageContext.request.contextPath}/jsp/admin/content/comment_delete?id=${ comment.id }">删除</a>
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