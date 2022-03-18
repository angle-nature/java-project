package filter;

import javax.servlet.*;
import java.io.IOException;

public class Fliter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.println("init is executed!");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("请求被拦截");
//        servletRequest.setCharacterEncoding("utf-8");
        //让请求放行
        filterChain.doFilter(servletRequest, servletResponse);
//        System.out.println("请求被放行");

    }

    @Override
    public void destroy() {
//        System.out.println("destroy is executed!");
    }
}
