
public  class LinkList {
	Item first;

	public LinkList() {
		first = null;
	}

	public void addItem(double coef, int exp) {
		Item newitem = new Item(coef, exp);
		if (first == null) {
			first = newitem;
		} else {
			Item currentitem = first;
			while (currentitem.getNext() != null) {
				currentitem = currentitem.getNext();
			}
			currentitem.setNext(newitem);
		}
	}

	public LinkList add(LinkList linklist2) {
		LinkList returnlist = new LinkList();
		Item currentitem1 = this.first;
		Item currentitem2 = linklist2.first;
		while (currentitem1 != null && currentitem2 != null) {
			if (currentitem1.getExp() < currentitem2.getExp()) {
				returnlist.addItem(currentitem1.getCoef(), currentitem1.getExp());
				currentitem1 = currentitem1.getNext();
			} else if (currentitem1.getExp() > currentitem2.getExp()) {
				returnlist.addItem(currentitem2.getCoef(), currentitem2.getExp());
				currentitem2 = currentitem2.getNext();
			} else {
				returnlist.addItem(currentitem1.getCoef() + currentitem2.getCoef(), 
						           currentitem1.getExp());
				currentitem1 = currentitem1.getNext();
				currentitem2 = currentitem2.getNext();
			}
		}
		if (currentitem1 != null) {
			while (currentitem1 != null) {
				returnlist.addItem(currentitem1.getCoef(), currentitem1.getExp());
				currentitem1 = currentitem1.getNext();
			}
		} else if (currentitem2 != null) {
			while (currentitem2 != null) {
				returnlist.addItem(currentitem2.getCoef(), currentitem2.getExp());
				currentitem2 = currentitem2.getNext();
			}
		}
		return returnlist;
	}

	public void printploy() {
		Item currentitem = first;
		while (currentitem != null) {
			System.out.print(currentitem.getCoef() + "x^" + currentitem.getExp());
			currentitem = currentitem.getNext();
			if (currentitem != null)
				System.out.print("+");
		}
	}
}
