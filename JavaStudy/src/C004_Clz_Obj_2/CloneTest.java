package C004_Clz_Obj_2;
/**
 * project_name: Java_Ex
 *
 * package_name: C004_Clz_Obj_2 
 *
 * author:  DarlingKe
 *
 * created Time: 2017-12-30 ионГ11:22:29 
 *
 * version: 1.0 
 *
 * since: JDK 1.7.0_15
 *
 * FileName: CloneTest.java  
 *
 * Description:  
 *
 */
public class CloneTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Employee original = new Employee("уехЩ", 50000, 1989, 7, 1);
			//original.setHireDay(2000, 10, 1);
			Employee copy = original.clone();
			copy.raiseSalary(10);
			
			//copy.setHireDay(2002, 11, 31);
			System.out.println("original=" + original);
			System.out.println("copy=" + copy);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}


 