package dao;

import po.Course;
import po.Schedule;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDao implements IScheduleDao{
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    @Override
    public List queryAllSchedule() {
        List<Schedule> schedules=new ArrayList<>();
        String sql="select * from Schedule";
        connection= DBUtil.getCon();
        try {
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                String courseID=resultSet.getString("courseID");
                String teacherID=resultSet.getString("teacherID");
                String classroom=resultSet.getString("classroom");
                String time=resultSet.getString("time");
                int limitation=resultSet.getInt("limitation");
                int selectedNumber=resultSet.getInt("selectedNumber");
                Schedule schedule=new Schedule(courseID,teacherID,classroom,time,limitation,selectedNumber);
                schedules.add(schedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection,preparedStatement,resultSet);
        }
        return schedules;
    }

    @Override
    public List queryScheduleByCourseID(String courseID) {
        List<Schedule> schedules=new ArrayList<>();
        String sql="select * from Schedule where courseID='"+courseID+"'";
        connection= DBUtil.getCon();
        try {
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                String teacherID=resultSet.getString("teacherID");
                String classroom=resultSet.getString("classroom");
                String time=resultSet.getString("time");
                int limitation=resultSet.getInt("limitation");
                int selectedNumber=resultSet.getInt("selectedNumber");
                Schedule schedule=new Schedule(courseID,teacherID,classroom,time,limitation,selectedNumber);
                schedules.add(schedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection,preparedStatement,resultSet);
        }
        return schedules;
    }

    @Override
    public Schedule querySchedule(String courseID, String teacherID, String time) {
        Schedule schedule=null;
        String sql="select * from Schedule where courseID='"+courseID+"' and teacherID='"+teacherID+"' and time='"+time+"'" ;
        connection= DBUtil.getCon();
        try {
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                String classroom=resultSet.getString("classroom");
                int limitation=resultSet.getInt("limitation");
                int selectedNumber=resultSet.getInt("selectedNumber");
                schedule=new Schedule(courseID,teacherID,classroom,time,limitation,selectedNumber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection,preparedStatement,resultSet);
        }
        return schedule;
    }

    @Override
    public List queryScheduleByCourseIDorTeacherID(String courseID, String teacherID) {
        List schedules=new ArrayList();

        String sql="select * from Schedule where 1=1";
        if(courseID!=null&&!"".equals(courseID))
        {
            sql=sql+" and courseID='"+courseID+"'";
        }
        if(teacherID!=null&&!"".equals(teacherID)){
            sql=sql+" and teacherID='"+teacherID+"'";
        }
        connection= DBUtil.getCon();
        try {
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Schedule schedule=new Schedule();
                schedule.setCourseID(resultSet.getString("courseID"));
                schedule.setTeacherID(resultSet.getString("teacherID"));
                schedule.setClassroom(resultSet.getString("classroom"));
                schedule.setTime(resultSet.getString("time"));
                schedule.setLimitation(resultSet.getInt("limitation"));
                schedule.setSelectedNumber(resultSet.getInt("selectedNumber"));
                schedules.add(schedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection,preparedStatement,resultSet);
        }
        return schedules;
    }
}