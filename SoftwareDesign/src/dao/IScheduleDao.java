package dao;

import po.Schedule;

import java.util.List;

public interface IScheduleDao {
    //查看所有开设课程信息
    List queryAllSchedule();

    //根据课程名称查询开课信息
    List queryScheduleByCourseID(String courseID);

    //根据参数 courseID，teacherID，time查询课程
    Schedule querySchedule(String courseID,String teacherID,String time);

    //根据courseID or teacherID 查询课程
    List queryScheduleByCourseIDorTeacherID(String courseID,String teacherID);
}