<%--
  Created by IntelliJ IDEA.
  User: 86156
  Date: 2021/11/5
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<table align="center" border='1px'>
    <form action="doReg" method="post">
        <tr>
            <td class="label">性别：</td>
            <td class="controler">
                <input type="radio" name="gender" checked="checked" value="Male">男
                <input type="radio" name="gender" value="Female">女
            </td>

        </tr>
        <tr>
            <td class="label">爱好：</td>
            <td class="controler">
                <input type="checkbox" name="favorite" value="nba"> NBA &nbsp;
                <input type="checkbox" name="favorite" value="music"> 音乐 &nbsp;
                <input type="checkbox" name="favorite" value="movie"> 电影 &nbsp;
                <input type="checkbox" name="favorite" value="internet"> 上网 &nbsp;
            </td>
        </tr>

        <tr>
            <td class="label">接受协议：</td>
            <td class="controler">
                <input type="checkbox" name="isAccept" value="true">是否接受霸王条款
            </td>
        </tr>
        <tr>
            <td colspan='2'><input type="submit" value="提交"></td>
        </tr>
    </form>
</table>
</body>
</html>
