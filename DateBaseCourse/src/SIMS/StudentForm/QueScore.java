package SIMS.StudentForm;

import SIMS.DBOperator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class QueScore {
    private String stuID=null;
    private String[] scoreInfo=new String[3];
    private DefaultTableModel tableModel=null;
    String[] header={"课程代码","课程名称","任课老师","开课院系","学时","分数"};
    private int row=-1;

    public QueScore(String stuID){
        this.stuID=stuID;

        JFrame jf=new JFrame("查看成绩");
        JPanel jp=new JPanel(new BorderLayout()); //边界布局
        JPanel jp1=new JPanel(new FlowLayout()); //流式布局

        String sql="select courseID,cName,teacher,college,time,score from COURSE NATURAL JOIN SCORE where stuID='"+stuID+"'";
        tableModel=new DBOperator().getTableData(sql,header);
        JTable jTable=new JTable(tableModel);
        // 设置列表头不可被用户重新拖动排列
        jTable.getTableHeader().setReorderingAllowed(false);
        jTable.setEnabled(false);
        JScrollPane jsp = new JScrollPane(jTable);

        JLabel avgScoreLabel=new JLabel();
        String avgScore=new DBOperator().getAvgScore(stuID);
        avgScoreLabel.setText("平均成绩："+avgScore);
        avgScoreLabel.setForeground(Color.RED);
        jp1.add(avgScoreLabel);

        jp.add(jp1,BorderLayout.NORTH);
        jp.add(jsp,BorderLayout.CENTER);
        jf.add(jp);
        jf.setSize(600,300);
        jf.setLocation(450,150);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setVisible(true);

    }
}
