package netWork;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClinet {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Socket s=new Socket("127.0.0.1",10002);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
		PrintWriter writer = new PrintWriter(s.getOutputStream());
		
		try {
        // Communicate with server until "bye" input.
			while (true) {

	            // 接受统标准输入(键盘)输入的信息
	        	BufferedReader in = new BufferedReader(
	                    new InputStreamReader(System.in));
	            String message = in.readLine();
	            // 将信息通过输出流发送给服务器
	            writer.println(message);
	            writer.flush();
	            // 是否终止会话
	            if ("bye".equals(message)) {
	                break;
	            }
	            if ("BINARY".equals(message)){
	                InputStream is = s.getInputStream();
	                FileOutputStream fo = new FileOutputStream("F:\\java-2020-06\\WorkSpace\\JavaStudy\\text2.txt");
	            	int len = 0;
	            	byte[] bytes=new byte[1024]; 
	            	while ((len=is.read(bytes))!=-1){
	            		fo.write(bytes,0,len);
	            	}
	            	fo.close();
	            }
	            if ("TEXT".equals(message)){
	            	FileWriter fr = new FileWriter("F:\\java-2020-06\\WorkSpace\\JavaStudy\\text3.txt");
	            	int leng = 0;
	            	char[] ch=new char[1024]; 
	            	while ((leng=reader.read(ch))!=-1){
	            		fr.write(ch,0,leng);
	            	}
	            	fr.close();
	            }
        }
        
        writer.close();
        reader.close();
        s.close();

		} catch (UnknownHostException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}


