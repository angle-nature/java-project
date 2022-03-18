package day03.am;

public class TreeNode {
	private int data;
	private TreeNode leftnode;
	private TreeNode rightnode;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public TreeNode getLeftnode() {
		return leftnode;
	}

	public void setLeftnode(TreeNode leftnode) {
		this.leftnode = leftnode;
	}

	public TreeNode getRightnode() {
		return rightnode;
	}

	public void setRightnode(TreeNode rightnode) {
		this.rightnode = rightnode;
	}

	public TreeNode(int data) {
		super();
		this.data = data;
		leftnode=null;
		rightnode=null;
	}

	public void displaydata(){
		System.out.print(this.data+"  ");
	}
	
}
