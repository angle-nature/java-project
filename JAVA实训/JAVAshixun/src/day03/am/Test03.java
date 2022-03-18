package day03.am;

public class Test03 {

	public static void main(String[] args) {
		Link link1=new Link();
		Link link2=new Link();
		
		link1.addItem(3,0);
		link1.addItem(4,2);
		link1.addItem(7,5);
		link1.addItem(8,12);
		link1.addItem(20,20);
		link1.addItem(20,30);
		link1.addItem(20,40);
		link1.addItem(20,50);
		
		link2.addItem(2,1);
		link2.addItem(5,2);
		link2.addItem(3,5);
		link2.addItem(10,15);
		
		link1.printPloy();
		link2.printPloy();
	 	Link link3=link1.add(link2);
	 	link3.printPloy();
		
	}
	
}
