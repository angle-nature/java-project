
public class Item {
	private double coef;
	private int exp;
	private Item next;

	public Item(double coef, int exp) {
		super();
		this.coef = coef;
		this.exp = exp;
		this.next = null;
	}

	public double getCoef() {
		return coef;
	}

	public void setCoef(double coef) {
		this.coef = coef;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public Item getNext() {
		return next;
	}

	public void setNext(Item next) {
		this.next = next;
	}	
}
