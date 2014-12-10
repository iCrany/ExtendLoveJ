<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<div class="content">
	<div class="panel panel-default">
		<div class="panel-heading">
			<div class="row">
				<div class="col-md-6 col-sm-6">
					<h3 class="panel-title" id="title"><strong>${ article.title }</strong>
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
			<p>${ article.content }</p>
		</div>
		
		<div class="panel-footer">
			<div class="input-group input-group-sm"><span class="input-group-addon">本文固定链接：</span><input type="url" class="form-control" value="${pageContext.request.contextPath}/jsp/blog/blog_view?id=${ article.id }"></div>
			<span class="help-block">转载请注明：作者为 <span class="author">admin</span> 于 <time class="updated" datetime="%1$s" pubdate>${ article.postTime }日发表</time> 在 <span class="blogname"></span> 发表</span>
			<h6>如果发现内容有误请告知我们，我们将及时更正。 <a href="#comments" title="报告错误"><button type="button" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-exclamation-sign"></span>&ensp;报错</button></a></h6>
			<c:if test="${ user != null }">
					<button type="button" class="btn btn-info pull-right" onclick="location.href='${pageContext.request.contextPath}/jsp/admin/content/article_update?id=${article.id}#title'">
					<span class="glyphicon glyphicon-edit" >&ensp;修改</span></button>
			</c:if>
			<button type="button" class="btn btn-info" onclick="location.href='${pageContext.request.contextPath}/jsp/blog/blog_view?id=${article.id}#comments'"><span class="glyphicon glyphicon-comment" ></span>&ensp;
				<c:choose>
					<c:when test="${ article.commentCount == 0}">
						抢沙发
					</c:when>
					<c:otherwise>
						${ article.commentCount }个评论
					</c:otherwise>
				</c:choose>
			</button>
		</div>
	</div>
	
</div>
    
    
    