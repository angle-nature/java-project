package dao;

import po.Course;

import java.util.List;

public interface ICourseDao {
    //查询所有课程
    List queryAllCourse();

    //根据课程号、课程名称查询课程信息
    Course queryCourseByIdOrName(String id, String name);
}
