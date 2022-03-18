package LMS;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class DBUtils {
    private static Connection con = null;
    private static Statement stat = null;
    private static ResultSet rs = null;
    private static String driver = "oracle.jdbc.OracleDriver";
    private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private static String sqlUser = "LMS";
    private static String SqlPwd = "LMS";

    //建立与数据库的连接
    public DBUtils() {
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
            String querySQL="select RID,Rpassword from reader";
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
            System.out.println("链接读者表失败!");
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
    public static DefaultTableModel getTableData(String sql,String[] headerArr){
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

    //返回图书类别
    public static Vector getCategory(){
        Vector bookCategory=new Vector();
        String sql="select distinct Bcategory from book";
        try {
            stat=con.createStatement();
            rs=stat.executeQuery(sql);
            while(rs.next()){
                bookCategory.add(rs.getString(1));
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
        return bookCategory;
    }

    //返回读者专业
    public static Vector getDept(){
        Vector dept=new Vector();
        String sql="select distinct Rdept from reader";
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

    //借书
    public static boolean insertIntoLendBook(String userID,String bookID,int time){
        boolean result=false;
        Date lendDate=new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String textDate = sdf.format(lendDate);
        String insertSql="insert into BookLend values('"+userID+"','"+bookID+"',to_date('"+textDate+"','yyyy-mm-dd hh24:mi:ss'),"+null+","+String.valueOf(time)+","+"'在借',0)";
        try {
            //图书库存数量和读者可借书数量更新已由数据库触发器完成
            stat=con.createStatement();
            if(stat.executeUpdate(insertSql)==1)
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

    //返回读者剩余可借书数量
    public static int getRLendNumber(String userID){
        int number=0;
        String sql="select RLendNumber from reader where RID='"+userID+"'";
        try {
            stat=con.createStatement();
            rs=stat.executeQuery(sql);
            rs.next();
            number=rs.getInt(1);
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
        return number;
    }

    //还书
    public static boolean returnBook(String userID,String bookID,String ld){
        boolean isReturn=false;
        Date returnDate=new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String textDate = sdf.format(returnDate);
        String[] lendDate=ld.split("\\.");
        String updateLendSql="update bookLend set returnStatus='已还',returnDate= to_date('"+textDate+"','yyyy-mm-dd hh24:mi:ss')"+
                " where RID='"+userID+"' and BID='"+bookID+"' and lendDate=to_date('"+lendDate[0]+"','yyyy-mm-dd hh24:mi:ss')";
        String actulTimeSql="select to_number(returnDate-lendDate),lendTime from bookLend"+
                " where RID='"+userID+"' and BID='"+bookID+"' and lendDate=to_date('"+lendDate[0]+"','yyyy-mm-dd hh24:mi:ss')";
        String calcFine="update bookLend set fine=(to_number(returnDate-lendDate)-lendTime)*2"+
                " where RID='"+userID+"' and BID='"+bookID+"' and lendDate=to_date('"+lendDate[0]+"','yyyy-mm-dd hh24:mi:ss')";
        //图书库存数量和读者可借书数量更新已由数据库触发器完成
        try {
            stat=con.createStatement();
            if(stat.executeUpdate(updateLendSql)==1) //还书 更新归还时间
                isReturn=true;
            rs=stat.executeQuery(actulTimeSql);
            rs.next();
            //如果实际借出时长大于约定时长，则开始计算罚金，计算规则为超出的时长按每天2元算
            if(rs.getInt(1)>rs.getInt(2))
                stat.executeUpdate(calcFine);
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
        return isReturn;
    }

    //返回指定读者信息
    public static String[] returnUserInfo(String userID){
        String[] userInfo=new String[6];
        String sql="select * from reader where RID='"+userID+"'";

        try {
            stat=con.createStatement();
            rs=stat.executeQuery(sql);
            rs.next();
            for (int i=0;i<userInfo.length;i++)
                userInfo[i]=rs.getString(i+1);
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

        return userInfo;
    }

    //修改用户密码
    public static boolean modifyPassword(String userID,String newPassword){
        boolean isModify=false;
        String sql="update reader set Rpassword='"+newPassword+"' where RID='"+userID+"'";
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
