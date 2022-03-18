package day07.am.view;

import day07.am.control.CheckValiData;
import day07.am.control.StudentDao;
import day07.am.model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifyStuForm extends JFrame {
    private JTextField stuIDTxt;
    private JTextField stuNameTxt;
    private JTextField stuAgeTxt;
    private JRadioButton stuSexRtn1,stuSexRtn2;
    private JTextField stuMajorTxt;
    private JButton modifyBtn,cancelBtn;
    private Student student=null;
    public ModifyStuForm(Student stu){
        this.student=stu;
        stuIDTxt=new JTextField(10);
        stuIDTxt.setEditable(false);
        stuNameTxt=new JTextField(10);
        stuAgeTxt=new JTextField(10);
        stuMajorTxt=new JTextField(10);
        stuSexRtn1=new JRadioButton("男");
        stuSexRtn2=new JRadioButton("女");
        ButtonGroup btg=new ButtonGroup();
        btg.add(stuSexRtn1);
        btg.add(stuSexRtn2);
        stuSexRtn1.setSelected(true);
        modifyBtn=new JButton("修改");
        cancelBtn=new JButton("取消");


        this.setLayout(new GridLayout(6,1));

        JPanel p1=new JPanel();
        p1.add(new JLabel("学号："));
        p1.add(stuIDTxt);
        this.add(p1);

        JPanel p2=new JPanel();
        p2.add(new JLabel("姓名："));
        p2.add(stuNameTxt);
        this.add(p2);

        JPanel p3=new JPanel();
        p3.add(new JLabel("年龄："));
        p3.add(stuAgeTxt);
        this.add(p3);

        JPanel p4=new JPanel();
        p4.add(new JLabel("专业："));
        p4.add(stuMajorTxt);
        this.add(p4);

        JPanel p5=new JPanel();
        p5.add(stuSexRtn1);
        p5.add(stuSexRtn2);
        this.add(p5);

        JPanel p6=new JPanel();
        p6.add(modifyBtn);
        p6.add(cancelBtn);
        this.add(p6);

        showModifyStuInfo();

        this.setTitle("修改学生信息");
        this.setBounds(200,200,350,250);
//        this.pack();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);



        modifyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int sID= Integer.parseInt(stuIDTxt.getText().trim());
                String stuName=stuNameTxt.getText().trim();
                if(CheckValiData.checkIsNull(stuName)){
                    JOptionPane.showMessageDialog(stuNameTxt,"姓名不能为空！","添加提示",JOptionPane.WARNING_MESSAGE);
                    stuNameTxt.grabFocus();
                    return;
                }
                String ageTxt=stuAgeTxt.getText().trim();
                if(!CheckValiData.checkIsNumber(ageTxt)){
                    JOptionPane.showMessageDialog(stuAgeTxt,"年龄必须为数字！","添加提示",JOptionPane.WARNING_MESSAGE);
                    stuAgeTxt.grabFocus();
                    return;
                }
                int stuAge=Integer.parseInt(ageTxt);
                int stuSex=1;
                if(stuSexRtn2.isSelected())
                    stuSex=0;
                String stuMajor=stuMajorTxt.getText().trim();

                Student newStu=new Student(sID,stuName,stuSex,stuAge,stuMajor);
                if(new StudentDao().doUpdate(newStu)){
                    JOptionPane.showMessageDialog(stuNameTxt,"修改成功！");
                    ModifyStuForm.this.dispose();
                }else{
                    JOptionPane.showMessageDialog(stuNameTxt,"修改失败！","添加提示",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModifyStuForm.this.dispose();
            }
        });
    }

    private void showModifyStuInfo(){
        stuIDTxt.setText(String.valueOf(student.getsID()));
        stuNameTxt.setText(student.getsName());
        if(student.getsSex()==0){
            stuSexRtn1.setSelected(true);
            stuSexRtn2.setSelected(false);
        }else{
            stuSexRtn1.setSelected(false);
            stuSexRtn2.setSelected(true);
        }
        stuAgeTxt.setText(String.valueOf(student.getsAge()));
        stuMajorTxt.setText(student.getsMajor());
    }
}
