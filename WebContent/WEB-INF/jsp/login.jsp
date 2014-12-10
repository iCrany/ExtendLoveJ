<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>

<link href="styles/common/bootstrap.css" rel="stylesheet">
<link href="styles/common/bootstrap-theme.css" rel="stylesheet">
<link href="styles/common/mycss.css" rel="stylesheet">

<script type="text/javascript">
	function adminLogin(){
		var username = document.getElementById("username").value;
		var password = document.getElementById("password").value;
		if(username==null || password==null){
			alter("用户名或密码为空,请输入");
		}
		else{
			document.getElementById("type").value = 1;
			document.forms.loginForm.action = "checkuser";//一个servlet 用户检验用户的正确性
			document.forms.loginForm.submit();
		}
	}
	
	function lookerLogin(){
			document.getElementById("type").value = 2;
			document.forms.loginForm.action = "main.jsp";
			document.forms.loginForm.submit();
	}
</script>

</head>
<body>
	<div class="container">
		<center>
			<p color="red">${userNameOrPasswordNotExits}</p>
			<form action="" name="loginForm" method="post" class="form-signin">
				<h3 class="form-signin-heading">管理员登录</h3>
				<p>帐号：<input type="text" class="input-block-level" name="username" id="username" placeholder="username"></p>
				<p>密码：<input type="password" class="input-block-level"  name="password" id="password" placeholder="password"></p>
				<input type="submit" class="btn btn-large btn-primary" value="登录" onclick="adminLogin()">
				<input type="submit" class="btn btn-large btn-primary" value="游客登录" onclick="lookerLogin()">
			</form>
		</center>
	</div>
</body>
</html>