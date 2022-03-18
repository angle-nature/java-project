package chap02;
import java.net.*;
import java.io.*;

public class Client {
	/** 
	 * �ͻ��˳���
	 */


	    private Socket socket;     
	    private BufferedReader reader;
	    private PrintWriter writer;
	    private FileOutputStream fo;
	    private FileWriter fr;

	    public Client(int serverPort) {
	        try {

	    // ��ָ��������(IP���˿�)��������
	            socket = new Socket("127.0.0.1", serverPort);

	    // �õõ��ĻỰ���������������
	            reader = new BufferedReader(
	                    new InputStreamReader(socket.getInputStream()));
	            writer = new PrintWriter(socket.getOutputStream());

	            // Communicate with server until "bye" input.
	            while (true) {

	                // ����ͳ��׼����(����)�������Ϣ
	BufferedReader in = new BufferedReader(
	                        new InputStreamReader(System.in));
	                String message = in.readLine();
	                // ����Ϣͨ����������͸�������
	writer.println(message);
	                writer.flush();
	// �Ƿ���ֹ�Ự
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
