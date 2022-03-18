package SCMS;

import java.sql.*;

public class LoginCheck {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String driver = "oracle.jdbc.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String sqluser = "LMS";
    String Sqlpwd = "LMS";
    String userName;
    String password;

    public LoginCheck(String username,String pwd){
        this.userName=username;
        this.password=pwd;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,sqluser,Sqlpwd);
        }catch (ClassNotFoundException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (SQLException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public boolean checkUser(){//检查用户名是否存在
        try {
            //查询语句查询表中所有数据
            String sql = "select学号 from学生表 where学号=?";
            pst=con.prepareStatement(sql);
            pst.setString(1,userName);
            rs = pst.executeQuery();//结果集
            if(rs.next())
                return true;
            }catch(Exception e) {
                e.printStackTrace();
            System.out.println("链接学生表失败!");
        }
        return false;
    }

    public boolean checkpwd(){//检查密码是否正确
        try {
            //查询语句查询表中所有数据
            String sql = "select学号from学生表 where学号=? and 出生年月=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, userName);
            pst.setString(2, password);
            rs = pst.executeQuery();//结果集
            if (rs.next())
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pst.close();
                con.close();
            } catch (SQLException e) {
                //TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return false;
    }
}
