package day06.pm.game;

import javax.swing.*;

public class OriginalImage extends JFrame {
    public OriginalImage(int level){
        ImageIcon background = new ImageIcon("Image/"+level+".jpg");
        JLabel imageLabel=new JLabel(background);

        this.add(imageLabel);
        int imageWidth=new PictureInfo(level).getWidth();
        int imageHeight=new PictureInfo(level).getHeight();
        this.setTitle("原图");
        this.setSize(imageWidth*level,imageHeight*level+30);
        this.setLocation(400,130);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
