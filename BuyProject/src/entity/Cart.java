package entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Cart {
	private HashMap<Items,Integer> goods;
	
	private double totalPrice;
	
	
	public Cart()
	{
		goods=new HashMap<Items,Integer>();
		totalPrice=0.0;
		
	}
	public HashMap<Items, Integer> getGoods() {
		return goods;
	}

	public void setGoods(HashMap<Items, Integer> goods) {
		this.goods = goods;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public boolean addGoodsInCart(Items item, int number) {
		if(goods.containsKey(item)) {
			goods.put(item, goods.get(item)+number);
		} else {
			goods.put(item, number);
		}
		calTotalPrice();
		return true;


	}

	public boolean removeGoodsFromCart(Items item) {
		goods.remove(item);
		calTotalPrice();
		return true;
	}
	
	public double calTotalPrice() {
		
		double sum = 0.0;
		Set <Items>  keys = goods.keySet();
		Iterator <Items> it = keys.iterator();
		
		while(it.hasNext()) {
			Items i = it.next();
			sum += i.getPrice() * goods.get(i);
		}
		
		this.setTotalPrice(sum);
		return this.getTotalPrice();
	}


	public static void main(String[] args) 
	{
		Items i1 = new Items(1,"沃特鞋","温州",200,400,"001.jpg");
		Items i2 = new Items(2,"李宁运动鞋","广州",300,200,"002.jpg");
		Items i3 = new Items(2,"李宁运动鞋","广州",300,200,"002.jpg");
		Cart c=new Cart();
		c.addGoodsInCart(i1, 2);
		c.addGoodsInCart(i2, 5);
		c.addGoodsInCart(i3, 8);
		
		Set<Map.Entry<Items, Integer>>items=c.getGoods().entrySet();
		for(Map.Entry<Items, Integer>obj:items)
		{
			System.out.println(obj);	
		}
		
		System.out.println("购物车的金额"+c.getTotalPrice());
	}
			
			
	
	
	

	
}
