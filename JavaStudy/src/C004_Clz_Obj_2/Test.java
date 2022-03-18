package C004_Clz_Obj_2;

/**
 * project_name: Java_Ex
 *
 * package_name: C004_Clz_Obj_2 
 *
 * author:  DarlingKe
 *
 * created Time: 2017-12-29 上午8:43:43 
 *
 * version: 1.0 
 *
 * since: JDK 1.7.0_15
 *
 * FileName: Test.java  
 *
 * Description:  
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test3();
	}
	
	public static void test1(){
		//Employee[] staff = new Employee[3];
		//staff[0].setBonus(5000); 
		//Manager m = staff[i]; 		
	}
	
	public static void test2(){
		Manager[] managers = new Manager[2]; 
		Employee[] staff = managers; 
		//staff[0] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		staff[0]=new Manager("Carl Cracker", 80000, 1987, 12, 15);
		staff[1]=new Manager("Carl Cracker...", 80000, 1987, 12, 15);
		managers[0].setBonus(1000) ;
		managers[1].setBonus(1000);	
		for (Employee e : staff)
			System.out.println("name=" + e.getName() + ",salary="
					+ e.getSalary() + ",hireDay=" + e.getHireDay());
	}
	
	public static void test3(){//测试上转型对象
		Manager manager = new Manager("Carl Cracker", 80000, 1987, 12, 15);
		Employee employee= manager;
		//employee.setBonus(1);
		System.out.println(manager.getName());
		System.out.println(employee.getName());
	}

}


 