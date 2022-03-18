package DBS;

import java.sql.*;
public class Trans {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection con=null;
        Statement stat=null;
        try {
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","JXGL","JXGL");

            con.setAutoCommit(false); //设置为手动提交
            stat=con.createStatement();

            //建立Account数据库表sql语句
            String str1="create table Account(AccountID char(6) primary key,Balance number(10,2))";
//            stat.executeUpdate(str1);
            //插入记录sql语句
            String str2="insert into Account values('34001',10000)";
            String str3="insert into Account values('34002',10000)";
//            stat.executeUpdate(str2);
//            stat.executeUpdate(str3);
            //转账sql语句
            String str4="update Account set Balance=Balance-1000 where AccountID='34001'";

            String str5="update Account set Balance=Balance+1000 where AccountID='34002'";
            stat.executeUpdate(str4);
            stat.executeUpdate(str5);
            con.commit();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                con.rollback(); //若出现错误，则执行回滚操作
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }finally{
            if(con!=null){
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(stat!=null) {
                try {
                    stat.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }
    }
}
