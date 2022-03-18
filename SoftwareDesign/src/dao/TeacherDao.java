package dao;

import po.Teacher;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDao implements ITeacherDao{
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    @Override
    public List queryAllTeacher() {
        List<Teacher> teachers=new ArrayList<>();
        String sql="select * from Teacher";
        connection= DBUtil.getCon();
        try {
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                Teacher teacher=new Teacher();
                teacher.setId(resultSet.getString("id"));
                teacher.setName(resultSet.getString("name"));
                teacher.setOffice(resultSet.getString("office"));
                teacher.setPosition(resultSet.getString("position"));
                teacher.setSex(resultSet.getString("sex"));
                teacher.setMobilePhone(resultSet.getString("mobilePhone"));
                teachers.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection,preparedStatement,resultSet);
        }
        return teachers;
    }

    @Override
    public Teacher queryTeacherByIDorName(String id,String name) {
        Teacher teacher=null;
        String sql="select * from Teacher where 1=1";
        if(id!=null&&!"".equals(id))
        {
            sql=sql+" and id='"+id+"'";
        }
        if(name!=null&&!"".equals(name)){
            sql=sql+" and name='"+name+"'";
        }
        try {
            connection= DBUtil.getCon();
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            if (resultSet.next()){
                teacher=new Teacher();
                teacher.setId(resultSet.getString("id"));
                teacher.setName(resultSet.getString("name"));
                teacher.setOffice(resultSet.getString("office"));
                teacher.setPosition(resultSet.getString("position"));
                teacher.setSex(resultSet.getString("sex"));
                teacher.setMobilePhone(resultSet.getString("mobilePhone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection,preparedStatement,resultSet);
        }
        return teacher;
    }
}
