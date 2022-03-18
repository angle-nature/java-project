package serv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "doLog", value = "/doLog")
public class doLog extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
//        RequestDispatcher rd= request.getRequestDispatcher("login.jsp");
        //获取客户端参数
        String userName=request.getParameter("username");
        String password=request.getParameter("password");
        String ccode=request.getParameter("checkname");

        //获取存在session中的code
        HttpSession session=request.getSession();
        String code=session.getAttribute("checkcode").toString();
        //用户是否免登录
        String auto=request.getParameter("isAuto");

        if (!code.equals(ccode)){
            out.println("<h1>验证码输入错误！</h1>");
            request.getRequestDispatcher("index.jsp").include(request,response);
            return;
        }
        if("admin".equals(userName)&&"123".equals(password)){ //验证成功 跳转到 欢迎页面
            if ("auto".equals(auto)){
                Cookie cookie=new Cookie("user",userName);
                //设置 10天 存储
                cookie.setMaxAge(10*24*60*60);
                response.addCookie(cookie);
            }
//            request.getRequestDispatcher("welcome.jsp").forward(request,response);
            response.sendRedirect("welcome.jsp");
//            out.println("<h1>登录成功！</h1>");
        }else{ //验证失败 跳转回 登录页面
            out.println("<h1>用户名或密码输入错误！</h1>");
            request.getRequestDispatcher("index.jsp").include(request,response);
//            response.sendRedirect("login.jsp");
//            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
