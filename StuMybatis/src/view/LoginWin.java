package view;

import dao.SessionMethod;
import pojo.InputOptionValue;
import pojo.UserLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWin extends JFrame implements ActionListener{
    private JRadioButton adminRbtn,teacherRbtn,studentRbtn;
    private JTextField nameTxt;
    private JPasswordField pwdTxt;
    private JButton submitBtn,cancelBtn;

    public LoginWin(){
        adminRbtn=new JRadioButton("管理员");
        teacherRbtn=new JRadioButton("教师");
        studentRbtn=new JRadioButton("学生");
        ButtonGroup btg=new ButtonGroup();
        btg.add(studentRbtn);
        btg.add(teacherRbtn);
        btg.add(adminRbtn);

        nameTxt=new JTextField(10);
        pwdTxt=new JPasswordField(10);
        submitBtn=new JButton("登录");
        submitBtn.setIcon(new ImageIcon("Image/登录.jpg"));
        cancelBtn=new JButton("取消");
        cancelBtn.setIcon(new ImageIcon("Image/取消.jpg"));

        this.setLayout(new GridLayout(4,1));

        JPanel p1=new JPanel();
        p1.add(new JLabel("姓名"));
        p1.add(nameTxt);
        this.add(p1);

        JPanel p2=new JPanel();
        p2.add(new JLabel("密码"));
        p2.add(pwdTxt);
        this.add(p2);

        JPanel p3=new JPanel();
        p3.add(studentRbtn);
        p3.add(teacherRbtn);
        p3.add(adminRbtn);
        studentRbtn.setSelected(true);
        this.add(p3);

        JPanel p4=new JPanel();
        p4.add(submitBtn);
        p4.add(cancelBtn);
        this.add(p4);

        submitBtn.addActionListener(this);

        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentRbtn.setSelected(true);
                nameTxt.setText(null);
                pwdTxt.setText(null);
            }
        });

        this.setTitle("用户登录");
        this.setIconImage(new ImageIcon("Image/QQ.jpg").getImage());
        this.setResizable(false);
        this.setBounds(300,200,300,200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int userPrivilege;
        String userName;
        String userPwd;

        if(adminRbtn.isSelected()){
            userPrivilege=0;
        }else if(teacherRbtn.isSelected()){
            userPrivilege=1;
        }else
            userPrivilege=2;

        userName=nameTxt.getText().strip();
        userPwd=new String(pwdTxt.getPassword()).strip();

        String str="dao.UserLoginMapper.doSelectByUserName";
        InputOptionValue inputOptionValue=new InputOptionValue<String>(str,userName);
        UserLogin userLogin=new SessionMethod<String,UserLogin>().selectOneObject(inputOptionValue);

        if (userLogin.getUserPwd().equals(userPwd)&&userLogin.getUserPrivilege()==userPrivilege){
            new MainForm(userLogin);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(this,"登录失败","登录提示",JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new LoginWin();
    }
}
