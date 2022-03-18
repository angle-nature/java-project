package day01;

public class A {
	int id;
	

	@Override
	protected void finalize() throws Throwable {
		 System.out.println("注销对象："+id);
	}


	public A(int id) {
		super();
		this.id = id;
		 System.out.println("构造对象："+id);
	}


	public void creatobject(int j) {
	   new A(j);
	}

	
	
	
	
}
