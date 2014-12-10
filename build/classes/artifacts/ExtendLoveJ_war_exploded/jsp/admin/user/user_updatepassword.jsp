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
				<%@ include  file="/jsp/admin/lib/admin_usernav.jsp" %>
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
							<form action="user_updatepassword" class="form-horizontal" role="form" method="post">
							  <c:choose>
							  	<c:when test="${ message != null }"><font color="red">${ message }</font></c:when>
							  	<c:otherwise><font color="green">${ message }</font></c:otherwise>
							  </c:choose>
							  <input type="hidden" name="id" id="id" value="${ user.id }">	
							  <div class="form-group">
							    <label for="oldPassword" class="col-sm-2 control-label">旧密码</label>
							    <div class="col-sm-10">
							      <input type="password" class="form-control" id="oldPassword" name="oldPassword" placeholder="旧密码">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="password" class="col-sm-2 control-label">新密码</label>
							    <div class="col-sm-10">
							      <input type="password" class="form-control" id="password" name="password" placeholder="新密码">
							    </div>
							  </div>							  
							  <div class="form-group">
							    <label for="confPassword" class="col-sm-2 control-label">确认密码</label>
							    <div class="col-sm-10">
							      <input type="password" class="form-control" id="confPassword" name="confPassword" placeholder="确认密码">
							    </div>
							  </div>
							  <div class="form-group">
							    <div class="col-sm-offset-2 col-sm-10">
							      <button type="submit" class="btn btn-primary">确认更新</button>
							    </div>
							  </div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>