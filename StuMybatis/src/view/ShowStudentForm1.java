package view;

import dao.SessionMethod;
import pojo.InputOptionValue;
import pojo.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ShowStudentForm1 extends JFrame {
    private JTextField stuIDTxt;
    private JTextField stuNameTxt;
    private JTextField stuAgeTxt;
    private JRadioButton stuSexRtn1,stuSexRtn2;
    private JTextField stuMajorTxt;
    private JButton firstBtn,preBtn,nextBtn,lastBtn;
    private List<Student> studentList=null;
    private int currentIndex=0;

    public ShowStudentForm1(){
        stuIDTxt=new JTextField(10);
        stuNameTxt=new JTextField(10);
        stuAgeTxt=new JTextField(10);
        stuMajorTxt=new JTextField(10);
        stuSexRtn1=new JRadioButton("男");
        stuSexRtn2=new JRadioButton("女");
        ButtonGroup btg=new ButtonGroup();
        btg.add(stuSexRtn1);
        btg.add(stuSexRtn2);
        stuSexRtn1.setSelected(true);
        firstBtn=new JButton("第一条记录");
        preBtn=new JButton("上一条记录");
        nextBtn=new JButton("下一条记录");
        lastBtn=new JButton("最后一条记录");

        stuIDTxt.setEditable(false);
        stuNameTxt.setEditable(false);
        stuAgeTxt.setEditable(false);
        stuMajorTxt.setEditable(false);
        stuSexRtn1.setEnabled(false);
        stuSexRtn2.setEnabled(false);

        this.setLayout(new GridLayout(6,1));

        JPanel p1=new JPanel();
        p1.add(new JLabel("学号"));
        p1.add(stuIDTxt);
        this.add(p1);

        JPanel p2=new JPanel();
        p2.add(new JLabel("姓名"));
        p2.add(stuNameTxt);
        this.add(p2);

        JPanel p3=new JPanel();
        p3.add(new JLabel("年龄"));
        p3.add(stuAgeTxt);
        this.add(p3);

        JPanel p4=new JPanel();
        p4.add(new JLabel("专业"));
        p4.add(stuMajorTxt);
        this.add(p4);

        JPanel p5=new JPanel();
        p5.add(stuSexRtn1);
        p5.add(stuSexRtn2);
        this.add(p5);

        JPanel p6=new JPanel(new GridLayout(1,4,10,5));
        p6.add(firstBtn);
        p6.add(preBtn);
        p6.add(nextBtn);
        p6.add(lastBtn);
        this.add(p6);

        String selectStr="dao.StudentMapper.doSelectAll";
        InputOptionValue inputOptionValue=new InputOptionValue<Student>(selectStr,null);
        studentList=new SessionMethod<Student,Student>().selectListObject(inputOptionValue);
        showStuInfo(currentIndex);

        this.setTitle("显示学生信息");
        this.setBounds(200,200,500,300);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

        firstBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showStuInfo(0);
            }
        });

        preBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    showStuInfo(currentIndex-1);
            }
        });

        nextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showStuInfo(currentIndex+1);
            }
        });

        lastBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showStuInfo(studentList.size()-1);
            }
        });
    }

    private void showStuInfo(int index){
        if(studentList!=null){
            Student stu=studentList.get(index);
            stuIDTxt.setText(String.valueOf(stu.getsID()));
            stuNameTxt.setText(stu.getsName());
            stuAgeTxt.setText(String.valueOf(stu.getsAge()));
            if (stu.getsSex()==0)
                stuSexRtn1.setSelected(true);
            else
                stuSexRtn2.setSelected(true);
            stuMajorTxt.setText(stu.getsMajor());

            currentIndex=index;

            setButtonEnable();
        }
    }

    private void setButtonEnable(){
        if(currentIndex==0){
            preBtn.setEnabled(false);
            nextBtn.setEnabled(true);
        }
        else if(currentIndex==studentList.size()-1){
            preBtn.setEnabled(true);
            nextBtn.setEnabled(false);
        }else{
            preBtn.setEnabled(true);
            nextBtn.setEnabled(true);
        }
    }
}
