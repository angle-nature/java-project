package servlet;

import dao.OrderDao;
import po.Order;
import po.UserInfo;
import service.IOrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QueryAllOrdersServlet", value = "/QueryAllOrdersServlet")
public class QueryAllOrdersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        List<Order> orders=(List<Order>)session.getAttribute("allOrders");
        if (orders==null){
            UserInfo user=(UserInfo)session.getAttribute("user");
            IOrderService orderService=new OrderDao();
            orders=orderService.findOrderByUserId(user.getId());
            session.setAttribute("allOrders",orders);
        }
        response.sendRedirect("allOrders.jsp");
    }
}