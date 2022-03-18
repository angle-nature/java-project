package SIMS;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class DBOperator {
    private static Connection con = null;
    private static Statement stat = null;
    private static ResultSet rs = null;
    private static String driver = "oracle.jdbc.OracleDriver";
    private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private static String sqlUser = "STUDENT";
    private static String SqlPwd = "STUDENT";

    //建立与数据库的连接
    public DBOperator() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,sqlUser,SqlPwd);
        }catch (ClassNotFoundException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (SQLException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //检查登录是否正确
    public static int checkLogin(String userName,String password){
        String administrator="admin";
        if(userName.equals(administrator))//进入管理员界面
            if(password.equals(administrator))
                return 0; //管理员登录成功
            else
                return 1; //管理员密码错误
        try {
            //查询语句查询表中所有数据
            String querySQL="select stuID,password from student";
            stat=con.createStatement();
            rs=stat.executeQuery(querySQL);
            while(rs.next()){
                if(rs.getString(1).strip().equals(userName)){
                    if(rs.getString(2).strip().equals(password))
                        return 2; //普通用户登录成功
                    else
                        return 3; //普通用户密码错误
                }
            }
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("链接学生表失败!");
        }finally{
            try {
                rs.close();
                stat.close();
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return -1; //用户名错误
    }

    //返回表格数据
    public static DefaultTableModel getTableData(String sql, String[] headerArr){
        DefaultTableModel model=null;
        Vector header=new Vector();
        for(int i=0;i<headerArr.length;i++)
            header.add(headerArr[i]);
        Vector column=null; //表头
        Vector newRow=new Vector();
        try {
            stat=con.createStatement();
            rs=stat.executeQuery(sql);
            while(rs.next()){
                column=new Vector();
                for(int j=0;j<headerArr.length;j++)
                    column.add(rs.getString(j+1));
                newRow.add(column);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                rs.close();
                stat.close();
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        model=new DefaultTableModel(newRow,header);
        return model;
    }

    //返回学生专业类别
    public static Vector getDept(){
        Vector dept=new Vector();
        String sql="select distinct dept from student";
        try {
            stat=con.createStatement();
            rs=stat.executeQuery(sql);
            while(rs.next()){
                dept.add(rs.getString(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                rs.close();
                stat.close();
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return dept;
    }

    //返回课程的开课院系
    public static Vector getCollege(){
        Vector college=new Vector();
        String sql="select distinct college from course";
        try {
            stat=con.createStatement();
            rs=stat.executeQuery(sql);
            while(rs.next()){
                college.add(rs.getString(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                rs.close();
                stat.close();
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return college;
    }

    //返回指定学生信息
    public static String[] getStuInfo(String stuID){
        String[] stuInfo=new String[7];
        String sql="select * from student where stuID='"+stuID+"'";

        try {
            stat=con.createStatement();
            rs=stat.executeQuery(sql);
            rs.next();
            for (int i=0;i<stuInfo.length;i++)
                stuInfo[i]=rs.getString(i+1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                rs.close();
                stat.close();
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return stuInfo;
    }

    //返回某个学生的平均成绩
    public static String getAvgScore(String stuID){
        String avgScore=null;
        String sql="select avg(score) from score group by stuID having stuID='"+stuID+"'";
        try {
            stat=con.createStatement();
            rs=stat.executeQuery(sql);
            rs.next();
            avgScore=rs.getString(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                rs.close();
                stat.close();
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return avgScore;
    }

    //判断学号是否已经存在
    public boolean isExistStuID(String stuID){
        boolean isExist=false;
        String sql="select * from student where stuID='"+stuID+"'";

        try {
            stat=con.createStatement();
            rs=stat.executeQuery(sql);
            if(rs.isBeforeFirst())
                isExist=true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                rs.close();
                stat.close();
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return isExist;
    }

    //判断课程是否已经存在
    public boolean isExistCourseID(String courseID){
        boolean isExist=false;
        String sql="select * from course where courseID='"+courseID+"'";

        try {
            stat=con.createStatement();
            rs=stat.executeQuery(sql);
            if(rs.isBeforeFirst())
                isExist=true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                rs.close();
                stat.close();
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return isExist;
    }

    //修改学生密码
    public static boolean modifyPassword(String stuID,String newPassword){
        boolean isModify=false;
        String sql="update student set password='"+newPassword+"' where stuID='"+stuID+"'";
        try {
            stat=con.createStatement();
            if(stat.executeUpdate(sql)==1)
                isModify=true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                stat.close();
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return isModify;
    }

    //执行 插入/删除/修改 语句
    public static boolean executeUpdateSql(String updateSql){
        boolean result=false;
        try {
            stat=con.createStatement();
            if (stat.executeUpdate(updateSql)==1)
                result=true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                stat.close();
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return result;
    }
}
