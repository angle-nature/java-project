package dao;

import po.Student;

public interface IStudentDao {
    //根据输入的账号密码检测登录
    Student checkLogin(String id,String password);

}
