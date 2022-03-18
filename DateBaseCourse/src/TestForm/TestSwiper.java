package TestForm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TestSwiper extends JFrame {
    MyJPanel mp;
    int index;
    ImageIcon[] imgs = {
            new ImageIcon("F:\\Java Project\\DateBaseCourse\\Image\\10.jpg"),
            new ImageIcon("F:\\Java Project\\DateBaseCourse\\Image\\11.jpg"),
            new ImageIcon("F:\\Java Project\\DateBaseCourse\\Image\\12.jpg"),
            new ImageIcon("F:\\Java Project\\DateBaseCourse\\Image\\library1.jpg"),
            new ImageIcon("F:\\Java Project\\DateBaseCourse\\Image\\library3.jpg"),
            new ImageIcon("F:\\Java Project\\DateBaseCourse\\Image\\library4.jpg"),
            new ImageIcon("F:\\Java Project\\DateBaseCourse\\Image\\library5.jpg"),
            new ImageIcon("F:\\Java Project\\DateBaseCourse\\Image\\library6.jpg"),
    };
    public TestSwiper() {
        mp = new MyJPanel();
        this.add(mp);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("窗口");
        this.setVisible(true);
        Timer timer = new Timer(1000,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mp.repaint();
            }
        });
        timer.start();
    }
    public static void main(String[] args) {
        new TestSwiper();
    }
    class MyJPanel extends JPanel{
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.drawImage(imgs[index%imgs.length].getImage(), 0, 0,this);
            index++;
        }
    }
}
