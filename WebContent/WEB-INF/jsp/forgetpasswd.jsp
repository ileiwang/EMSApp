<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>忘记密码</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="author" content="教务管理系统">
    <meta name="description" content="教务管理系统">
    <meta name="keywords" content="教务管理系统">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ctx}/css/yds.css">
    <link rel="stylesheet" href="${ctx}/css/ucenter.css">
    <script src="${ctx}/js/jquery-1.11.3.min.js"></script>
    <script src="${ctx}/js/bootstrap.min.js"></script>

</head>
<body class="docs">
    <div id="navtop">
        <div class="wp1080">
            <div class="yds_channels">
            </div>
            <div class="yds_userbar">
                [ <a href="${ctx}/loginForm">登录</a> | <a href="${ctx}/register?flag=1">注册</a> ]
            </div>
        </div>
    </div>
    <nav class="main">
        <div class="container">
            <a href="${ctx}" class="brand">教务管理系统</a>

		<c:if test="${sessionScope.student!=null}">
        <ul class="main-nav">
            <li class="nav-docs"><a href="${ctx}">首页</a></li>
            <li class="nav-community"><a href="${ctx}/showbooks">书库</a></li>
            <li class="nav-community"><a href="${ctx}/showremarks">书评</a></li>
            <li class="nav-community"><a href="${ctx}/showwishbook">想读</a></li>
        </ul>
        </c:if>
        
        <c:if test="${sessionScope.admin!=null}">
        <ul class="main-nav">
            <li class="nav-community"><a href="${ctx}/bookmgmt">图书</a></li>
            <li class="nav-community"><a href="${ctx}/remarkmgmt">书评</a></li>
            <li class="nav-community"><a href="${ctx}/usermgmt">用户</a></li>
            <li class="nav-community"><a href="${ctx}/borrowmgmt">借阅</a></li>
            <li class="nav-community"><a href="${ctx}/categorymgmt">分类</a></li>
        </ul>
        </c:if>
        </div>
    </nav>
    <div class="docs-wrapper container">
        <center><h3>请填写账号和姓名信息</h3></center>
        <form id="findpasswd" name="findpasswd" action="${ctx}/findpasswd" method="post">
            <div class="mc">
                <div class="m-ipt">
                    <div class="u-ipt">
                        <div class="iptctn">
                            <input class="form-control" placeholder="学号" name="num" id="num" value="" type="text">
                        </div>
                    </div>
                </div>
                <br>
                <div class="m-ipt">
                    <div class="u-ipt">
                        <div class="iptctn">
                            <input class="form-control" placeholder="姓名" name="name" id="name" value="" type="text">
                        </div>
                    </div>
                </div>
                <br>
                <div class="m-ipt">
                    <div class="u-ipt">
                        <div class="iptctn">
                            <input class="form-control" placeholder="手机号" name="tel" id="tel" value="" type="text">
                        </div>
                    </div>
                </div>
                <br>
                <button style="float:right" type="submit" class="btn btn-success btn-lg">查找</button>
            </div>
        </form>
    </div>

<footer class="main">
  <ul>
    <li class="nav-docs"><a href="${ctx}/about" target="_blank">关于本系统</a></li>
  </ul>
  <p class="less-significant"><a href="${ctx}" target="_blank">教务管理系统</a></p>
  <p class="beianaa">Copyright(C) 2018 All Rights Reserved 版权所有</p>
</footer>
</body>
</html>