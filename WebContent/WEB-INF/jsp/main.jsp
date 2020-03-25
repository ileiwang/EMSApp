<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>教务管理系统</title>
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
          <ul><li class="item"><a href="${ctx}/score/scoreList">成绩列表</a></li></ul>
          <ul><li class="item"><a href="${ctx}/score/scoreStatistics">成绩统计</a></li></ul>

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
        
		<c:if test="${sessionScope.student!=null}">
        <ul class="main-nav">
            <li class="nav-docs"><a href="${ctx}">首页</a></li>
            <li class="nav-community"><a href="${ctx}/score/selectScore">成绩查询</a></li>
            <li class="nav-community"><a href="${ctx}/course/courseTable">课程表</a></li>
            <li class="nav-community"><a href="${ctx}/course/chooseCourse?flag=1">选课</a></li>
        </ul>
       </c:if>
        
        
       <c:if test="${sessionScope.teacher!=null}">
        <ul class="main-nav">
            <li class="nav-docs"><a href="${ctx}">首页</a></li>
            <li class="nav-community"><a href="${ctx}/score/teacherAddScore">添加成绩</a></li>
            <li class="nav-community"><a href="${ctx}/student/studentList">学生名单</a></li>
            <li class="nav-community"><a href="${ctx}/score/scoreStatistics">成绩统计</a></li>
        </ul>
        </c:if>
        
        <c:if test="${sessionScope.admin!=null}">
        <ul class="main-nav">
            <li class="nav-community"><a href="${ctx}/studentmgmt">学生管理</a></li>
            <li class="nav-community"><a href="${ctx}/teachermgmt">教师管理</a></li>
            <li class="nav-community"><a href="${ctx}/coursemgmt">课程管理</a></li>
            <li class="nav-community"><a href="${ctx}/noticemgmt">公告管理</a></li>
            <li class="nav-community"><a href="${ctx}/collegemgmt">学院管理</a></li>
            <li class="nav-community"><a href="${ctx}/majormgmt">专业管理</a></li>
            <li class="nav-community"><a href="${ctx}/clazzmgmt">班级管理</a></li>
            <li class="nav-community"><a href="${ctx}/scoremgmt">成绩管理</a></li>
        </ul>
        </c:if>
    </div>
</nav>
<div class="docs-wrapper container">
    <article>
        <div class="section">

            <div class="ibklist">
                <h2>
                    <span class="">最新公告</span>
                    <span class="link-more"><a href="${ctx}">更多&gt;&gt;</a></span>
                </h2>
                <ul class="list-col">

                <c:forEach items="${sessionScope.books}" var="book" varStatus="stat" begin="0" end="17" step="1">
                    <li class="">
                        <div class="cover">
                            <a href="${ctx}/showbookdetail?id=${book.id}" target="_blank" title="${book.name}">
                            <img src="${ctx }/images/${book.coverfilename}" class="" alt="${book.name}" height="158px" width="106px">
                            </a>
                        </div>
                        <div class="">
                            <div class="title"><a class="" href="${ctx}/showbookdetail?id=${book.id}" target="_blank" title="${book.name}">${book.name}</a></div>
                            <div class="author">${book.author}</div>
                        </div>
                    </li>
                </c:forEach>

                </ul>
            </div>
            </div>
        </article>
	 <section class="sidebar">
	     <div class="blank5"></div>
	     <div class="fenlei">
	         <h2>导航栏</h2>
	         <ul class="unstyled">
	         <c:forEach items="${sessionScope.categorys}" var="category" varStatus="stat" begin="0" end="20" step="1">
	         <li><a href="${ctx}/showbooksbycategoryid?category_id=${category.id}"> ${category.name} </a></li>
	     	</c:forEach>
	                 </ul>
	             </div>
	 </section>
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