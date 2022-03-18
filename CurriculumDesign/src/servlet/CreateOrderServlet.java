package servlet;

import dao.GoodsDao;
import po.Goods;
import po.Order;
import po.OrderItem;
import po.UserInfo;
import service.IGoodsService;
import util.IdUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CreateOrderServlet", value = "/CreateOrderServlet")
public class CreateOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String operator=request.getParameter("operator");
        if ("buyNow".equals(operator))
            buyNow(request,response);
        else if ("settlement".equals(operator)){
            settlement(request, response);
        }
    }

    //立即购买商品 不经过购物车
    private void buyNow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserInfo user = (UserInfo)session.getAttribute("user");

        int num=Integer.parseInt(request.getParameter("number")); //购买数量
        int id= Integer.parseInt(request.getParameter("id")); //购买的商品id
        IGoodsService goodsService=new GoodsDao();
        Goods goods= goodsService.findGoodsById(id);

        String orderId =  IdUtil.getId();//自动生成：订单号
        OrderItem orderItem=new OrderItem();
        orderItem.setGoods(goods);
        orderItem.setBuyCount(num);
        orderItem.setState(0);
        orderItem.setOneClassPrice(goods.getPrice()*num);
        //创建订单项列表
        List<OrderItem> orderItems=new ArrayList<>();
        orderItems.add(orderItem);

        //创建订单项
        Order orders = new Order();
        orders.setOrderID(orderId);
        orders.setNum(1);
        orders.setOrderItems(orderItems);
        orders.setPrice(orderItem.getOneClassPrice());
        orders.setUser(user);

        session.setAttribute("order",orders);
        response.sendRedirect("order.jsp");
    }

    //结算 购物车中指定商品
    private void settlement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserInfo user = (UserInfo)session.getAttribute("user");
        String[] idArr=request.getParameterValues("checkbox");
        if(idArr==null){
            response.sendRedirect("cart.jsp");
            return;
        }
        System.out.println(idArr);
        List<OrderItem> orderItems=new ArrayList<>();
        float totalPrice=0;
        for (String id:idArr){
            System.out.println(id);
            OrderItem orderItem=new OrderItem();
            int number= Integer.parseInt(request.getParameter("goodsNumber_"+id));
            IGoodsService goodsService=new GoodsDao();
            Goods goods=goodsService.findGoodsById(Integer.parseInt(id));
            orderItem.setGoods(goods);
            orderItem.setBuyCount(number);
            orderItem.setState(0);
            totalPrice+=goods.getPrice()*number;
            orderItem.setOneClassPrice(goods.getPrice()*number);
            orderItems.add(orderItem);
        }
        Order order=new Order(IdUtil.getId(),orderItems.size(),totalPrice,orderItems,user);

        session.setAttribute("order",order);
        response.sendRedirect("order.jsp");
    }
}