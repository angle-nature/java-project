package C008_FileOpEg;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;

/**
 * 
 * Created Time��2013-12-9 ����9:19:53
 * 
 * Project Name��Ex.Proj
 * 
 * @author DarlingKe
 * 
 * @version 1.0
 * 
 * @since JDK 1.7.0_15
 * 
 *        FileName��Ex4.java
 * 
 *        Description��
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
				System.out.printf("\tλ��%d,�ַ�\'%c\'", n, (char) n);
			}
		} catch (IOException e) {
		}
	}

}
