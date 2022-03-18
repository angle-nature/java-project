package servlet;

import dao.GoodsDao;
import po.Goods;
import po.CartItem;
import po.UserInfo;
import service.IGoodsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddCartServlet", value = "/AddCartServlet")
public class AddCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num=Integer.parseInt(request.getParameter("number"));
        int id= Integer.parseInt(request.getParameter("id"));
        IGoodsService goodsService=new GoodsDao();
        Goods goods= goodsService.findGoodsById(id);

        //获得session
        HttpSession session=request.getSession();
        //获取用户
        UserInfo user=(UserInfo)session.getAttribute("user");
        //约定 购物车放在session中 约定名字为cart
        List<CartItem> cart=(List)session.getAttribute("cart");
        //如果是首次购物 cart为空
        if(cart==null){
            //首次购物 需要创建购物车-ArrayList集合对象
            cart=new ArrayList<CartItem>();
            //把购物车存入session中
            session.setAttribute("cart",cart);
        }
        //商品放入购物车中
        Boolean isBuy=false;
        for (CartItem cartItem: cart){
            //相同用户 且 同一个商品 增加其数量
            if ((id==(cartItem.getGoods().getId()))&&(user.getId()==cartItem.getUserInfo().getId())){
                cartItem.setBuyCount(cartItem.getBuyCount()+num);
                cartItem.setOneClassPrice(cartItem.getGoods().getPrice()*cartItem.getBuyCount());
                isBuy=true;
                break;
            }
        }
        if (!isBuy)
            cart.add(new CartItem(goods,num,goods.getPrice()*num,user));
        //创建Cookie 存放session_id
        Cookie cookie=new Cookie("JSESSIONID",session.getId());
        cookie.setMaxAge(60*60*24);//24小时内有效
        //cookie写回浏览器端
        response.addCookie(cookie);
        //在购买结束后，将页面重定向到用户已购买的商品列表
        request.setAttribute("result","success");
        request.getRequestDispatcher("GoodsDetailServlet?id="+id).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
