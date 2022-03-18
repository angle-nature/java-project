<%--
  Created by IntelliJ IDEA.
  User: 86156
  Date: 2021/12/8
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>购物车</title>
    <link rel="stylesheet" href="css/cart.css" type="text/css">
    <link href="images/logo.ico" rel="icon" type="image/x-ico">
    <script type="text/javascript" src="js/cart.js"></script>
    <c:set var="cartItems" value="${sessionScope.userCart}"/>
</head>
<body>
<form action="CreateOrderServlet?operator=settlement" method="post">
    <div class="div_cartItems">
        <div class="div_head">
            <span >选项</span>
            <span>商品信息</span>
            <span>单价</span>
            <span>数量</span>
            <span>金额</span>
            <span>操作</span>
        </div>

        <c:forEach var="cartItem" items="${cartItems}">
            <div class="div_cartItem">
                <div class="div_title">
                    <span>
                        12.12 0点开享,每满199减25
                    </span>
                </div>
                <div class="div_content">
                    <div class="div_check">
                        <input type="checkbox" name="checkbox" class="checkbox" id="checkbox_${cartItem.goods.id}" value="${cartItem.goods.id}" onclick="oneCheckbox(${cartItem.goods.id})">
                    </div>
                    <div class="div_img">
                        <img id="img_goods" src="images/${cartItem.goods.picture}">
                    </div>
                    <div class="div_name">
                        <a href="GoodsDetailServlet?id=${cartItem.goods.id}">${cartItem.goods.name}</a>
                    </div>
                    <div class="div_price">
                        <span id="price_${cartItem.goods.id}">￥${cartItem.goods.price}</span>
                    </div>
                    <div class="div_count">
                        <button type="button" class="btn_sub" onclick="return sub(${cartItem.goods.id})">-</button>
                        <input type="text" name="goodsNumber_${cartItem.goods.id}" class="goods_number" id="goods_number_${cartItem.goods.id}" value="${cartItem.buyCount}" readonly>
                        <button type="button" class="btn_add" onclick="return add(${cartItem.goods.id})">+</button>
                    </div>
                    <div class="div_totalPrice">
                        <span class="oneClass_totalPrice" id="totalPrice_${cartItem.goods.id}">￥${cartItem.oneClassPrice}</span>
                    </div>
                    <div class="div_operator">
                        <a onclick="deleteCartItem(${cartItem.goods.id})" href="">删除</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="div_buy">
        <span id="check"><input type="checkbox" id="checkboxAll" onclick="selectAll()">全选</span>
        <a id="a_delete" onclick="return emptyCart()" href="">清空购物车</a>
        <span id="span_number">已选商品&nbsp<span id="totalNumber">0</span>&nbsp件</span>
        <span id="span_total">
            总计：<span id="totalPrice">￥0.00</span>
        </span>
        <input id="input_buy" type="submit" value="结算">
    </div>
</form>
</body>
</html>