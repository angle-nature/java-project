package LMS.Admin;

import javax.swing.*;

public class AdministratorForm {
    private JFrame jf=new JFrame("管理员界面");

    public AdministratorForm(){

        ImageIcon background = new ImageIcon("F:\\Java Project\\DateBaseCourse\\Image\\AHUTLibrary.jpg");
        JLabel imageLabel=new JLabel(background);
        imageLabel.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
        jf.getLayeredPane().add(imageLabel, Integer.valueOf(Integer.MIN_VALUE));
        JPanel jPanel = (JPanel) jf.getContentPane();
        jPanel.setOpaque(false);

        //创建菜单栏
        JMenuBar bar=new JMenuBar();

        //创建一级菜单
        JMenu jm1=new JMenu("用户管理");
        JMenu jm2=new JMenu("图书管理");
        JMenu jm3=new JMenu("关于我们");

        //创建二级菜单
        JMenuItem jmt1_1=new JMenuItem("用户信息维护");
        JMenuItem jmt1_2=new JMenuItem("用户注册");
        JMenuItem jmt2_1=new JMenuItem("图书信息维护");
        JMenuItem jmt2_2=new JMenuItem("增加图书");

        jm1.add(jmt1_1);
        jm1.add(jmt1_2);
        jm2.add(jmt2_1);
        jm2.add(jmt2_2);

        bar.add(jm1);
        bar.add(jm2);
        bar.add(jm3);

        jf.setJMenuBar(bar);

        jf.setBounds(400, 130, 894, 516);
        jf.setVisible(true);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);

        jmt1_1.addActionListener(e -> new UserUpdate());

        jmt1_2.addActionListener(e -> new UserAdd());

        jmt2_1.addActionListener(e -> new BookUpdate());

        jmt2_2.addActionListener(e -> new BookAdd());
    }

}
