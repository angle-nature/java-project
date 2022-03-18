package C008_FileOpEg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**  

 * Created Time£º2013-12-9 ÏÂÎç8:27:09  

 * Project Name£ºEx.Proj  

 * @author DarlingKe  

 * @version 1.0   

 * @since JDK 1.7.0_15  

 * FileName£ºEx1.java  

 * Description£º  

 */
public class Ex1 {

	/**
	
	 * <p>Title: main</p>
	
	 * <p>Description: </p>
	
	 * @param args
	
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file=new File("hello.txt");
        byte b[]="»¶aÓ­welcome".getBytes();
        try{  
			FileOutputStream out = new FileOutputStream(file);
			out.write(b);
			out.close();
			FileInputStream in = new FileInputStream(file);
			int n = 0;
			while ((n = in.read(b, 0, 2)) != -1) {
				String str = new String(b, 0, n);
				System.out.println(str);
			}
        }
        catch(IOException e){
             System.out.println(e);
        }  
	}

}
