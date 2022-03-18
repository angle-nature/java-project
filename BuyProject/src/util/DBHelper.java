package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBHelper {
	public static Connection getConn(){
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/liu";
			String username="lzx";
			String password="1";
		   // conn=DriverManager.getConnection(url,username,password);
			conn=DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
		
	}
	/**
	 * �ر�������Դ
	 */
	public static void closeAll(Connection con,PreparedStatement pst,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(pst!=null){
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
	}
	public static void main(String[]args) {
		try {
			Connection conn=DBHelper.getConn();
			if(conn!=null)
			{
				System.out.println("���ݿ�����������");
			}
			else
			{
				System.out.println("���ݿ������쳣��");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
		
	}
}
