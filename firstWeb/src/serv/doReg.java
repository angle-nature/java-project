package serv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "doReg", value = "/doReg")
public class doReg extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        request.setCharacterEncoding("utf-8");

        //获取注册页面参数
        String sex="Male".equals(request.getParameter("gender"))?"男":"女";
        String[] hobby=request.getParameterValues("favorite");
        String isAccept="true".equals(request.getParameter("isAccept"))?"接受":"不接受";

        //将信息输出到前台页面
        out.println("<html>");
        out.println("<body>");
        out.println("性别："+sex+"<br>");
        out.println("爱好：<br>");
        out.println("<ul>");
        for (int i=0;i<hobby.length;i++)
            out.println("<li>"+hobby[i]+"</li>");
        out.println("</ul>");
        out.println(isAccept);
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
