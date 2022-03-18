package C004_Clz_Obj_2;

import java.util.Arrays;

/**
 * project_name: Java_Ex
 *
 * package_name: C004_Clz_Obj_2 
 *
 * author:  DarlingKe
 *
 * created Time: 2017-12-29 ÉÏÎç9:33:36 
 *
 * version: 1.0 
 *
 * since: JDK 1.7.0_15
 *
 * FileName: EmployeeSortTest.java  
 *
 * Description:  
 *
 */
public class EmployeeSortTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee[] staff = new Employee[3];

	      staff[0] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
	      staff[1] = new Employee("Tommy Tester", 70000, 1990, 3, 15);
	      staff[2] = new Employee("Tony Tester", 39000, 1970, 4, 25);

	      Arrays.sort(staff);

	      // print out information about all Employee objects
	      for (Employee e : staff)
	         System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
	}

}


 