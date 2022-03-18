package shiyan;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class Accept1{

	private Connection con = null;
	private Statement statement = null;
	private ResultSet rs = null;
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/mydatabase?useSSL=false";
    private String Sqluser = "root";
    private String Sqlpwd = "<haKch(eM5sl";
    
    public Accept1() { //³õÊ¼»¯
    	try {
			Class.forName(driver);
	        con = DriverManager.getConnection(url,Sqluser,Sqlpwd);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
	
	public static void main(String args[ ]) {
			System.out.println(1);

	}
}
