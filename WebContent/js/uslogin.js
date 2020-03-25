// 提交验证，异步传输 
$(document).ready(function(){
    $("form").submit(function (){
        if ($("#num").val() == '' || $("#password").val() == ''){
            //alert("帐号和密码不能为空!");
            $(".u-tips-err").html("<span><font color='red'>帐号和密码不能为空!</font></span>");
            return false;
        }
        else{
            $.ajax({
                type: 'post',   // 路由器中提交页面使用post方式，这里也需要用post
                url: 'uslogin',       //处理登录页面,注意返回内容，成功返回OK
                dataType: 'text',
                data: $("form").serialize(),
                success: function (msg) {
                    if (msg == "ok"){
                        //window.location.href = "books"; //登录成功，跳转到books页面
                        //window.history.back(); //登录成功，跳转到前一页,不刷新
                        //window.history.go(-1); //登录成功，跳转到前一页,不刷新
                        location.href=document.referrer; //document.referrer是获取上一页的url
                    }else{                          
                        //alert("帐号或密码不正确，请您重新输入!"); 
                        $(".u-tips-err").html("<span><font color='red'>帐号或密码不正确，请您重新输入!</font></span>");
                        return false;                      
                    }
                }
            });
        }
    return false; // 要阻止表单提交     
    });
});