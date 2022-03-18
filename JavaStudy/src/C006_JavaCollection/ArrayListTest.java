package C006_JavaCollection;

import java.util.ArrayList;
import java.util.List;

/**
 * project_name: Java_Ex
 *
 * package_name: C006_JavaCollection 
 *
 * author:  DarlingKe
 *
 * created Time: 2017-12-31 ÉÏÎç8:40:03 
 *
 * version: 1.0 
 *
 * since: JDK 1.7.0_15
 *
 * FileName: ArrayListTest.java  
 *
 * Description:  
 *
 */
public class ArrayListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> strList = new ArrayList<String>();
		strList.add("AAAAA");
		strList.add("BBBBB");
		strList.add("CCCCC");
		strList.add("DDDDD");
		strList.add("EEEEE");
		for(String s:strList)
			System.out.println(s);
		
	}

}


 