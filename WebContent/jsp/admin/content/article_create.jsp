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
	    <script charset="utf-8" src="<%=request.getContextPath() %>/styles/kindeditor-4.1/kindeditor.js" type="text/javascript"></script>		
	    <script charset="utf-8" src="<%=request.getContextPath() %>/styles/kindeditor-4.1/lang/zh_CN.js" type="text/javascript"></script>		
	    <script charset="utf-8" src="<%=request.getContextPath() %>/js/jquery-2.1.1.js" type="text/javascript"></script>		
	    <script>
			KindEditor.ready(function(K) {
					editor = K.create('textarea[id="content"]', {
						langType : 'zh_CN',
						uploadJson : '<%=request.getContextPath()%>/kindEditorUpload',
						allowFileManager : false,
					});
				});
				
   		</script>
    		
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
		<form action="article_create" role="form" method="post">
			<div class="row">
				<!-- 隔壁的一些框框 侧边栏 -->
				<div class="sidebar-offcanvas col-xs-2" id="sidemenu"> <!-- sidebar-offcanvas -->
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
								
								  <div class="form-group">
								    <label for="title">文章标题</label>
								    <input type="text" class="form-control" id="title" name="title">
								  </div>
								  <div class="form-group">
								    <label for="txtContent">文章内容</label>
									<textarea id="content" name="content" class="form-control" rows="25">
									
									</textarea>
								  </div>
	
								  <button type="submit" class="btn btn-primary">发表</button>
								
							</div>
						</div>
					</div>
				</div>
				
				<div class="sidebar-offcanvas col-xs-2" id="sidebar"> <!-- sidebar-offcanvas -->
					<aside class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">分类选择</h3>
						</div>
						<div class="tab-pane" id="recentposts">
							<c:forEach items="${ categorys }" var="category" varStatus="itemStatus">
								<div class="checkbox">
								  <label>
								    <input type="checkbox" name="categorys" value="${ category.id }">
								   		<c:out value="${ category.name }"/>
								  </label>
								</div>						
							</c:forEach>
	
			            </div>
					</aside>
					<aside class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">标签选择</h3>
						</div>
						<div class="tab-pane" id="recentposts">
							<c:forEach items="${ tags }" var="tag" varStatus="itemStatus">
								<div class="checkbox">
								  <label>
								    <input type="checkbox" name="tags" value="${ tag.id }">
								   		<c:out value="${ tag.name }"></c:out>
								  </label>
								</div>						
							</c:forEach>
			            </div>
					</aside>
				</div>			
			</div>
		</form>
	</body>
</html>