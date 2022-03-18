package work;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MyText {
	
	public static void main(String[] args) {
		try {
			File file=new File("F:\\java-2020-06\\WorkSpace\\JavaStudy\\src\\work\\Readme.txt");

			FileInputStream fis=new FileInputStream(file);
			byte b[]=new byte[1024];
			fis.read(b, 100, 1024);
			String str=new String(b,0,1024);
			System.out.println(str);
			fis.close();
		}catch(IOException e) {
			
		}
	}

}
