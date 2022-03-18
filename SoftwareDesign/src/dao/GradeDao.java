package dao;

import po.Grade;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradeDao implements IGradeDao{
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    @Override
    public List queryGradeByStudentID(String studentID) {
        List<Grade> grades=new ArrayList<>();
        String sql="select * from Grade where studentID='"+studentID+"'";
        connection= DBUtil.getCon();
        try {
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                String courseID=resultSet.getString("courseID");
                String teacherID=resultSet.getString("teacherID");
                float examScore=resultSet.getFloat("examScore");
                float usualScore=resultSet.getFloat("usualScore");
                float totalScore=resultSet.getFloat("totalScore");
                Grade grade=new Grade(studentID,courseID,teacherID,examScore,usualScore,totalScore);
                grades.add(grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection,preparedStatement,resultSet);
        }
        return grades;
    }

    @Override
    public Grade queryGradeByStudentIDAndCourseName(String studentID, String courseID) {
        Grade grade=null;
        String sql="select * from Grade where studentID='"+studentID+"' and courseID='"+courseID+"'";
        connection= DBUtil.getCon();
        try {
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            if (resultSet.next()){
                String teacherID=resultSet.getString("teacherID");
                float examScore=resultSet.getFloat("examScore");
                float usualScore=resultSet.getFloat("usualScore");
                float totalScore=resultSet.getFloat("totalScore");
                grade=new Grade(studentID,courseID,teacherID,examScore,usualScore,totalScore);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection,preparedStatement,resultSet);
        }
        return grade;
    }

    @Override
    public boolean enterScore(String studentID, String courseID, String teacherID,float examScore,float usualScore) {
        boolean result=false;
        double totalScore=0.5*examScore+0.5*usualScore;
        String sql="insert into Grade value('"+studentID+"','"+courseID+"','"+teacherID+"','"+examScore+"','"+usualScore+"','"+totalScore+"')";
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
}
