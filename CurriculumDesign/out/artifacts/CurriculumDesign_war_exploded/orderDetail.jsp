<%--
  Created by IntelliJ IDEA.
  User: 86156
  Date: 2021/12/11
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>订单详情</title>
    <link rel="stylesheet" href="css/orderDetail.css" type="text/css">
    <link href="images/logo.ico" rel="icon" type="image/x-ico">
    <c:set var="order" value="${requestScope.orderDetail}"/>
    <c:set var="user" value="${sessionScope.user}"/>
</head>
<body>
<div class="div_orderDetail">
    <div class="div_head">
        <div class="div_border">
            <b>收货地址：</b>
            <span class="span_address">
                ${user.address}
            </span>
        </div>
    </div>
    <div class="div_head">
        <div class="div_border">
            <b>订单编号</b>
            <span>${order.orderID}</span>
        </div>
    </div>
    <table>
        <tr>
            <th>商品</th>
            <th>状态</th>
            <th>单价</th>
            <th>数量</th>
            <th>金额</th>
        </tr>
        <c:forEach var="orderItem" items="${order.orderItems}">
            <tr>
                <td>
                    <div class="div_img"><img class="goods_img" src="images/${orderItem.goods.picture}"></div>
                    <div class="div_goodsName">
                        <a target="_blank" href="GoodsDetailServlet?id=${orderItem.goods.id}">${orderItem.goods.name}</a>
                    </div>
                </td>
                <td>${orderItem.state==0?"未发货":"已发货"}</td>
                <td>￥${orderItem.goods.price}</td>
                <td>${orderItem.buyCount}</td>
                <td>￥${orderItem.oneClassPrice}</td>
            </tr>
        </c:forEach>
    </table>
    <div class="div_end">
        <b>实付款：</b>
        <span>￥${order.price}</span>
    </div>
</div>
</body>
</html>