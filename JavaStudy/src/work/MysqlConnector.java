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
            // ʹ��DriverManager��ȡ����
            con = DriverManager.getConnection(url,user,password);
            // ����statement���������ִ��SQL��䣡��
            statement = con.createStatement();
            //��ѯ���  ��ѯ������������
            String sql = "select * from information";
            rs = statement.executeQuery(sql); //�����
            System.out.println("studentId\tname\tmajor\tclass\taverageCredits");  
            
            String id=null;
            String name = null;
            String major=null;
            String Myclass = null;
            String credits=null;
            
            while(rs.next())
            {
                // ResultSet��ȡ����ֵʱ�����������ִ�Сд
            	id=rs.getString("studentid");
                name = rs.getString("nAme");
                major=rs.getString(3);  //�����ֶδ�1��ʼ���
                Myclass = rs.getString("class");
                credits=rs.getString(5);                
                System.out.println(id+"\t\t"+name + "\t" +major+"\t"+ Myclass+"\t"+credits);
            }           
            rs.beforeFirst();  //�ص���ʼλ��
            
            //���� map�е�value�洢����  "�ܷ� ����"  ������ֳܷ����������õ�ƽ����
            HashMap<String,String> map1=new HashMap<String,String>(); //�洢ÿ���༶��ƽ��ѧ�� 
            HashMap<String,String> map2=new HashMap<String,String>(); //�洢ÿ��רҵ��ƽ��ѧ��
            
            String temp[]=new String[2]; //�������ָܷ�value����ַ��� temp[0]Ϊ�ܷ�  temp[1]Ϊ����
            
            while(rs.next()) {
            	major=rs.getString(3);  //�����ֶδ�1��ʼ���
                Myclass = rs.getString("class");
                credits=rs.getString(5);
            	
            	if(!map1.containsKey(Myclass)) //����ǰû�а���Myclass
            		map1.put(Myclass,credits+" 1"); 
            	else {   //��map������ֵKey �����put(K,V)�Ḳ��ԭ����V       		
            		temp=map1.get(Myclass).split(" "); //����Keyֵ��Ӧ��value
            		temp[1]=(Integer.parseInt(temp[1])+1)+"";  //�༶����
            		temp[0]=(Double.parseDouble(credits)+Double.parseDouble(temp[0]))+"";  //�༶�ܷ�
            		map1.put(Myclass, temp[0]+" "+temp[1]);            		
            	}
            	
            	if(!map2.containsKey(major)) //����ǰû�а���major
            		map2.put(major,credits+" 1"); 
            	else {   //��map������ֵKey �����put(K,V)�Ḳ��ԭ����V       		
            		temp=map2.get(major).split(" ");
            		temp[1]=(Integer.parseInt(temp[1])+1)+"";  //�༶����
            		temp[0]=(Double.parseDouble(credits)+Double.parseDouble(temp[0]))+"";  //�༶�ܷ�
            		map2.put(major, temp[0]+" "+temp[1]);            		
            	}
            		
            }
            
            double averageCredits;
            java.text.DecimalFormat df=new java.text.DecimalFormat("#.00"); //��ʽ����� ������λС��     
            System.out.println("\n==================\n");
            for(String s:map1.keySet()) {
            	temp=map1.get(s).split(" ");
            	averageCredits=Double.parseDouble(temp[0])/Integer.parseInt(temp[1]);
            	System.out.println(s+"�İ༶ƽ�����ǣ�"+df.format(averageCredits));
            }
            
            for(String s:map2.keySet()) {
            	temp=map2.get(s).split(" ");
            	averageCredits=Double.parseDouble(temp[0])/Integer.parseInt(temp[1]);
            	System.out.println(s+"��רҵƽ�����ǣ�"+df.format(averageCredits));
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
        