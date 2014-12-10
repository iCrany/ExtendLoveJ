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
							<form class="form-horizontal" role="form" name="musicForm">
							  <table class="table table-striped" id="musicTable">
							  	<tr>
							  		<td>#</td>
							  		<td>歌曲名</td>
							  		<td>歌手</td>
							  		<td>链接地址</td>
							  	</tr>
							  </table>
<script>
$(document).ready(function(){
	var index;
	$("#createLine").click(function(){
	var $musicTable = $("#musicTable");
	if (index == null) {
	var name = $musicTable.find("tr:last td:last input").attr("name");
	name = name.substring(name.indexOf('[')+1);
	index = name.substring(0,name.indexOf(']'));
	}
	index++;
	//alert(index);
	var $track_tr = $("<tr><td><input name='tracks[" + index + "].title'/></td>"+
	"<td><input name='tracks[" + index + "].location' style='width:250px;'/></td>"+
	"<td><input name='tracks[" + index + "].creator'/></td></tr>");
	$trackTable.append($track_tr);
	});
	});
</script>							  
							  <c:forEach items="${ musics }" var="music" varStatus="itemStatus">
							  	<tr>
							  		<td><c:out value="${ itemStatus.index + 1 }"/></td>
							  		<td><input type="text" name="name" value="${ music.name }"></td>
							  		<td><input type="text" name="singer" value="${ music.singer }"></td>
							  		<td><input type="text" name="url" value="${ music.url }"></td>
							  	</tr>
							  </c:forEach>					  
							  <div class="form-group">
							    <div class="col-sm-offset-1 col-sm-10">
							      <button type="button" class="btn btn-primary" name="createLine" id="createLine">新增</button>
							      <button type="submit" class="btn btn-primary" name="submit" id="submit">保存</button>
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