package servlet;

import dao.GoodsDao;
import dao.OrderDao;
import po.CartItem;
import po.Order;
import po.OrderItem;
import po.UserInfo;
import service.IGoodsService;
import service.IOrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SubmitOrderServlet", value = "/SubmitOrderServlet")
public class SubmitOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        UserInfo user=(UserInfo)session.getAttribute("user");
        Order order=(Order)session.getAttribute("order");
        //更新数据库中的商品数量
        IGoodsService goodsService=new GoodsDao();
        for (OrderItem orderItem:order.getOrderItems()){
            goodsService.updateGoodsNumber(orderItem.getGoods().getId(),orderItem.getBuyCount());
        }

        IOrderService orderService=new OrderDao();
        //提交订单
        orderService.addOrders(order);

        //删除购物车中对应商品
        List<OrderItem> orderItems= order.getOrderItems();
        List<CartItem> cart=(List) session.getAttribute("cart");
        if(cart!=null)
            for (OrderItem orderItem:orderItems){
                for (CartItem cartItem: cart){
                    if (orderItem.getGoods().getId()==(cartItem.getGoods().getId())&&(user.getId()==cartItem.getUserInfo().getId())){
                        cart.remove(cartItem);
                        break;
                    }
                }
            }
        response.sendRedirect("submitSuccess.jsp");
    }
}
