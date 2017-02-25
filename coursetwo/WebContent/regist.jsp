<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>注册</title>

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
		function regist(){
			//location.href="index-x.jsp";
			document.registForm.submit();
		}
	
	</script>
</head>
<body class="loginbody">
<div class="dataEye">
	<div class="loginbox registbox">
		<div class="logo-a">
			<a href="login.jsp" title="js代码网">
			    <br><br><br><br>
				<img src="resources/images/logo-a.png">
			</a>
		</div>
		<div class="login-content reg-content">
			<div class="loginbox-title">
				<h3>注册</h3>
			</div>
			<form id="signupForm" name="registForm" action="${ctx }/loginuser/regist" method="post">
			<div class="login-error"></div>
			<div class="row">
				<label class="field" for="loginName">用户名</label>
				<input type="text" class="input-text-user noPic input-click" name="loginName" id="loginName">
			</div>
			<div class="row">
				<label class="field" for="email">注册邮箱</label>
				<input type="text" value="" class="input-text-user noPic input-click" name="email" id="email">
			</div>
			<div class="row">
				<label class="field" for="company">角色id</label>
				<input type="text" value="" class="input-text-user noPic input-click" name="roleid" id="company">
			</div>
			<div class="row">
				<label class="field" for="tel">真实姓名</label>
				<input type="text" value="" class="input-text-user noPic input-click" name="realName" id="tel">
			</div>
			<div class="row">
				<label class="field" for="qq">出生日期</label>
				<input type="text" value="" class="input-text-user noPic input-click" name="birthday" id="qq">
			</div>
			<div class="row">
				<label class="field" for="password">密码</label>
				<input type="password" value="" class="input-text-password noPic input-click" name="password" id="password">
			</div>
			<div class="row">
				<label class="field" for="passwordAgain">确认密码</label>
				<input type="password" value="" class="input-text-password noPic input-click" name="passwordAgain" id="passwordAgain">
			</div>
			
			<div class="row tips">
				<input type="checkbox" id="checkBox">
				<label>
				我已阅读并同意
				<a href="#" target="_blank">隐私政策、服务条款</a>
				</label>
			</div>
			<div class="row btnArea">
				<a class="login-btn" id="submit" onclick="regist()">注册</a>
			</div>
			</form>
		</div>
		<div class="go-regist">
			已有帐号,请<a href="login.jsp" class="link">登录</a>
		</div>
	</div>
	
<div id="footer">
	<div class="dblock">
		<div class="inline-block"><br><img src="resources/images/logo-gray.png"></div>
		<div class="inline-block copyright">
			<p><a href="#">关于我们</a> | <a href="#">微博</a> | <a href="#">隐私政策</a> | <a href="#">人员招聘</a></p>
			<p> Copyright © 2016 TangWenru</p>
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

