package day07.am.control;

import day07.am.model.Student;

import java.util.ArrayList;

public interface InterfaceStudent {
    public boolean doInsert(Student stu);
    public Student doSelectBySID(int sID);
    public ArrayList<Student> doSelectAll();
    public boolean doUpdate(Student stu);
    public boolean doDeleteBySID(int sID);
    public ArrayList<Student> doDeleteByInputString(String str,String colName);
    public ArrayList<Student> doDeleteByInputInt(int inputStr,String colName);

}
