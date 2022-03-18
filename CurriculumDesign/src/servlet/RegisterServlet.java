package servlet;

import dao.UserDao;
import service.IUserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session=request.getSession();
        String userName=request.getParameter("userName");
        String password=request.getParameter("password");
        String mobilePhone=request.getParameter("mobilePhone");
        String birthday=request.getParameter("birthday").replace("-","");
        String address=request.getParameter("address");


        if (userName==null||"".equals(userName)||
            password==null||"".equals(password)||
            mobilePhone==null||"".equals(mobilePhone)||
            birthday==null||"".equals(birthday)||
            address==null||"".equals(address)){
            response.sendRedirect("registered.jsp");
            return;
        }
        IUserService userService=new UserDao();
        boolean result=userService.registerUser(userName,password,mobilePhone,birthday,address);
        if (result){
            session.setAttribute("result","success");
            //注册成功
            response.sendRedirect("login.jsp");
        }else{
            session.setAttribute("result","fail");
            response.sendRedirect("registered.jsp");
        }
    }
}