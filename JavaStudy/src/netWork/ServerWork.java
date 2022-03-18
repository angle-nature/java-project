package netWork;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerWork extends Thread {
	private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private FileInputStream fi;
    private FileReader fr;

    // Ready to conversation
    public ServerWork(Socket s) throws IOException {
        this.socket = s;
        // 构造该会话中的输入输出流
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
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

            fr.close();
            fi.close();
            out.close();
            in.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
