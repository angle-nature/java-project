package shiyan;

public class Employee {
	private static double baseSalary=3000;
	private String name;
	protected int id;
	
	public Employee(String n,int id) {
		
		this.name=n;
		this.id=id;
	}
	
	public static double getTotalSalary() {
		return 1.5*baseSalary;
	}
}
