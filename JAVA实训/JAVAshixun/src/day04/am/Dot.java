package day04.am;

public class Dot<E,T> {
	private E x;
	private T y;

	public E getX() {
		return x;
	}

	public void setX(E x) {
		this.x = x;
	}

	public T getY() {
		return y;
	}

	public void setY(T y) {
		this.y = y;
	}

	public Dot(E x, T y) {
		super();
		this.x = x;
		this.y = y;
	}	
	
}
