package LMS.User;

import LMS.DBUtils;

import javax.swing.*;

public class UserInfo {
    private String userID;
    private String[] userInfo=new String[5];

    public UserInfo(String userID) {
        this.userID = userID;

        JFrame jf=new JFrame("个人信息");
        jf.setSize(280,250);
        jf.setLocation(800,250);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel jp=new JPanel(null);
        JLabel jlb1=new JLabel(" 编号：          ");
        JLabel jlb2=new JLabel(" 姓名：          ");
        JLabel jlb3=new JLabel(" 性别：          ");
        JLabel jlb4=new JLabel(" 专业：          ");
        JLabel jlb5=new JLabel(" 可借书数量:      ");

        userInfo=new DBUtils().returnUserInfo(userID);

        JTextField jtf1=new JTextField(userInfo[0]);
        JTextField jtf2=new JTextField(userInfo[1]);
        JTextField jtf3=new JTextField(userInfo[2]);
        JTextField jtf4=new JTextField(userInfo[3]);
        JTextField jtf5=new JTextField(userInfo[4]);

        jlb1.setBounds(15,10,100,30);
        jlb2.setBounds(15,50,100,30);
        jlb3.setBounds(15,90,100,30);
        jlb4.setBounds(15,130,100,30);
        jlb5.setBounds(15,170,100,30);

        jtf1.setBounds(90,15,170,25);
        jtf2.setBounds(90,55,170,25);
        jtf3.setBounds(90,95,170,25);
        jtf4.setBounds(90,135,170,25);
        jtf5.setBounds(90,175,170,25);

        jtf1.setEditable(false); //文本框设置为不可编辑
        jtf2.setEditable(false);
        jtf3.setEditable(false);
        jtf4.setEditable(false);
        jtf5.setEditable(false);

        jp.add(jlb1);
        jp.add(jtf1);
        jp.add(jlb2);
        jp.add(jtf2);
        jp.add(jlb3);
        jp.add(jtf3);
        jp.add(jlb4);
        jp.add(jtf4);
        jp.add(jlb5);
        jp.add(jtf5);

        jf.add(jp);
        jf.setVisible(true);
    }
}
