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
		<script type="text/javascript">
			function submbit(){
				alert("submit()");
				document.forms.form.submit();
			}
		</script>
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
							<h3>原标签名：</h3>
                           <div class="well">
                              <c:out value="${ tag.name }"/>
                           </div>
                           <h3>原标签描述：</h3>
                           <div class="well">
                              <c:out value="${ tag.description }"></c:out>
                           </div>
                           
 							<form action="tag_update" class="form-horizontal" role="form" method="Post" name="form" id="form">
	                             <div class="input-group" >
	                                 <input type="text" class="form-control" size=150 name="name" placeholder="键入新标签名">
	                             </div>
	                             <div class="input-group">
	                             	<input type="text" class="form-control" name="description" placeholder="键入新标签描述">
	                             	<span class="input-group-btn"><button class="btn btn-default" type="button" onclick="javascript:submit()">更新</button></span>
	                             </div>
								 <input type="hidden" name="id" value="${ tag.id }">
	                             <input type="hidden" name="trash" value="${ tag.trash }">
	                       </form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>