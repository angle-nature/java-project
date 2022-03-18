package netWork;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	
	public static void main(String[] args) throws IOException {
		
		ServerSocket ss=new ServerSocket(10002);
		System.out.println("Server is started...");
		
        try {
            while (true) {
            	//����һ�˿ڣ��ȴ��ͻ�����
                Socket socket = ss.accept();  
                System.out.println("Client is online...");
                //���Ự�����̴߳���
                new ServerWork(socket); 
            }
        } catch (IOException e) {
        	e.printStackTrace();
        } finally{
        	ss.close();
        }
    }		
}