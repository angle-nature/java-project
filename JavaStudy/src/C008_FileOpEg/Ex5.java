package C008_FileOpEg;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**  

 * Created Time：2013-12-9 下午9:22:58  

 * Project Name：Ex.Proj  

 * @author DarlingKe  

 * @version 1.0   

 * @since JDK 1.7.0_15  

 * FileName：Ex5.java  

 * Description：  

 */
public class Ex5 {

	/**
	
	 * <p>Title: main</p>
	
	 * <p>Description: </p>
	
	 * @param args
	
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=-1;
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        for(int i=1;i<=127;i++){
           out.write(i); 
		}
		ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
		while ((n = in.read()) != -1) {
			System.out.printf("\t字节%d,对应字符\'%c\'", n, (char) n);
			if (n % 2 == 0) {
				System.out.printf("\n");
			}
		}
	}

}
