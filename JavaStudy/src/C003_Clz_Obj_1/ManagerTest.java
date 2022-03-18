package C003_Clz_Obj_1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * project_name: Java_Ex
 * 
 * package_name: C003_Clz_Obj_1
 * 
 * author: DarlingKe
 * 
 * created Time: 2017-12-26 ÏÂÎç3:55:35
 * 
 * version: 1.0
 * 
 * since: JDK 1.7.0_15
 * 
 * FileName: ManagerTest.java
 * 
 * Description:
 * 
 */
public class ManagerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// construct a Manager object
		// ManagerTest mg = new ManagerTest();
		Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
		boss.setBonus(5000);

		Employee[] staff = new Employee[3];

		// fill the staff array with Manager and Employee objects

		staff[0] = boss;
		staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		staff[2] = new Employee("Tommy Tester", 40000, 1990, 3, 15);

		// print out information about all Employee objects
		for (Employee e : staff)
			System.out.println("name=" + e.getName() + ",salary="
					+ e.getSalary() + ",hireDay=" + e.getHireDay());
	}

	public static void EqualTest() {

		Employee alice1 = new Employee("Alice Adams", 75000, 1987, 12, 15);
		Employee alice2 = alice1;
		Employee alice3 = new Employee("Alice Adams", 75000, 1987, 12, 15);
		Employee bob = new Employee("Bob Brandson", 50000, 1989, 10, 1);
		System.out.println("alice1 == alice2: " + (alice1 == alice2));
		System.out.println("alice1 == alice3: " + (alice1 == alice3));
		System.out.println("alice1.equals(alice3): " + alice1.equals(alice3));
		System.out.println("alice1.equals(bob): " + alice1.equals(bob));
		System.out.println("bob.toString(): " + bob);
		Manager carl = new Manager("Carl Cracker", 80000, 1987, 12, 15);
		Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
		boss.setBonus(5000);
		System.out.println("boss.toString(): " + boss);
		System.out.println("carl.equals(boss): " + carl.equals(boss));
		System.out.println("alice1.hashCode(): " + alice1.hashCode());
		System.out.println("alice3.hashCode(): " + alice3.hashCode());
		System.out.println("bob.hashCode(): " + bob.hashCode());
		System.out.println("carl.hashCode(): " + carl.hashCode());
	}

}

class Employee implements Cloneable {
	
	public Employee(){
		name = "zhangsan";
		salary = 5000;
		GregorianCalendar calendar = new GregorianCalendar(2018, 5, 1);
		hireDay = calendar.getTime();
	}
	
	public Employee(String n, double s, int year, int month, int day) {
		name = n;
		salary = s;
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
		hireDay = calendar.getTime();
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public String getHireDay() {
		SimpleDateFormat smt = new SimpleDateFormat("yyyy-MM-dd");
		return smt.format(hireDay);
	}

	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}

	public boolean equals(Object otherObject) {
		// a quick test to see if the objects are identical
		if (this == otherObject)
			return true;

		// must return false if the explicit parameter is null
		if (otherObject == null)
			return false;

		// if the classes don't match, they can't be equal
		if (getClass() != otherObject.getClass())
			return false;

		// now we know otherObject is a non-null Employee
		Employee other = (Employee) otherObject;

		// test whether the fields have identical values
		return name.equals(other.name) && salary == other.salary
				&& hireDay.equals(other.hireDay);
	}

	public int hashCode() {
		return 7 * name.hashCode() + 11 * new Double(salary).hashCode() + 13
				* hireDay.hashCode();
	}

	public String toString() {
		return getClass().getName() + "[name=" + name + ",salary=" + salary
				+ ",hireDay=" + hireDay + "]";
	}

	public Employee clone() throws CloneNotSupportedException {
		// call Object.clone()
		Employee cloned = (Employee) super.clone();

		// clone mutable fields
		cloned.hireDay = (Date) hireDay.clone();

		return cloned;
	}

	private String name;
	private double salary;
	private Date hireDay;
}

class Manager extends Employee {
	/**
	 * @param n
	 *            the employee's name
	 * @param s
	 *            the salary
	 * @param year
	 *            the hire year
	 * @param month
	 *            the hire month
	 * @param day
	 *            the hire day
	 */
	public Manager(String n, double s, int year, int month, int day) {
		super(n, s, year, month, day);
		bonus = 0;
	}

	public double getSalary() {
		double baseSalary = super.getSalary();
		return baseSalary + bonus;
	}

	public void setBonus(double b) {
		bonus = b;
	}

	public boolean equals(Object otherObject) {
		if (!super.equals(otherObject))
			return false;
		Manager other = (Manager) otherObject;
		// super.equals checked that this and other belong to the same class
		return bonus == other.bonus;
	}

	public int hashCode() {
		return super.hashCode() + 17 * new Double(bonus).hashCode();
	}

	public String toString() {
		return super.toString() + "[bonus=" + bonus + "]";
	}

	private double bonus;
}
