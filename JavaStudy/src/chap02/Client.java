package chap02;
import java.net.*;
import java.io.*;

public class Client {
	/** 
	 * 客户端程序
	 */


	    private Socket socket;     
	    private BufferedReader reader;
	    private PrintWriter writer;
	    private FileOutputStream fo;
	    private FileWriter fr;

	    public Client(int serverPort) {
	        try {

	    // 向指定服务器(IP、端口)发出请求
	            socket = new Socket("127.0.0.1", serverPort);

	    // 用得到的会话对象构造输入输出流
	            reader = new BufferedReader(
	                    new InputStreamReader(socket.getInputStream()));
	            writer = new PrintWriter(socket.getOutputStream());

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
	                    InputStream is = socket.getInputStream();
	                    fo = new FileOutputStream("F:\\java-2020-06\\WorkSpace\\JavaStudy\\text2.txt");
	                	int len = 0;
	                	byte[] bytes=new byte[1024]; 
	                	while ((len=is.read(bytes))!=-1){
	                		fo.write(bytes,0,len);
	                	}
	                	fo.close();
	                }
	                if ("TEXT".equals(message)){
	                	fr = new FileWriter("F:\\java-2020-06\\WorkSpace\\JavaStudy\\text3.txt");
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
	            socket.close();

	        } catch (UnknownHostException ex) {
	            ex.printStackTrace();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }

	    public static void main(String[] args) {
	        new Client(1002);
	    
	}

}
