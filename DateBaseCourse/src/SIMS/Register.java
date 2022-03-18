package SIMS;

import SIMS.AdminForm.AdminForm;
import SIMS.StudentForm.StudentForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Register implements ItemListener {
    JFrame jf = new JFrame("[欢迎进入学生信息管理系统]");
    JLabel stuIDLabel = new JLabel("用       户      名:");
    JLabel pwdLabel = new JLabel(" 密            码:");

    ImageIcon background = new ImageIcon("F:\\Java Project\\DateBaseCourse\\Image\\Login.jpg");
    JLabel imageLabel = new JLabel(background);
    JTextField stuIDText = new JTextField(15);
    JPasswordField pwdText = new JPasswordField(15);
    JButton loginButton = new JButton("登 录");
    JButton resetButton = new JButton("重 置");
    JRadioButton stuRadioBtn=new JRadioButton("学生",true);
    JRadioButton adminRadioBtn=new JRadioButton("管理员");
    ButtonGroup btg=new ButtonGroup();    //定义按钮组

    private String stuID=null;
    private String password=null;
    boolean isAdmin=false; //是否为管理员

    public Register(){
        imageLabel.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
        jf.getLayeredPane().add(imageLabel, Integer.valueOf(Integer.MIN_VALUE));
        JPanel jp = (JPanel) jf.getContentPane();

        jp.setOpaque(false);  //JPanel对象才可以调用setOpaque(false);设置是否透明
        JPanel jpanel = new JPanel();
        jpanel.setOpaque(false);
        jpanel.setLayout(null); //自由布局

        stuRadioBtn.setContentAreaFilled(false);
        adminRadioBtn.setContentAreaFilled(false);
        stuRadioBtn.setForeground(Color.YELLOW);
        adminRadioBtn.setForeground(Color.YELLOW);

        stuIDLabel.setBounds(150, 85, 140, 30);
        pwdLabel.setBounds(150, 135, 140, 30);
        stuIDText.setBounds(258, 90, 180, 23);
        pwdText.setBounds(258, 140, 180, 23);
        loginButton.setBounds(265, 210, 80, 25);
        resetButton.setBounds(355, 210, 80, 25);
        stuRadioBtn.setBounds(265,180,80,25);
        adminRadioBtn.setBounds(355,180,80,25);
        stuRadioBtn.addItemListener(this);
        adminRadioBtn.addItemListener(this);

        btg.add(stuRadioBtn);
        btg.add(adminRadioBtn);
        jpanel.add(stuIDLabel);
        jpanel.add(pwdLabel);
        jpanel.add(loginButton);
        jpanel.add(resetButton);
        jpanel.add(stuIDText);
        jpanel.add(pwdText);
        jpanel.add(stuRadioBtn);
        jpanel.add(adminRadioBtn);

        jf.add(jpanel);
        jf.pack();
        jf.setBounds(460, 260, 500, 320);
        jf.setVisible(true);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);

        //登录按钮事件
        loginButton.addActionListener(e -> {
            stuID=stuIDText.getText().strip();
            password=new String(pwdText.getPassword()).strip();
            int status=new DBOperator().checkLogin(stuID,password);

            if(isAdmin){ //管理员选项下
                if(status==0){
                    new AdminForm();
                    jf.dispose();
                }
                else if (status==1)
                    JOptionPane.showMessageDialog(null, "密码错误！", "登录提示",JOptionPane.ERROR_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "用户名错误！", "登录提示",JOptionPane.ERROR_MESSAGE);
            }else{  //普通用户选项下
                if(status==2){
                    new StudentForm(stuID);
                    jf.dispose();
                }
                else if (status==3)
                    JOptionPane.showMessageDialog(null, "密码错误！", "登录提示",JOptionPane.ERROR_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "用户名错误！", "登录提示",JOptionPane.ERROR_MESSAGE);
            }
        });

        //重置按钮事件
        resetButton.addActionListener(e -> {
            stuIDText.setText("");
            pwdText.setText("");
        });
    }

    //单选按钮监听事件
    public void itemStateChanged(ItemEvent e){
        if(e.getSource()==adminRadioBtn)
            isAdmin=true;
        else if(e.getSource()==stuRadioBtn)
            isAdmin=false;
    }

    public static void main(String[] args) {
        new Register();
    }
}
