package day01;

public class TestStatic {
	int x;
	static int y;
	
     static void f(){
    	 
     }
	
	static{
		y=50;
	 System.out.println("static语句块"+y);	
	}
	
	
	public TestStatic(){
		System.out.println("构造方法");
	}
	
}
