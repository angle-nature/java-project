package servlet;

import dao.GoodsDao;
import po.Goods;
import po.UserInfo;
import service.IGoodsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GoodsDetailServlet", value = "/GoodsDetailServlet")
public class GoodsDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        UserInfo userInfo=(UserInfo)session.getAttribute("user");
        if (userInfo==null){
            response.sendRedirect("login.jsp");
        }else{
            int id= Integer.parseInt(request.getParameter("id"));
            IGoodsService goodsService=new GoodsDao();
            Goods goods= goodsService.findGoodsById(id);
            request.setAttribute("goods",goods);
            request.getRequestDispatcher("goodsDetail.jsp").forward(request,response);
        }
    }
}