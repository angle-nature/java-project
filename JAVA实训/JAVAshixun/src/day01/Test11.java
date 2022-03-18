package day01;

public class Test11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Dot dot1=new Dot(12,20);
		Dot dot2=new Dot(16,10);
		
		Dot middot=dot1.midDot(dot2);
         System.out.println(middot.getX()+ " , "+middot.getY());
	}

}
