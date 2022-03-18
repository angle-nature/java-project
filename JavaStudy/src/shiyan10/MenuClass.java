package shiyan10;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MenuClass {
	private Connection con = null;
    private Statement statement = null;
    private ResultSet rs = null;
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3306/mydatabase?useSSL=false";
    private String Sqluser = "root";
    private String Sqlpwd = "<haKch(eM5sl";
    
    public MenuClass() { //��ʼ��
    	try {
			Class.forName(driver);
	        con = DriverManager.getConnection(url,Sqluser,Sqlpwd);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public void queClass() {  //��ѯ�γ�
    	String sql="Select * from �γ̱�";
    	DefaultTableModel model=new DefaultTableModel();
    	String[] info={"�γ̺�","�γ���"};
    	model.setColumnIdentifiers(info);
    	try {
			statement=con.createStatement();
			rs=statement.executeQuery(sql);			
			
			while(rs.next()) {
				info[0]=rs.getString(1);
				info[1]=rs.getString(2);
				
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

    	JFrame showAllFrame=new JFrame("���пγ���Ϣ");
    	showAllFrame.setBounds(350,250,500,460);
    	showAllFrame.setVisible(true);
    	showAllFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //���رձ�����
    	showAllFrame.add(panel);
    }
    
    public void addOrDelClass() { //��ӻ�ɾ���γ�
    	JFrame addClassFrame=new JFrame("�γ���Ϣ����");
    	JLabel idLabel=new JLabel("�γ̺�");
    	JLabel nameLabel=new JLabel("�γ���");
    	JTextField idText=new JTextField(8);
    	JTextField nameText=new JTextField(8);
    	JButton addButton=new JButton("���");
    	JButton delButton=new JButton("ɾ��");
    	JLabel statusLabel=new JLabel("");
    	   	
    	JPanel panel1=new JPanel();
    	JPanel panel2=new JPanel();
    	JPanel panel3=new JPanel();
    	JPanel panel4=new JPanel();
    	
    	panel1.add(idLabel);
    	panel1.add(idText);
    	panel2.add(nameLabel);
    	panel2.add(nameText);
    	panel3.add(addButton);
    	panel3.add(delButton);
    	panel4.add(statusLabel);
    	
    	addClassFrame.setLayout(new GridLayout(4,1));
    	addClassFrame.setBounds(400,300,300,200);
    	addClassFrame.setVisible(true);
    	addClassFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //���رձ�����
    	
    	addClassFrame.add(panel1);
    	addClassFrame.add(panel2);
    	addClassFrame.add(panel3);
    	addClassFrame.add(panel4);
    	
    	addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "insert into �γ̱� (�γ̺�,�γ���) "
		                + "values ('"+idText.getText()+"','"+nameText.getText()+"')";
				String sql1="select * from �γ̱� where �γ̺�="+idText.getText();
				try {
					statement=con.createStatement();
					rs=statement.executeQuery(sql1);
					if(rs.next()) {
						statusLabel.setText("���д˿γ̺ţ�");
						statusLabel.setForeground(Color.blue);
					}
					else {
						int rows=statement.executeUpdate(sql);
						if(rows>0) {
							statusLabel.setText("��ӳɹ���");
							statusLabel.setForeground(Color.green);
						}
						else {
							statusLabel.setText("���ʧ�ܣ�");
							statusLabel.setForeground(Color.red);
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					try {
						statement.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					addClassFrame.validate();
				}
				
			}
    	});
    	
    	delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="delete from �γ̱� where �γ̺�="+idText.getText()+" OR �γ���='"+nameText.getText()+"'";
				try {
					statement=con.createStatement();
					int rows=statement.executeUpdate(sql);
					if(rows>0) {
						statusLabel.setText("ɾ���ɹ���");
						statusLabel.setForeground(Color.green);
					}
					else {
						statusLabel.setText("ɾ��ʧ�ܣ�");
						statusLabel.setForeground(Color.red);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					try {
						statement.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					addClassFrame.validate();
				}
				
			}
    	});
    }
       
}
