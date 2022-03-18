package serv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "doLog4", value = "/doLog4")
public class doLog4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        request.setCharacterEncoding("utf-8");
        //获取参数
        String uname=request.getParameter("username");
        String pwd=request.getParameter("password");

        if("admin".equals(uname) && "123".equals(pwd)) {
            HttpSession session=request.getSession();
            session.setAttribute("user",uname);
            response.sendRedirect("userWelcome.jsp");
        }else {
            out.println("<h1>用户名或密码错误</h1>");
            request.getRequestDispatcher("abc.jsp").include(request, response);
        }
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
