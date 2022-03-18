package servlet;

import dao.OrderDao;
import po.Order;
import po.UserInfo;
import service.IOrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "OrderDetailServlet", value = "/OrderDetailServlet")
public class OrderDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        //获取用户
        UserInfo user=(UserInfo)session.getAttribute("user");
        //订单id
        int id= Integer.parseInt(request.getParameter("id"));
        Order order=new OrderDao().findOrderByOrderId(user.getId(),id);
        request.setAttribute("orderDetail",order);
        request.getRequestDispatcher("orderDetail.jsp").forward(request,response);
    }
}
