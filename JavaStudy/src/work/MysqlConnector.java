package work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class MysqlConnector {

    public static void main(String[] args) throws SQLException, ClassNotFoundException{

        Connection con = null;
        Statement statement = null;
        ResultSet rs = null;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/Student";
        String user = "root";
        String password = "<haKch(eM5sl";
        try {
            Class.forName(driver);
            // 使用DriverManager获取连接
            con = DriverManager.getConnection(url,user,password);
            // 创建statement类对象，用来执行SQL语句！！
            statement = con.createStatement();
            //查询语句  查询表中所有数据
            String sql = "select * from information";
            rs = statement.executeQuery(sql); //结果集
            System.out.println("studentId\tname\tmajor\tclass\taverageCredits");  
            
            String id=null;
            String name = null;
            String major=null;
            String Myclass = null;
            String credits=null;
            
            while(rs.next())
            {
                // ResultSet获取返回值时，列名不区分大小写
            	id=rs.getString("studentid");
                name = rs.getString("nAme");
                major=rs.getString(3);  //表中字段从1开始标号
                Myclass = rs.getString("class");
                credits=rs.getString(5);                
                System.out.println(id+"\t\t"+name + "\t" +major+"\t"+ Myclass+"\t"+credits);
            }           
            rs.beforeFirst();  //回到开始位置
            
            //其中 map中的value存储的是  "总分 人数"  最后用总分除以人数即得到平均分
            HashMap<String,String> map1=new HashMap<String,String>(); //存储每个班级的平均学分 
            HashMap<String,String> map2=new HashMap<String,String>(); //存储每个专业的平均学分
            
            String temp[]=new String[2]; //用来接受分割value后的字符串 temp[0]为总分  temp[1]为人数
            
            while(rs.next()) {
            	major=rs.getString(3);  //表中字段从1开始标号
                Myclass = rs.getString("class");
                credits=rs.getString(5);
            	
            	if(!map1.containsKey(Myclass)) //若此前没有包含Myclass
            		map1.put(Myclass,credits+" 1"); 
            	else {   //若map包含键值Key 则调用put(K,V)会覆盖原来的V       		
            		temp=map1.get(Myclass).split(" "); //返回Key值对应的value
            		temp[1]=(Integer.parseInt(temp[1])+1)+"";  //班级人数
            		temp[0]=(Double.parseDouble(credits)+Double.parseDouble(temp[0]))+"";  //班级总分
            		map1.put(Myclass, temp[0]+" "+temp[1]);            		
            	}
            	
            	if(!map2.containsKey(major)) //若此前没有包含major
            		map2.put(major,credits+" 1"); 
            	else {   //若map包含键值Key 则调用put(K,V)会覆盖原来的V       		
            		temp=map2.get(major).split(" ");
            		temp[1]=(Integer.parseInt(temp[1])+1)+"";  //班级人数
            		temp[0]=(Double.parseDouble(credits)+Double.parseDouble(temp[0]))+"";  //班级总分
            		map2.put(major, temp[0]+" "+temp[1]);            		
            	}
            		
            }
            
            double averageCredits;
            java.text.DecimalFormat df=new java.text.DecimalFormat("#.00"); //格式化输出 保留两位小数     
            System.out.println("\n==================\n");
            for(String s:map1.keySet()) {
            	temp=map1.get(s).split(" ");
            	averageCredits=Double.parseDouble(temp[0])/Integer.parseInt(temp[1]);
            	System.out.println(s+"的班级平均分是："+df.format(averageCredits));
            }
            
            for(String s:map2.keySet()) {
            	temp=map2.get(s).split(" ");
            	averageCredits=Double.parseDouble(temp[0])/Integer.parseInt(temp[1]);
            	System.out.println(s+"的专业平均分是："+df.format(averageCredits));
            }
            
            
        }catch(Exception e) {
        	//e.printStackTrace();
        }finally{
        	rs.close();
        	statement.close();
        	con.close();
        }
    }
}
        