package day03.am;

public class LinkList {
	private Node first;
	
	
	public void insert(int data){
		Node newnode =new Node(data);
		if(first==null){
			first=newnode;
		}
		else{
			newnode.setNext(first);
			first=newnode;
		}
	}

	public void displayAll() {
	 Node current =first;
	 while(current!=null){
		 System.out.print(current.getData()+"->");
		 current=current.getNext();
	 }
	 System.out.println();
	}

	public LinkList (){
		first=null;
	}

	public boolean find(int data) {
		boolean f=false;
		 Node current =first;
		 while(current!=null){
			  if(current.getData()==data){
				  f=true;
				  break;
			  }
			 current=current.getNext();
		 }
		return f;
	}

	public void removeFirst(int data) {
		 Node current=first;
		 Node prev=first;
		 
		 while(current.getData()!=data && current!=null){
			 prev=current;
			 current=current.getNext();
		 }
		 if(current==first){
			first=current.getNext(); 
		 }
		 else{
			 prev.setNext(current.getNext());
		 } 		
	}
}
