package work;

import java.io.*;
class ReadPic{
 //*此程序将当前目录下的run.gif文件复制到copyrun.gif中
	ReadPic(){
		try{
		    File f=new File("run.gif");
		    File f1=new File("copyrun.gif");
		    FileInputStream inFile=new FileInputStream(f);
		    BufferedInputStream inB=new BufferedInputStream(inFile);
		    FileOutputStream outFile=new FileOutputStream(f1);
		    BufferedOutputStream outB=new BufferedOutputStream(outFile);
		    
		    byte[] b=new byte[(int)f.length()];
		    while((inB.read(b))!=-1) {
		                    
		    }
		    outB.flush();
		    inB.close();
		    outB.close();
		 }catch(Exception e) {e.printStackTrace();}
 	}
	
		public static void main(String args[ ]) {
			new ReadPic();
		}
}
 