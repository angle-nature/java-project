package SIMS.AdminForm;

import SIMS.DBOperator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AvgScore {

    private DefaultTableModel tableModel=null;
    String[] header={"学号","学生姓名","平均成绩"};
    private int row=-1;

    public AvgScore() {

        JFrame jf = new JFrame("平均成绩查询");
        JPanel jp = new JPanel(new BorderLayout()); //边界布局
        JPanel jp1 = new JPanel(new FlowLayout()); //流式布局

        JLabel stuIDLabel = new JLabel("学号     ");
        JLabel sNameLabel = new JLabel("姓名     ");

        JTextField stuIDText = new JTextField(5);
        JTextField sNameText = new JTextField(8);
        JButton searchButton = new JButton("查询");

        jp1.add(stuIDText);
        jp1.add(stuIDLabel);
        jp1.add(sNameText);
        jp1.add(sNameLabel);
        jp1.add(searchButton);

        String sql = "select stuID,sName,avg(score) from student NATURAL join score group by stuID,sName";
        tableModel = new DBOperator().getTableData(sql, header);
        JTable jTable = new JTable(tableModel);
        // 设置列表头不可被用户重新拖动排列
        jTable.getTableHeader().setReorderingAllowed(false);
        JScrollPane jsp = new JScrollPane(jTable);

        jp.add(jp1, BorderLayout.NORTH);
        jp.add(jsp, BorderLayout.CENTER);
        jf.add(jp);
        jf.setSize(450, 300);
        jf.setLocation(450, 150);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setVisible(true);

        //搜索事件
        searchButton.addActionListener(e -> {
            String sqlSearch = "select stuID,sName,avg(score) from student NATURAL join score group by stuID,sName where 1=1";
            String sqlStuID = "";
            String sqlStuName = "";

            String stuID = stuIDText.getText().strip();
            String stuName = sNameText.getText().strip();

            if (!"".equals(stuID))
                sqlStuID = " and stuID='" + stuID + "'";
            if (!"".equals(stuName))
                sqlStuName = " and sName='" + stuName + "'";

            sqlSearch = sqlSearch + sqlStuID + sqlStuName;

            tableModel = new DBOperator().getTableData(sqlSearch, header);
            jTable.setModel(tableModel);
            jTable.revalidate();
        });
    }
}
