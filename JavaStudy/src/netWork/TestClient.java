package netWork;

import java.io.*;
import java.io.IOException;
import java.net.Socket;

public class TestClient {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Socket s=new Socket("127.0.0.1",10002);
		PrintWriter pw=new PrintWriter(s.getOutputStream());
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		String message=in.readLine();
		pw.println(message);
		pw.close();
	}
}
