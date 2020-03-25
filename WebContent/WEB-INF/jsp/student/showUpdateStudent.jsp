<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>编辑学生</title>
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
            <li class="nav-community"><a href="${ctx}/student/showAllStudent">学生列表</a></li>
            <li class="nav-community"><a href="${ctx}/student/addStudent?flag=1">添加学生</a></li>
            <li class="nav-community"><a href="${ctx}/student/selectStudent?flag=1">查询学生</a></li>
			<li class="nav-community"><a href="${ctx}/student/selectStudentByCollege?flag=1">按学院查询学生</a></li>
			<li class="nav-community"><a href="${ctx}/student/selectStudentByMajor?flag=1">按专业查询学生</a></li>
        </ul>
        </c:if>
    </div>
</nav>

<div id="yds_screen">
    <div id="yds_content" class="clearfix">


<div class="spaceList adminbody">
    <div class="adminhead">
        <h1>修改学生资料</h1>
    </div>
    <div class="admincontent mainform">
        <form name="form" class="form-horizontal" method="post" action="${ctx}/student/updateStudent">
            
            
            <input type="hidden" name="flag" value="2">
			<input type="hidden" name="id" value="${student.id }">
            <div class=""><span>编号：</span><span>${requestScope.student.id}</span>
            </div>
            
            <div class=""><span>学号：</span><span>${requestScope.student.num}</span>
            </div>
            
            
          	<input class="form-control" style="width:300px;" name="id" maxlength="128" value="${requestScope.student.id}" type="hidden">
          	<input class="form-control" style="width:300px;" name="num" maxlength="128" value="${requestScope.student.num}" type="hidden">
          	
          	
            <div class="">
                <span>姓名：</span>
                <span>
                    <input class="form-control" style="width:300px;" name="name" maxlength="128" value="${requestScope.student.name}" type="text">
                </span>
            </div>
            
            <c:if test="${requestScope.student.sex.equals(\"男\")}">
          	<div class="">
                <span>性别：</span>
                <span>
                    <input name="sex" value="男" type="radio" checked="checked">男 
                    <input name="sex" value="女" type="radio">女
                </span>
            </div>
        	</c:if>
        	
        	<c:if test="${requestScope.student.sex.equals(\"女\")}">
          	<div class="">
                <span>性别：</span>
                <span>
                    <input name="sex" value="男" type="radio">男 
                    <input name="sex" value="女" type="radio" checked="checked">女
                </span>
            </div>
        	</c:if>
            

            <div class="">
                <span>证件：</span>
                <span>
                    <input class="form-control" style="width:300px;" name="idcard" maxlength="128" value="${requestScope.student.idcard}" type="text">
                </span>
            </div>
            
            <div class="">
                <span>班级：</span>
                <span>
                    <select  name="clazz_id" class="form-control" style="width:300px;" maxlength="128">
						   <option value="0">选择班级</option>
						   <c:forEach items="${requestScope.clazzs }" var="clazz">
						   		<c:choose>
			    					<c:when test="${student.clazz.id == clazz.id }">
			    						<option value="${clazz.id }" selected="selected">${clazz.name }</option>
			    					</c:when>
			    					<c:otherwise>
			    						<option value="${clazz.id }">${clazz.name }</option>
			    					</c:otherwise>
			    				</c:choose>
			    			</c:forEach>
					</select>
                </span>
            </div>
            
            <div class="">
                <span>QQ：</span>
                <span>
                    <input class="form-control" style="width:300px;" name="qq" maxlength="128" value="${requestScope.student.qq}" type="text">
                </span>
            </div>
            <div class="">
                <span>邮箱：</span>
                <span>
                    <input class="form-control" style="width:300px;" name="email" maxlength="128" value="${requestScope.student.email}" type="text">
                </span>
            </div>
            <div class="">
                <span>手机：</span>
                <span>
                    <input class="form-control" style="width:300px;" name="tel" maxlength="128" value="${requestScope.student.tel}" type="text">
                </span>
            </div>
            <div class="">
                <span>地址：</span>
                <span>
                    <input class="form-control" style="width:300px;" name="address" maxlength="128" value="${requestScope.student.address}" type="text">
                </span>
            </div>
            


            <div class="bton"><span class="ms"></span><button type="submit" id="saveprofile" class="btn btn-success">保存</button></div>
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