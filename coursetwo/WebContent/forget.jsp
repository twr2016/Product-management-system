<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
<meta name="keywords" content="注册页面模板,网站注册页面,注册模板页面,网站模板,注册页面表单验证">
<meta name="description" content="JS代码网提供大量的注册页面模板的学习和下载">
<link rel="shortcut icon" href="resources/images/favicon.ico" />
<link href="resources/style/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="resources/js/jquery.js"></script>
<script type="text/javascript" src="resources/js/jquery.i18n.properties-1.0.9.js" ></script>
<script type="text/javascript" src="resources/js/jquery-ui-1.10.3.custom.js"></script>
<script type="text/javascript" src="resources/js/jquery.validate.js"></script>
<script type="text/javascript" src="resources/js/md5.js"></script>
<script type="text/javascript" src="resources/js/page_regist.js?lang=zh"></script>
<!--[if IE]>
  <script src="resources/js/html5.js"></script>
<![endif]-->
<!--[if lte IE 6]>
	<script src="resources/js/DD_belatedPNG_0.0.8a-min.js" language="javascript"></script>
	<script>
	  DD_belatedPNG.fix('div,li,a,h3,span,img,.png_bg,ul,input,dd,dt');
	</script>
<![endif]-->
<script type="text/javascript">
		function forget(){
			//location.href="index-x.jsp";
			document.forgetForm.submit();
		}
	
	</script>
</head>
<body class="loginbody">
<div class="dataEye">
	<div class="loginbox">
		<div class="logo-a">
			<a href="http://www.js-css.cn" title="js代码网">
			    <br><br><br><br>
				<img src="resources/images/logo-a.png">
			</a>
		</div>
		<div class="login-content">
			<div class="loginbox-title">
				<h3>修改密码</h3>
			</div>
			
			<form id="signupForm" name="forgetForm" action="${ctx }/loginuser/edito" method="post">
			<div class="login-error"></div>
			<div class="row">
				用户名：
				<input type="text" value="${l.loginName }" class="input-text-user noPic input-click" name="loginName" id="loginName">
			</div>
			<div class="row">
			    注册邮箱：
				<input type="text" value="${l.email }" class="input-text-user noPic input-click" name="email" id="email">
			</div>
			<div class="row">
				新密码：
				<input type="password" value="${l.password }" class="input-text-password noPic input-click" name="password" id="password">
			</div>
			<div class="row">
				确认密码：
				<input type="password" value="" class="input-text-password noPic input-click" name="passwordAgain" id="passwordAgain">
			</div>
			<br>
				<div class="login-error"></div>
			<div class="row btnArea">
				<a class="login-btn" id="submit" onclick="forget()">确定</a>
			</div>
			
			</form>
		</div>
		<div class="go-regist">
			还没有账号？请
			<a href="regist.jsp">立即注册</a>
		</div>
	</div>
	
<div id="footer">
	<div class="dblock">
		<div class="inline-block"><br><img src="resources/images/logo-gray.png"></div>
		<div class="inline-block copyright">
			<p><a href="#">关于我们</a> | <a href="#">微博</a> | <a href="#">隐私政策</a> | <a href="#">人员招聘</a></p>
			<p> Copyright © 2013 JS代码网</p>
		</div>
	</div>
</div>
</div>
<div class="loading">
	<div class="mask">
		<div class="loading-img">
		<img src="resources/images/loading.gif" width="31" height="31">
		</div>
	</div>
</div>
</body>
</html>