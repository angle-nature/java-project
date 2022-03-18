package shiyan10;

import java.sql.*;

public class LoginCheck {
	
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://127.0.0.1:3306/mydatabase?useSSL=false";
    String Sqluser = "root";
    String Sqlpwd = "<haKch(eM5sl";
    String userName;
    String password;
	
	public LoginCheck(String username,String pwd) {
		this.userName=username;
		this.password=pwd;
		try {
			Class.forName(driver);
	        con = DriverManager.getConnection(url,Sqluser,Sqlpwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean checkUser() { //����û����Ƿ����
        try {            
            //��ѯ���  ��ѯ������������
            String sql = "select ѧ�� from ѧ���� where ѧ��=?";
            pst=con.prepareStatement(sql);
            pst.setString(1, userName);
            rs = pst.executeQuery(); //�����
            if(rs.next())
            	return true;
        }catch(Exception e) {
        	//e.printStackTrace();
        	System.out.println("����ѧ����ʧ�ܣ�");
        }
		return false;
	}
	
	public boolean checkpwd() { //��������Ƿ���ȷ
        try {
            //��ѯ���  ��ѯ������������
            String sql = "select ѧ�� from ѧ���� where ѧ��=? and ��������=?";
            pst=con.prepareStatement(sql);
            pst.setString(1, userName);
            pst.setString(2, password);
            rs = pst.executeQuery(); //�����
            if(rs.next())
            	return true;
        }catch(Exception e) {
        	//e.printStackTrace();
        }finally{
        	try {
				rs.close();
	        	pst.close();
	        	con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		return false;
	}
}
