package SIMS.AdminForm;

import SIMS.DBOperator;

import javax.swing.*;
import java.awt.*;

public class AddScore extends JFrame {

    public AddScore() {
        JPanel jPanel1=new JPanel(new FlowLayout());
        JPanel jPanel2=new JPanel(new FlowLayout());
        JPanel jPanel3=new JPanel(new FlowLayout());
        JPanel jPanel4=new JPanel(new FlowLayout());

        JLabel stuIDLabel=new JLabel("学生学号：");
        JLabel courseIDLabel=new JLabel("课程代码：");
        JLabel scoreLabel=new JLabel("课程分数：");

        JTextField stuIDTf=new JTextField(8);
        JTextField courseIDTf=new JTextField(8);
        JTextField scoreTf=new JTextField(8);

        JButton enterBtn=new JButton("录入");
        JButton cancelBtn=new JButton("取消");

        jPanel1.add(stuIDLabel);
        jPanel1.add(stuIDTf);
        jPanel2.add(courseIDLabel);
        jPanel2.add(courseIDTf);
        jPanel3.add(scoreLabel);
        jPanel3.add(scoreTf);
        jPanel4.add(enterBtn);
        jPanel4.add(cancelBtn);

        this.add(jPanel1);
        this.add(jPanel2);
        this.add(jPanel3);
        this.add(jPanel4);

        this.setLayout(new GridLayout(4,1));
        this.setTitle("成绩录入");
        this.setBounds(600,300,250,180);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        enterBtn.addActionListener(e -> {
            String stuID=stuIDTf.getText().strip();
            String courseID=courseIDTf.getText().strip();
            String score=scoreTf.getText().strip();

            if("".equals(stuID)||"".equals(courseID)||"".equals(score))
                JOptionPane.showMessageDialog(null, "请填写完整！");
            else if(!new DBOperator().isExistStuID(stuID))
                JOptionPane.showMessageDialog(null, "学号不存在！");
            else if(!new DBOperator().isExistCourseID(courseID))
                JOptionPane.showMessageDialog(null, "课程代码不存在！");
            else{
                String insertSql="insert into score values('"+stuID+"','"+courseID+"',"+score+")";
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
