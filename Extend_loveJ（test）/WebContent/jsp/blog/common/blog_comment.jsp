<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

    <div id="comments">
    	<div id="response">
    		<h3>来了就留个言吧<small><span class="badge">几个评论</span></small></h3>
    		<form action="" id="commentForm" name="commentForm"  role="form">
    			<div class="input-group">
    				<p></p>
    				<p></p>
    				<span class="input-group-addon">
    					<span class="glyphicon glyphicon-user">
    						
    					</span>
    				</span>
    				<input type="text" name="author" id="author" class="input-control" placeholder="姓名 必填">
    			</div>
    			<div class="input-group">
    				<p></p>
    				<p></p>
    				<span class="input-group-addon">
    					<span class="glyphicon glyphicon-envelope">
    						
    					</span>
    				</span>
    				<input type="text" name="email" id="email" class="input-control" placeholder="邮件 必填">
    			</div>
    			<div class="input-group">
    				<p></p>
    				<p></p>
    				<span class="input-group-addon">
    					<span class="glyphicon glyphicon-globe">
    						
    					</span>
    				</span>
    				<input type="text" name="website" id="website" class="input-control" placeholder="网站">
    			</div>
    			<div class="input-group">
    				<p></p>
    				<p></p>
    				<span class="input-group-addon">
    					<span class="glyphicon glyphicon-comment">
    						
    					</span>
    				</span>
    				<textarea name="comment" id="comment" rows="5" cols="" class="form-control"></textarea>
    			</div>
    			<hr>
    			<button type="submit" id="submit" name="submit" class="btn btn-primary pull-right">
    				提交&ensp;<span class="glyphicon glyphicon-send"></span>
    			</button>			
    		</form>
    	</div>
    	
    	<!--     		这里就循环的输出该页面下所有的评论即可 -->
    	<div name="comment-12" id="comment-12" class="">
    		<div class="media">
	    		<a href="#" class="pull-left" rel="nofollow">
	    			<img id="" class="img-thumbnail avatar-64 photo grav-hashed grav-hijack" height="64" width="64">
	    		</a>
	    		<div class="mediabody">
	    			<h5 class="mediaheadding">
	    				<a href="#">评论者一</a>
	    				<small>2014年6月14日</small>
	    			</h5>
	    			<div class="well well-sm">
	    				<p>这里是评论的内容</p>
	    			</div>
	    		</div>
	    	</div>
    	</div>
    </div>