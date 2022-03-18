package serv;

import po.Good;
import po.UserGood;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ServletCart", value = "/ServletCart")
public class ServletCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");// 设置生成的文档类型
        PrintWriter out = response.getWriter();// 得到输出字符输出流
        //从session中把购物车取出来显示
        HttpSession session=request.getSession();
        //获得购物车cart
        List<UserGood> cart=(List)session.getAttribute("cart");
        if (cart==null){
            out.println("还未选择商品");
        }else{
            out.println("<h1>您选购的商品如下：</h1>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>商品名称</th>");
            out.println("<th>商品单价</th>");
            out.println("<th>购买数量</th>");
            out.println("<th>总价</th>");
            out.println("</tr>");
            int totalPrice=0;
            for(UserGood uGood:cart){
                out.println("<tr>");
                out.println("<td>"+uGood.getGood().getName()+"</td>");
                out.println("<td>"+uGood.getGood().getPrice()+"</td>");
                out.println("<td>"+uGood.getBuyCount()+"</td>");
                out.println("<td>"+uGood.getOneClassPrice()+"</td>");
                out.println("</tr>");
                totalPrice+=uGood.getOneClassPrice();
            }
            out.println("</table>");
            out.println("总计："+totalPrice+"<br>");
        }
        out.println("<a href='ServletListGood'>返回继续选择商品！</a>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
