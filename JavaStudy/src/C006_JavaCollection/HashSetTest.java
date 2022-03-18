package C006_JavaCollection;

import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * project_name: Java_Ex
 * 
 * package_name: C006_JavaCollection
 * 
 * author: DarlingKe
 * 
 * created Time: 2017-12-31 ÉÏÎç9:38:09
 * 
 * version: 1.0
 * 
 * since: JDK 1.7.0_15
 * 
 * FileName: HashSetTest.java
 * 
 * Description:
 * 
 */
public class HashSetTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> words = new HashSet<String>();
		long totalTime = 0;

		Scanner in = new Scanner("");
		ClassLoader cl = HashSetTest.class.getClassLoader();
		try {
			in = new Scanner(new InputStreamReader(
					cl.getResourceAsStream("alice30.txt")));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("File not Found.");
		}
		while (in.hasNext()) {
			String word = in.next();
			long callTime = System.currentTimeMillis();
			words.add(word);
			callTime = System.currentTimeMillis() - callTime;
			totalTime += callTime;
		}

		Iterator<String> iter = words.iterator();
		for (int i = 1; i <= 20; i++)
			System.out.println(iter.next());
		System.out.println(". . .");
		System.out.println(words.size() + " distinct words. " + totalTime
				+ " milliseconds.");

	}

}
