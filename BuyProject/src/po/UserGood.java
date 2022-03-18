package po;

public class UserGood {
    private Good good; //已购买商品
    private int buyCount;  //已购买数量
    private int oneClassPrice; //此类商品总价

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public int getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(int buyCount) {
        this.buyCount = buyCount;
    }

    public int getOneClassPrice() {
        return oneClassPrice;
    }

    public void setOneClassPrice(int oneClassPrice) {
        this.oneClassPrice = oneClassPrice;
    }

    public UserGood() {
    }

    public UserGood(Good good, int buyCount, int oneClassPrice) {
        this.good = good;
        this.buyCount = buyCount;
        this.oneClassPrice = oneClassPrice;
    }
}
