package LMS.User;

import LMS.Login;

import javax.swing.*;

public class UserForm {

    private String userID;

    public UserForm(String userID) {
        this.userID=userID;

        JFrame jf=new JFrame("图书管");
        ImageIcon background = new ImageIcon("F:\\Java Project\\DateBaseCourse\\Image\\AHUTLibrary.jpg");
        JLabel imageLabel=new JLabel(background);
        jf.setSize(894,516);
        jf.setLocation(400,130);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        imageLabel.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
        jf.getLayeredPane().add(imageLabel, Integer.valueOf(Integer.MIN_VALUE));
        JPanel jPanel = (JPanel) jf.getContentPane();
        jPanel.setOpaque(false);
        //创建菜单栏
        JMenuBar bar=new JMenuBar();

        //创建一级菜单
        JMenu userInfoMenu=new JMenu("个人信息管理");
        JMenu bookMenu=new JMenu("图书管理");

        //创建二级菜单
        JMenuItem lendHistoryMenuItem=new JMenuItem("借书历史");
        JMenuItem userInfoMenuItem=new JMenuItem("个人信息");
        JMenuItem modifyPsdMenuItem=new JMenuItem("修改密码");
        JMenuItem exitLoginMenuItem=new JMenuItem("退出登录");
        
        JMenuItem lendBookMenuItem=new JMenuItem("借书");
        JMenuItem returnBookMenuItem=new JMenuItem("还书");
        
        userInfoMenu.add(lendHistoryMenuItem);
        userInfoMenu.add(userInfoMenuItem);
        userInfoMenu.add(modifyPsdMenuItem);
        userInfoMenu.add(exitLoginMenuItem);
        bookMenu.add(lendBookMenuItem);
        bookMenu.add(returnBookMenuItem);

        bar.add(bookMenu);
        bar.add(userInfoMenu);

        jf.setJMenuBar(bar);
//        jf.add(jPanel);
//        jf.pack();
        jf.setVisible(true);

        //借书历史
        lendHistoryMenuItem.addActionListener(e -> new LendHistory(userID));
        //个人信息
        userInfoMenuItem.addActionListener(e -> new UserInfo(userID));
        //修改密码
        modifyPsdMenuItem.addActionListener(e -> new ModifyPassword(userID));
        //退出登录
        exitLoginMenuItem.addActionListener(e -> { jf.dispose();new Login();});
        //借书
        lendBookMenuItem.addActionListener(e -> new LendBook(userID));
        //还书
        returnBookMenuItem.addActionListener(e -> new ReturnBook(userID));
    }

    public static void main(String[] args) {
        new UserForm("199074001");
    }
}
