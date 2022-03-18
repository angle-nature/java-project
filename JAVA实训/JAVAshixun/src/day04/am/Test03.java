package day04.am;

public class Test03 {
	
	//public static void f(Dot p){  //泛型擦除 Dot<Integer,Integer>->Dot<Object,Object>
//	public static void f(Dot<?,?> p){   //通配符	Dot<Integer,Integer> 
//		System.out.println(p);
//	}
	
	public static void f(Dot<?,? extends Number> p){   //泛型的限界  	 
		System.out.println(p);
	}
	
	
	public static void main(String[] args) {
	//	Integer x=12;
	//	Double y=10.5;
	//	Object z=x;  //上转型  Integer->Object
	//	Object g=y;  //上转型  Double->Object

		Dot<Integer,Integer> dot1=new Dot<Integer,Integer>(10,5);
		Dot<Integer,Double> dot2=new Dot<Integer,Double>(10,5.5);
		Dot<String,String> dot3=new Dot<String,String>("东经38度", "北纬18度");

		f(dot2);

	}

}
