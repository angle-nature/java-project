<%@ page import="po.Goods" %>
<%@ page import="po.UserInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="images/logo.ico" rel="icon" type="image/x-ico">
    <link rel="stylesheet" href="css/goodsDetail.css" type="text/css">
    <c:set var="goods" value="${requestScope.goods}"></c:set>
    <c:set var="result" value="${requestScope.result}"></c:set>
    <title>${goods.name}</title>
    <script type="text/javascript">
        if ("success"=="${result}")
            alert("成功加入购物车");
    </script>
</head>
<body>
    <script>
        function add(){
            var text=document.getElementById("goods_number");
            var number=parseInt(text.value);
            number++;
            text.value=number;
        }

        function sub(){
            var subButton=document.getElementsByClassName("btn_sub");
            var text=document.getElementById("goods_number");
            var number=parseInt(text.value);
            if (number>1)
                number--;
            else{
                subButton.attr("disabled",false)
            }
            text.value=number;
        }

        function gotoAddCartServlet(){
            var numberText=document.getElementById("goods_number");
            var number=numberText.value;
            var url="AddCartServlet?id=${goods.id}&number="+number;
            window.open(url,"_self");
            return false;
        }

        function buyNow(){
            var numberText=document.getElementById("goods_number");
            var number=numberText.value;
            var url="CreateOrderServlet?operator=buyNow&id=${goods.id}&number="+number;
            window.open(url,"_self");
            return false;
        }

    </script>
    <hr>
    <div class="bigBox">
        <div class="div_img">
            <img id="img_goods" src="images/${goods.picture}">
        </div>
        <div class="content">
            <div class="goods_item">${goods.name}</div>
            <div class="goods_item">
                <span class="span_title">价格</span>
                <em>￥${goods.price}</em>
            </div>
            <div class="goods_item">
                <span class="span_title">配送</span>
                <span>${goods.city}&nbsp至&nbsp${sessionScope.user.address}&nbsp快递&nbsp免运费&nbsp&nbsp付款后48小时内发货</span>
            </div>
            <div class="goods_item">
                <span class="span_title">数量</span>
                <button class="btn_sub" onclick="sub()">-</button>
                <input type="text" id="goods_number" value="1">
                <button class="btn_add" onclick="add()">+</button>
                <span class="stock">（库存${goods.number}件）</span>
            </div>
            <div class="goods_item">
                <a class="a_buy"  onclick="return buyNow()" href="">立即购买</a>
                <a class="a_addCart" onclick="return gotoAddCartServlet()" href="">加入购物车</a>
                <a class="show_cart" href="ShowCartServlet" target="_blank">查看购物车</a>
            </div>
        </div>
    </div>
</body>
</html>