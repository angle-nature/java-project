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
			while((s=br.readLine())!=null) { //��file1�е��ַ�������str������
				str[i++]=s;  
			}
			br.close();
			fr.close();
			String tempStr[]=new String[3]; 
			
			for(int j=0;j<i;j++) {
				tempStr=str[j].split(" "); //�ָ�str[j]�ַ���
				switch(tempStr[1]) 
				{
				case "+":	  //+"\n"  ����1�������������ת��Ϊ�ַ����ͣ�������ͻ����룩������2������
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
