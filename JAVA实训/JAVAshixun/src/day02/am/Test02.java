package day02.am;

public class Test02 {

	public static void main(String[] args) {
		 Tiger t1=new Tiger();
		 t1.call();
		 t1.youyong();
		 
		 Dog d1=new Dog();
		 
		 
		 Animal a1=t1;   //上转型，=表示地址引用关系的传递
		 a1.call();      //上转型，体现了语法编译（语法逻辑）和程序运行（看内存）的差异
		// a1.youyong();   失效，无法调用
		 
		 Tiger t2 =(Tiger)a1;
		 t2.youyong();
		 
		 Dog d2=(Dog)a1;
		 d2.call();
		 
		 
		 a1=d1;
		 a1.call();     //多态性
		 

	}

}
