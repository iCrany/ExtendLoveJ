<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <div class="content">
 	<c:forEach items="${ articles }" var="article" varStatus="itemStatus">
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="row">
					<div class="col-md-6 col-sm-6">
						<h3 class="panel-title"><a href="#"><strong>${ article.title }</strong></a>
						<span class="badge postview">
							<span class="glyphicon glyphicon-eye-open"></span>&ensp;${ article.view }
						</span>
						<h6 class="text-muted">
							<p>作者为 <span class="author">admin</span>
								 于 <time class="updated" datetime="" pubdate>${ article.postTime }</time> 发表
							</p>
						</h6>
						</h3>
					</div>
				</div>
			</div>
			<div class="panel-body">
				${ article.content }
				<button type="button" class="btn btn-success pull-right"><span class="glyphicon glyphicon-chevron-down"></span>&ensp;阅读更多</button>
			</div>
			
			<div class="panel-footer">
				<c:choose>
					<c:when test="${ user != null }">
						<button type="button" class="btn btn-info pull-right"><span class="glyphicon glyphicon-edit"></span>&ensp;修改</button>
					</c:when>
				</c:choose>
				
				<button type="button" class="btn btn-info"><span class="glyphicon glyphicon-comment"></span>&ensp;6个评论</button>
			</div>
		</div>
	</c:forEach>
</div>