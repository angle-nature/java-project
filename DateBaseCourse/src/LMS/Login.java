package LMS;

import LMS.Admin.AdministratorForm;
import LMS.User.UserForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Login implements ItemListener {

    JFrame jf = new JFrame("[欢迎进入图书管理系统]");
    JLabel lb1 = new JLabel("用       户      名:");
    JLabel lb2 = new JLabel(" 密            码:");

    ImageIcon background = new ImageIcon("F:\\Java Project\\DateBaseCourse\\Image\\Login.jpg");
    JLabel label = new JLabel(background);
    JTextField jt1 = new JTextField(15);
    JPasswordField jt2 = new JPasswordField(15);
    JButton btn1 = new JButton("登 录");
    JButton btn2 = new JButton("重 置");
    JRadioButton jrb1=new JRadioButton("普通用户",true);
    JRadioButton jrb2=new JRadioButton("管理员");
    ButtonGroup btg=new ButtonGroup();    //定义按钮组

    static String user=null;
    static String password=null;
    boolean isAdministrator=false; //是否为管理员

    public Login(){
        label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
        jf.getLayeredPane().add(label, Integer.valueOf(Integer.MIN_VALUE));
        JPanel jp = (JPanel) jf.getContentPane();

        jp.setOpaque(false);  //JPanel对象才可以调用setOpaque(false);设置是否透明
        JPanel jpanel = new JPanel();
        jpanel.setOpaque(false);
        jpanel.setLayout(null); //自由布局

        jrb1.setContentAreaFilled(false);
        jrb2.setContentAreaFilled(false);
        jrb1.setForeground(Color.YELLOW);
        jrb2.setForeground(Color.YELLOW);

        lb1.setBounds(150, 85, 140, 30);
        lb2.setBounds(150, 135, 140, 30);
        jt1.setBounds(258, 90, 180, 23);
        jt2.setBounds(258, 140, 180, 23);
        btn1.setBounds(265, 210, 80, 25);
        btn2.setBounds(355, 210, 80, 25);
        jrb1.setBounds(265,180,80,25);
        jrb2.setBounds(355,180,80,25);
        jrb1.addItemListener(this);
        jrb2.addItemListener(this);

        btg.add(jrb1);
        btg.add(jrb2);
        jpanel.add(lb1);
        jpanel.add(lb2);
        jpanel.add(btn1);
        jpanel.add(btn2);
        jpanel.add(jt1);
        jpanel.add(jt2);
        jpanel.add(jrb1);
        jpanel.add(jrb2);

        jf.add(jpanel);
        jf.pack();
        jf.setBounds(460, 260, 500, 320);
        jf.setVisible(true);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);

        //登录按钮事件
        btn1.addActionListener(e -> {
            user=jt1.getText().strip();
            password=new String(jt2.getPassword()).strip();
            int status=new DBUtils().checkLogin(user,password);

            if(isAdministrator){ //管理员选项下
                if(status==0){
                    new AdministratorForm();
                    jf.dispose();
                }
                else if (status==1)
                    JOptionPane.showMessageDialog(null, "密码错误！", "登录提示",JOptionPane.ERROR_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "用户名错误！", "登录提示",JOptionPane.ERROR_MESSAGE);
            }else{  //普通用户选项下
                if(status==2){
                    new UserForm(user);
                    jf.dispose();
                }
                else if (status==3)
                    JOptionPane.showMessageDialog(null, "密码错误！", "登录提示",JOptionPane.ERROR_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "用户名错误！", "登录提示",JOptionPane.ERROR_MESSAGE);
            }
        });

        //重置按钮事件
        btn2.addActionListener(e -> {
            jt1.setText("");
            jt2.setText("");
        });
    }

    //单选按钮监听事件
    public void itemStateChanged(ItemEvent e){
        if(e.getSource()==jrb2)
            isAdministrator=true;
        else if(e.getSource()==jrb1)
            isAdministrator=false;
    }

    public static void main(String[] args) {
        new Login();
    }
}
