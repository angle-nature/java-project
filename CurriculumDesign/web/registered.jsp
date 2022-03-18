<%--
  Created by IntelliJ IDEA.
  User: 86156
  Date: 2021/12/4
  Time: 8:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" href="css/register.css" type="text/css">

    <script>
        window.onload=function (){
            // 用户名正则表达式：/^[a-zA-Z][0-9a-zA-Z_]{5,19}$/
            // 密码正则表达式：/^[a-zA-Z][0-9a-zA-Z_]{5,14}$/
            // 手机号正则表达式：/^1[3456789]\d{9}$/
            var rgArr=[/^[a-zA-Z][0-9a-zA-Z_]{5,19}$/,/^[a-zA-Z][0-9a-zA-Z_]{5,14}$/,/^1[3456789]\d{9}$/];
            var txtArr=document.querySelectorAll("input");
            var spanArr=document.querySelectorAll("span1");
            var nameArr=['用户名','密码','手机号'];
            for (var i = 0; i < spanArr.length; i++) {
                (function (index) {  // 闭包
                    // 失去焦点 onblur
                    txtArr[index].onblur = function () {
                        var str = txtArr[index].value;
                        //test方法验证
                        if (rgArr[index].test(str)) {
                            spanArr[index].innerHTML = nameArr[index] + '输入正确';
                            spanArr[index].className = 'success';
                        } else {
                            spanArr[index].innerHTML = nameArr[index] + '输入错误';
                            spanArr[index].className = 'error';
                        }
                    }
                }(i))
            }
        }
    </script>
</head>
<body>
    <form action="RegisterServlet" method="post">
        <div class="register">
            <div class="registerForm">
                <span class="text">用户名&nbsp&nbsp</span>
                <input class="inputText" type="text" name="userName" autocomplete="off" placeholder="请输入你的用户名">
                <span1></span1>
            </div>
            <div class="registerForm">
                <span class="text">密码&nbsp&nbsp</span>
                <input class="inputText" type="password" name="password" autocomplete="off" placeholder="请输入你的密码">
                <span1></span1>
            </div>
            <div class="registerForm">
                <span class="text">手机号码&nbsp&nbsp</span>
                <input class="inputText"type="text" name="mobilePhone" autocomplete="off" placeholder="请输入你的手机号码">
                <span1></span1>
            </div>
            <div class="registerForm">
                <span class="text">出生日期&nbsp&nbsp</span>
                <input class="inputText" type="date" name="birthday">
            </div>
            <div class="registerForm">
                <span class="text">地址&nbsp&nbsp</span>
                <input class="inputText" type="text" name="address" autocomplete="off" placeholder="请输入你的地址">
            </div>
            <input id="submit" type="submit" value="注册">
            <a id="returnLogin" href="login.jsp">返回登录</a>
        </div>
    </form>
</body>
</html>
