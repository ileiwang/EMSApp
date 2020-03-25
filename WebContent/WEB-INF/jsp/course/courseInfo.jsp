<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@	taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>课程统计信息</title>
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
          <ul><li class="item"><a href="${ctx}/course/chooseCourse">选课</a></li></ul>
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
            <li class="nav-community"><a href="${ctx}/course/showAllCourse">课程列表</a></li>
            <li class="nav-community"><a href="${ctx}/course/addCourse?flag=1">添加课程</a></li>
            <li class="nav-community"><a href="${ctx}/course/selectCourse?flag=1">查询课程</a></li>
            <li class="nav-community"><a href="${ctx}/course/courseInfo">选课统计</a></li>
			<li class="nav-community"><a href="${ctx}/course/selectCourseByCollege?flag=1">按学院查询</a></li>
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
<center><h2>课程选课人数统计</h2></center>
	<table class="table table-hover">
	<thead>
	<tr>
	
	<td>编号</td>
	<td>课程号</td>
	<td>课程名</td>
	<td>选课人数</td>
	</tr>
	</thead>
	<tbody>
		<c:forEach items="${requestScope.courseinfo}" var="info" varStatus="stat">
		<tr>
			<td>${info.get("course_id") }</td>
			<td>${info.get("num") }</td>
			<td>${info.get("name") }</td>
			<td>${info.get("cnt") }</td>
		</tr>
	</c:forEach>

	</tbody>
	</table>
	<hr>
<center><h2>学生选课数量统计</h2></center>
	<table class="table table-hover">
	<thead>
	<tr>
	
	<td>编号</td>
	<td>学号</td>
	<td>姓名</td>
	<td>选课数量</td>
	</tr>
	</thead>
	<tbody>
		<c:forEach items="${requestScope.coursecount}" var="info" varStatus="stat">
		<tr>
			<td>${info.get("studentid") }</td>
			<td>${info.get("studentnum") }</td>
			<td>${info.get("studentname") }</td>
			<td>${info.get("coursecount") }</td>
		</tr>
	</c:forEach>

	</tbody>
	</table>
	<hr>
<center><h2>选修3门及以上课程学生统计</h2></center>
	<table class="table table-hover">
	<thead>
	<tr>
	
	<td>编号</td>
	<td>学号</td>
	<td>姓名</td>
	<td>选课数量</td>
	</tr>
	</thead>
	<tbody>
		<c:forEach items="${requestScope.overthree}" var="info" varStatus="stat">
		<tr>
			<td>${info.get("studentid") }</td>
			<td>${info.get("studentnum") }</td>
			<td>${info.get("studentname") }</td>
		</tr>
	</c:forEach>

	</tbody>
	</table>
<hr>
<center><h2>选课人数为30及以上的课程</h2></center>
	<table class="table table-hover">
	<thead>
	<tr>
	<td>编号</td>
	<td>课程号</td>
	<td>名称</td>
	<td>上课时间</td>
	<td>节次</td>
	<td>开始周</td>
	<td>结束周</td>
	<td>学分</td>
	<td>地点</td>
	<td>所属专业</td>
	<td>授课教师</td>
	</tr>
	</thead>
	<tbody>
		<c:forEach items="${requestScope.morethan}" var="course" varStatus="stat">
		<tr>
			<td>${course.id }</td>
			<td>${course.num }</td>
			<td>${course.name }</td>
			<td>周${course.day }</td>
			<td>第${course.coursetime }大节</td>
			<td>第${course.start }周</td>
			<td>第${course.last }周</td>
			<td>${course.credit }</td>
			<td>${course.place }</td>
			<td>${course.major.name }</td>
			<td>${course.teacher.name }</td>
		</tr>
	</c:forEach>

	</tbody>
	</table>
	<hr>
<center><h2>选课人数为30以下的课程</h2></center>
	<table class="table table-hover">
	<thead>
	<tr>
	
	<td>编号</td>
	<td>课程号</td>
	<td>名称</td>
	<td>上课时间</td>
	<td>节次</td>
	<td>开始周</td>
	<td>结束周</td>
	<td>学分</td>
	<td>地点</td>
	<td>所属专业</td>
	<td>授课教师</td>
	</tr>
	</thead>
	<tbody>
		<c:forEach items="${requestScope.lessthan}" var="course" varStatus="stat">
		<tr>
			<td>${course.id }</td>
			<td>${course.num }</td>
			<td>${course.name }</td>
			<td>周${course.day }</td>
			<td>第${course.coursetime }大节</td>
			<td>第${course.start }周</td>
			<td>第${course.last }周</td>
			<td>${course.credit }</td>
			<td>${course.place }</td>
			<td>${course.major.name }</td>
			<td>${course.teacher.name }</td>
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