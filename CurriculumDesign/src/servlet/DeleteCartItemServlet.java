package servlet;

import po.CartItem;
import po.UserInfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DeleteCartItemServlet", value = "/DeleteCartItemServlet")
public class DeleteCartItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr=request.getParameter("id");
        HttpSession session=request.getSession();
        UserInfo user=(UserInfo)session.getAttribute("user");
        List<CartItem> cart=(List) session.getAttribute("cart");
        if (idStr!=null){
            int id= Integer.parseInt(idStr);
            for (CartItem cartItem: cart){
                if ((id==cartItem.getGoods().getId())&&(user.getId()==cartItem.getUserInfo().getId())){
                    cart.remove(cartItem);
                    session.setAttribute("cart",cart);
                    System.out.println(cart);
                    break;
                }
            }
        }else{
            //没有参数id 即清空该用户的购物车项
            for (CartItem cartItem: cart){
                if (user.getId()==cartItem.getUserInfo().getId()){
                    cart.remove(cartItem);
                    session.setAttribute("cart",cart);
                    break;
                }
            }
        }
        List<CartItem> userCart=new ArrayList<>();
        for (CartItem cartItem:cart){
            if (cartItem.getUserInfo().getId()==user.getId()){
                userCart.add(cartItem);
            }
        }

        session.setAttribute("userCart",userCart);
        response.sendRedirect("cart.jsp");
//        response.sendRedirect("ShowCartServlet");
    }
}
