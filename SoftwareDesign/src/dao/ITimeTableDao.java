package dao;

import java.util.List;

public interface ITimeTableDao {
    //选课
    boolean selectCourse(String studentID,String courseID,String teacherID,String classroom,String time);

    //退课
    boolean removeCourse(String studentID,String courseID);

    //查看课表
    List queryTimeTable(String studentID);
}