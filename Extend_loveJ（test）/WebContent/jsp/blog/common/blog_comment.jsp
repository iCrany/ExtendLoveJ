<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<hr>
    <div id="comments">
    	<div id="response">
    		<h3>来了就留个言吧<small><span class="badge">
    			<c:choose>
    				<c:when test="${ article.commentCount == 0 }"> 抢沙发 </c:when>
    				<c:otherwise>${ article.commentCount } 个评论 </c:otherwise>
    			</c:choose>
    			
    			</span></small></h3>
    		<form action="" id="commentForm" name="commentForm"  role="form">
    			<div class="input-group">
    				<span class="input-group-addon">
    					<span class="glyphicon glyphicon-user">
    					</span>
    				</span>
    				<input type="text" name="name" id="name" class="form-control" placeholder="姓名 必填">
    			</div>
    			<br>
    			<div class="input-group"> 
    				<span class="input-group-addon">
    					<span class="glyphicon glyphicon-envelope">
    					</span>
    				</span>
    				<input type="text" name="email" id="email" class="form-control" placeholder="邮件 必填 我们会替你保密的">
    			</div>
    			<br>
    			<div class="input-group">
    				<span class="input-group-addon">
    					<span class="glyphicon glyphicon-globe">
    					</span>
    				</span>
    				<input type="text" name="site" id="site" class="form-control" placeholder="网站 以 http:// 开头">
    			</div>
    			<br>
    			<div class="input-group">
    				<span class="input-group-addon">
    					<span class="glyphicon glyphicon-comment">
    					</span>
    				</span>
    				<textarea name="comment" id="comment" rows="8" cols="" class="form-control"></textarea>
    			</div>
    			<hr>
    			<button type="submit" id="submit" name="submit" class="btn btn-primary pull-right">
    				提交&ensp;<span class="glyphicon glyphicon-send"></span>
    			</button>			
    		</form>
    	</div>
    	
    	<!--     		这里就循环的输出该页面下所有的评论即可 -->
    	<c:forEach items="${ comments }" var="comment" varStatus="itemStatus">
	    	<div name="comment-12" id="comment-12" class="">
	    		<div class="media">
		    		<a href="#" class="pull-left" rel="nofollow">
		    			<img id="" class="img-thumbnail avatar-64 photo grav-hashed grav-hijack" height="64" width="64">
		    		</a>
		    		<div class="mediabody">
			    			<h5 class="mediaheadding">
			    				<a href="${ comment.site }"><c:out value="${ comment.name }"/></a>
			    				<small><c:out value="${ comment.postTime }"/></small>
			    			</h5>
			    			<div class="well well-sm">
			    				<p><c:out value="${ comment.content }"/></p>
			    			</div>	    			
		    			
		    		</div>
		    	</div>
	    	</div>
    	</c:forEach>
    </div>