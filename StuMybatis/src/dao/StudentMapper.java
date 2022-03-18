package dao;

import pojo.Student;
import java.util.List;

public interface StudentMapper {
    public List<Student> doSelectAll();
    public Student doSelectByStuID(int stuID);
    public boolean doInsertStudent(Student stu);
    public boolean doModifyStudent(Student stu);
    public boolean doDeleteByStuID(int stuID);
    public List<Student> doSelectByStuName(String stuName);
    public List<Student> doSelectByStuMajor(String stuMajor);
    public List<Student> doSelectByStuAge(int stuAge);
    public List<Student> doSelectByStuSex(int stuSex);
}
