package po;

public class CartItem {
    private Goods goods; //已购买商品
    private int buyCount;  //已购买数量
    private float oneClassPrice; //此类商品总价
    private UserInfo userInfo; //用户

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

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public CartItem() {
    }

    public CartItem(Goods goods, int buyCount, float oneClassPrice, UserInfo userInfo) {
        this.goods = goods;
        this.buyCount = buyCount;
        this.oneClassPrice = oneClassPrice;
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "goods=" + goods +
                ", buyCount=" + buyCount +
                ", oneClassPrice=" + oneClassPrice +
                ", userInfo=" + userInfo +
                '}';
    }
}


