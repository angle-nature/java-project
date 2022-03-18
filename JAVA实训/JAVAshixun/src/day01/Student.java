package day01;

public class Student {
	public static String schoolname;
	public int sid;
	public String sname;
	public int sage;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getSage() {
		return sage;
	}

	public void setSage(int sage) {
		this.sage = sage;
	}

	public Student(int sid, String sname, int sage) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sage = sage;
	}

	void f(){
		System.out.println(this.sname);
	}
	
	public Student(){
		
	}
	
}
