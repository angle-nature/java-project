package po;

public class Good {
    private String id;
    private String name;
    private int price; //单价
    private int count; //剩余库存

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Good() {
    }

    public Good(String id, String name, int price, int count) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
    }
}
