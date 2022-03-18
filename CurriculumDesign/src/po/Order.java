package po;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private String orderID;
    private int num;//订单项数量
    private float price;//总金额
    private List<OrderItem> orderItems=new ArrayList<>(); //包括的订单项
    private UserInfo user;//属于哪个用户

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public Order() {
    }

    public Order(String orderID, int num, float price, List<OrderItem> orderItems, UserInfo user) {
        this.orderID = orderID;
        this.num = num;
        this.price = price;
        this.orderItems = orderItems;
        this.user = user;
    }
}
