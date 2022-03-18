package C005_String_Regex;

import java.util.StringTokenizer;

/**
 * project_name: Java_Ex
 *
 * package_name: C005_String_Regex 
 *
 * author:  DarlingKe
 *
 * created Time: 2017-12-30 下午8:58:28 
 *
 * version: 1.0 
 *
 * since: JDK 1.7.0_15
 *
 * FileName: StringTokenizerTest.java  
 *
 * Description:  
 *
 */
public class StringTokenizerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test2();
	}
	
	public static void test1(){
		String testString = "We produce +about two million +dollars for each +hour we +work.";
	    StringTokenizer st = new StringTokenizer(testString, "+");
	    //输出共有几个分隔符
	    System.out.println("countTokens:"+st.countTokens());
	    while(st.hasMoreTokens()){
	        System.out.println(st.nextToken());
	    }
	}

	public static void test2(){
		String testString = "We produce +about two million +dollars for each +hour we +work.";
	    StringTokenizer st = new StringTokenizer(testString, "+",true);
	    //输出共有几个分隔符
	    System.out.println("countTokens:"+st.countTokens());
	    while(st.hasMoreTokens()){
	        System.out.println(st.nextToken());
	    }
	}
}


 