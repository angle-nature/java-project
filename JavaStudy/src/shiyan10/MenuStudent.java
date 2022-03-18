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
    
    public MenuStudent() { //��ʼ��
    	try {
			Class.forName(driver);
	        con = DriverManager.getConnection(url,Sqluser,Sqlpwd);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public void showAll() { //��ʾ����ѧ����Ϣ
    	String sql="Select * from ѧ����";
    	DefaultTableModel model=new DefaultTableModel();
    	String[] info={"ѧ��","����","�Ա�","��������"};
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
    	jscrollpane.setViewportView(table);//������Ҫ
    	table.setRowHeight(35); 
    	JPanel panel=new JPanel();
    	panel.add(jscrollpane);

    	JFrame showAllFrame=new JFrame("����ѧ����Ϣ");
    	showAllFrame.setBounds(350,250,500,460);
    	showAllFrame.setVisible(true);
    	showAllFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //���رձ�����
    	showAllFrame.add(panel);
    }
    
    public void findStu() { //��ѯ������Ϣ
    	
    	JFrame findStuFrame=new JFrame("ѧ����Ϣ��ѯ");
    	findStuFrame.setLayout(new GridLayout(2,1));
   		JButton findButton=new JButton("����");
		JTextField idText=new JTextField(8); //ѧ�������
		JTextField nameText=new JTextField(8); //���������
		idText.setText("");
		nameText.setText("");
		JLabel idLabel=new JLabel("ѧ�ţ�",JLabel.CENTER);
		JLabel nameLabel=new JLabel("������",JLabel.CENTER);
		
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
		findStuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //���رձ�����
    		 		
				
		DefaultTableModel model=new DefaultTableModel();
    	String[] info={"ѧ��","����","�Ա�","��������"};	    	
    	model.setColumnIdentifiers(info);
    			
		findButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="Select * from ѧ����";
				String byID="Select * from ѧ���� where ѧ��="+idText.getText();
				String byName="Select * from ѧ���� where ����='"+nameText.getText()+"'";
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
		    	jscrollpane.setViewportView(table);//������Ҫ
		    	table.setRowHeight(20); 
		    	showPanel.add(jscrollpane);				
				findStuFrame.validate();
			}
		});		
    } 
}
