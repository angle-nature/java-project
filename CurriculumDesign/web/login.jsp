<%--
  Created by IntelliJ IDEA.
  User: 86156
  Date: 2021/11/24
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>知云优购</title>
    <%--  使用外部样式  --%>
    <link rel="stylesheet" href="css/login.css" type="text/css">
    <%--  设置标题栏图标  --%>
    <link href="images/logo.ico" rel="icon" type="image/x-ico">
    <c:set var="loginError" value="${requestScope.loginError}"></c:set>
    <script type="text/javascript">
      if ("userEmpty"=="${loginError}")
        alert("用户名或密码为空！");
      else if ("userError"=="${loginError}")
        alert("用户名或密码错误！");
      else if ("codeError"=="${loginError}")
        alert("验证码错误！");
    </script>
  </head>
  <body>
    <form action="LoginServlet" method="post">
        <div class="loginBox" id="container">
          <div class="textForm">
            <div class="idLogo"></div>
            <input type="text" id="userName" name="userName" autocomplete="off" placeholder=" 请输入你的用户名">
          </div>
          <div class="textForm">
            <div class="pwdLogo"></div>
            <input type="password" id="userPwd" name="userPwd" autocomplete="off" placeholder=" 请输入你的登录密码">
          </div>
          <div class="checkCode">
            <input type="text" id="code" name="checkName" autocomplete="off" placeholder="验证码">
            <img src="CheckCodeServlet" id="codeImage">
          </div>
          <div class="loginForm">
            <input type="submit" id="submit" value="登录">
          </div>
          <div class="regBar">
            <a class="reg" href="registered.jsp">立即注册</a>
            <a class="forget" href="javascript:">忘记密码</a>
          </div>
        </div>
    </form>
  </body>
</html>
