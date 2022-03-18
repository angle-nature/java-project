package shiyan10;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.*;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.RangeType;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;

public class MenuGrade {
	
	private Connection con = null;
	private Statement statement = null;
	private ResultSet rs = null;
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/mydatabase?useSSL=false";
    private String Sqluser = "root";
    private String Sqlpwd = "<haKch(eM5sl";
    
    public MenuGrade() { //��ʼ��
    	try {
			Class.forName(driver);
	        con = DriverManager.getConnection(url,Sqluser,Sqlpwd);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
	public void queGrade() { //��ѯ�ɼ�
		
		JFrame putInFrame=new JFrame();
		JLabel idLabel=new JLabel("������ѧ��");
		JTextField idText=new JTextField(8);
		JButton findButton=new JButton("��ѯ");
		JPanel panel1=new JPanel();
		JPanel panel2=new JPanel();
		
		panel1.add(idLabel);
		panel1.add(idText);
		panel2.add(findButton);
		
		putInFrame.setBounds(350,250,220,120);
		putInFrame.setVisible(true);
		putInFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //���رձ�����
		putInFrame.setLayout(new GridLayout(2,1));
		putInFrame.add(panel1);
		putInFrame.add(panel2);
		
		findButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="Select * from �ɼ��� where ѧ��="+idText.getText();
		    	DefaultTableModel model=new DefaultTableModel();
		    	String[] info={"ѧ��","�γ̺�","�ɼ�"};
		    	model.setColumnIdentifiers(info);
		    	try {
					statement=con.createStatement();
					rs=statement.executeQuery(sql);			
					
					while(rs.next()) {
						info[0]=rs.getString(1);
						info[1]=rs.getString(2);
						info[2]=rs.getString(3);
						model.addRow(info);				
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					try {
						rs.close();
						statement.close();
						con.close();		
					}catch(Exception e2) {
						e2.printStackTrace();
					}
				}
		    	
		    	putInFrame.dispose();
		    	
		    	JTable table=new JTable(model);
		    	JScrollPane jscrollpane = new JScrollPane();
		    	jscrollpane.setBounds(300, 200, 300, 160);
		    	jscrollpane.setViewportView(table);//������Ҫ
		    	table.setRowHeight(35); 
		    	JPanel panel=new JPanel();
		    	panel.add(jscrollpane);

		    	JFrame showAllFrame=new JFrame(idText.getText()+"�ĳɼ���");
		    	showAllFrame.setBounds(350,250,480,320);
		    	showAllFrame.setVisible(true);
		    	showAllFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //���رձ�����
		    	showAllFrame.add(panel);
			}
		});						
		
	}
	
	public void addOrModifyGrade() { //¼��ɼ�
		JFrame addClassFrame=new JFrame("¼��ɼ�");
    	JLabel idLabel=new JLabel("ѧ��");
    	JLabel classidLabel=new JLabel("�γ̺�");
    	JLabel gradeLabel=new JLabel("�ɼ�");
    	JTextField idText=new JTextField(8);
    	JTextField classidText=new JTextField(8);
    	JTextField gradeText=new JTextField(8);
    	JButton addButton=new JButton("¼��");
    	JButton modifyButton=new JButton("�޸�");
    	JLabel statusLabel=new JLabel("");
    	   	
    	JPanel panel1=new JPanel();
    	JPanel panel2=new JPanel();
    	JPanel panel3=new JPanel();
    	JPanel panel4=new JPanel();
    	JPanel panel5=new JPanel();
    	
    	panel1.add(idLabel);
    	panel1.add(idText);
    	panel2.add(classidLabel);
    	panel2.add(classidText);
    	panel3.add(gradeLabel);
    	panel3.add(gradeText);
    	panel4.add(addButton);
    	panel4.add(modifyButton);
    	panel5.add(statusLabel);
    	
    	addClassFrame.setLayout(new GridLayout(5,1));
    	addClassFrame.setBounds(400,300,300,200);
    	addClassFrame.setVisible(true);
    	addClassFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //���رձ�����
    	
    	addClassFrame.add(panel1);
    	addClassFrame.add(panel2);
    	addClassFrame.add(panel3);
    	addClassFrame.add(panel4);
    	addClassFrame.add(panel5);
    	
    	addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "insert into �ɼ��� (ѧ��,�γ̺�,�ɼ�) "
		                + "values ('"+idText.getText()+"','"+classidText.getText()+"','"+gradeText.getText()+"')";
				String sql1="select * from �ɼ��� where ѧ��="+idText.getText()+" and �γ̺�="+classidText.getText();
				try {
					statement=con.createStatement();
					rs=statement.executeQuery(sql1);
					if(rs.next()) {
						statusLabel.setText(idText.getText()+"���д˿γ̺ţ�");
						statusLabel.setForeground(Color.blue);
					}
					else {
						int rows=statement.executeUpdate(sql);
						if(rows>0) {
							statusLabel.setText("¼��ɹ���");
							statusLabel.setForeground(Color.green);
						}
						else {
							statusLabel.setText("¼��ʧ�ܣ�");
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
    	
    	modifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="update �ɼ��� set �ɼ�="+gradeText.getText()+" where ѧ��="
						+idText.getText()+" and �γ̺�="+classidText.getText();
				try {
					statement=con.createStatement();
					int rows=statement.executeUpdate(sql);
					if(rows>0) {
						statusLabel.setText("�޸ĳɹ���");
						statusLabel.setForeground(Color.green);
					}
					else {
						statusLabel.setText("�޸�ʧ�ܣ�");
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
	
	public void average() { //��ƽ���ɼ�
		JFrame acerageFrame=new JFrame("ƽ���ɼ�");
		JLabel idLabel=new JLabel("������ѧ��");
		JTextField idText=new JTextField(8);
		JButton findButton=new JButton("��ѯ");
		JLabel averageLabel=new JLabel("");
		
		JPanel panel1=new JPanel();
		JPanel panel2=new JPanel();
		JPanel panel3=new JPanel();
		
		panel1.add(idLabel);
		panel1.add(idText);
		panel2.add(findButton);
		panel3.add(averageLabel);
		
		acerageFrame.add(panel1);
		acerageFrame.add(panel2);
		acerageFrame.add(panel3);
		
		acerageFrame.setLayout(new GridLayout(3,1));
		acerageFrame.setBounds(400,300,300,200);
		acerageFrame.setVisible(true);
		acerageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //���رձ�����
		
		findButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="select AVG(�ɼ�)  from �ɼ��� where ѧ��="+idText.getText();
				try {
					statement=con.createStatement();
					rs=statement.executeQuery(sql);
					rs.next();
					if(rs.getString(1)==null) {
						averageLabel.setText(idText.getText()+"�����ڣ�");
						averageLabel.setForeground(Color.blue);
					}
					else {
						averageLabel.setText(idText.getText()+"��ƽ���ɼ�Ϊ��"+rs.getString(1));		
						averageLabel.setForeground(Color.red);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					try {
						rs.close();
						statement.close();						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					acerageFrame.validate();
				}
			}
			
		});
	}
	
	public void gradeStatics() { //�����ֶ�ͳ�ƣ�������ͳ��ͼ��
		
		int[] grade=new int[4];
        String averageSql="select AVG(�ɼ�) from �ɼ��� group by ѧ��";
       
	    try {
			statement=con.createStatement();
			rs=statement.executeQuery(averageSql);
			
			while(rs.next()) {
				double averageSorce=rs.getDouble(1);
				if(averageSorce<60) //����������
					grade[0]+=1;
				else if(averageSorce>=60&&averageSorce<70) //��������
					grade[1]+=1;
				else if(averageSorce>=70&&averageSorce<85) //��������
					grade[2]+=1;
				else if(averageSorce>=85) //��������
					grade[3]+=1;
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	    
	    System.out.println(grade[0]);
	    System.out.println(grade[1]);
	    System.out.println(grade[2]);
	    System.out.println(grade[3]);
	    DefaultCategoryDataset dateSet = new DefaultCategoryDataset();
	    dateSet.setValue(grade[0],"��","������");
	    dateSet.setValue(grade[1],"��","����");
	    dateSet.setValue(grade[2],"��","����");
	    dateSet.setValue(grade[3],"��","����");
	    JFreeChart chart = ChartFactory.createBarChart("����ͳ��ͼ",//����
                "����",//Ŀ¼�����ʾ��ǩ
                "����/��",//��ֵ����ʾ��ǩ
                dateSet,//����
                PlotOrientation.VERTICAL,//ͼ�귽��  ˮƽ/��ֱ
                true,//�Ƿ���ʾͼ��
                false,//�Ƿ����ɹ���
                false); //�Ƿ�����URL����

	    CategoryPlot categoryPlot = chart.getCategoryPlot();//ͼ����
        CategoryAxis domainAxis = categoryPlot.getDomainAxis();//X��
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.STANDARD);//X���±�  90����ʾ
        domainAxis.setMaximumCategoryLabelLines(10);//�Զ�����    �����ʾ������
        domainAxis.setLabelFont(new Font("����",Font.BOLD,20));//�±�
        domainAxis.setTickLabelFont(new Font("����",Font.BOLD,20));//X�����
 
        ValueAxis rangeAxis = categoryPlot.getRangeAxis();//Y��
        rangeAxis.setLabelFont(new Font("����",Font.BOLD,20));//�±�
        rangeAxis.setTickLabelFont(new Font("����",Font.BOLD,20));//Y�����
 
        NumberAxis numberAxis = (NumberAxis) categoryPlot.getRangeAxis();
        numberAxis.setAutoTickUnitSelection(false);//ȡ���Զ�����Y��̶�
        numberAxis.setTickUnit(new NumberTickUnit(10));//�̶ȴ�С
        numberAxis.setAutoRangeStickyZero(true);//������һ�д���ʹ��   ����Y�ᶼ������
        numberAxis.setRangeType(RangeType.POSITIVE);
        numberAxis.setNumberFormatOverride(new DecimalFormat("0.00"));//����Y���ϵ���ֵ����
 
        chart.getLegend().setItemFont( new Font("����",Font.BOLD,20));//ͼ������
        chart.getTitle().setFont( new Font("����",Font.BOLD,20));
        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();//ͼ���޸�
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}",new DecimalFormat("0.00")));//������״ͼ�ϵ���ֵ����
        renderer.setItemMargin(0);//��������֮��ľ���
        renderer.setPositiveItemLabelPositionFallback(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_CENTER));
        renderer.setBaseItemLabelFont(new Font("����",Font.BOLD,20));
        renderer.setDrawBarOutline(false);
        renderer.setMaximumBarWidth(0.4); //�������ӿ��
        renderer.setMinimumBarLength(0.00); //�������Ӹ߶�
        renderer.setBaseItemLabelsVisible(true);//��״���ϵ���ֵ��ʾ
      
	}
	
	public static void main(String[] args) {
		new MenuGrade().gradeStatics();
	}
}
