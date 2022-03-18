package C006_JavaCollection;

import java.util.HashMap;
import java.util.Map;

/**
 * project_name: Java_Ex
 *
 * package_name: C006_JavaCollection 
 *
 * author:  DarlingKe
 *
 * created Time: 2017-12-31 ÉÏÎç9:40:28 
 *
 * version: 1.0 
 *
 * since: JDK 1.7.0_15
 *
 * FileName: HashMapTest.java  
 *
 * Description: This program demonstrates the use of a map with key type
 * String and value type Employee.
 *
 */
public class HashMapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Employee> staff = new HashMap<String, Employee>();
	      staff.put("144-25-5464", new Employee("Amy Lee"));
	      staff.put("567-24-2546", new Employee("Harry Hacker"));
	      staff.put("157-62-7935", new Employee("Gary Cooper"));
	      staff.put("456-62-5527", new Employee("Francesca Cruz"));

	      // print all entries

	      System.out.println(staff.toString());

	      // remove an entry

	      staff.remove("567-24-2546");

	      // replace an entry

	      staff.put("456-62-5527", new Employee("Francesca Miller"));

	      // look up a value

	      System.out.println(staff.get("157-62-7935"));

	      // iterate through all entries

	      for (Map.Entry<String, Employee> entry : staff.entrySet())
	      {  
	         String key = entry.getKey();
	         Employee value = entry.getValue();
	         System.out.println("key=" + key + ", value=" + value);
	      }
	}

}

/**
A minimalist employee class for testing purposes.
*/
class Employee
{ 
/**
   Constructs an employee with $0 salary.
   @param n the employee name
*/
public Employee(String n)
{  
   name = n;
   salary = 0;
}

public String toString()
{  
   return "[name=" + name + ", salary=" + salary + "]";
}

private String name;
private double salary;
}


 