package view;

import dao.TeacherDao;
import po.Student;
import util.SwingUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TeacherInfoForm {
    private DefaultTableModel tableModel=null;
    String[] header={"老师工号","老师姓名","教研室","职称","性别","手机号码"};

    public TeacherInfoForm(Student student) {
        JFrame jf = new JFrame("课程信息");
        JPanel jp = new JPanel(new BorderLayout());
        JPanel jp1 = new JPanel(new FlowLayout()); //流式布局

        JTable jTable = SwingUtil.returnJTable(new TeacherDao().queryAllTeacher(), header, "Teacher");
        jTable.setRowHeight(30);

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
