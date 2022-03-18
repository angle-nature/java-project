package C008_FileOpEg;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;

/**
 * 
 * Created Time£º2013-12-9 ÏÂÎç9:19:53
 * 
 * Project Name£ºEx.Proj
 * 
 * @author DarlingKe
 * 
 * @version 1.0
 * 
 * @since JDK 1.7.0_15
 * 
 *        FileName£ºEx4.java
 * 
 *        Description£º
 */
public class Ex4 {

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
		int n = -1;
		CharArrayWriter out = new CharArrayWriter();
		for (int i = 20320; i <= 20520; i++) {
			out.write(i);
		}
		CharArrayReader in = new CharArrayReader(out.toCharArray());
		try {
			while ((n = in.read()) != -1) {
				if (n % 2 == 0) {
					System.out.printf("\n");
				}
				System.out.printf("\tÎ»ÖÃ%d,×Ö·û\'%c\'", n, (char) n);
			}
		} catch (IOException e) {
		}
	}

}
