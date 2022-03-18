package day03.pm;

public class DataNode {
	private char datachar;
	private int edgenumber;
	private DataNode next;

	public char getDatachar() {
		return datachar;
	}

	public void setDatachar(char datachar) {
		this.datachar = datachar;
	}

	public int getEdgenumber() {
		return edgenumber;
	}

	public void setEdgenumber(int edgenumber) {
		this.edgenumber = edgenumber;
	}

	public DataNode getNext() {
		return next;
	}

	public void setNext(DataNode next) {
		this.next = next;
	}

	public DataNode(char datachar, int edgenumber) {
		this.datachar = datachar;
		this.edgenumber = edgenumber;
		this.next = null;
	}

	public void printDataNode() {
		System.out.print(this.datachar + "(" + this.edgenumber + ")->");
	}

}
