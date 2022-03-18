package serv;

import po.Good;
import po.GoodDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@WebServlet(name = "ServletListGood", value = "/ServletListGood")
public class ServletListGood extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");// 设置生成的文档类型
        PrintWriter out = response.getWriter();// 得到输出字符输出流
        Collection<Good> goods= GoodDB.getAll();
        out.println("<h1>今日热销商品如下：</h1>");
        out.println("<table>");
        out.println("<tr>");
        out.println("<th>商品名称</th>");
        out.println("<th>商品单价</th>");
        out.println("<th>剩余库存</th>");
        out.println("</tr>");
        for(Good good:goods){
            //点击超链接 可以把id传过去 get请求
            String url=request.getContextPath()+"/ServletPur?id="+good.getId();
            out.println("<tr>");
            out.println("<td>"+good.getName()+"</td>");
            out.println("<td>"+good.getPrice()+"</td>");
            out.println("<td>"+good.getCount()+"</td>");
            out.println("<td><a href='"+url+"'>立即购买</a></td>");
            out.println("</tr>");
        }
        out.println("</table>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
