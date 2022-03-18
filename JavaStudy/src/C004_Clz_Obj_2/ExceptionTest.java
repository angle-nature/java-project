package C004_Clz_Obj_2;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * project_name: Java_Ex
 *
 * package_name: C004_Clz_Obj_2 
 *
 * author:  DarlingKe
 *
 * created Time: 2017-12-30 下午12:24:08 
 *
 * version: 1.0 
 *
 * since: JDK 1.7.0_15
 *
 * FileName: ExceptionTest.java  
 *
 * Description:  
 *
 */
public class ExceptionTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args){
		// TODO Auto-generated method stub
		//testException1();
		//testException2();
//		try {
//			testException3();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		testException4();
	}
	
	public static void testException1(){
		int i = 10;
		i = i/0;
		System.out.println("program end");		
	}
	
	public static void testException2(){
		int i = 10;
		try{
			i = i/0;
		}catch (ArithmeticException ae){
			System.out.println("ArithmeticException catching...");
		}		
		System.out.println("program end");	
	}
	
	@SuppressWarnings("resource")
	public static void testException3() throws IOException {
		@SuppressWarnings("unused")
		FileInputStream s;
		s = new FileInputStream("file.txt");
	}
	
	public static void testException4(){
		int a=10,b=-2,c;
		try{
			c=devide(a,b);
			System.out.println(c);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static int devide(int x, int y) throws ArithmeticException,
			DevideByMinusException {
		if (y < 0)
			throw new DevideByMinusException("被除数为负数：", y);
		int result = x / y;
		return result;
	}

}
class DevideByMinusException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5662906591596223193L;
	int devisor;
	public DevideByMinusException(String msg,int devisor){
		super(msg+devisor);
		this.devisor=devisor;
	}
	public int getDevisor(){
		return devisor;
	}
}



 