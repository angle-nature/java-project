package SIMS.AdminForm;

import javax.swing.*;

public class AdminForm extends JFrame {
    private JMenuBar menuBar=null;

    private JMenu stuMenu=null;
    private JMenu courseMenu=null;
    private JMenu scoreMenu=null;

    private JMenuItem stuUpdateMenuItem=null;
    private JMenuItem stuAddMenuItem=null;
    private JMenuItem courseManageMenuItem=null;
    private JMenuItem addCourseMenuItem=null;
    private JMenuItem scoreMenuItem=null;
    private JMenuItem avgScoreMenuItem=null;
    private JMenuItem addScoreMenuItem=null;

    public AdminForm() {

        ImageIcon background = new ImageIcon("F:\\Java Project\\DateBaseCourse\\Image\\AHUT.jpg");
        JLabel imageLabel=new JLabel(background);
        this.setTitle("[欢迎进入学生信息管理系统(管理员端)]");
        this.setSize(845,478);
        this.setLocation(400,130);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        imageLabel.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
        this.getLayeredPane().add(imageLabel, Integer.valueOf(Integer.MIN_VALUE));
        JPanel jPanel = (JPanel) this.getContentPane();
        jPanel.setOpaque(false);

        menuBar=new JMenuBar();
        stuMenu =new JMenu("学生管理");
        courseMenu=new JMenu("课程管理");
        scoreMenu=new JMenu("成绩管理");

        stuUpdateMenuItem=new JMenuItem("学生信息管理");
        stuAddMenuItem=new JMenuItem("添加学生");

        courseManageMenuItem=new JMenuItem("课程信息管理");
        addCourseMenuItem=new JMenuItem("录入课程");

        scoreMenuItem=new JMenuItem("成绩查询");
        avgScoreMenuItem=new JMenuItem("平均成绩查询");
        addScoreMenuItem=new JMenuItem("录入成绩");

        stuMenu.add(stuUpdateMenuItem);
        stuMenu.add(stuAddMenuItem);
        courseMenu.add(courseManageMenuItem);
        courseMenu.add(addCourseMenuItem);
        scoreMenu.add(scoreMenuItem);
        scoreMenu.add(avgScoreMenuItem);
        scoreMenu.add(addScoreMenuItem);

        menuBar.add(stuMenu);
        menuBar.add(courseMenu);
        menuBar.add(scoreMenu);

        this.setJMenuBar(menuBar);
        this.setVisible(true);

        stuUpdateMenuItem.addActionListener(e -> new StuInfoUpdate());
        stuAddMenuItem.addActionListener(e -> new AddStudent());
        courseManageMenuItem.addActionListener(e -> new CourseManage());
        addCourseMenuItem.addActionListener(e -> new AddCourse());
        scoreMenuItem.addActionListener(e -> new ScoreUpdate());
        avgScoreMenuItem.addActionListener(e -> new AvgScore());
        addScoreMenuItem.addActionListener(e -> new AddScore());
    }

    public static void main(String[] args) {
        new AdminForm();
    }
}
