<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="dao.GoodsDao,po.Goods" %>
<%@ page import="po.UserInfo" %>
<%@ page import="service.IGoodsService" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link href="images/logo.ico" rel="icon" type="image/x-ico">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="css/index.css" type="text/css">
    <title>知云优购</title>

</head>
<body>
    <div class="navigator">
        <span class="span-search">
            <input type="text" class="input-search" autocomplete="off" placeholder="冬季棉服">
            <button class="button-search">搜索</button>
            <c:if test="${empty sessionScope.user}">
                <a class="a_login" href="login.jsp">登录</a>
            </c:if>
            <c:if test="${!empty sessionScope.user}">
                <span class="span_welcome">欢迎&nbsp
                    <span style="color: #ff4400">${sessionScope.user.userName}</span>
                    &nbsp浏览本网站&nbsp
                    <a href="SignOutUserServlet">退出登录</a>
                    <a target="_blank" href="ShowCartServlet">购物车</a>
                    <a target="_blank" href="QueryAllOrdersServlet">全部订单</a>
                </span>
            </c:if>
        </span>
        <span class="span-tab">
            <ul class="ul-tab">
            　　<li><a href=''>首页</a></li>
            　　<li><a href=''>秒杀</a></li>
            　　<li><a href=''>优惠券</a></li>
            　　<li><a href=''>知云超市</a></li>
            　　<li><a href=''>拍卖</a></li>
            　　<li><a href=''>生鲜</a></li>
            　　<li><a href=''>会员中心</a></li>
            </ul>
        </span>
    </div>
    <%
        IGoodsService goodsService=new GoodsDao();
        List<Goods> allGoods= goodsService.queryAllGoods();
        request.setAttribute("allGoods",allGoods);
    %>
    <div class="goodsList">
        <!-- 商品循环开始 -->
        <c:forEach var="goods" items="${requestScope.allGoods}">
        <div class="goods_item">
           <a target="_blank" href="GoodsDetailServlet?id=${goods.id}">
               <img class="goods_img" src="images/${goods.picture}"/>
           </a>
           <p class="p_name">${goods.name}</p>
           <span class="span_price"><em class="em_sign">￥</em>${goods.price}</span>
        </div>
        <!-- 商品循环结束 -->
        </c:forEach>
    </div>
</body>
</html>