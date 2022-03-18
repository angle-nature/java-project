package util;

import java.sql.*;

public class DBUtil {
    private static Connection connection;

    // 获得连接
    public static Connection getCon(){
        //加载驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/softwareDesign?userUnicode=true&characterEncoding=utf-8";
            String userName="root";
            String userPwd="root";
            connection= DriverManager.getConnection(url,userName,userPwd);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    //关闭连接
    public static void closeAll(Connection connection, PreparedStatement pStatement, ResultSet resultSet) {
        try {
            if (connection != null) {
                connection.close();
            }
            if (pStatement != null) {
                pStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

