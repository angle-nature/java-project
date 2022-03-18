package dao;

import po.Student;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao implements IStudentDao{
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    @Override
    public Student checkLogin(String id, String password) {
        Student student=null;
        String sql="select * from Student where id='"+id+"' and password='"+password+"'";
        try {
            connection= DBUtil.getCon();
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            if (resultSet.next()){
                student=new Student();
                student.setId(resultSet.getString("id"));
                student.setName(resultSet.getString("name"));
                student.setPassword(resultSet.getString("password"));
                student.setSex(resultSet.getString("sex"));
                student.setBirthday(resultSet.getDate("birthday"));
                student.setNativePlace(resultSet.getString("nativePlace"));
                student.setCurrentAddress(resultSet.getString("currentAddress"));
                student.setMobilePhone(resultSet.getString("mobilePhone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection,preparedStatement,resultSet);
        }
        return student;
    }
}
