package dao;

import po.Grade;

import java.util.List;

public interface IGradeDao {
    //查看指定学号的成绩
    List queryGradeByStudentID(String studentID);

    //查看指定学号、指定课程名称的成绩
    Grade queryGradeByStudentIDAndCourseName(String studentID,String courseName);

    //录入成绩
    boolean enterScore(String studentID,String courseID,String teacherID,float examScore,float usualScore);
}
