package shiyan;

public class Calculate {
	
	 private int a;	 
	 public Calculate(int a) {	 
		 this.a=a;
		 System.out.println("from constrartion"+this.a);
	 }
	 
	 public double volume(double height,double width,double depth) {	 
		 Double v=height*width*depth;      //º∆À„
		 return v;
	 }
	 int add(int x, int y) {	 
		 return x+y;
	 }
	 protected void a() {	 
		 System .out.println("from constration"+a);
	 }

}
