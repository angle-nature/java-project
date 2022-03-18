package entity;

//商品表
public class Items {
	private int id;// 商品编号
	private String name;// 商品名称
	private String city;//
	private int price;//
	private int number;//
	private String picture;//

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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
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

	public Items() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Items(int i, String string, String string2, int j, int k, String string3) {
		super();
		this.id = i;
		this.name = string;
		this.city = string2;
		this.price = j;
		this.number = k;
		this.picture = string3;
	}

	
	public String toString()
	{
		return "商品编号："+this.getId()+"商品名称："+this.getName();
	}

	@Override
	public int hashCode() {
		
		return this.getId() + this.getName().hashCode();
	
	}
 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if(obj == null) {
			return false;
		}
		if(obj instanceof Items) {
			Items i = (Items)obj;
			if(this.getId() == i.getId() && this.getName().equals(i.getName())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}






}
