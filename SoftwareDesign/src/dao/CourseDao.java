package dao;

import po.Course;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDao implements ICourseDao{
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    @Override
    public List queryAllCourse() {
        List<Course> courses=new ArrayList<>();
        String sql="select * from Course";
        connection= DBUtil.getCon();
        try {
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                String id=resultSet.getString("id");
                String name=resultSet.getString("name");
                int credit=resultSet.getInt("credit");
                String previousId=resultSet.getString("previousId");
                int hour=resultSet.getInt("hour");
                Course course=new Course(id,name,credit,previousId,hour);
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection,preparedStatement,resultSet);
        }
        return courses;
    }

    @Override
    public Course queryCourseByIdOrName(String id,String name) {
        Course course=null;

        String sql="select * from Course where 1=1";
        if(id!=null&&!"".equals(id))
        {
            sql=sql+" and id='"+id+"'";
        }
        if(name!=null&&!"".equals(name)){
            sql=sql+" and name='"+name+"'";
        }

        connection= DBUtil.getCon();
        try {
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            if (resultSet.next()){
                String courseID=resultSet.getString("id");
                String courseName=resultSet.getString("name");
                int credit=resultSet.getInt("credit");
                String previousId=resultSet.getString("previousId");
                int hour=resultSet.getInt("hour");
                course=new Course(courseID,courseName,credit,previousId,hour);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection,preparedStatement,resultSet);
        }
        return course;
    }
}
