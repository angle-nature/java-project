package day03.am;



public class Link {
	private Item first;

	public Item getFirst() {
		return first;
	}

	public void setFirst(Item first) {
		this.first = first;
	}

	public Link() {
		super();
		this.first = null;
	}

	public void addItem(double coef, int exp) {
		 Item newitem=new Item(coef, exp);
		 if(first==null){
			 first=newitem;
		 }
		 else{
			 Item current=first;
			 while(current.getNext()!=null){
				current=current.getNext(); 
			 }
			 current.setNext(newitem);
		 }
		
	}

	public void printPloy() {
		Item current=first;
		while(current!=null){
			System.out.print(current.getCoef()+"x^"+
		                      current.getExp());
			current=current.getNext();
			if(current!=null) System.out.print("+");
		}
		System.out.println();
	}

	public Link add(Link link2) {
		Link returnlink=new Link(); 
		Item currentlink1=this.first;
		Item currentlink2=link2.first; //link2.getFirst()
		
		while(currentlink1!=null && currentlink2!=null){
			if(currentlink1.getExp()<currentlink2.getExp()){
				returnlink.addItem(currentlink1.getCoef(), currentlink1.getExp());
			    currentlink1=currentlink1.getNext();
			}
			else if(currentlink1.getExp()>currentlink2.getExp()){
				returnlink.addItem(currentlink2.getCoef(), currentlink2.getExp());
			    currentlink2=currentlink2.getNext();
			}
			else{
				returnlink.addItem(currentlink1.getCoef()+currentlink2.getCoef(),
						           currentlink1.getExp());
			    currentlink1=currentlink1.getNext();
			    currentlink2=currentlink2.getNext();
			}	
		}
		if(currentlink1!=null){
			while(currentlink1!=null){
				returnlink.addItem(currentlink1.getCoef(), currentlink1.getExp());
			    currentlink1=currentlink1.getNext();
			}
		}
		if(currentlink2!=null){
			while(currentlink2!=null){
				returnlink.addItem(currentlink2.getCoef(), currentlink2.getExp());
			    currentlink2=currentlink2.getNext();
			}
		}
				
		return returnlink;
	}
	
	
	

}
