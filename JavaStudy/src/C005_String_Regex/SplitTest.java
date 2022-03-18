package C005_String_Regex;
/**
 * project_name: Java_Ex
 *
 * package_name: C005_String_Regex 
 *
 * author:  DarlingKe
 *
 * created Time: 2017-12-30 обнГ9:07:37 
 *
 * version: 1.0 
 *
 * since: JDK 1.7.0_15
 *
 * FileName: SplitTest.java  
 *
 * Description:  
 *
 */
public class SplitTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test1();
	}

	public static void test1(){
		//String[] ts = "192.168.1.1".split(".");
		String[] ts = "192.168.1.1".split("\\.");
		for(String s : ts)
			System.out.println(s);
	}
}


 