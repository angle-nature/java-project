package po;

public class OrderItem {
    private int id; //订单项id
    private Goods goods; //已购买商品
    private int buyCount;  //已购买数量
    private float oneClassPrice; //此类商品总价
    private int state; //0 表示未发货 1 表示已发货

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public int getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(int buyCount) {
        this.buyCount = buyCount;
    }

    public float getOneClassPrice() {
        return oneClassPrice;
    }

    public void setOneClassPrice(float oneClassPrice) {
        this.oneClassPrice = oneClassPrice;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public OrderItem() {
    }

    public OrderItem(Goods goods, int buyCount, int oneClassPrice, int state) {
        this.goods = goods;
        this.buyCount = buyCount;
        this.oneClassPrice = oneClassPrice;
        this.state = state;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "goods=" + goods +
                ", buyCount=" + buyCount +
                ", oneClassPrice=" + oneClassPrice +
                '}';
    }
}
