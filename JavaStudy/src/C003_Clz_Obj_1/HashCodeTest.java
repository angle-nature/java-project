package C003_Clz_Obj_1;
/**
 * project_name: Java_Ex
 *
 * package_name: C003_Clz_Obj_1 
 *
 * author:  DarlingKe
 *
 * created Time: 2017-12-26 ÏÂÎç6:27:50 
 *
 * version: 1.0 
 *
 * since: JDK 1.7.0_15
 *
 * FileName: HashCodeTest.java  
 *
 * Description:  
 *
 */
public class HashCodeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Ok"; 
		StringBuffer sb = new StringBuffer(s); 
		System.out.println(s.hashCode() + " " + sb.hashCode()); 

		String t = new String("Ok"); 
		StringBuffer tb = new StringBuffer(t); 
		System.out.println(t.hashCode() + " " + tb.hashCode()); 
	}

}


 