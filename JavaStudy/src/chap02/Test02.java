package chap02;

public class Test02 {
		private static void setString1(StringBuffer sb1){
		  sb1.append("_appended.");
		}
		private static void setString2(StringBuffer sb2){
		  sb2=new StringBuffer("changed.");
		}
		public static void main(String[] args) {   
		    StringBuffer sb=new StringBuffer("abc");
		    setString1(sb);  
		    System.out.println(sb);  
		    setString2(sb);
		    System.out.println(sb);
		}
}
