package servlet;

import po.CartItem;
import po.UserInfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShowCartServlet", value = "/ShowCartServlet")
public class ShowCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        //获取用户
        UserInfo user=(UserInfo)session.getAttribute("user");
        //所有用户的购物车项
        List<CartItem> cart=(List)session.getAttribute("cart");
        System.out.println(cart);
        if(cart==null){
            //首次购物 需要创建购物车-ArrayList集合对象
            cart=new ArrayList<CartItem>();
            //把购物车存入session中
            session.setAttribute("cart",cart);
        }
        List<CartItem> userCart=new ArrayList<>();
        for (CartItem cartItem:cart){
            if (cartItem.getUserInfo().getId()==user.getId()){
                userCart.add(cartItem);
            }
        }

        session.setAttribute("userCart",userCart);
        response.sendRedirect("cart.jsp");
    }
}