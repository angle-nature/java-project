package day02.pm;

public class Test03 {

	public static void main(String[] args) {
		 MyStack myst=new MyStack(5);
		 myst.push('a');
		 myst.push('b');
		 myst.push('c');
		 myst.push('d');
		 myst.push('e');
		//System.out.println(myst.peek());
		while(!myst.isEmpty()){
		System.out.print(myst.pop() +"   ");
		}
	

	}

}
