package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemsDAO;
import entity.Cart;
import entity.Items;

/**
 * Servlet implementation class Cartservlet
 */
@WebServlet("/Cartservlet")
public class Cartservlet extends HttpServlet {
	private String action;
	private ItemsDAO idao=new ItemsDAO();
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cartservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charest=utf-8");
		PrintWriter out=response.getWriter();
		if(request.getParameter("action")!=null)
		{
			this.action=request.getParameter("action");
			if(action.equals("add"))
			{
				if(addToCart(request,response))
				{
					request.getRequestDispatcher("success.html").forward(request, response);
				}
				else
				{
					request.getRequestDispatcher("failing.html").forward(request, response);

				}
			}
			if(action.equals("show"))
			{
				//showCart(request,response);
			}
				
		}
			
	}
	private boolean addToCart(HttpServletRequest request, HttpServletResponse response)
	{
		String id=request.getParameter("id");
		String number=request.getParameter("num");
		Items item=idao.getItemsById(Integer.parseInt(id));
		if(request.getSession().getAttribute("cart")!=null)
		{
			Cart cart =new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		Cart cart=(Cart)request.getSession().getAttribute("cart");
		if(cart.addGoodsInCart(item, Integer.parseInt(number)))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	

}
