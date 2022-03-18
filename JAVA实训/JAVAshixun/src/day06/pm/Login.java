package day06.pm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JTextField nameTxt;           //私有成员放与用户需要交互的组件
    private JPasswordField pwdTxt;
    private JButton OKJbt;
    private JButton CancelJbt;
    private A a;

    public Login(){
        nameTxt=new JTextField(10);
        pwdTxt=new JPasswordField(10);
        OKJbt=new JButton("登录");
        OKJbt.setIcon(new ImageIcon("Image/登录.jpg"));
        CancelJbt=new JButton("取消");
        CancelJbt.setIcon(new ImageIcon("Image/取消.jpg"));

        this.setLayout(new BorderLayout());
        JPanel p1=new JPanel(); //默认流式布局
        JPanel p2=new JPanel();
        JPanel p3=new JPanel();

        p1.add(new JLabel("姓名"));
        p1.add(nameTxt);
        p2.add(new JLabel("密码"));
        p2.add(pwdTxt);
        p3.add(OKJbt);
        p3.add(CancelJbt);

        this.add(p1,BorderLayout.NORTH);
        this.add(p2,BorderLayout.CENTER);
        this.add(p3,BorderLayout.SOUTH);

        OKJbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        this.setTitle("用户登录");
        this.setIconImage(new ImageIcon("Image/QQ.jpg").getImage());
        this.setBounds(300,250,300,150);
        this.setResizable(false);  //设置窗体不可更改大小
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
