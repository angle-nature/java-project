package C008_FileOpEg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * Created Time£º2013-12-9 ÏÂÎç9:04:08
 * 
 * Project Name£ºEx.Proj
 * 
 * @author DarlingKe
 * 
 * @version 1.0
 * 
 * @since JDK 1.7.0_15
 * 
 *        FileName£ºEx3.java
 * 
 *        Description£º
 */
public class Ex3 {

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
	@SuppressWarnings({ "resource" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileReader inOne = new FileReader("Student.txt");
			BufferedReader inTwo = new BufferedReader(inOne);
			FileWriter tofile = new FileWriter("hello5.txt");
			BufferedWriter out = new BufferedWriter(tofile);
			String s = null;
			int i = 0;
			while ((s = inTwo.readLine()) != null) {
				i++;
				out.write(i + " " + s);
				out.newLine();
			}
			out.flush();
			out.close();
			tofile.close();
			inOne = new FileReader("hello5.txt");
			inTwo = new BufferedReader(inOne);
			while ((s = inTwo.readLine()) != null) {
				System.out.println(s);
			}
			inOne.close();
			inTwo.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
