package serv;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Serv1 extends HttpServlet {
    public Serv1() {
        System.out.println("无参构造！");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置文档类型 字符集
        resp.setContentType("text/html;charset=utf-8");
        // 获取输出流
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        // 系统时间
        Date date = new Date();
        // 格式化日期 2020-11-06
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String sDate = simpleDateFormat.format(date);
        out.println("<h1>日期："+sDate+"</h1>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
