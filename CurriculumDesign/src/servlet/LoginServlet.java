package servlet;

import dao.UserDao;
import po.UserInfo;
import service.IUserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        //获取用户请求参数
        String userName=request.getParameter("userName");
        String password=request.getParameter("userPwd");
        String ccode=request.getParameter("checkName");

        HttpSession session=request.getSession();
        String code=session.getAttribute("checkCode").toString();

        String loginError="userEmpty";
        //如果用户或密码为空 返回登录页面
        if (userName==null||"".equals(userName)||password==null||"".equals(password)){
            request.setAttribute("loginError",loginError);
            request.getRequestDispatcher("login.jsp").forward(request,response);
            return;
        }

        //创建service对象 进行用户验证
        IUserService userService=new UserDao();
        //调用service的checkUser方法进行验证
        UserInfo userInfo=userService.checkUser(userName,password);
        //判断
        if (userInfo==null){
            loginError="userError";
            request.setAttribute("loginError",loginError);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }

        if (!code.equals(ccode)){
            loginError="codeError";
            request.setAttribute("loginError",loginError);
            request.getRequestDispatcher("login.jsp").forward(request,response);
            return;
        }

        session.setAttribute("user",userInfo);
        response.sendRedirect("index.jsp");
    }
}
