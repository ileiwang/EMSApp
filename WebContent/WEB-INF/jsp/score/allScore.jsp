<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@	taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>成绩列表</title>
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
        <!-- 学生显示 -->
        <c:if test="${sessionScope.student!=null}">
          <ul><li class="item"><a href="${ctx}">首页</a></li></ul>
          <ul><li class="item"><a href="${ctx}/score/selectScore">成绩查询</a></li></ul>
          <ul><li class="item"><a href="${ctx}/course/courseTable">课程表</a></li></ul>
          <ul><li class="item"><a href="${ctx}/course/chooseCourse?flag=1">选课</a></li></ul>
        </c:if>
        
        
         <!-- 教师显示 -->
        <c:if test="${sessionScope.teacher!=null}">
          <ul><li class="item"><a href="${ctx}">首页</a></li></ul>
          <ul><li class="item"><a href="${ctx}/score/addScore">添加成绩</a></li></ul>
          <ul><li class="item"><a href="${ctx}/student/studentList">学生名单</a></li></ul>

        </c:if>
        
        <!--管理员显示  -->
        <c:if test="${sessionScope.admin!=null}">
          <ul><li class="item"><a href="${ctx}">首页</a></li></ul>
          <ul><li class="item"><a href="${ctx}/studentmgmt">学生管理</a></li></ul>
          <ul><li class="item"><a href="${ctx}/teachermgmt">教师管理</a></li></ul>
          <ul><li class="item"><a href="${ctx}/coursemgmt">课程管理</a></li></ul>
          <ul><li class="item"><a href="${ctx}/scoremgmt">公告管理</a></li></ul>
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
        <ul class="main-nav nav-pills">
         <c:if test="${sessionScope.admin!=null}">
            <li class="nav-docs"><a href="${ctx}">首页</a></li>
            <li class="nav-community"><a href="${ctx}/score/showAllScore">成绩列表</a></li>
            <li class="nav-community"><a href="${ctx}/score/addScore?flag=1">添加成绩</a></li>
            <li class="nav-community"><a href="${ctx}/score/selectScore?flag=1">查询成绩</a></li>
            </c:if>
            
			<c:if test="${sessionScope.student!=null}">
                <li class="nav-community"><a href="${ctx}/score/showAvgScore">平均成绩</a></li>
                <li class="nav-community"><a href="${ctx}/score/showMaxScore">最高成绩</a></li>
            	<li class="nav-community"><a href="${ctx}/score/showMinScore">最低成绩</a></li>
            	<li class="nav-community"><a href="${ctx}/score/showGetCredit">已获学分</a></li>
            	<li class="nav-community"><a href="${ctx}/score/showPassScore">已过成绩</a></li>
            	<li class="nav-community"><a href="${ctx}/score/showFailScore">挂科成绩</a></li>
            </c:if>
        </ul>
    </div>
</nav>
	<table class="table table-hover">
	<thead>
	<tr>
	<td>编号</td>
	<td>课程名</td>
	<td>学生</td>
	<td>成绩</td>
	<c:if test="${sessionScope.admin!=null}">
	<td>修改</td>
	<td>删除</td>
	</c:if>
	</tr>
	</thead>
	<tbody>
		<c:forEach items="${requestScope.scores}" var="score" varStatus="stat">
		<tr>
			<td>${score.id }</td>
			<td>${score.course.name }</td>
			<td>${score.student.name }</td>
			<td>${score.score }</td>
			<c:if test="${sessionScope.admin!=null}">
			<td><a href="${ctx}/score/updateScore?id=${score.id}&flag=1"><button type="button" class="btn btn-success">修改</button></a></td>
 			<td><a href="${ctx}/score/deleteScore?id=${score.id}"><button type="button" class="btn btn-danger">删除</button></a></td>
			</c:if>
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