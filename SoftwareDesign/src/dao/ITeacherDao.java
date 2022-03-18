package dao;

import po.Teacher;

import java.util.List;

public interface ITeacherDao {
    List queryAllTeacher();

    //根据老师工号或姓名查询老师信息
    Teacher queryTeacherByIDorName(String id,String name);
}
