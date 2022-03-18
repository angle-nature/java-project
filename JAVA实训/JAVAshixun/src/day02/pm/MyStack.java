package day02.pm;

public class MyStack {
	private char[] arr;
	private int top;

	public MyStack(int length){
		arr=new char[length];
		top=-1;
	}

	public void push(char ch) {
		if (!isFull())  arr[++top]=ch;
	}

	public char peek() {
		return arr[top];
		
	}

	public char pop() {
		return arr[top--];
	}

	public boolean isEmpty() {
		 
		return top==-1;
	}
	
	public boolean isFull(){
		return top==arr.length-1;
	}
	
}
