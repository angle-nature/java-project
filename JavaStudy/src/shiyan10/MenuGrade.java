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
    
    public MenuGrade() { //初始化
    	try {
			Class.forName(driver);
	        con = DriverManager.getConnection(url,Sqluser,Sqlpwd);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
	public void queGrade() { //查询成绩
		
		JFrame putInFrame=new JFrame();
		JLabel idLabel=new JLabel("请输入学号");
		JTextField idText=new JTextField(8);
		JButton findButton=new JButton("查询");
		JPanel panel1=new JPanel();
		JPanel panel2=new JPanel();
		
		panel1.add(idLabel);
		panel1.add(idText);
		panel2.add(findButton);
		
		putInFrame.setBounds(350,250,220,120);
		putInFrame.setVisible(true);
		putInFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //仅关闭本窗口
		putInFrame.setLayout(new GridLayout(2,1));
		putInFrame.add(panel1);
		putInFrame.add(panel2);
		
		findButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="Select * from 成绩表 where 学号="+idText.getText();
		    	DefaultTableModel model=new DefaultTableModel();
		    	String[] info={"学号","课程号","成绩"};
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
		    	jscrollpane.setViewportView(table);//这句很重要
		    	table.setRowHeight(35); 
		    	JPanel panel=new JPanel();
		    	panel.add(jscrollpane);

		    	JFrame showAllFrame=new JFrame(idText.getText()+"的成绩单");
		    	showAllFrame.setBounds(350,250,480,320);
		    	showAllFrame.setVisible(true);
		    	showAllFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //仅关闭本窗口
		    	showAllFrame.add(panel);
			}
		});						
		
	}
	
	public void addOrModifyGrade() { //录入成绩
		JFrame addClassFrame=new JFrame("录入成绩");
    	JLabel idLabel=new JLabel("学号");
    	JLabel classidLabel=new JLabel("课程号");
    	JLabel gradeLabel=new JLabel("成绩");
    	JTextField idText=new JTextField(8);
    	JTextField classidText=new JTextField(8);
    	JTextField gradeText=new JTextField(8);
    	JButton addButton=new JButton("录入");
    	JButton modifyButton=new JButton("修改");
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
    	addClassFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //仅关闭本窗口
    	
    	addClassFrame.add(panel1);
    	addClassFrame.add(panel2);
    	addClassFrame.add(panel3);
    	addClassFrame.add(panel4);
    	addClassFrame.add(panel5);
    	
    	addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "insert into 成绩表 (学号,课程号,成绩) "
		                + "values ('"+idText.getText()+"','"+classidText.getText()+"','"+gradeText.getText()+"')";
				String sql1="select * from 成绩表 where 学号="+idText.getText()+" and 课程号="+classidText.getText();
				try {
					statement=con.createStatement();
					rs=statement.executeQuery(sql1);
					if(rs.next()) {
						statusLabel.setText(idText.getText()+"已有此课程号！");
						statusLabel.setForeground(Color.blue);
					}
					else {
						int rows=statement.executeUpdate(sql);
						if(rows>0) {
							statusLabel.setText("录入成功！");
							statusLabel.setForeground(Color.green);
						}
						else {
							statusLabel.setText("录入失败！");
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
				String sql="update 成绩表 set 成绩="+gradeText.getText()+" where 学号="
						+idText.getText()+" and 课程号="+classidText.getText();
				try {
					statement=con.createStatement();
					int rows=statement.executeUpdate(sql);
					if(rows>0) {
						statusLabel.setText("修改成功！");
						statusLabel.setForeground(Color.green);
					}
					else {
						statusLabel.setText("修改失败！");
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
	
	public void average() { //求平均成绩
		JFrame acerageFrame=new JFrame("平均成绩");
		JLabel idLabel=new JLabel("请输入学号");
		JTextField idText=new JTextField(8);
		JButton findButton=new JButton("查询");
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
		acerageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //仅关闭本窗口
		
		findButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="select AVG(成绩)  from 成绩表 where 学号="+idText.getText();
				try {
					statement=con.createStatement();
					rs=statement.executeQuery(sql);
					rs.next();
					if(rs.getString(1)==null) {
						averageLabel.setText(idText.getText()+"不存在！");
						averageLabel.setForeground(Color.blue);
					}
					else {
						averageLabel.setText(idText.getText()+"的平均成绩为："+rs.getString(1));		
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
	
	public void gradeStatics() { //分数分段统计（并画出统计图）
		
		int[] grade=new int[4];
        String averageSql="select AVG(成绩) from 成绩表 group by 学号";
       
	    try {
			statement=con.createStatement();
			rs=statement.executeQuery(averageSql);
			
			while(rs.next()) {
				double averageSorce=rs.getDouble(1);
				if(averageSorce<60) //不及格人数
					grade[0]+=1;
				else if(averageSorce>=60&&averageSorce<70) //及格人数
					grade[1]+=1;
				else if(averageSorce>=70&&averageSorce<85) //良好人数
					grade[2]+=1;
				else if(averageSorce>=85) //优秀人数
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
	    dateSet.setValue(grade[0],"好","不及格");
	    dateSet.setValue(grade[1],"好","及格");
	    dateSet.setValue(grade[2],"好","良好");
	    dateSet.setValue(grade[3],"好","优秀");
	    JFreeChart chart = ChartFactory.createBarChart("分数统计图",//标题
                "分数",//目录轴的显示标签
                "人数/人",//数值的显示标签
                dateSet,//数据
                PlotOrientation.VERTICAL,//图标方向  水平/垂直
                true,//是否显示图例
                false,//是否生成工具
                false); //是否生成URL链接

	    CategoryPlot categoryPlot = chart.getCategoryPlot();//图部分
        CategoryAxis domainAxis = categoryPlot.getDomainAxis();//X轴
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.STANDARD);//X轴下标  90°显示
        domainAxis.setMaximumCategoryLabelLines(10);//自动换行    最多显示多少行
        domainAxis.setLabelFont(new Font("黑体",Font.BOLD,20));//下标
        domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,20));//X轴标题
 
        ValueAxis rangeAxis = categoryPlot.getRangeAxis();//Y轴
        rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,20));//下标
        rangeAxis.setTickLabelFont(new Font("宋体",Font.BOLD,20));//Y轴标题
 
        NumberAxis numberAxis = (NumberAxis) categoryPlot.getRangeAxis();
        numberAxis.setAutoTickUnitSelection(false);//取消自动设置Y轴刻度
        numberAxis.setTickUnit(new NumberTickUnit(10));//刻度大小
        numberAxis.setAutoRangeStickyZero(true);//和下面一行搭配使用   设置Y轴都是正数
        numberAxis.setRangeType(RangeType.POSITIVE);
        numberAxis.setNumberFormatOverride(new DecimalFormat("0.00"));//设置Y轴上的数值精度
 
        chart.getLegend().setItemFont( new Font("黑体",Font.BOLD,20));//图标字体
        chart.getTitle().setFont( new Font("黑体",Font.BOLD,20));
        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();//图形修改
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}",new DecimalFormat("0.00")));//设置柱状图上的数值精度
        renderer.setItemMargin(0);//设置柱子之间的距离
        renderer.setPositiveItemLabelPositionFallback(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_CENTER));
        renderer.setBaseItemLabelFont(new Font("黑体",Font.BOLD,20));
        renderer.setDrawBarOutline(false);
        renderer.setMaximumBarWidth(0.4); //设置柱子宽度
        renderer.setMinimumBarLength(0.00); //设置柱子高度
        renderer.setBaseItemLabelsVisible(true);//柱状体上的数值显示
      
	}
	
	public static void main(String[] args) {
		new MenuGrade().gradeStatics();
	}
}
