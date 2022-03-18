package work;

import java.io.*;
class UseStream1
{
	UseStream1(String path){
		  try{
		     File f=new File(path+"\\test1.txt");
		     //向文件test1.txt中写入数据
		     FileWriter outFile=new FileWriter(f);
		     BufferedWriter outB=new BufferedWriter(outFile);
		     String s="你们好，这是一个测试写入数据的文件。";
		     outB.write(s);
		     //插入一行
		     outB.newLine();
		     outB.write("这是利用FileWrite与 BuffereWrite的例题。");
		     //需要调用flush（）方法
		     outB.flush();
		     //写入完毕要关闭流
		     outB.close();
		     //从text.txt中读取数据
		     FileReader inFile=new FileReader(f);
		     BufferedReader inB=new BufferedReader(inFile);
		     /*inB中含有能够直接读取一行数据的方法raesLine()供我们使用，当然返回值null时，意味着读取结束*/
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
