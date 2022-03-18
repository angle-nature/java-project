package SCMS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm implements ActionListener {

    JFrame frame=new JFrame("学生信息管理系统");
    JMenuBar bar=new JMenuBar();//菜单条

    JMenu menuStu=new JMenu("个人信息管理");
    JMenu menuClass=new JMenu("课程信息管理");
    JMenu menuGrade=new JMenu("成绩管理");

    JMenuItem disAll=new JMenuItem("显示所有学生信息");
    JMenuItem queStu=new JMenuItem("查询个人信息");
    JMenuItem queClass=new JMenuItem("查询课程信息.");
    JMenuItem addOrDelClass=new JMenuItem("添加或删除课程信息:");

    JMenuItem queGrade=new JMenuItem("查询成绩");
    JMenuItem addOrModifyGrade=new JMenuItem("录入或修改成绩");
    JMenuItem queAvg=new JMenuItem("查询平均成绩");
    JMenuItem queSta=new JMenuItem("查看成绩统计");

    public MainForm(){
        bar.add(menuStu);
        bar.add(menuClass);
        bar.add(menuGrade);
        menuStu.add(disAll);
        disAll.addActionListener(this);
        menuStu.add(queStu);
        queStu. addActionListener(this);
        menuClass.add(queClass);
        queClass.addActionListener(this);
        menuClass.add(addOrDelClass);
        addOrDelClass.addActionListener(this);
        menuGrade.add(queGrade);
        queGrade.addActionListener(this);
        menuGrade.add(addOrModifyGrade);
        addOrModifyGrade.addActionListener(this);
        menuGrade.add(queAvg);
        queAvg.addActionListener(this);
        menuGrade.add(queSta);
        queSta.addActionListener(this);
        frame.setJMenuBar(bar);
        frame.setBounds (350,250,300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        // TODO Auto-generated method stub

        if(e.getSource()==disAll){//显示所有学生信息
//            new MenuStudent().showAll();
        }else if(e.getSource()==queStu) {//查询个人信息
//            new MenuStudent().findStu();
        }else if(e.getSource()==queClass) { //查询课程
//            new MenuClass().queClass();
        }else if(e.getSource()==addOrDelClass){//添加或删除课程
//            new MenuClass().addOrDelClass();
        }else if(e.getSource()==queGrade){//查询成绩
//            new MenuGrade().queGrade();
        }else if(e.getSource()==addOrModifyGrade){//录入或修改成绩
//            new MenuGrade().addOrModifyGrade();
        }else if(e.getSource()==queAvg){//查询平均成绩
//            new MenuGrade().average();
        }else if(e.getSource()==queSta){//分数统计
//            new MenuGrade().gradeStatics();
        }
    }

}
