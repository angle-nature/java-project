package view;


import po.Student;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    private JMenuBar menuBar;
    private JMenu courseMenu,scoreMenu,informationMenu;
    private JMenuItem queryScheduleItem,querySelectedCourseItem,queryCourseItem;
    private JMenuItem queryScoreItem;
    private JMenuItem queryStuInfoItem,queryTeacherInfoItem;

    public MainForm(Student student){
        menuBar=new JMenuBar();
        courseMenu=new JMenu("选课管理");
        courseMenu.setIcon(new ImageIcon("images/课程管理.png"));
        queryScheduleItem=new JMenuItem("查看开课情况");
        queryCourseItem=new JMenuItem("查看课程详细信息");
        querySelectedCourseItem=new JMenuItem("查看选课情况");
        scoreMenu=new JMenu("成绩管理");
        scoreMenu.setIcon(new ImageIcon("images/成绩.png"));
        queryScoreItem=new JMenuItem("查看成绩");
        informationMenu=new JMenu("信息管理");
        informationMenu.setIcon(new ImageIcon("images/信息.png"));
        queryStuInfoItem=new JMenuItem("查看个人信息");
        queryTeacherInfoItem=new JMenuItem("查看老师信息");

        courseMenu.add(queryScheduleItem);
        courseMenu.add(querySelectedCourseItem);
        courseMenu.add(queryCourseItem);
        menuBar.add(courseMenu);

        scoreMenu.add(queryScoreItem);
        menuBar.add(scoreMenu);

        informationMenu.add(queryStuInfoItem);
        informationMenu.add(queryTeacherInfoItem);
        menuBar.add(informationMenu);

        this.setJMenuBar(menuBar);
        JLabel background=new JLabel();
        background.setIcon(new ImageIcon("images/background.jpg"));
        this.add(background);
        this.setBounds(100,100,1112,702);
        this.setTitle("欢迎"+student.getName()+"登录访问选课管理系统");
        this.setIconImage(new ImageIcon("images/选课.png").getImage());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

        queryScheduleItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ScheduleForm(student);
            }
        });

        queryCourseItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CourseForm(student);
            }
        });

        querySelectedCourseItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TimeTableForm(student);
            }
        });

        queryScoreItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GradeForm(student);
            }
        });

        queryStuInfoItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentInfoForm(student);
            }
        });

        queryTeacherInfoItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TeacherInfoForm(student);
            }
        });
    }
}