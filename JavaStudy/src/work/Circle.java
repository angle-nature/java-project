package work;

public class Circle implements Shape{

	private final double Pi=3.14159;
	private double r;
	
	public Circle(double r) {
		this.r=r;
	}
	
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return Pi*r*r;
	}

	@Override
	public double getCircumference() {
		// TODO Auto-generated method stub
		return 2*Pi*r;
	}

}
