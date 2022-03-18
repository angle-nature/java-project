package day01;

public class Test05 {

	public static void main(String[] args) {
		int[][] x={{1,2,3},{4,5,6,7},{8,9}};
		printx(x);
		f(x);
		System.out.println("*********");
		printx(x);
	}

	private static void f(int[][] a) {
		a[1][2]=10; 
		
	}

	private static void printx(int[][] x) {
		for (int[] i : x) {
			for(int k:i){
		        System.out.print(k+"   ");
			}
			System.out.println();
	}
		
	}
	
	
}
