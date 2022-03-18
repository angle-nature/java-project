package dao;

import po.UserInfo;
import service.IUserService;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao implements IUserService {
    private Connection connection=null;
    private PreparedStatement preState=null;
    private ResultSet resultSet=null;

    @Override
    public UserInfo checkUser(String userName, String password) {
        //创建用户对象
        UserInfo user=null;
        String sql="select * from userInfo where userName='"+userName+"' and password='"+password+"'";
//        System.out.println(sql);
        try {
            connection= DBUtil.getCon();
            preState=connection.prepareStatement(sql);
            resultSet=preState.executeQuery();
            if (resultSet.next()){
                user=new UserInfo();
                user.setId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("userName"));
                user.setPassword(resultSet.getString("password"));
                user.setMobilePhone(resultSet.getString("MobilePhone"));
                user.setBirthday(resultSet.getDate("birthday"));
                user.setAddress(resultSet.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection,preState,resultSet);
        }
        return user;
    }

    @Override
    public boolean registerUser(String userName, String password, String mobilePhone, String birthday,String address)
    {
        boolean result=false;
        String querySql="select count(*) from userInfo";
        System.out.println(querySql);
        int id=0;
        connection=DBUtil.getCon();
        try {
            preState=connection.prepareStatement(querySql);
            resultSet=preState.executeQuery();
            if (resultSet.next()){
                id=resultSet.getInt(1)+1;
            }else{
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String insertSql="insert into userInfo values("+id+",'"+userName+"','"+password+"','"+mobilePhone+"',"+birthday+",'"+address+"')";
        System.out.println(insertSql);
        try {
            preState=connection.prepareStatement(insertSql);
            result=preState.executeUpdate()>0?true:false;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection,preState,resultSet);
        }
        return result;
    }
}
