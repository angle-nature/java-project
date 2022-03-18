package work;

public class StringThread extends Thread{
	 private String s[] = { " Who "," is ", " the ", " champion "," of ", "the ","Russian ","Cup?", };
	 static String str=new String(" ");
	 public void run() {
		 synchronized(str) {
			 for(int i=0;i<8;i++)
				 System.out.print(s[i]);
			 System.out.println();
		 }

	 }
}
