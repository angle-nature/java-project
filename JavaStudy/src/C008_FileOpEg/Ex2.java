package C008_FileOpEg;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * Created Time：2013-12-9 下午8:36:40
 * 
 * Project Name：Ex.Proj
 * 
 * @author DarlingKe
 * 
 * @version 1.0
 * 
 * @since JDK 1.7.0_15
 * 
 *        FileName：Ex2.java
 * 
 *        Description：
 */
public class Ex2 {

	/**
	 * 
	 * <p>
	 * Title: main
	 * </p>
	 * 
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("hello2.txt");
		char b[] = "欢迎welcome".toCharArray();
		System.out.println(b.length);
		try {
			FileWriter out = new FileWriter(file);
			out.write(b);
			out.write("来到北京!");
			out.close();
			FileReader in = new FileReader(file);
			int n = 0;
			while ((n = in.read(b, 0, 2)) != -1) {
				String str = new String(b, 0, n);
				System.out.println(str);
			}
			in.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
