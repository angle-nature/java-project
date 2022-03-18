package SIMS.AdminForm;

import SIMS.DBOperator;

import javax.swing.*;
import java.awt.*;

public class AddCourse extends JFrame{

    public AddCourse() {
        JPanel jPanel1=new JPanel(new FlowLayout());
        JPanel jPanel2=new JPanel(new FlowLayout());
        JPanel jPanel3=new JPanel(new FlowLayout());
        JPanel jPanel4=new JPanel(new FlowLayout());
        JPanel jPanel5=new JPanel(new FlowLayout());
        JPanel jPanel6=new JPanel(new FlowLayout());

        JLabel courseIDLabel=new JLabel("课程代码：");
        JLabel courseNameLabel=new JLabel("课程名称：");
        JLabel teacherLabel=new JLabel("任课老师：");
        JLabel collegeLabel=new JLabel("开课院系：");
        JLabel timeLabel=new JLabel("课程学时：");

        JTextField courseIDTf=new JTextField(8);
        JTextField courseNameTf=new JTextField(8);
        JTextField teacherTf=new JTextField(8);
        JTextField collegeTf=new JTextField(8);
        JTextField timeTf=new JTextField(8);

        JButton enterBtn=new JButton("录入");
        JButton cancelBtn=new JButton("取消");

        jPanel1.add(courseIDLabel);
        jPanel1.add(courseIDTf);
        jPanel2.add(courseNameLabel);
        jPanel2.add(courseNameTf);
        jPanel3.add(teacherLabel);
        jPanel3.add(teacherTf);
        jPanel4.add(collegeLabel);
        jPanel4.add(collegeTf);
        jPanel5.add(timeLabel);
        jPanel5.add(timeTf);
        jPanel6.add(enterBtn);
        jPanel6.add(cancelBtn);

        this.add(jPanel1);
        this.add(jPanel2);
        this.add(jPanel3);
        this.add(jPanel4);
        this.add(jPanel5);
        this.add(jPanel6);

        this.setLayout(new GridLayout(6,1));
        this.setTitle("课程录入");
        this.setBounds(600,300,250,250);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        enterBtn.addActionListener(e -> {
            String courseID=courseIDTf.getText().strip();
            String courseName=courseNameTf.getText().strip();
            String teacher=teacherTf.getText().strip();
            String college=collegeTf.getText().strip();
            String time=timeTf.getText().strip();

            if("".equals(courseID)||"".equals(courseName)||"".equals(teacher)||"".equals(college)||"".equals(time))
                JOptionPane.showMessageDialog(null, "请填写完整！");
            else if(new DBOperator().isExistCourseID(courseID))
                JOptionPane.showMessageDialog(null, "课程代码已存在！");
            else{
                String insertSql="insert into score values('"+courseID+"','"+courseName+"','"+teacher+"','"+college+"',"+time+")";
                if(new DBOperator().executeUpdateSql(insertSql)){
                    this.dispose();
                    JOptionPane.showMessageDialog(null, "添加成功！");
                }
                else
                    JOptionPane.showMessageDialog(null, "添加失败！", "提示",JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelBtn.addActionListener(e -> this.dispose());
    }
}
