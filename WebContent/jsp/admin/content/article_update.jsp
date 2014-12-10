<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
				
// 			uploadJson 这个属性用来设置相对应的控制文件上传的 servlet 路径
// 			加了这句会报错！！！！！
// 				var editor = KindEditor.create('textarea.editor', {
// 			    	cssPath : ['[kePath]/plugins/code/prettify.css']
// 				});
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
							<form action="article_update" role="form" method="post">
							  <div class="form-group">
							    <label for="title">文章标题</label>
							    <input type="text" class="form-control" id="title" name="title" value="${ article.title }">
							  </div>
							  <div class="form-group">
							    <label for="content">文章内容</label>
								<textarea id="content" name="content" class="form-control" rows="25">
									<c:out value="${ article.content }"/>
								</textarea>
							  </div>
							  <input type="hidden" name="id" value="${ article.id }">
							  <input type="hidden" name="status" value="${ article.status }">
							  <input type="hidden" name="quote" value="${ article.quote }">
							  <input type="hidden" name="postTime" value="${article.postTime}">
							  <input type="hidden" name="view" value="${ article.view }">
							  <input type="hidden" name="topTime" value="${ article.topTime }">
							  <input type="hidden" name="trash" value="${ article.trash }">
							  <button type="submit" class="btn btn-primary">确认更新</button>
							</form>
						</div>
					</div>
				</div>
			</div>
			
			<div class="sidebar-offcanvas col-xs-2" id="sidebar"> <!-- sidebar-offcanvas -->
				<aside class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">分类目录</h3>
					</div>
					<div class="tab-pane" id="recentposts">
		            	<div class="list-group">
		<!--             		这里进行循环的输出文章的标题 -->
		            		<a href="#" class="list-group-item">分类一</a>
		            	</div>
		            </div>
				</aside>
				<aside class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">标签</h3>
					</div>
					<div class="tab-pane" id="recentposts">
		            	<div class="list-group tagcloud">
		<!--             		这里进行循环的输出文章的标题 -->
		            		<a class="" href="#" role="button">生活</a>
		            		<a class="" href="#" role="button">学习</a>
		            		<a class="" href="#" role="button">工作</a>
		            		<a class="" href="#" role="button">运动</a>
		            	</div>
		            </div>
				</aside>
			</div>			
		</div>
	</body>
</html>