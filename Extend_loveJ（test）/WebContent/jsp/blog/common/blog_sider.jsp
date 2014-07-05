<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--   	 搜索栏 -->
	    <div class="widget-area" role="complementary">
		    <h2 class="star">
				<form action="" method="post" id="formID">
					<div class="input-group">
						<span class="input-group-addon">
							<span class="glyphicon glyphicon-search"></span>
						</span>
						<input type="text" name="searchinput" class="form-control" id="searchinput"/>
						<span class="input-group-btn">
							<button type="submit" name="search" id="search" class="btn btn-default">搜索</button>
						</span>
					</div>
				</form>
			</h2>
	    </div>  
	    <hr>
<!-- 	   最新文章 -->
		<aside class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">最新文章</h3>
			</div>
			<div class="tab-pane" id="recentposts">
            	<div class="list-group">
<!--             		这里进行循环的输出文章的标题 -->
					<c:forEach items="${ newestArticle }" var="article" varStatus="itemStatus">
						<a href="#" class="list-group-item"><c:out value="${ article.title }"/></a>
					</c:forEach>
            	</div>
            </div>
		</aside>

		<aside class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">最新评论</h3>
			</div>
			<div class="tab-pane" id="recentcomments">
            	<div class="list-group">
<!--             		这里进行循环的输出最新评论 -->
					<c:forEach items="${ newestComment }" var="comment" varStatus="itemStatus">
						<a href="#" class="list-group-item"><c:out value="${ comment.name }"/></a>
					</c:forEach>
            	</div>
            </div>
		</aside>
	    
 		
<!--  		文章分类-->
		<aside class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">文章分类</h3>
			</div>
			<div class="tab-pane" id="posttype">
            	<div class="list-group">
<!--             		这里进行循环的输出文章分类-->
					<c:forEach items="${ categorys }" var="category" varStatus="itemStatus">
						<a href="#" class="list-group-item"><c:out value="${ category.name }"/></a>
					</c:forEach>
            	</div>
            </div>
		</aside>

<!-- 	    友情链接 -->
		<aside class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">友情链接</h3>
			</div>
			<div class="tab-pane" id="friendlink">
            	<div class="list-group">
					<c:forEach items="${ newestLink }" var="link" varStatus="itemStatus">
						<a href="#" class="list-group-item"><c:out value="${ link.name }"/></a>
					</c:forEach>
            	</div>
            </div>
		</aside>
		 
<!-- 		只有首页显示音乐播放器 -->
		<aside class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">放松一下</h3>
			</div>
			<div class="tab-pane" id="friendlink">
            	<div class="list-group">
				<object type="application/x-shockwave-flash" data="<%=request.getContextPath() %>/styles/dewplayer/dewplayer-playlist.swf" width="240" height="200" id="dewplayer" name="dewplayer">
				<param name="wmode" value="transparent"/>
				<param name="movie" value="dewplayer-playlist.swf"/>
				<param name="flashvars" value="showtime=true&autoreplay=true&autostart=false&xml=<%=request.getContextPath() %>/styles/dewplayer/playlist.xml" />
				</object>
            	</div>
            </div>
		</aside>
