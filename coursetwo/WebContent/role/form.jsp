<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!doctype html>
<html lang="en"><head>
    <meta charset="utf-8">
    <title>产品管理系统</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="${ctx}/lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="${ctx}/lib/font-awesome/css/font-awesome.css">

    <script src="${ctx}/lib/jquery-1.11.1.min.js" type="text/javascript"></script>

    

    <link rel="stylesheet" type="text/css" href="${ctx}/stylesheets/theme.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/stylesheets/premium.css">

</head>
<body class=" theme-blue">

    <!-- Demo page code -->

    <script type="text/javascript">
        $(function() {
            var match = document.cookie.match(new RegExp('color=([^;]+)'));
            if(match) var color = match[1];
            if(color) {
                $('body').removeClass(function (index, css) {
                    return (css.match (/\btheme-\S+/g) || []).join(' ')
                })
                $('body').addClass('theme-' + color);
            }

            $('[data-popover="true"]').popover({html: true});
            
        });
    </script>
    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .navbar-default .navbar-brand, .navbar-default .navbar-brand:hover { 
            color: #fff;
        }
    </style>

    <script type="text/javascript">
        $(function() {
            var uls = $('.sidebar-nav > ul > *').clone();
            uls.addClass('visible-xs');
            $('#main-menu').append(uls.clone());
        });
    </script>

    <link rel="shortcut icon" href="../assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${ctx}/../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${ctx}/../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${ctx}/../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="${ctx}/../assets/ico/apple-touch-icon-57-precomposed.png">
  

 

    <div class="navbar navbar-default" role="navigation">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="" href="${ctx}/product/main.jsp"><span class="navbar-brand"><span class="fa fa-paper-plane"></span>&nbsp;&nbsp;产 品 管 理 系 统</span></a></div>

        <div class="navbar-collapse collapse" style="height: 1px;">
          <ul id="main-menu" class="nav navbar-nav navbar-right">
            <li class="dropdown hidden-xs">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <span class="glyphicon glyphicon-user padding-right-small" style="position:relative;top: 3px;"></span>${realName }&nbsp;:&nbsp;${name}
                    <i class="fa fa-caret-down"></i>
                </a>

              <ul class="dropdown-menu">
                  <li><a tabindex="-1" href="${ctx }/userinfo/edit?loginName=${name}">修改个人信息</a></li>
                <li><a tabindex="-1" href="${ctx}/login.jsp">注销</a></li>
              </ul>
            </li>
          </ul>

        </div>
      </div>
    </div>
    

   
   <div class="sidebar-nav">
    <ul>
    <c:forEach items="${menus }" var="ms">
     <li><a href="#" data-target=".dashboard-menu" class="nav-header" data-toggle="collapse"><i class="fa fa-fw fa-dashboard"></i> ${ms.key.name }<i class="fa fa-collapse"></i></a></li>
     <li><ul class="dashboard-menu nav nav-list collapse in">
          <c:forEach items="${ms.value }" var="menu">
           <li><a href="${menu.url}"><span class="fa fa-caret-right"></span>${menu.name }</a></li>
          </c:forEach>
    </ul></li>
    </c:forEach>
    
            </ul>
    </div>

    <div class="content">
        <div class="header">
            
           <c:if test="${action=='edit' }">
			<h1 class="page-title">修改角色</h1>
                    <ul class="breadcrumb">
            <li><a href="${ctx }/main.jsp">首页</a> </li>
            <li class="active">修改角色</li>
			</c:if>
			<c:if test="${action!='edit' }">
			<h1 class="page-title">新增角色</h1>
                    <ul class="breadcrumb">
            <li><a href="${ctx }/main.jsp">首页</a> </li>
            <li class="active">新增角色</li>
			</c:if>
        </ul>

        </div>
       
 <div class="main-content">
            
<div class="btn-toolbar list-toolbar">
    	<c:if test="${action=='edit' }">
			<form action="${ctx }/role/edit" method="post">
			</c:if>
			<c:if test="${action!='edit' }">
			<form action="${ctx }/role/add" method="post">
			</c:if>
				<input type="hidden" name="roleId" value="${r.roleId }" />
				角色名称：<input type="text" name="name" value="${r.name}" /><br><br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button class="btn btn-default">提&nbsp;交</button><br><br><!-- <input type="submit" value="提交" /> -->
			</form>
			
   
  <div class="btn-group">
  </div>
</div>


            <footer>
                <hr>

                <!-- Purchase a site license to remove this link from the footer: http://www.portnine.com/bootstrap-themes -->
                <p class="pull-right"><a href="http://www.portnine.com/bootstrap-themes" target="_blank">Made</a> by <a href="http://www.portnine.com" target="_blank">TangWenru 2014011771</a></p>
                <p>© 2016 <a href="http://www.portnine.com" target="_blank">Product Manager System</a></p>
            </footer>
        </div>
    </div>


    <script src="${ctx}/lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
    
  
</body></html>
