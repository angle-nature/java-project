package work;

public class Tri {
	private double a,b,c;
	
	public Tri() {
		this.a=0;
		this.b=0;
		this.c=0;
	}
	
	public Tri(double x,double y,double z) {
		this.a=x;
		this.b=y;
		this.c=z;
	}
	
	public double getArea() {
		double p=(a+b+c)/2;
		return Math.sqrt(p*(p-a)*(p-b)*(p-c));
	}
	
}
