<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">
<script src="${ctx}/js/jquery.min.js"></script>
<script src="${ctx}/js/popper.min.js"></script>
<script src="${ctx}/js/bootstrap.min.js"></script>
<style>
body {
	position: relative;
}
</style>
<title>关于本系统</title>
</head>
<body data-spy="scroll" data-target=".navbar" data-offset="50">

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="#section1">功能</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="#section2">使用</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="#section3">帮助</a>
			</li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbardrop"
				data-toggle="dropdown"> 联系方式 </a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="#section41">博客</a> 
					<a class="dropdown-item" href="#section42">邮箱</a>
				</div></li>
		</ul>
	</nav>

	<div id="section1" class="container-fluid bg-success"
		style="padding-top: 70px; padding-bottom: 70px">
		<h1>功能介绍</h1>
		<p>EMSApp提供学生查看成绩、查询课表，教师添加成绩、修改成绩，管理员添加用户、编辑用户、删除用户、添加课程等功能。</p>
	</div>
	<div id="section2" class="container-fluid bg-warning"
		style="padding-top: 70px; padding-bottom: 70px">
		<h1>使用说明</h1>
		<p>使用说明</p>

	</div>
	<div id="section3" class="container-fluid bg-secondary"
		style="padding-top: 70px; padding-bottom: 70px">
		<h1>帮助</h1>
		<p>如果您在使用过程中遇到问题，请提交给我们。谢谢！</p>

	</div>
	<div id="section41" class="container-fluid bg-danger"
		style="padding-top: 70px; padding-bottom: 70px">
		<h1>博客</h1>
		<p>BLOG:www.ileiwang.cc</p>
		<p>GITHUB:github.com/ileiwang</p>
	</div>
	<div id="section42" class="container-fluid bg-info"
		style="padding-top: 70px; padding-bottom: 70px">
		<h1>邮箱</h1>
		<p>3970111@gmail.com</p>
		<p>ileiwang@live.com</p>
	</div>

</body>
</html>

