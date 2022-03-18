package serv;

import po.Good;
import po.GoodDB;
import po.UserGood;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ServletPur", value = "/ServletPur")
public class ServletPur extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //将用户购买的商品添加到session中
        //获得id
        String id=request.getParameter("id");
        if(id==null){
            response.sendRedirect("ServletListGood");
            return;
        }
        //根据id获得商品
        Good good=GoodDB.getById(id);
        //商品数量减一
        if(good.getCount()<=0){
            response.sendRedirect("ServletListGood");
            return;
        }else{
            good.setCount(good.getCount()-1);
        }
        //把商品Good放入购物车
        //获得session
        HttpSession session=request.getSession();
        //约定 购物车放在session中 约定名字为cart
        List<UserGood> cart=(List) session.getAttribute("cart");
        //如果是首次购物 cart为空
        if(cart==null){
            //首次购物 需要创建购物车-ArrayList集合对象
            cart=new ArrayList<UserGood>();
            //把购物车存入session中
            session.setAttribute("cart",cart);
        }
        //商品放入购物车中
        Boolean isBuy=false;
        for (UserGood uGood: cart){
            if (id.equals(uGood.getGood().getId())){
                uGood.setBuyCount(uGood.getBuyCount()+1);
                uGood.setOneClassPrice(uGood.getGood().getPrice()*uGood.getBuyCount());
                isBuy=true;
                break;
            }
        }
        if (!isBuy)
            cart.add(new UserGood(good,1,good.getPrice()));
        //创建Cookie 存放session_id
        Cookie cookie=new Cookie("JSESSIONID",session.getId());
        cookie.setMaxAge(60*30);//30分钟内有效
        //cookie写回浏览器端
        response.addCookie(cookie);
        //在购买结束后，将页面重定向到用户已购买的商品列表
        response.sendRedirect("ServletCart");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
