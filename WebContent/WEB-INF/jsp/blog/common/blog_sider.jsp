<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--   	 搜索栏 -->
	    <div class="gadget sidebar-module">
		    <h2 class="star">
				<form action="" method="post" id="formID">
					<table border="0" cellpadding="0" cellspacing="0" class="tab_search">
						<tr>
							<td>
								<input type="text" name="q" class="searchinput" id="searchinput" size="20"/>
							</td>
							<td>
								<input type="image" width="21px" height="17px" class="searchaction"  src="<%=request.getContextPath() %>/styles/blog/images/search_btn_side.gif" border="0" hspace="2"/>
							</td>
						</tr>
					</table>
				</form>
			</h2>
	    </div>  
	    
<!-- 	   最新文章 -->
	    <div class="gadget sidebar-module">
	      <h2 class="star"><span>最新日志</span></h2><div class="clr"></div>
	      <ul class="sb_menu">
<!-- 	      	<#list newestArticles as c> -->
<!-- 				<li><#if c.topTime??><font style="color:red;">[<@s.message code="form.top"/>]</font></#if> -->
<%-- 					<a href="<@s.url relativeUrl="/blog/view/${c.id}"/>"> --%>
<!-- 						<#--expression?something    这个 something 一般为一个函数，--> -->
<%-- 						<#if c.title?length gt 40>${c.title?substring(0,40)}...<#else>${c.title}</#if> --%>
<!-- 					</a> -->
<!-- 				</li> -->
<!-- 			</#list> -->
	      </ul>
	    </div>
	    
<!-- 	   最新评论 -->
	    <div class="gadget sidebar-module">
<!-- 	      <h2 class="star"><span><@s.message code="blog.newest.comment"/></span></h2><div class="clr"></div> -->
	      <ul class="sb_menu">
<!-- 	      	<#list newestComments as c> -->
<!-- 				<li> -->
<%-- 					<a href="<@s.url relativeUrl="/blog/view/${c.articleId}#cmts"/>"> --%>
<%-- 						<#if c.content?length gt 40>${c.content?substring(0,40)}...<#else>${c.content}</#if> --%>
<!-- 					</a> -->
<!-- 				</li> -->
<!-- 			</#list> -->
	      </ul>
	    </div>
 		
<!--  		文章分类-->
	    <div class="gadget sidebar-module">
<!-- 	      <h2 class="star"><span><@s.message code="blog.category"/></span></h2><div class="clr"></div> -->
	      <ul class="sb_menu">
<!-- 	      	<#list categories as c> -->

			<!--循环的输出分类名 -->
			<c:forEach var="c" items="categories">
			
			</c:forEach>
<!-- 			</#list> -->
	      </ul>
	    </div>
	    
<!-- 	    友情链接 -->
	    <div class="gadget sidebar-module">
 	      <h2 class="star"><span> 友情链接  </span></h2><div class="clr"></div> 
	      <ul class="sb_menu">
<!-- 	      	<#list newestLinks as c> -->
				<li>s
 					<a href="${c.site}">
<%-- 						<#if c.name?length gt 20>${c.name?substring(0,20)}<#else>${c.name}</#if> --%>
					</a>
				</li>
<!-- 			</#list> -->
	      </ul>
	    </div>   
		 
<!-- 		只有首页显示音乐播放器 -->
<!-- 		 <#if title==index0 > -->
		    <div class="gadget sidebar-module">
				<object type="application/x-shockwave-flash" data="<%=request.getContextPath() %>/styles/dewplayer/dewplayer-playlist.swf" width="240" height="200" id="dewplayer" name="dewplayer">
				<param name="wmode" value="transparent"/>
				<param name="movie" value="dewplayer-playlist.swf"/>
				<param name="flashvars" value="showtime=true&autoreplay=true&autostart=false&xml=<%=request.getContextPath() %>/styles/dewplayer/playlist.xml" />
				</object>
		    </div>    
<!-- 		 </#if> -->
