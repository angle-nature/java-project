package dao;

import po.Order;
import po.OrderItem;
import service.IOrderService;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao implements IOrderService {
    Connection connection = null;
    PreparedStatement pStatement = null;
    ResultSet resultSet = null;

    //添加订单信息（即：将该信息添加到我的订单中。即 ：保存到数据库的订单表中）
    public void addOrders(Order orders) {
        connection = DBUtil.getCon();
        try {
            String sql = "insert into orders (orderId,num,price,userId) values(?,?,?,?);";
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, orders.getOrderID());
            pStatement.setInt(2, orders.getNum());
            pStatement.setFloat(3, orders.getPrice());
            pStatement.setInt(4, orders.getUser().getId());
            if(pStatement.executeUpdate()>0){
                String querySql="select id from orders where orderId='"+orders.getOrderID()+"'";
                pStatement=connection.prepareStatement(querySql);
                resultSet=pStatement.executeQuery();
                if(resultSet.next())
                    orders.setId(resultSet.getInt("id"));
            }

            //订单中的订单项
            List<OrderItem> items = orders.getOrderItems();
            if (items != null && items.size() > 0) {//订单项中 有东西，才添加进数据库中的订单项表
                String sql2 = "insert into orderItem (num,price,orderId,goodsId,state) values(?,?,?,?,?)";
                pStatement = connection.prepareStatement(sql2);
                Object pps[][] = new Object[items.size()][];
                for (int i = 0; i < items.size(); i++) {
                    OrderItem item = items.get(i);
                    pStatement.setInt(1, item.getBuyCount());
                    pStatement.setFloat(2, item.getOneClassPrice());
                    pStatement.setInt(3, orders.getId());
                    pStatement.setInt(4, item.getGoods().getId());
                    pStatement.setInt(5, item.getState());
                    pStatement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(connection, pStatement, resultSet);
        }
    }

    //根据用户的id查询属于自己的订单
    public List<Order> findOrderByUserId(int id) {
        connection = DBUtil.getCon();
        try {
            pStatement = connection.prepareStatement("select * from orders where userId=? order by orderId desc;");
            pStatement.setInt(1, id);
            resultSet = pStatement.executeQuery();
            List<Order> list = new ArrayList<Order>();
            Order order = null;
            while (resultSet.next()) {
                //创建Orders对象
                order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setOrderID(resultSet.getString("orderId"));
                order.setNum(resultSet.getInt("num"));
                order.setPrice(resultSet.getFloat("price"));
                //order.setUser(rs.getString("user_id"));
                list.add(order);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            DBUtil.closeAll(connection, pStatement, resultSet);
        }
    }

    @Override
    public Order findOrderByOrderId(int userId, int orderId) {
        connection = DBUtil.getCon();
        try {
            pStatement = connection.prepareStatement("select * from orderItem where orderId=?;");
            pStatement.setInt(1, orderId);
            resultSet = pStatement.executeQuery();
            List<OrderItem> orderItems=new ArrayList<>();
            while (resultSet.next()){
                OrderItem orderItem=new OrderItem();
                orderItem.setGoods(new GoodsDao().findGoodsById(resultSet.getInt("goodsId")));
                orderItem.setState(resultSet.getInt("state"));
                orderItem.setBuyCount(resultSet.getInt("num"));
                orderItem.setOneClassPrice(resultSet.getFloat("price"));
                orderItem.setId(resultSet.getInt("id"));
                orderItems.add(orderItem);
            }

            pStatement = connection.prepareStatement("select * from orders where userId=? and id=?;");
            pStatement.setInt(1, userId);
            pStatement.setInt(2, orderId);
            resultSet = pStatement.executeQuery();
            Order order=new Order();
            if (resultSet.next()) {
                //创建Orders对象
                order.setId(resultSet.getInt("id"));
                order.setOrderID(resultSet.getString("orderId"));
                order.setNum(resultSet.getInt("num"));
                order.setPrice(resultSet.getFloat("price"));
                order.setOrderItems(orderItems);
            }
            return order;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            DBUtil.closeAll(connection, pStatement, resultSet);
        }
    }
}
