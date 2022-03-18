package chap02;

public class Test {

	public static void main(String[] args) {
		
		int rows=9; //行数及列数
		int[][] arr=new int[rows][rows];
		
		for(int i=0;i<rows;i++) {
			arr[i][0]=1;
		}
		
		for(int i=1;i<rows;i++) {			
			for(int j=1;j<=i;j++) {
				arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
			}
		}
		
		for(int i=0;i<rows;i++) {			
			for(int j=0;j<=i;j++) {
				System.out.print("\t"+arr[i][j]);
			}
			System.out.println();
		}
	}

}
