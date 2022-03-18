package day01;

public class Test07 {

	public static void main(String[] args) {
         Student s1=new Student();
         s1.setSid(1001);
         Student s2=new Student(1002, "张三", 20);
         s1=s2;
         

	}

}
