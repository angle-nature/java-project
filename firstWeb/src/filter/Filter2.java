package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class Filter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //获取请求路径
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        String path1=request.getRequestURI();
//        String path2=request.getRequestURL().toString();
//        System.out.println(path1+"  "+path2);
        //path1不包含user字符串 就放行 否则 看是否登录
        if (!path1.contains("user")){
            //放行
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        HttpSession session=request.getSession();
        String user=session.getAttribute("user").toString();
        if (user!=null){
            filterChain.doFilter(servletRequest, servletResponse);
        }else{
            response.sendRedirect("abc.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
