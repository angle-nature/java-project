package serv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Main", value = "/Main")
public class Main extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得 cookie 看是否由用户信息
        Cookie[] cookies=request.getCookies();
        if (cookies!=null){
            //遍历
            for (Cookie co:cookies){
                //获取cookie名字
                String name=co.getName();
                //name是否为“lastTime”
                if ("user".equals(name)){
                    //转到欢迎界面
                    request.getRequestDispatcher("welcome.jsp").forward(request,response);
                    return;
                }
            }
        }
        //转到登录页面
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
