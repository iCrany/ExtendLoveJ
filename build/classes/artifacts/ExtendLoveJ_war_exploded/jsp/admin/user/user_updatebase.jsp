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
							<form action="user_updatebase" class="form-horizontal" role="form" method="post">
							  <c:choose>
							  	<c:when test="${ message != null }"><font color="red">${ message }</font></c:when>
							  	<c:otherwise><font color="green">${ message }</font></c:otherwise>
							  </c:choose>							
							  <input type="hidden" name="id" id="id" value="${ user.id }">
							  <div class="form-group">
							    <label for="nickname" class="col-sm-2 control-label">昵称</label>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" id="nickname" name="nickname" value="${ user.nickname }" placeholder="昵称">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="description" class="col-sm-2 control-label">描述</label>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" id="description" name="description" value="${ user.description }" placeholder="描述">
							    </div>
							  </div>							  
							  <div class="form-group">
							    <label for="age" class="col-sm-2 control-label">年龄</label>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" id="age" name="age" value="${ user.age }" placeholder="年龄">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="birthday" class="col-sm-2 control-label">生日</label>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" id="birthday" name="birthday" value="${ user.birthday }"placeholder="生日（2014-06-24 17:50:44）">
							    </div>
							  </div>							  
							  <div class="form-group">
							    <label for="gender" class="col-sm-2 control-label">性别</label>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" id="gender" name="gender" value="${ user.gender }" placeholder="性别（如：男 或 man 女或woman）">
							    </div>
							  </div>							  
							  <div class="form-group">
							    <label for="qq" class="col-sm-2 control-label">qq号</label>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" id="qq" name="qq" value="${ user.qq }" placeholder="qq号">
							    </div>
							  </div>
							  <div class="form-group">
							    <div class="col-sm-offset-2 col-sm-10">
							      <input type="submit" class="btn btn-primary" value="确认更新">
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