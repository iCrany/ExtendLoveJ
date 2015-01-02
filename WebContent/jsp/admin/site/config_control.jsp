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
				<%@ include  file="/jsp/admin/lib/admin_sitenav.jsp" %>
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
							<form action="config_update" class="form-horizontal" role="form" method="post">
							  <input type="hidden" name="id" id="id" value="${ siteConfig.id }">
							  <div class="form-group">
							    <label for="name" class="col-sm-2 control-label">名称</label>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" id="name" name="name" value="${ siteConfig.name }" placeholder="名称">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="url" class="col-sm-2 control-label">链接</label>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" id="url" name="url" value="${ siteConfig.url }" placeholder="链接 加上 http://">
							    </div>
							  </div>							  
							  <div class="form-group">
							    <label for="contactDescription" class="col-sm-2 control-label">站点描述</label>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" id="contactDescription" name="contactDescription" value="${ siteConfig.contactDescription }"placeholder="站点描述">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="icp" class="col-sm-2 control-label">站点备案</label>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" id="icp" name="icp" value="${ siteConfig.icp }" placeholder="备案号 如：京ICP证030173号">
							    </div>
							  </div>							  
							  <div class="form-group">
							    <label for="about" class="col-sm-2 control-label">联系说明</label>
							    <div class="col-sm-10">
									<textarea rows="15" cols="" class="form-control"  id="about" name="about">${ siteConfig.about }</textarea>
							    </div>
							  </div>							  
							  <div class="form-group">
							    <div class="col-sm-offset-2 col-sm-10">
							      <button type="submit" class="btn btn-primary">保存</button>
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