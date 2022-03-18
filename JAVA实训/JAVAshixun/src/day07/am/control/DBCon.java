package day07.am.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {
    public static Connection getConnection(){
        Connection conn=null;
        String URL="jdbc:mysql://localhost:3306/stuinfo?userUnicode=true&characterEncoding=utf-8";
        String user="root";
        String pwd="root";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection(URL,user,pwd);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
}
