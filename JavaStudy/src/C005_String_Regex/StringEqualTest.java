package C005_String_Regex;
/**
 * project_name: Java_Ex
 *
 * package_name: C005_String_Regex 
 *
 * author:  DarlingKe
 *
 * created Time: 2017-12-30 ÏÂÎç8:46:38 
 *
 * version: 1.0 
 *
 * since: JDK 1.7.0_15
 *
 * FileName: StringEqualTest.java  
 *
 * Description:  
 *
 */
public class StringEqualTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1,s2,s3,s4;	
		s1="How are you";
		s2="How are you";   
		s3=new String(s1);	
		s4=s3;
		System.out.println(s1==s2); 
		System.out.println(s1.equals(s2)); 
		System.out.println(s3==s1); 	//false
		System.out.println(s3.equals(s1)); 
		System.out.println(s4==s3); 
		System.out.println(s4.equals(s3)); 

	}

}


 