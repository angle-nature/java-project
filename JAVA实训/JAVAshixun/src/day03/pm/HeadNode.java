package day03.pm;

public class HeadNode {
	private char headchar;
	private DataNode next;

	public char getHeadchar() {
		return headchar;
	}

	public void setHeadchar(char headchar) {
		this.headchar = headchar;
	}

	public DataNode getNext() {
		return next;
	}

	public void setNext(DataNode next) {
		this.next = next;
	}

	public HeadNode(char headchar) {
		this.headchar = headchar;
		this.next = null;
	}

	public void printchar() {
		System.out.print(this.headchar + "->");
	}

}
