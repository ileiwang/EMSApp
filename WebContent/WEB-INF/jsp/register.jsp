<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>注册账号</title>
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
<body>
<header class="header">
    <a href="${ctx}/"><div class="bg"></div></a>
</header>
<section id="mainSection" class="content">
    <div class="content-tit">
        <center><h3>欢迎注册！</h3></center>
        <hr>
    </div>
    <div id="" class="">
    <div class="">
        <div class="">
        <form id="form1" name="form1" class="form-horizontal" role="form" action="${ctx}/register" method="post">
        <input type="hidden" name="flag" value="2">
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">姓名</label>
                <div class="col-sm-10 basic-input">
                <div style="float:left">
                <div style="width:200px;float:left">
                	<input type="text" class="form-control" maxlength="25" id="name" name="name" placeholder="姓名">
                </div>              
                </div>                             
                </div>
            </div>
            
            
            <div class="form-group">
                <label for="num" class="col-sm-2 control-label">学号</label>
                <div class="col-sm-10 basic-input">
                <div style="float:left">
                <div style="width:200px;float:left">
                	<input type="text" class="form-control" maxlength="25" id="num" name="num" placeholder="学号">
                </div>              
                </div>                             
                </div>
            </div>
            
            
            <div class="form-group">
                <label for="email" class="col-sm-2 control-label">邮箱</label>
                <div class="col-sm-10 basic-input">
                <div style="float:left">
                <div style="width:200px;float:left">
                <input type="text" class="form-control" id="email" name="email" placeholder="邮箱">
                </div>
                <div id="emailTip" style="width: 280px; float: right; margin: 0px; padding: 0px; background: transparent;" class="onShow"></div>
                </div>                
                </div>
            </div>
            
            
            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">密码</label>
                <div class="col-sm-10 basic-input">
                <div style="float:left">
                <div style="width:200px;float:left">
                <input type="password" class="form-control" maxlength="25" id="password1" name="password1" placeholder="密码">
                </div>
                <div id="password1Tip" style="width: 280px; float: right; margin: 0px; padding: 0px; background: transparent;" class="onShow"></div>
                </div>               
                </div>
            </div>
            
            <div class="form-group">
                <label for="cpassword" class="col-sm-2 control-label">确认密码</label>
                <div class="col-sm-10 basic-input">
                <div style="float:left">
                <div style="width:200px;float:left">
                <input type="password" class="form-control" maxlength="25" id="password2" name="password2" placeholder="确认密码">
                </div>
                <div id="password2Tip" style="width: 280px; float: right; margin: 0px; padding: 0px; background: transparent;" class="onShow"></div>
                </div>               
                </div>
            </div>
            
            
            <div class="form-group">
                <label for="mobile" class="col-sm-2 control-label">手机号码</label>
                <div class="col-sm-10 basic-input">
                <div style="float:left">
                <div style="width:200px;float:left">
                <input type="mobile" class="form-control" maxlength="25" id="tel" name="tel" placeholder="请输入手机号码">
                </div>
                <div id="mobileTip" style="width: 280px; float: right; margin: 0px; padding: 0px; background: transparent;" class="onShow"></div>
                </div>             
                </div>
            </div>
            
            
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-success btn-lg" id="button" name="button">立即注册</button>
                &nbsp;&nbsp;<a href="${ctx}/loginForm">我已注册，登录</a>
                </div>                
            </div>
            
        </form>
        
       </div>
       
    </div>
    </div>
</section>
<footer class="main">
  <ul>
    <li class="nav-docs"><a href="${ctx}/about" target="_blank">关于本系统</a></li>
  </ul>
  <p class="less-significant"><a href="${ctx}" target="_blank">教务管理系统</a></p>
  <p class="beianaa">Copyright(C) 2018 All Rights Reserved 版权所有</p>
</footer>

</body>
</html>