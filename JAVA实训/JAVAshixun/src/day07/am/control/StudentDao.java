package day07.am.control;

import day07.am.model.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentDao implements InterfaceStudent{
    @Override
    public boolean doInsert(Student stu) {
        Connection conn=DBCon.getConnection();
        Statement stat=null;
        String sql="insert into student(sName,sSex,sAge,sMajor) values('"+stu.getsName()+"',"+stu.getsSex()+","+stu.getsAge()+",'"+stu.getsMajor()+"')";
        boolean flag=false;
        try {
            stat=conn.createStatement();
            if(stat.executeUpdate(sql)>0)
                flag=true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return flag;
    }

    @Override
    public Student doSelectBySID(int sID) {
        Connection conn=DBCon.getConnection();
        Statement stat=null;
        ResultSet rs=null;
        Student stu=null;
        String sql="select * from student where sID="+sID;
        try {
            stat=conn.createStatement();
            rs=stat.executeQuery(sql);
            while (rs.next()){
                String sName=rs.getString("sName");
                int sSex=rs.getInt("sSex");
                int sAge=rs.getInt("sAge");
                String sMajor=rs.getString("sMajor");
                stu=new Student(sID,sName,sSex,sAge,sMajor);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return stu;
    }

    @Override
    public ArrayList<Student> doSelectAll() {
        Connection conn=DBCon.getConnection();
        Statement stat=null;
        ResultSet rs=null;
        ArrayList<Student> studentArrayList=new ArrayList<>();
        String sql="select * from student";
        try {
            stat=conn.createStatement();
            rs=stat.executeQuery(sql);
            while (rs.next()){
                int sID=rs.getInt("sID");
                String sName=rs.getString("sName");
                int sSex=rs.getInt("sSex");
                int sAge=rs.getInt("sAge");
                String sMajor=rs.getString("sMajor");
                Student stu=new Student(sID,sName,sSex,sAge,sMajor);
                studentArrayList.add(stu);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return studentArrayList;
    }

    @Override
    public boolean doUpdate(Student stu) {
        Connection conn=DBCon.getConnection();
        Statement stat=null;
        String sql="update student set sName='"+stu.getsName()+"',sSex="+stu.getsSex()+",sAge="+stu.getsAge()+"," +
                "sMajor='"+stu.getsMajor()+"' where sID="+stu.getsID();
        boolean flag=false;
        try {
            stat=conn.createStatement();
            if(stat.executeUpdate(sql)>0)
                flag=true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return flag;
    }

    @Override
    public boolean doDeleteBySID(int sID) {
        Connection conn=DBCon.getConnection();
        Statement stat=null;
        String sql="delete from student where sID="+sID;
        boolean flag=false;
        try {
            stat=conn.createStatement();
            if(stat.executeUpdate(sql)>0)
                flag=true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return flag;
    }

    @Override
    public ArrayList<Student> doDeleteByInputString(String str, String colName) {
        Connection conn=DBCon.getConnection();
        Statement stat=null;
        ResultSet rs=null;
        ArrayList<Student> studentArrayList=new ArrayList<>();
        String sql="select * from student where "+colName+" like '%"+str+"%'";
        try {
            stat=conn.createStatement();
            rs=stat.executeQuery(sql);
            while (rs.next()){
                int sID=rs.getInt("sID");
                String sName=rs.getString("sName");
                int sSex=rs.getInt("sSex");
                int sAge=rs.getInt("sAge");
                String sMajor=rs.getString("sMajor");
                Student stu=new Student(sID,sName,sSex,sAge,sMajor);
                studentArrayList.add(stu);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return studentArrayList;
    }

    @Override
    public ArrayList<Student> doDeleteByInputInt(int inputStr, String colName) {
        Connection conn=DBCon.getConnection();
        Statement stat=null;
        ResultSet rs=null;
        ArrayList<Student> studentArrayList=new ArrayList<>();
        String sql="select * from student where "+colName+"="+inputStr;
        try {
            stat=conn.createStatement();
            rs=stat.executeQuery(sql);
            while (rs.next()){
                int sID=rs.getInt("sID");
                String sName=rs.getString("sName");
                int sSex=rs.getInt("sSex");
                int sAge=rs.getInt("sAge");
                String sMajor=rs.getString("sMajor");
                Student stu=new Student(sID,sName,sSex,sAge,sMajor);
                studentArrayList.add(stu);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return studentArrayList;
    }
}
