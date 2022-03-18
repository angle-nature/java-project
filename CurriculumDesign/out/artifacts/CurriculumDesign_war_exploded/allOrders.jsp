<%--
  Created by IntelliJ IDEA.
  User: 86156
  Date: 2021/12/11
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>全部订单</title>
    <style>
        table tr th {
            border: 1px solid #C1C1C1;
            font-size: 16px;
        }

        table tr td {
            border: 1px solid #C1C1C1;
        }
        table {
            width: 71%;
            min-height: 25px;
            line-height: 25px;
            border-collapse: collapse;
            padding: 2px;
            margin: auto;
            text-align: center;
        }
    </style>
</head>
<body>
<h2 style="text-align: center;font-size: 20px">以下是您近期的订单</h2>
<table>
    <tr>
        <th>订单号</th>
        <th>金额</th>
        <th>订单项数量</th>
        <th>订单详情</th>
    </tr>
    <c:forEach items="${sessionScope.allOrders}" var="order">
        <tr>
            <td>${order.orderID}</td>
            <td>￥${order.price}元</td>
            <td>${order.num}</td>
            <td>
                <a target="_blank" href="OrderDetailServlet?id=${order.id}">查看明细</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>