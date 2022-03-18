package work;


public class Employee {
	private String name;
	private double salary;
	private  MyDate hireDay;
	
	public Employee(String n,double s,MyDate day) {
		this.name=n;
		this.salary=s;
		this.hireDay=day;
	}
	
	public boolean equals(Employee e) {
		
		if(this.name==e.name&&this.salary==e.salary&&this.hireDay.equals(e.hireDay))
			return true;
		else
			return false;
	}
		

}
