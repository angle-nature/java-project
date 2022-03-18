package serv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "cookie", value = "/cookie")
public class cookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        String lasTime=null;
        //1、取上次访问时间
        //获得cookie
        Cookie[] cookies=request.getCookies();
        if (cookies!=null){
            //遍历
            for (Cookie co:cookies){
                //获取cookie名字
                String name=co.getName();
                //name是否为“lastTime”
                if ("lastTime".equals(name)){
                    lasTime=co.getValue();
                    break;
                }
            }
        }
        if (lasTime!=null){
            out.println("上次访问时间："+lasTime);
        }else{
            out.println("首次访问");
        }
        //2、存当前时间
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("hh时mm分ss秒");
        String time=simpleDateFormat.format(date);
        //创建一个Cookie 名字=值 String 类型 最大存储4KB
        Cookie cookie=new Cookie("lastTime",time);

        //Cookie在浏览器的存储时间
        //1、存在浏览器缓存中，浏览器如果关闭 就删除了Cookie
        //2、存在硬盘中 设置Cookie的有效时间
        cookie.setMaxAge(3600); //以秒为单位  3600s 1h

        //cookie 发送到客户端
        response.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
