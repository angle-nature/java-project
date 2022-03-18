package serv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Serv2", value = "/Serv2")
public class Serv2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out= response.getWriter();
        out.println("用户名或密码错误！");
//        out.println("11111");
        //request对象 能存数据 是 域对象
        //键值对形式
        request.setAttribute("uname","admin");
        //获得请求分派对象
        RequestDispatcher rd= request.getRequestDispatcher("login.jsp"); //servlet路径
        //转发请求
//        rd.forward(request,response);
        //重定向
//        response.sendRedirect("Serv3");
        //包含Serv3
        rd.include(request,response);
//        out.println("22222");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
