package dao;

import po.TimeTable;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TimeTableDao implements ITimeTableDao{
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    @Override
    public boolean selectCourse(String studentID, String courseID, String teacherID, String classroom, String time) {
        boolean result=false;
        String sql="insert into TimeTable value('"+studentID+"','"+courseID+"','"+teacherID+"','"+classroom+"','"+time+"')";
        connection= DBUtil.getCon();
        try {
            preparedStatement=connection.prepareStatement(sql);
            result=preparedStatement.executeUpdate()>0?true:false;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection,preparedStatement,resultSet);
        }
        return result;
    }

    @Override
    public boolean removeCourse(String studentID, String courseID) {
        boolean result=false;
        String sql="delete from TimeTable where studentID='"+studentID+"' and courseID='"+courseID+"'";
        connection=DBUtil.getCon();
        try {
            preparedStatement=connection.prepareStatement(sql);
            result=preparedStatement.executeUpdate()>0?true:false;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection,preparedStatement,resultSet);
        }
        return result;
    }

    @Override
    public List queryTimeTable(String studentID) {
        List<TimeTable> timeTables=new ArrayList<>();
        String sql="select * from TimeTable where studentID='"+studentID+"'";
        connection= DBUtil.getCon();
        try {
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                TimeTable timeTable=new TimeTable();
                timeTable.setStudentID(studentID);
                timeTable.setCourseID(resultSet.getString("courseID"));
                timeTable.setTeacherID(resultSet.getString("teacherID"));
                timeTable.setClassroom(resultSet.getString("classroom"));
                timeTable.setTime(resultSet.getString("time"));
                timeTables.add(timeTable);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection,preparedStatement,resultSet);
        }
        return timeTables;
    }
}
