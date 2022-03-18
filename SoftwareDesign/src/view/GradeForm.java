package view;

import dao.GradeDao;
import po.Student;
import util.SwingUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GradeForm {
    private DefaultTableModel tableModel=null;
    String[] header={"课程名称","授课老师","考试成绩","平时成绩","总评"};

    public GradeForm(Student student) {
        JFrame jf = new JFrame("成绩信息");
        JPanel jp = new JPanel(new BorderLayout());
        JPanel jp1 = new JPanel(new FlowLayout()); //流式布局

        JTable jTable = SwingUtil.returnJTable(new GradeDao().queryGradeByStudentID(student.getId()), header, "Grade");
//      jTable.setRowHeight(30);

        JScrollPane jsp = new JScrollPane(jTable);

        jp.add(jp1, BorderLayout.NORTH);
        jp.add(jsp, BorderLayout.CENTER);
        jf.add(jp);
        jf.setSize(600, 400);
        jf.setLocation(300, 150);
        jf.setIconImage(new ImageIcon("images/选课.png").getImage());
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setVisible(true);
    }
}
