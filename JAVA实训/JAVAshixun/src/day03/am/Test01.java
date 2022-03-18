package day03.am;

public class Test01 {

	public static void main(String[] args) {
		Node node1=new Node(10);
		Node node2=new Node(20);
		Node node3=new Node(30);
		
		node2.setNext(node3);
		node1.setNext(node2);
		
		System.out.println(node1.getData());
		System.out.println(node1.getNext().getData());
		System.out.println(node1.getNext().getNext().getData());
		 
	}

}
