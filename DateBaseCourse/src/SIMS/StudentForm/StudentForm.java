package SIMS.StudentForm;

import SIMS.Register;

import javax.swing.*;

public class StudentForm extends JFrame {
    private String stuID;

    public StudentForm(String stuID) {
        this.stuID=stuID;
        
        ImageIcon background = new ImageIcon("F:\\Java Project\\DateBaseCourse\\Image\\AHUT.jpg");
        JLabel imageLabel=new JLabel(background);
        this.setTitle("[欢迎进入学生信息管理系统(学生端)]");
        this.setSize(845,478);
        this.setLocation(400,130);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        imageLabel.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
        this.getLayeredPane().add(imageLabel, Integer.valueOf(Integer.MIN_VALUE));
        JPanel jPanel = (JPanel) this.getContentPane();
        jPanel.setOpaque(false);
        //创建菜单栏
        JMenuBar bar=new JMenuBar();

        //创建一级菜单
        JMenu userInfoMenu=new JMenu("个人信息管理");
        JMenu scoreMenu=new JMenu("成绩管理");

        //创建二级菜单
        JMenuItem userInfoMenuItem=new JMenuItem("修改个人信息");
        JMenuItem modifyPsdMenuItem=new JMenuItem("修改密码");
        JMenuItem exitLoginMenuItem=new JMenuItem("退出登录");
        JMenuItem queScore=new JMenuItem("查询成绩");

        userInfoMenu.add(userInfoMenuItem);
        userInfoMenu.add(modifyPsdMenuItem);
        userInfoMenu.add(exitLoginMenuItem);
        scoreMenu.add(queScore);

        bar.add(userInfoMenu);
        bar.add(scoreMenu);

        this.setJMenuBar(bar);
        this.setVisible(true);
        
        //个人信息
        userInfoMenuItem.addActionListener(e -> new StuInfo(stuID));
        //修改密码
        modifyPsdMenuItem.addActionListener(e -> new ModifyPassword(stuID));
        //查询成绩
        queScore.addActionListener(e -> new QueScore(stuID));
        //退出登录
        exitLoginMenuItem.addActionListener(e -> { this.dispose();new Register();});
    }

    public static void main(String[] args) {
        new StudentForm("96001");
    }
}