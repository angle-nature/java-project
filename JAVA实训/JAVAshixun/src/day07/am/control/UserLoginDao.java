package day07.am.control;

import day07.am.model.UserLogin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserLoginDao implements InterfaceUserLogin{
    @Override
    public int doInsert(UserLogin u) {
        return 0;
    }

    @Override
    public boolean doLoginCheck(UserLogin u) {
        Connection conn=DBCon.getConnection();
        Statement stat=null;
        ResultSet rs=null;
        String sql="select userPrivilege,userPwd from userlogin where userName='"+u.getUserName()+"'";
        boolean flag=false;
        try{
            stat=conn.createStatement();
            rs=stat.executeQuery(sql);
            if (rs.next()){
                int userPrg=rs.getInt("userPrivilege");
                String userPwd=rs.getString("userPwd");
                if(userPrg==u.getUserPrivilege()&&userPwd.equals(u.getUserPwd())){
                    flag=true;
                }
            }

        }catch (SQLException e){

        }finally {
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return flag;
    }

    @Override
    public boolean doModifyPwd(UserLogin u) {
        return false;
    }

    @Override
    public ArrayList<UserLogin> doSelectAll() {
        return null;
    }
}
