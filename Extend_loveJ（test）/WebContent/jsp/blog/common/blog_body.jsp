<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <div class="content">
 	<c:forEach items="${ articles }" var="article" varStatus="itemStatus">
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="row">
					<div class="col-md-6 col-sm-6">
						<h3 class="panel-title"><a href="${pageContext.request.contextPath}/jsp/blog/blog_view?id=${ article.id }"><strong>${ article.title }</strong></a>
						<span class="badge postview">
							<span class="glyphicon glyphicon-eye-open"></span>&ensp;${ article.view }
						</span>
						<h6 class="text-muted">
							<p>作者为 <span class="author">admin</span>
								 于 <time class="updated" datetime="" pubdate>${ article.postTime }</time> 发表
							</p>
							<p><span class="glyphicon glyphicon-th-list"></span>&ensp;
								<c:forEach items="${ article.categoryList }" var="category" varStatus="secondItemStatus">
									<a href="${pageContext.request.contextPath}/jsp/blog/blog_search?categoryId=${ category.id }"><c:out value="${ category.name }"/></a>
									<c:if test="${ secondItemStatus.last == false }">•</c:if>
								</c:forEach>
							</p>
							<p><span class="glyphicon glyphicon-tag"></span>&ensp;
								<c:forEach items="${ article.tagList }" var="tag" varStatus="secondItemStatus">
									<a href="${pageContext.request.contextPath}/jsp/blog/blog_search?tagId=${ tag.id}"><c:out value="${ tag.name }"/></a>
									<c:if test="${ secondItemStatus.last == false }">•</c:if>
								</c:forEach>							
							</p>
						</h6>
						</h3>
					</div>
<!-- 					这里可以放置一些缩略图 -->
					<div class="col-md-6 col-sm-6"></div>			
				</div>
			</div>
			<div class="panel-body">
				${ article.content }
				<button type="button" class="btn btn-success pull-right"><span class="glyphicon glyphicon-chevron-down"></span>&ensp;阅读更多</button>
			</div>
			
			<div class="panel-footer">
				<c:if test="${ user != null }">
					<button type="button" class="btn btn-info pull-right"><span class="glyphicon glyphicon-edit"></span>&ensp;修改</button>
				</c:if>
				<button type="button" class="btn btn-info"><span class="glyphicon glyphicon-comment"></span>&ensp;${ article.commentCount }个评论</button>
			</div>
		</div>
	</c:forEach>
</div>