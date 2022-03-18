package shiyan10;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MenuStudent{
	
	private Connection con = null;
    private Statement statement = null;
    private ResultSet rs = null;
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3306/mydatabase?useSSL=false";
    private String Sqluser = "root";
    private String Sqlpwd = "<haKch(eM5sl";
    
    public MenuStudent() { //初始化
    	try {
			Class.forName(driver);
	        con = DriverManager.getConnection(url,Sqluser,Sqlpwd);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public void showAll() { //显示所有学生信息
    	String sql="Select * from 学生表";
    	DefaultTableModel model=new DefaultTableModel();
    	String[] info={"学号","姓名","性别","出生年月"};
    	model.setColumnIdentifiers(info);
    	try {
			statement=con.createStatement();
			rs=statement.executeQuery(sql);			
			
			while(rs.next()) {
				info[0]=rs.getString(1);
				info[1]=rs.getString(2);
				info[2]=rs.getString(3);
				info[3]=rs.getString(4);
				
				model.addRow(info);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				statement.close();
				con.close();		
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
    	
    	JTable table=new JTable(model);
    	JScrollPane jscrollpane = new JScrollPane();
    	jscrollpane.setBounds(300, 200, 600, 150);
    	jscrollpane.setViewportView(table);//这句很重要
    	table.setRowHeight(35); 
    	JPanel panel=new JPanel();
    	panel.add(jscrollpane);

    	JFrame showAllFrame=new JFrame("所有学生信息");
    	showAllFrame.setBounds(350,250,500,460);
    	showAllFrame.setVisible(true);
    	showAllFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //仅关闭本窗口
    	showAllFrame.add(panel);
    }
    
    public void findStu() { //查询个人信息
    	
    	JFrame findStuFrame=new JFrame("学生信息查询");
    	findStuFrame.setLayout(new GridLayout(2,1));
   		JButton findButton=new JButton("查找");
		JTextField idText=new JTextField(8); //学号输入框
		JTextField nameText=new JTextField(8); //姓名输入框
		idText.setText("");
		nameText.setText("");
		JLabel idLabel=new JLabel("学号：",JLabel.CENTER);
		JLabel nameLabel=new JLabel("姓名：",JLabel.CENTER);
		
		JPanel showPanel=new JPanel();
		JPanel panel=new JPanel();
		JPanel panel1=new JPanel();
		JPanel panel2=new JPanel();
		
		panel1.add(idLabel);
		panel1.add(idText);
		panel2.add(nameLabel);
		panel2.add(nameText);
		panel.add(panel1);
		panel.add(panel2);
		panel.add(findButton);
		findStuFrame.add(panel);	
		findStuFrame.add(showPanel,JFrame.CENTER_ALIGNMENT);
		
		findStuFrame.setBounds(350,250,500,300);
		findStuFrame.setVisible(true);
		findStuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //仅关闭本窗口
    		 		
				
		DefaultTableModel model=new DefaultTableModel();
    	String[] info={"学号","姓名","性别","出生年月"};	    	
    	model.setColumnIdentifiers(info);
    			
		findButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="Select * from 学生表";
				String byID="Select * from 学生表 where 学号="+idText.getText();
				String byName="Select * from 学生表 where 姓名='"+nameText.getText()+"'";
				showPanel.removeAll();
				try {
					con = DriverManager.getConnection(url,Sqluser,Sqlpwd);
					statement=con.createStatement();
					if(idText.getText()!=null&&idText.getText()!="") {
						 rs=statement.executeQuery(byID);
					}else if(nameText.getText()!=null&&nameText.getText()!="") {
						rs=statement.executeQuery(byName);
					}else {
						 rs = statement.executeQuery(sql);
					}
					
					while(rs.next()) {
						info[0]=rs.getString(1);
						info[1]=rs.getString(2);
						info[2]=rs.getString(3);
						info[3]=rs.getString(4);						
						model.addRow(info);			
					}									
				}catch(Exception e2) {
					e2.printStackTrace();
				}finally {
					try {
						rs.close();
						statement.close();
						con.close();		
					}catch(Exception e3) {
						e3.printStackTrace();
					}
				}				
				JTable table=new JTable(model);
		    	JScrollPane jscrollpane = new JScrollPane();
		    	jscrollpane.setBounds(350, 250,500, 300);
		    	jscrollpane.setViewportView(table);//这句很重要
		    	table.setRowHeight(20); 
		    	showPanel.add(jscrollpane);				
				findStuFrame.validate();
			}
		});		
    } 
}
