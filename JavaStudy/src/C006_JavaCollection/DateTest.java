package C006_JavaCollection;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * project_name: Java_Ex
 *
 * package_name: C006_JavaCollection 
 *
 * author:  DarlingKe
 *
 * created Time: 2017-12-31 上午7:26:42 
 *
 * version: 1.0 
 *
 * since: JDK 1.7.0_15
 *
 * FileName: DateTest.java  
 *
 * Description:  
 *
 */
public class DateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test1();
	}
	
	public static void test1(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy年mm月dd日 hh时mm分ss秒");
		Date d=new Date();
		System.out.println(sdf.format(d));
		long t = System.currentTimeMillis();
		Date d2=new Date(t);
		System.out.println(sdf2.format(d2));
	}

}


 