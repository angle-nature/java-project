package chap02;

import java.net.*;
import java.io.*;

public class Server extends ServerSocket{

	public ServerSocket os;

	public Server(int serverPort) throws IOException {
//用指定的端口构造一个ServerSocket
        super(serverPort);  
        try {
            while (true) {
//监听一端口，等待客户接入
                Socket socket = accept();  
//将会话交给线程处理
                new ServerThread(socket);  
            }
        } catch (IOException e) {
    e.printStackTrace();
} 
finally {
            close();  //关闭监听端口
        }
    }

    // inner-class ServerThread
    class ServerThread extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;
        private FileInputStream fi;
        private FileReader fr;

        // Ready to conversation
        public ServerThread(Socket s) throws IOException {
            this.socket = s;
    // 构造该会话中的输入输出流
            in = new BufferedReader(new InputStreamReader(
            		socket.getInputStream(), "GB2312"));
             out = new PrintWriter(socket.getOutputStream(), true);
 
            start();
        }
        // Execute conversation
        public void run() {
            try {

                // Communicate with client until "bye" received.
                while (true) {
    // 通过输入流接收客户		       
                    String line = in.readLine();  
                    if ("bye".equals(line)) {  // 是否终止会话
                        break;
                    }
                    if ("BINARY".equals(line)){
                    	fi=new FileInputStream("F:\\java-2020-06\\WorkSpace\\JavaStudy\\src\\netWork\\test.txt");
                    	OutputStream os=socket.getOutputStream();
                    	out = new PrintWriter(os);
                    	int len = 0;
                    	byte[] bytes=new byte[1024]; 
                    	while ((len=fi.read(bytes))!=-1){
                    		os.write(bytes,0,len);
                    	} 
                    }
                    if ("TEXT".equals(line)){
                        fr=new FileReader("F:\\java-2020-06\\WorkSpace\\JavaStudy\\src\\netWork\\test.txt");
                        int leng = 0;
                       char[] ch=new char[1024]; 
                       while ((leng=fr.read(ch))!=-1){
                        	out.println(ch);
                        	out.flush();
                        }
                    }
                    socket.shutdownOutput(); 
       	

                }

    // 通过输出流向客户端发送信息  
 
                fr.close();
                fi.close();
                out.close();
                in.close();
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

		private void write(byte[] bytes, int i, int len) {
			// TODO Auto-generated method stub
		}

    }
    // main method
    public static void main(String[] args) throws IOException {
        new Server(1002);
    }
}
