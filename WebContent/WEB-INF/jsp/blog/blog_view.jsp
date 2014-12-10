<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link href="../../styles/common/mycss.css" rel="stylesheet">
		<link href="../../styles/common/bootstrap.css" rel="stylesheet">
		<link href="../../styles/common/bootstrap-theme.css" rel="stylesheet">
		<link href="../../styles/common/bootstrap-theme.css" rel="stylesheet">
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
				<%@ include file="common/blog_body.jsp" %>
			</div>
			
			<!-- 隔壁的一些框框 -->
			<div class="sidebar-offcanvas col-xs-6 col-xs-4" id="sidebar"> <!-- sidebar-offcanvas -->
				<%@ include file="common/blog_sider.jsp"%>
			</div>
		</div>

<!-- 		<div class="footer1"> -->
			<%@ include file="common/blog_footer.jsp" %>
<!-- 		</div> -->
	</body>
</html>