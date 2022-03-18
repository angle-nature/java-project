package day03.am;

public class Test02 {
	
	public static void main(String[] args) {
		LinkList linklist=new LinkList();
		   linklist.insert(10);
		   linklist.insert(20);
		   linklist.insert(30);
		   linklist.insert(40);
		   linklist.insert(20);
		   linklist.insert(50);
		   linklist.displayAll();
    		boolean flag=linklist.find(40);
    		System.out.println("flag="+flag);
 			linklist.removeFirst(20);
 			linklist.displayAll();
//			linklist.insert(60,3);
	}
   
	
}
