package view;

import dao.CourseDao;
import dao.TimeTableDao;
import po.*;
import util.SwingUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TimeTableForm {
    private String courseID;
    private DefaultTableModel tableModel=null;
    String[] header={"课程名称","授课老师","上课教室","上课时间"};
    public TimeTableForm(Student student){
        JFrame jf=new JFrame("课表信息");
        JPanel jp=new JPanel(new BorderLayout());
        JPanel jp1=new JPanel(new FlowLayout()); //流式布局

        JButton jbt2=new JButton("退课");
        jp1.add(jbt2);

        JTable jTable= SwingUtil.returnJTable(new TimeTableDao().queryTimeTable(student.getId()),header,"TimeTable");
        jTable.setRowHeight(30);

        JScrollPane jsp = new JScrollPane(jTable);

        jp.add(jp1,BorderLayout.SOUTH);
        jp.add(jsp,BorderLayout.CENTER);
        jf.add(jp);
        jf.setSize(700,500);
        jf.setLocation(300,150);
        jf.setIconImage(new ImageIcon("images/选课.png").getImage());
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setVisible(true);

        jTable.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {//仅当鼠标单击时响应
                //得到选中的行列的索引值
                int r= jTable.getSelectedRow();
                //得到选中的单元格的值，表格中都是字符串
                courseID=new CourseDao().queryCourseByIdOrName(null,jTable.getValueAt(r, 0).toString()).getId();
            }
        });

        //退课
        jbt2.addActionListener(e -> {
            if(jTable.getSelectedRow()==-1)
                JOptionPane.showMessageDialog(null, "请选择要退的课程！");
            else{
                if (new TimeTableDao().removeCourse(student.getId(),courseID)){
                    JOptionPane.showMessageDialog(null, "退课成功！");
                }else{
                    JOptionPane.showMessageDialog(null, "退课失败！");
                }
            }
        });
    }
}
