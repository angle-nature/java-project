package day02.pm;

public class Test02 {

	public static void main(String[] args) {
		 MyArray myarr=new MyArray(10);
		 myarr.insert(40);
		 myarr.insert(30);
		 myarr.insert(10);
		 myarr.insert(5);
		 myarr.insert(20);
		 myarr.insert(50);
		 myarr.display();
     	// myarr.bubbleSort();
		 myarr.selectSort();
     	 System.out.println();
     	 myarr.display();
	}

}
