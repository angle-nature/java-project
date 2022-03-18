package view;

import dao.CheckValiData;
import dao.SessionMethod;
import pojo.InputOptionValue;
import pojo.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStuForm extends JFrame {
    private JTextField stuNameTxt;
    private JTextField stuAgeTxt;
    private JRadioButton stuSexRtn1,stuSexRtn2;
    private JTextField stuMajorTxt;
    private JButton okBtn,cancelBtn;
    public AddStuForm(){
        stuNameTxt=new JTextField(10);
        stuAgeTxt=new JTextField(10);
        stuMajorTxt=new JTextField(10);
        stuSexRtn1=new JRadioButton("男");
        stuSexRtn2=new JRadioButton("女");
        ButtonGroup btg=new ButtonGroup();
        btg.add(stuSexRtn1);
        btg.add(stuSexRtn2);
        stuSexRtn1.setSelected(true);
        okBtn=new JButton("确定");
        cancelBtn=new JButton("取消");


        this.setLayout(new GridLayout(5,1));

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
        p6.add(okBtn);
        p6.add(cancelBtn);
        this.add(p6);

        this.setTitle("添加学生信息");
        this.setBounds(200,200,350,200);
//        this.pack();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

                Student newStu=new Student(stuName,stuSex,stuAge,stuMajor);
                String str="dao.StudentMapper.doInsertStudent";
                InputOptionValue inputOptionValue=new InputOptionValue<Student>(str,newStu);
                if(new SessionMethod<Student,String>().doInsert(inputOptionValue)){
                    JOptionPane.showMessageDialog(stuNameTxt,"添加成功！");
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(stuNameTxt,"添加失败！","添加提示",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
