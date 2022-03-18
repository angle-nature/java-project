package view;

import po.Student;

import javax.swing.*;
import java.awt.*;

public class StudentInfoForm extends JFrame{
    private JTextField idTxt;
    private JTextField nameTxt;
    private JRadioButton sexRtn1,sexRtn2;
    private JTextField birthdayTxt;
    private JTextField nativePlaceTxt;
    private JTextField currentAddressTxt;
    private JTextField mobilePhoneTxt;

    public StudentInfoForm(Student student){
        idTxt=new JTextField(12);
        nameTxt=new JTextField(12);
        birthdayTxt=new JTextField(12);
        nativePlaceTxt=new JTextField(12);
        currentAddressTxt=new JTextField(12);
        mobilePhoneTxt=new JTextField(12);
        sexRtn1=new JRadioButton("男");
        sexRtn2=new JRadioButton("女");
        ButtonGroup btg=new ButtonGroup();
        btg.add(sexRtn1);
        btg.add(sexRtn2);
        sexRtn1.setSelected(true);

        idTxt.setEditable(false);
        nameTxt.setEditable(false);
        birthdayTxt.setEditable(false);
        nativePlaceTxt.setEditable(false);
        currentAddressTxt.setEditable(false);
        mobilePhoneTxt.setEditable(false);
        sexRtn1.setEnabled(false);
        sexRtn2.setEnabled(false);

        this.setLayout(new GridLayout(7,1));

        JPanel p1=new JPanel();
        p1.add(new JLabel("学        号"));
        p1.add(idTxt);
        idTxt.setText(student.getId());
        this.add(p1);

        JPanel p2=new JPanel();
        p2.add(new JLabel("姓        名"));
        p2.add(nameTxt);
        nameTxt.setText(student.getName());
        this.add(p2);

        JPanel p3=new JPanel();
        p3.add(new JLabel("出生年月"));
        p3.add(birthdayTxt);
        birthdayTxt.setText(student.getBirthday().toString());
        this.add(p3);

        JPanel p4=new JPanel();
        p4.add(new JLabel("籍        贯"));
        p4.add(nativePlaceTxt);
        nativePlaceTxt.setText(student.getNativePlace());
        this.add(p4);

        JPanel p5=new JPanel();
        p5.add(new JLabel("现居地址"));
        p5.add(currentAddressTxt);
        currentAddressTxt.setText(student.getCurrentAddress());
        this.add(p5);

        JPanel p6=new JPanel();
        p6.add(new JLabel("手机号码"));
        p6.add(mobilePhoneTxt);
        mobilePhoneTxt.setText(student.getMobilePhone());
        this.add(p6);

        JPanel p7=new JPanel();
        p7.add(sexRtn1);
        p7.add(sexRtn2);
        String sex=student.getSex();
        if ("男".equals(sex)){
            sexRtn1.isSelected();
        }else{
            sexRtn2.isSelected();
        }
        this.add(p7);

        this.setTitle("显示学生信息");
        this.setBounds(300,200,320,300);
        this.setIconImage(new ImageIcon("images/选课.png").getImage());
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }
}
