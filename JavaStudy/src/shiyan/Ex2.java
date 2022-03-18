package shiyan;

public class Ex2 extends Exception{
	
	Ex2(String msg){
		super(msg);             	  
	}
	
	static class MyEx{

		 private int x;	 
		 void setX(int x) {
		        this.x=x;         
		 }		 
		 void f1() throws Ex2{		  
			 if(x==13)
				 throw new Ex2("I don¡¯t like 13!");
			 else if(x==4)
				 throw new Ex2("I don?t like 4!");                        
			 else
				 System .out.println(100/x);
		 }		
		public static void main(String args[]) {				
			MyEx a=new MyEx();
			try {	 
			 	//a.setX(5);
			 	//a.setX(13);
			 	a.setX(4);
			 	//a.setX(0);
				a.f1();
			}catch(Ex2 e) {
				System .out.println("get message:"+e.getMessage());
			}
		}
	}
}
