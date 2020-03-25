<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@	taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>学生列表</title>
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
       <!-- 教师显示 -->
        <c:if test="${sessionScope.teacher!=null}">
          <ul><li class="item"><a href="${ctx}">首页</a></li></ul>
          <ul><li class="item"><a href="${ctx}/score/teacherAddScore">添加成绩</a></li></ul>
          <ul><li class="item"><a href="${ctx}/student/studentList">学生名单</a></li></ul>

        </c:if>        
        <!--管理员显示  -->
        <c:if test="${sessionScope.admin!=null}">
          <ul><li class="item"><a href="${ctx}">首页</a></li></ul>
          <ul><li class="item"><a href="${ctx}/studentmgmt">学生管理</a></li></ul>
          <ul><li class="item"><a href="${ctx}/teachermgmt">教师管理</a></li></ul>
          <ul><li class="item"><a href="${ctx}/coursemgmt">课程管理</a></li></ul>
          <ul><li class="item"><a href="${ctx}/noticemgmt">公告管理</a></li></ul>
          <ul><li class="item"><a href="${ctx}/collegemgmt">学院管理</a></li></ul>
          <ul><li class="item"><a href="${ctx}/majormgmt">专业管理</a></li></ul>
          <ul><li class="item"><a href="${ctx}/clazzmgmt">班级管理</a></li></ul>
          <ul><li class="item"><a href="${ctx}/scoremgmt">成绩管理</a></li></ul>
        </c:if>
      </div>
      <div class="yds_userbar">
      
[ <a href="${ctx}/logoff">退出</a> ]
    </div>
</div>
</div>
<nav class="main">
    <div class="container">
        <a href="${ctx}" class="brand">教务管理系统</a>
        <c:if test="${sessionScope.admin!=null}">
        <ul class="main-nav">
            <li class="nav-docs"><a href="${ctx}">首页</a></li>
            <li class="nav-community"><a href="${ctx}/score/showAllScore">成绩列表</a></li>
            <li class="nav-community"><a href="${ctx}/score/addScore?flag=1">添加成绩</a></li>
            <li class="nav-community"><a href="${ctx}/score/selectScore?flag=1">查询成绩</a></li>
        </ul>
        </c:if>
        
               <c:if test="${sessionScope.teacher!=null}">
        <ul class="main-nav">
            <li class="nav-docs"><a href="${ctx}">首页</a></li>
            <li class="nav-community"><a href="${ctx}/score/teacherAddScore">添加成绩</a></li>
            <li class="nav-community"><a href="${ctx}/student/studentList">学生名单</a></li>
        </ul>
        </c:if>
    </div>
</nav>
	<table class="table table-hover">
	<thead>
	<tr>
	<td>编号</td>
	<td>学号</td>
	<td>姓名</td>
	<td>身份证号</td>
	<td>性别</td>
	<td>Tel</td>
	<td>QQ</td>
	<td>邮箱</td>
	<td>地址</td>
	<td>班级</td>
	</tr>
	</thead>
	<tbody>
		<c:forEach items="${requestScope.students}" var="student" varStatus="stat">
		<tr>
			<td>${student.id }</td>
			<td>${student.num }</td>
			<td>${student.name }</td>
<%-- 			<td>${student.birthday }</td> --%>
			<td>${student.idcard }</td>
			<td>${student.sex }</td>
			<td>${student.tel }</td>
			<td>${student.qq }</td>
			<td>${student.email }</td>
			<td>${student.address }</td>
			<td>${student.clazz.name }</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>



<footer class="main">
    <ul>
        <li class="nav-docs"><a href="${ctx}/about" target="_blank">关于本系统</a></li>
    </ul>
    <p class="less-significant"><a href="${ctx}" target="_blank">教务管理系统</a></p>
    <p class="beianaa">Copyright(C) 2018 All Rights Reserved 版权所有</p>
</footer>
</body>
</html>