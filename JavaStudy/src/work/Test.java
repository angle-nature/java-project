package work;

public class Test extends Thread{

	//public void start() {
		//System.out.println(1);
	//}
	
	public void run() {
		System.out.println(1);
	}
	
	public static void main(String[] args) {
		Test t=new Test();
		t.start();
		System.out.println(2);
	}

}
