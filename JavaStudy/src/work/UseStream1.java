package work;

import java.io.*;
class UseStream1
{
	UseStream1(String path){
		  try{
		     File f=new File(path+"\\test1.txt");
		     //���ļ�test1.txt��д������
		     FileWriter outFile=new FileWriter(f);
		     BufferedWriter outB=new BufferedWriter(outFile);
		     String s="���Ǻã�����һ������д�����ݵ��ļ���";
		     outB.write(s);
		     //����һ��
		     outB.newLine();
		     outB.write("��������FileWrite�� BuffereWrite�����⡣");
		     //��Ҫ����flush��������
		     outB.flush();
		     //д�����Ҫ�ر���
		     outB.close();
		     //��text.txt�ж�ȡ����
		     FileReader inFile=new FileReader(f);
		     BufferedReader inB=new BufferedReader(inFile);
		     /*inB�к����ܹ�ֱ�Ӷ�ȡһ�����ݵķ���raesLine()������ʹ�ã���Ȼ����ֵnullʱ����ζ�Ŷ�ȡ����*/
		     String fileContent="",str="";
		     while((fileContent=inB.readLine())!=null) {
		    	 str=str+fileContent+"\n";
		     }
		     System.out.println(str);
		     inB.close();
		  }catch(Exception e){e.printStackTrace();}
	}
	
	public static void main(String args[ ]) {
		new UseStream1("F:\\java-2020-06\\WorkSpace\\JavaStudy");
   }
}
