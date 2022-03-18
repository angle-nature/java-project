package day01;

public class Dot {
	private double x;
	private double y;

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public Dot(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public  Dot   midDot(Dot d){
		double midx=(this.x+d.x)/2;
		double midy=(this.y+d.y)/2;
		
		return new Dot(midx, midy);
		
	}
	
	
}
