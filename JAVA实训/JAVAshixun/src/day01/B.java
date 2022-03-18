package day01;

public class B {
   public  void f(){
	   System.out.println("*****f()****");
   }
   
	
   public  void f(int x){
	   x++;
	   System.out.println("*****f(int x)****");
   }
	
//   public  void f(int x,int y){
//	   y=x+y;
//	   System.out.println("*****f(int x,int y)****");
//   }
   
   public  void f(int x,double y){
	   y=x+y;
	   System.out.println("*****f(int x,double y)****");
   }
   
   public  void f(double x,int y){
	   double z=x+y;
	   System.out.println("*****f(double x,int y)****");
   }
	
//   public  void f(int x,float y){
//	   y=x+y;
//	   System.out.println("*****f(int x,float y)****");
//   }
   
}
