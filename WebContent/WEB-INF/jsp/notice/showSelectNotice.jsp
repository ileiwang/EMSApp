<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查询公告</title>
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
            <li class="nav-community"><a href="${ctx}/notice/showAllNotice">公告列表</a></li>
            <li class="nav-community"><a href="${ctx}/notice/addNotice?flag=1">添加公告</a></li>
            <li class="nav-community"><a href="${ctx}/notice/selectNotice?flag=1">查询公告</a></li>
        </ul>
        </c:if>
    </div>
</nav>

<div id="yds_screen">
    <div id="yds_content" class="clearfix">

<div class="spaceList adminbody">
    <div class="adminhead">
        <h1>查询公告</h1>
    </div>
    <div class="admincontent mainform">
        <form name="form" class="form-horizontal" method="post" action="${ctx}/notice/selectNotice">
        
            <input type="hidden" name="flag" value="2">
            
            <div class="">
            	<span>标题：</span>
            	<span>
             		<input class="form-control" style="width:300px;" name="title" maxlength="128" value="" type="text">
             	</span>
            </div>
            
        
            <div class="">
                <span>内容：</span>
                <span>
                    <textarea rows="5" class="form-control" style="width:300px;" name="content"  type="text"></textarea>
                </span>
            </div>
            
           
            
            <div class="">
                <span>发布人：</span>
                <span>
                    <select  name="admin_id" class="form-control" style="width:300px;" maxlength="128">
						   <option value="">选择发布人</option>
						   <c:forEach items="${requestScope.admins }" var="admin">
			    			<option value="${admin.id }">${admin.name }</option>
			    			</c:forEach>
					</select>
                </span>
            </div>

            


            <div class="bton"><span class="ms"></span><button type="submit" id="saveprofile" class="btn btn-success">查询</button></div>
        </form>
    </div>
</div>
</div>
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