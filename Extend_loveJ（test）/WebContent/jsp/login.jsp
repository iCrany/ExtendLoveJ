<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>

<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap-theme.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/mycss.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/carousel.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>

<script type="text/javascript">
	function randomNumAjax(){
		
		var randomNum = document.getElementById("randomNum").value;
		var inputResult = document.getElementById("inputResult").value;
		if(randomNum == null || randomNum == "") return 0;
		
		$.ajax({
			   type: "POST",
			   url: "<%=request.getContextPath()%>/randomNumAjax",
			   data: "randomNum="+randomNum,
			   success: function(msg){
				   if(msg == "true"){
					   document.getElementById("randomNumIsWrong").color = "green";
					   inputResult = "1";
					   document.getElementById("inputResult").setAttribute("value", inputResult);
					   document.getElementById("randomNumIsWrong").innerHTML="验证码正确";
					   
				   }
				   else{
					   document.getElementById("randomNumIsWrong").color = "red";
					   inputResult = "-1";
					   document.getElementById("inputResult").setAttribute("value", inputResult);
					   document.getElementById("randomNumIsWrong").innerHTML="验证码出错";
					   
				   } 
			   },
			  error: function(msg){
				  alert("randomNum 出错了");
			  }
			});
	}
	
	
	function adminLogin(){
		
		var username = document.getElementById("username").value;
		var password = document.getElementById("password").value;
		var inputResult = document.getElementById("inputResult").value;
		
		if(username==null || username == "" || password == "" || password==null){
			alert("用户名或密码为空,请输入!");
		}
		else if(inputResult != 1){
			alert("验证码错误，请重新输入!");
		}else{
			document.forms.loginForm.action = "<%=request.getContextPath()%>/jsp/login";
			document.forms.loginForm.submit();
		}
	}
	
	function lookerLogin(){
			document.forms.loginForm.action = "register.jsp";
			document.forms.loginForm.submit();
	}
</script>
</head>

<body>
	<div class="container">
		<center>
			<p>${userNameOrPasswordNotExits}</p>
			<form action="" name="loginForm" method="post" class="form-login form-horizontal" role="form">
				<h3 class="form-signin-heading">用户登录</h3>
				<div class="form-group">
					<label for="username" class="col-md-2 col-md-offset-3 control-label">帐号：</label>
					<div class="col-sm-2">
						<input type="text" class="form-control" id="username" name="username" placeholder="username">
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="col-md-2 col-md-offset-3 control-label">密码：</label>
					<div class="col-sm-2">
						<input type="password" class="form-control" id="password" name="password" placeholder="password">
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="col-md-2 col-md-offset-3 control-label">验证码:</label>
					<div class="col-sm-2">
						<input type="text" id="randomNum" name="randomNum" class="form-control" onblur="javascript:randomNumAjax()">
					</div>
					<div class="col-sm-1">
						<img src="${pageContext.request.contextPath}/randomNum" class="img-rounded" height="30" ></img>
					</div>
					<div class="col-sm-2">
<!-- 						-1: wrong , 0: not input , 1: true 默认为 0-->
						<input type="hidden" id="inputResult" value="0">
						<span><font id="randomNumIsWrong"></font></span>
					</div>
				</div>
			  <div class="form-group">
			    <div class="col-sm-offset-1 col-sm-8">
			      <div class="checkbox">
			        <label>
			          <input type="checkbox" name="isRemember" value="true">记住我
			        </label>
			      </div>
			    </div>
			  </div>
				<input type="submit" class="btn btn-large btn-primary" value="登录" onclick="adminLogin()">
				<input type="submit" class="btn btn-large btn-primary" value="注册" onclick="lookerLogin()">
			</form>
		</center>
	</div>
</body>
</html>