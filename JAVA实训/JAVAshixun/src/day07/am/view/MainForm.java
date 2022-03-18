package day07.am.view;

import day07.am.model.UserLogin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    private UserLogin userLogin;
    private JMenuBar menuBar;
    private JMenu studentMenu;
    private JMenuItem addStuItem,selectStuItem,showAllStuItem;

    public MainForm(UserLogin u){
        this.userLogin=u;
        menuBar=new JMenuBar();
        studentMenu=new JMenu("学生信息管理");
        addStuItem=new JMenuItem("添加学生信息");
        selectStuItem=new JMenuItem("查询学生信息");
        showAllStuItem=new JMenuItem("显示所有学生信息");

        studentMenu.add(addStuItem);
        studentMenu.add(selectStuItem);
        studentMenu.add(showAllStuItem);
        menuBar.add(studentMenu);

        this.setJMenuBar(menuBar);
        JLabel background=new JLabel();
        background.setIcon(new ImageIcon("Image/bj.jpg"));
        this.add(background);
        this.setBounds(100,100,1112,702);
        this.setTitle("欢迎"+u.getUserName()+"登录访问学生信息管理系统");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

        if(u.getUserPrivilege()!=0){
            addStuItem.setEnabled(false);
            showAllStuItem.setEnabled(false);
        }

        addStuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddStuForm();
            }
        });

        selectStuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SelectStuForm();
            }
        });

        showAllStuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowStudentForm2();
//                new ShowStudentForm1();
            }
        });
    }
}
