package day01;

public class Test13 {

	public static void main(String[] args) {
		
	Student.schoolname="X中学";
	
      Student s1=new Student();
        s1.sid=1001;
        System.out.println(s1.schoolname);
      Student s2=new Student();
        s2.sid =1002;
        s2.schoolname="Y GASDF";
        System.out.println(s1.schoolname);
        System.out.println(s2.schoolname);

	}

}
