package view;

import dao.StudentDao;
import po.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame implements ActionListener{
    private JRadioButton teacherRbtn,studentRbtn;
    private JTextField nameTxt;
    private JPasswordField pwdTxt;
    private JButton submitBtn,cancelBtn;

    public LoginForm(){
        teacherRbtn=new JRadioButton("教师");
        studentRbtn=new JRadioButton("学生");
        ButtonGroup btg=new ButtonGroup();
        btg.add(studentRbtn);
        btg.add(teacherRbtn);

        nameTxt=new JTextField(10);
        pwdTxt=new JPasswordField(10);
        submitBtn=new JButton("登录");
        submitBtn.setIcon(new ImageIcon("images/登录.png"));
        cancelBtn=new JButton("取消");
        cancelBtn.setIcon(new ImageIcon("images/取消.png"));

        this.setLayout(new GridLayout(4,1));

        JPanel p1=new JPanel();
        p1.add(new JLabel("用户名"));
        p1.add(nameTxt);
        this.add(p1);

        JPanel p2=new JPanel();
        p2.add(new JLabel("密   码"));
        p2.add(pwdTxt);
        this.add(p2);

        JPanel p3=new JPanel();
        p3.add(studentRbtn);
        p3.add(teacherRbtn);
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
        this.setIconImage(new ImageIcon("images/选课.png").getImage());
        this.setResizable(false);
        this.setBounds(300,200,300,200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name;
        String password;

        name=nameTxt.getText().strip();
        password=new String(pwdTxt.getPassword()).strip();

        Student student=new StudentDao().checkLogin(name,password);
        if(student!=null){
            new MainForm(student);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(this,"登录失败","登录提示",JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}
