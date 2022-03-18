package day06.pm.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class StartForm extends JFrame implements ItemListener {
    private JRadioButton easyRadioBtn=null;
    private JRadioButton midRadioBtn=null;
    private JRadioButton diffRadioBtn=null;
    private ButtonGroup btg=null;    //定义按钮组
    private JButton startBtn=null;
    private JPanel panel1=null;
    private JPanel panel2=null;
    private JPanel panel3=null;
    private int level=3;

    public StartForm(){
        easyRadioBtn=new JRadioButton("简单",true);
        midRadioBtn=new JRadioButton("中等");
        diffRadioBtn=new JRadioButton("困难");
        btg=new ButtonGroup();
        btg.add(easyRadioBtn);
        btg.add(midRadioBtn);
        btg.add(diffRadioBtn);
        easyRadioBtn.addItemListener(this);
        midRadioBtn.addItemListener(this);
        diffRadioBtn.addItemListener(this);
        panel1=new JPanel();
        panel1.add(new JLabel("请选择难度"));
        panel2=new JPanel();
        panel2.add(easyRadioBtn);
        panel2.add(midRadioBtn);
        panel2.add(diffRadioBtn);
        panel3=new JPanel();
        startBtn=new JButton("开始");
        panel3.add(startBtn);

        this.setTitle("拼图小游戏");
        this.setLayout(new BorderLayout());
        this.add(panel1,BorderLayout.NORTH);
        this.add(panel2,BorderLayout.CENTER);
        this.add(panel3,BorderLayout.SOUTH);
        this.setBounds(300,200,250,150);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        JFrame jf=this;

        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GameFrame(level);
                jf.dispose();
            }
        });
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource()==easyRadioBtn){
            level=3;
        }
        else if(e.getSource()==midRadioBtn){
            level=4;
        }
        else if(e.getSource()==diffRadioBtn){
            level=5;
        }
    }

    public static void main(String[] args) {
        new StartForm();
    }
}
