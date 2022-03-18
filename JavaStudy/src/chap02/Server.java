package chap02;

import java.net.*;
import java.io.*;

public class Server extends ServerSocket{

	public ServerSocket os;

	public Server(int serverPort) throws IOException {
//��ָ���Ķ˿ڹ���һ��ServerSocket
        super(serverPort);  
        try {
            while (true) {
//����һ�˿ڣ��ȴ��ͻ�����
                Socket socket = accept();  
//���Ự�����̴߳���
                new ServerThread(socket);  
            }
        } catch (IOException e) {
    e.printStackTrace();
} 
finally {
            close();  //�رռ����˿�
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
    // ����ûỰ�е����������
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
    // ͨ�����������տͻ�		       
                    String line = in.readLine();  
                    if ("bye".equals(line)) {  // �Ƿ���ֹ�Ự
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

    // ͨ���������ͻ��˷�����Ϣ  
 
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
