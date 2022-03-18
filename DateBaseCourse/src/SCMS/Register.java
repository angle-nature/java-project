package SCMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register {
    private JFrame register;//登录界面
    private JLabel prompt;//用户密码提示标签
    private JLabel userName;//用户提示标签
    private JLabel password;//密码提示标签
    private JTextField idText;//用户输入框
    private JPasswordField pwdText;//密码输入框
    private JButton submit;//登录按钮
    private JButton reset;//重置按钮
    private JLabel loginStatus;//登录状态

    public Register() {
        prompt = new JLabel("用户名为学号，初始密码为出生年月", JLabel.CENTER);
        userName = new JLabel("用户名:", JLabel.CENTER);//创建用户名提示信息
        idText = new JTextField(15);//创建用户名输入框
        password = new JLabel("密码:", JLabel.CENTER);//创建密码提示信息
        pwdText = new JPasswordField(15);//创建密码输入框
        submit = new JButton("登录");
        reset = new JButton("重置");
        loginStatus = new JLabel("", JLabel.CENTER);

        JPanel promptPanel=new JPanel();//提示信息面板
        JPanel userPanel=new JPanel();//用户面板
        JPanel pwdPanel=new JPanel();//密码面板
        JPanel buttonPanel=new JPanel();//按钮面板
        JPanel statusPanel=new JPanel();//状态面板
        promptPanel.add(prompt);
        userPanel.add(userName);
        userPanel.add(idText);
        pwdPanel.add(password);
        pwdPanel.add(pwdText);
        buttonPanel.add(submit);
        buttonPanel.add(reset);
        //Font font=new Font("黑体",Font.BOLD+Font.PLAIN, 20);
        // loginStatus.setFont(font);
        loginStatus.setForeground(Color.red);
        statusPanel.add(loginStatus);
        register=new JFrame("学生登录界面");
        register.setLayout(new GridLayout(5,1));
        register.add(promptPanel);
        register.add(userPanel);
        register.add (pwdPanel);
        register.add(buttonPanel);
        register.add(statusPanel);
        register.setSize(500, 300);//窗口大小
        register.setLocation(300,200);//窗口出现位置
        register.setVisible(true);
        register.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String user=idText.getText();
                String password=new String (pwdText.getPassword());
                LoginCheck loginCheck =new LoginCheck(user,password);//检查登录
                if(! loginCheck.checkUser())
                    loginStatus.setText("用户名不存在!");
                else if(!loginCheck.checkpwd())
                    loginStatus.setText("密码错误!");
                else {
                    loginStatus.setForeground(Color.green);loginStatus.setText("登录成功! ");
                    new MainForm();//启动主窗口
                    register.dispose();//退出当前窗口
            }
        }});
        reset.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                idText.setText("");
                pwdText.setText("");
                loginStatus.setForeground(Color.blue);
                loginStatus.setText("请重新输入!");
            }
        });


    }

    public static void main(String[] args) {
        new Register();
    }
}

