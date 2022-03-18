package service;

import po.Order;
import java.util.List;

public interface IOrderService {
    //添加订单
    void addOrders(Order orders);
    //查询指定用户的所有订单
    List<Order> findOrderByUserId(int id);
    //查询指定用户的指定订单
    Order findOrderByOrderId(int userId,int orderId);
}
