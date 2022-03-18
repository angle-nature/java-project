package SIMS.AdminForm;

import SIMS.DBOperator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ScoreUpdate {
    private String[] scoreInfo=new String[3];
    private DefaultTableModel tableModel=null;
    String[] header={"学号","学生姓名","课程代码","课程名称","分数"};
    private int row=-1;

    public ScoreUpdate(){

        JFrame jf=new JFrame("成绩信息管理");
        JPanel jp=new JPanel(new BorderLayout()); //边界布局
        JPanel jp1=new JPanel(new FlowLayout()); //流式布局

        JLabel stuIDLabel=new JLabel("学号     ");
        JLabel sNameLabel=new JLabel("姓名     ");
        JLabel courseIDLabel=new JLabel("课程代码     ");
        JLabel cNameLabel=new JLabel("课程名称     ");

        JTextField stuIDText=new JTextField(5);
        JTextField sNameText=new JTextField(8);
        JTextField courseIDText=new JTextField(5);
        JTextField cNameText=new JTextField(8);
        JButton searchButton=new JButton("搜索");
        JButton deleteButton=new JButton("删除");
        JButton updateButton=new JButton("提交更改");

        jp1.add(stuIDText);
        jp1.add(stuIDLabel);
        jp1.add(sNameText);
        jp1.add(sNameLabel);
        jp1.add(courseIDText);
        jp1.add(courseIDLabel);
        jp1.add(cNameText);
        jp1.add(cNameLabel);
        jp1.add(searchButton);
        jp1.add(deleteButton);
        jp1.add(updateButton);

        String sql="select stuID,sName,courseID,cName,score from STUDENT NATURAL JOIN COURSE NATURAL JOIN SCORE";
        tableModel=new DBOperator().getTableData(sql,header);
        JTable jTable=new JTable(tableModel);
        // 设置列表头不可被用户重新拖动排列
        jTable.getTableHeader().setReorderingAllowed(false);
        JScrollPane jsp = new JScrollPane(jTable);

        jp.add(jp1,BorderLayout.NORTH);
        jp.add(jsp,BorderLayout.CENTER);
        jf.add(jp);
        jf.setSize(800,500);
        jf.setLocation(450,150);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setVisible(true);

        jTable.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {//仅当鼠标单击时响应
                //得到选中的行列的索引值
                row= jTable.getSelectedRow(); //行
                //得到选中的单元格的值，表格中都是字符串
                scoreInfo[0]= jTable.getValueAt(row, 0).toString();
                scoreInfo[1]= jTable.getValueAt(row, 2).toString();
            }
        });

        //搜索事件
        searchButton.addActionListener(e -> {
            String sqlSearch="select stuID,sName,courseID,cName,score from STUDENT NATURAL JOIN COURSE NATURAL JOIN SCORE where 1=1";
            String sqlStuID="";
            String sqlStuName="";
            String sqlCourseID="";
            String sqlCName="";

            String stuID=stuIDText.getText().strip();
            String stuName=sNameText.getText().strip();
            String courseID=courseIDText.getText().strip();
            String cName=cNameText.getText().strip();

            if(!"".equals(stuID))
                sqlStuID=" and stuID='"+stuID+"'";
            if(!"".equals(stuName))
                sqlStuName=" and sName='"+stuName+"'";
            if(!"".equals(courseID))
                sqlCourseID=" and courseID='"+courseID+"'";
            if(!"".equals(cName))
                sqlCName=" and cName='"+cName+"'";

            sqlSearch=sqlSearch+sqlStuID+sqlStuName+sqlCourseID+sqlCName;

            tableModel=new DBOperator().getTableData(sqlSearch,header);
            jTable.setModel(tableModel);
            jTable.revalidate();
        });

        //删除事件
        deleteButton.addActionListener(e -> {
            int n = JOptionPane.showConfirmDialog(null, "是否删除该记录", "",JOptionPane.YES_NO_OPTION);
            if(n==0) {
                String delSql="delete from score where stuID='"+scoreInfo[0]+"' and courseID='"+scoreInfo[2]+"'";
                new DBOperator().executeUpdateSql(delSql);
                int row = jTable.getSelectedRow();
                if (row != -1)
                    tableModel.removeRow(row);
            }
        });

        updateButton.addActionListener(e -> {
            if(row!=-1){
                scoreInfo[2]= jTable.getValueAt(row, 4).toString();
                String alterSql="update score set score="+scoreInfo[2]+" where stuID='"+scoreInfo[0]+"' and courseID='"+scoreInfo[1]+"'";
                if(new DBOperator().executeUpdateSql(alterSql))
                    JOptionPane.showMessageDialog(null, "更改已提交成功！");
                else
                    JOptionPane.showMessageDialog(null, "更改提交失败！", "提示",JOptionPane.ERROR_MESSAGE);
            }

        });
    }
}
