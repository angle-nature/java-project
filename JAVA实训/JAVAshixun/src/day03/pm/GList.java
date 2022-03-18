package day03.pm;

public class GList {
	private HeadNode first;

	public HeadNode getFirst() {
		return first;
	}

	public void setFirst(HeadNode first) {
		this.first = first;
	}

	public GList(char headchar) {
		this.first = new HeadNode(headchar);
	}

	public void insert(char datachar, int edgenum) {
		DataNode newdatanode = new DataNode(datachar, edgenum);
		if (first.getNext() != null) {
			newdatanode.setNext(first.getNext());
			first.setNext(newdatanode);
		} else {
			first.setNext(newdatanode);
		}
	}

	public void printGList() {
		this.first.printchar();
		DataNode current = first.getNext();
		while (current != null) {
			current.printDataNode();
			current = current.getNext();
		}
	}

}
