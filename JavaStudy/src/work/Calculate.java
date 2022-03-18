package work;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Calculate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file1=new File("F:\\java-2020-06\\WorkSpace\\JavaStudy\\calculate.txt");
		File file2=new File("F:\\java-2020-06\\WorkSpace\\JavaStudy\\calculate2.txt");
		String str[]=new String[200];
		try {
			FileReader fr=new FileReader(file1);
			BufferedReader br=new BufferedReader(fr);
			FileWriter fw=new FileWriter(file2);
			String s=null;
			int i=0;
			while((s=br.readLine())!=null) { //将file1中的字符串读到str数组中
				str[i++]=s;  
			}
			br.close();
			fr.close();
			String tempStr[]=new String[3]; 
			
			for(int j=0;j<i;j++) {
				tempStr=str[j].split(" "); //分割str[j]字符串
				switch(tempStr[1]) 
				{
				case "+":	  //+"\n"  作用1：将输出的整型转换为字符串型（输出整型会乱码），作用2：换行
					fw.write(Integer.parseInt(tempStr[0])+Integer.parseInt(tempStr[2])+"\n");break;
				case "-":	
					fw.write(Integer.parseInt(tempStr[0])-Integer.parseInt(tempStr[2])+"\n");break;
				case "*":	
					fw.write(Integer.parseInt(tempStr[0])*Integer.parseInt(tempStr[2])+"\n");break;
				case "/":	
					fw.write(Integer.parseInt(tempStr[0])/Integer.parseInt(tempStr[2])+"\n");break;
				case "%":	
					fw.write(Integer.parseInt(tempStr[0])%Integer.parseInt(tempStr[2])+"\n");break;
				}
			}
			fw.close();
			
		}catch(Exception e) {
			
		}
	}

}
