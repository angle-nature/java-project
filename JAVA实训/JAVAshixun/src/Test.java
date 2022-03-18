
public class Test {

	public static void main(String[] args) {
		LinkList linklist1=new LinkList();
		LinkList linklist2=new LinkList();
		linklist1.addItem(3,0);
		linklist1.addItem(4,2);
		linklist1.addItem(7,5);
		linklist1.addItem(8,12);
		linklist2.addItem(2,1);
		linklist2.addItem(5,2);
		linklist2.addItem(3,5);
		linklist2.addItem(10,15);
		linklist1.printploy();
		System.out.println();
		linklist2.printploy();
		System.out.println();
		LinkList linklist3=linklist1.add(linklist2);
		linklist3.printploy();

	}

}
