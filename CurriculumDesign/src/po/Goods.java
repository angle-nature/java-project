package po;

public class Goods {
	private int id; // 商品编号
	private String name; // 商品名称
	private String city; // 产地
	private float price; // 价格
	private int number; // 库存
	private String picture; // 商品图片

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Goods() {
	}

	public Goods(int id, String name, String city, float price, int number, String picture) {
		this.id = id;
		this.name = name;
		this.city = city;
		this.price = price;
		this.number = number;
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "Goods{" +
				"id=" + id +
				", name='" + name + '\'' +
				", city='" + city + '\'' +
				", price=" + price +
				", number=" + number +
				", picture='" + picture + '\'' +
				'}';
	}
}
