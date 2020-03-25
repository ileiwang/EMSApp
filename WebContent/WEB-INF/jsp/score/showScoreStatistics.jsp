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
          <ul><li class="item"><a href="${ctx}/score/teacherAddScore">添加成绩</a></li></ul>
          <ul><li class="item"><a href="${ctx}/student/studentList">学生名单</a></li></ul>
          <ul><li class="item"><a href="${ctx}/score/scoreStatistics">成绩统计</a></li></ul>

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
            
        <c:if test="${sessionScope.teacher!=null}">
        <ul class="main-nav">
            <li class="nav-docs"><a href="${ctx}">首页</a></li>
            <li class="nav-community"><a href="${ctx}/score/teacherAddScore">添加成绩</a></li>
            <li class="nav-community"><a href="${ctx}/student/studentList">学生名单</a></li>
            <li class="nav-community"><a href="${ctx}/score/scoreStatistics">成绩统计</a></li>
        </ul>
        </c:if>
        </ul>
    </div>
</nav>
<center><h3>最高分最低分</h3></center>
	<table class="table table-hover">
	<thead>
	<tr>
	<td>最高分</td>
	<td>学号</td>
	<td>姓名</td>
	<td>班级</td>
	</tr>
	</thead>
	<tbody>
		<c:forEach items="${requestScope.maxscoreinfo}" var="info" varStatus="stat">
		<tr>
			<td>${info.get("maxscore") }</td>
			<td>${info.get("studentnum") }</td>
			<td>${info.get("studentname") }</td>
			<td>${info.get("clazzname") }</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
	<br>
	<table class="table table-hover">
	<thead>
	<tr>
	<td>最低分</td>
	<td>学号</td>
	<td>姓名</td>
	<td>班级</td>
	</tr>
	</thead>
	<tbody>
		<c:forEach items="${requestScope.minscoreinfo}" var="info" varStatus="stat">
		<tr>
			<td>${info.get("minscore") }</td>
			<td>${info.get("studentnum") }</td>
			<td>${info.get("studentname") }</td>
			<td>${info.get("clazzname") }</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
<center><h3>平均分及其他</h3></center>
	<table class="table table-hover">
	<thead>
	<tr>
	<td>平均分</td>
	<td>平均分以上人数</td>
	<td>平均分以下人数</td>
	<td>通过人数</td>
	<td>挂科人数</td>
	</tr>
	</thead>
	<tbody>
		<tr>
			<td>${avgscore.get("avgscore") }</td>
			<td>${upavgscorecount.get("upavgscorecount") }</td>
			<td>${downavgscorecount.get("downavgscorecount") }</td>
			<td>${passcount.get("passcount") }</td>
			<td>${failcount.get("failcount") }</td>
		</tr>
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