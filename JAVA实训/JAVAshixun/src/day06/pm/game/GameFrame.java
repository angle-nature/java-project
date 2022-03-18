package day06.pm.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame {
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenu lookMenu;
    private JMenuItem saveMenuItem;
    private JMenuItem openMenuItem;
    private JMenuItem lookOriImageMenuItem;
    private JButton startJbt;
    private GamePanel mainPanel;
    public static JLabel countLb;
    private int level;  //难度等级 分为3*3  4*4  5*5  默认为3

    public GameFrame(int level) {
        this.level=level;
        menuBar=new JMenuBar();
        fileMenu=new JMenu("文件");
        lookMenu=new JMenu("查看");
        saveMenuItem=new JMenuItem("保存");
        openMenuItem=new JMenuItem("打开上次存档");
        lookOriImageMenuItem=new JMenuItem("查看原图");

        menuBar.add(fileMenu);
        menuBar.add(lookMenu);
        fileMenu.add(saveMenuItem);
        fileMenu.add(openMenuItem);
        lookMenu.add(lookOriImageMenuItem);

        startJbt=new JButton("开始");
        countLb=new JLabel(String.valueOf((level*level)*30));
        mainPanel=new GamePanel(level);

        this.setLayout(new BorderLayout());
        JPanel p1=new JPanel();
//        p1.setBackground(Color.GRAY);
        p1.add(startJbt);
        p1.add(new JLabel("                                   剩余步数："));
        p1.add(countLb);
        this.add(p1,BorderLayout.NORTH);
        this.add(mainPanel,BorderLayout.CENTER);

        startJbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setRandom();
            }
        });

        saveMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.save();
            }
        });

        openMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.openRecent();
            }
        });

        lookOriImageMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new OriginalImage(level);
            }
        });

        int imageWidth=new PictureInfo(level).getWidth();
        int imageHeight=new PictureInfo(level).getHeight();
        this.setJMenuBar(menuBar);
        this.setTitle("拼图游戏");
        this.setBounds(300,120,imageWidth*level+10,imageHeight*level+90);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
