<%--
  Created by IntelliJ IDEA.
  User: 86156
  Date: 2021/12/11
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>订单</title>
    <link rel="stylesheet" href="css/order.css" type="text/css">
    <link href="images/logo.ico" rel="icon" type="image/x-ico">
    <c:set var="order" value="${sessionScope.order}"/>
</head>
<body>
    <div class="div_head">
        <div class="div_headBorder">
            <span class="span_goods">商品信息</span>
            <span class="span_price">单价</span>
            <span class="span_number">数量</span>
            <span class="span_total">小计</span>
        </div>
    </div>
    <c:forEach var="orderItem" items="${order.orderItems}">
    <div class="div_content">
        <div class="div_img">
            <img src="images/${orderItem.goods.picture}">
        </div>
        <div class="div_name">
            <a href="GoodsDetailServlet?id=${orderItem.goods.id}">${orderItem.goods.name}</a>
        </div>
        <div class="div_price">
            <span class="goods_price">￥${orderItem.goods.price}</span>
        </div>
        <div class="div_count">
            <span class="goods_number">${orderItem.buyCount}</span>
        </div>
        <div class="div_totalPrice">
            <span class="oneClass_totalPrice">￥${orderItem.oneClassPrice}</span>
        </div>
    </div>
    <div class="div_trans">
        <div class="div_message">
            给卖家留言：
            <textarea rows="3" cols="20" maxlength="200" placeholder="选填，请先和商家协商一致"></textarea>
        </div>
        <div class="div_transMethod">
            <div class="div_border">
                <span>运送方式：普通配送&nbsp快递&nbsp免邮</span>
            </div>
        </div>
        <div class="div_freight">
            <span>运费险：卖家赠送，退换货可赔</span>
        </div>
    </div>
    </c:forEach>
    <div class="div_buy">
        <div id="div_total">
            <b class="b_head">实付款：</b>
            <b id="totalPrice">￥${order.price}</b>
        </div>
        <div id="div_address">
            <b class="b_head">寄送至：</b>
            <span id="span_address">${order.user.address}</span>
        </div>
        <div id="div_userName">
            <b class="b_head">收货人：</b>
            <span id="span_name">${order.user.userName}&nbsp${order.user.mobilePhone}</span>
        </div>
    </div>
    <a id="submit" href="SubmitOrderServlet">提交订单</a>
</body>
</html>