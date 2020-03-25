// 提交验证，异步传输 
// 登录对话框
$(document).ready(function(){
    $("#loginform").click(function (){
        if ($("#username").val() == '' || $("#password").val() == ''){
            $(".u-dialog-err").html("<span class='ms-login'><font color='red'>帐号和密码不能为空!</font></span>");
            $(".ms-login").fadeOut(3000);
            return false;
        }
        else{
            $.ajax({                
                type: 'post',   // 路由器中提交页面使用post方式，这里也需要用post
                url: '../uslogin',       //处理登录页面,注意返回内容，成功返回OK
                //url: 'http://localhost/uslogin', 
                dataType: 'text',
                data: $("form").serialize(),
                success: function (msg) {
                    if (msg == "ok"){
                        location.href=document.referrer; //document.referrer是获取上一页的url
                    }else{                          
                        $(".u-dialog-err").html("<span class='ms-login'><font color='red'>帐号或密码不正确，请您重新输入!</font></span>");
                        $(".ms-login").fadeOut(3000);
                        return false;                      
                    }
                }
            });
        }
    return false; // 要阻止表单提交     
    });
});