package C005_String_Regex;

import java.util.Enumeration;
import java.util.Properties;

/**
 * project_name: Java_Ex
 *
 * package_name: C005_String_Regex 
 *
 * author:  DarlingKe
 *
 * created Time: 2017-12-30 ÏÂÎç8:18:56 
 *
 * version: 1.0 
 *
 * since: JDK 1.7.0_15
 *
 * FileName: SystemPropertyDemo.java  
 *
 * Description:  
 *
 */
public class SystemPropertyDemo {

	/**
	 * @param args
	 */
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties p = System.getProperties();
		Enumeration e = p.propertyNames();
		while (e.hasMoreElements()) {
			String key = (String) e.nextElement();
			System.out.println(key + "=" + p.getProperty(key));
		}
	}
}


 