package day06.pm.game;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.Random;

public class GamePanel extends JPanel implements MouseListener {
    private PictureButton[] picBtnS;
    private PictureButton blankPicBtn;  //空白块
    private int countOrigin;  //最大可用步数
    private int count;  //当前剩余步数
    private boolean addMouse=true; //避免重复添加鼠标监听器
    private int level;
    private PictureInfo picInfo;

    public GamePanel(int level){
        this.level=level;
        this.setLayout(null);
        picInfo=new PictureInfo(level);
        picBtnS=new PictureButton[level*level];
        countOrigin=Integer.parseInt(GameFrame.countLb.getText());
        count=countOrigin;
        for (int j = 0; j < level; j++) {
            for (int i = 0; i < level; i++) {
                int x=i*picInfo.getWidth();
                int y=j*picInfo.getHeight();
                int k=j*level+i+1;
                int id=level-2;
                picBtnS[k-1]=new PictureButton();
                picBtnS[k-1].setPlace(k);
                String picStr="Image/images"+id+"/"+k+".jpg";
                picBtnS[k-1].setIcon(new ImageIcon(picStr));
                picBtnS[k-1].setSize(picInfo.getWidth(),picInfo.getHeight());
                picBtnS[k-1].setLocation(x,y);
                this.add(picBtnS[k-1]);
            }
        }
        blankPicBtn=picBtnS[picBtnS.length-1];
    }

    public void setRandom(){
        Random random=new Random();
        GameFrame.countLb.setText(String.valueOf(countOrigin));
        count=countOrigin;
        if(addMouse){
            for (int i = 0; i < picBtnS.length; i++) {
                picBtnS[i].addMouseListener(this);
            }
            addMouse=false;
        }

        for (int i = 0; i < 100; i++) {
            int ranInt1=random.nextInt(picBtnS.length);
            int ranInt2=random.nextInt(picBtnS.length);
            int x1=picBtnS[ranInt1].getX();
            int y1=picBtnS[ranInt1].getY();
            int x2=picBtnS[ranInt2].getX();
            int y2=picBtnS[ranInt2].getY();
            picBtnS[ranInt1].setLocation(x2,y2);
            picBtnS[ranInt2].setLocation(x1,y1);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        PictureButton clickPicBtn=(PictureButton)e.getSource();
        int cX=clickPicBtn.getX();
        int cY=clickPicBtn.getY();
        int bX=blankPicBtn.getX();
        int bY=blankPicBtn.getY();
        if((cX==bX+picInfo.getWidth()&&cY==bY)
            ||cX==bX-picInfo.getWidth()&&cY==bY
            ||cX==bX&&cY==bY+picInfo.getHeight()
            ||cX==bX&&cY==bY-picInfo.getHeight()){
            clickPicBtn.setLocation(bX,bY);
            blankPicBtn.setLocation(cX,cY);
            count--;
            GameFrame.countLb.setText(String.valueOf(count));
        }

//        if(cX==bX+picInfo.getWidth()&&cY==bY){
//            clickPicBtn.move(Direction.LEFT);
//            blankPicBtn.move(Direction.RIGHT);
//            count--;
//            GameFrame.countLb.setText(String.valueOf(count));
//        }else if(cX==bX-picInfo.getWidth()&&cY==bY){
//            clickPicBtn.move(Direction.RIGHT);
//            blankPicBtn.move(Direction.LEFT);
//            count--;
//            GameFrame.countLb.setText(String.valueOf(count));
//        }else if(cX==bX&&cY==bY+picInfo.getHeight()){
//            clickPicBtn.move(Direction.UP);
//            blankPicBtn.move(Direction.DOWN);
//            count--;
//            GameFrame.countLb.setText(String.valueOf(count));
//        }else if(cX==bX&&cY==bY-picInfo.getHeight()){
//            clickPicBtn.move(Direction.DOWN);
//            blankPicBtn.move(Direction.UP);
//            count--;
//            GameFrame.countLb.setText(String.valueOf(count));
//        }

        if(isSuccess()){
            int i=JOptionPane.showConfirmDialog(this,"拼图成功！再来一局？","成功提示",JOptionPane.YES_NO_OPTION);
            if(i==JOptionPane.YES_OPTION){
                setRandom();
            }
        }

        if(count<=0){
            int i=JOptionPane.showConfirmDialog(this,"拼图失败！再来一局？","失败提示",JOptionPane.YES_NO_OPTION);
            if(i==JOptionPane.YES_OPTION){
                setRandom();
            }
        }
    }

    private boolean isSuccess(){
        boolean flag=true;
        for (int i = 0; i < picBtnS.length; i++) {
            int x=picBtnS[i].getX();
            int y=picBtnS[i].getY();
            int k=level*y/picInfo.getHeight()+x/picInfo.getWidth()+1;
            if(k!=picBtnS[i].getPlace()){
                flag=false;
                break;
            }
        }
        return flag;
    }

    public void save(){
        String data="";
        for (int i = 0; i < picBtnS.length; i++) {
            int x=picBtnS[i].getX();
            int y=picBtnS[i].getY();
            int k=level*y/picInfo.getHeight()+x/picInfo.getWidth()+1;
    data+=k;
}
        data+="\n"+count;

                try {
                BufferedWriter out = new BufferedWriter(new FileWriter("Image/gameData.txt"));
                out.write(data);
                out.close();
                } catch (IOException e) {
                e.printStackTrace();
                }
                }

    public void openRecent(){
        File file = new File("Image/gameData.txt");
        BufferedReader reader = null;
        String[] tempString = null;

        //读取文件内容
        try {
            reader = new BufferedReader(new FileReader(file));
            tempString = new String[3];
            int line=0;
            while ((tempString[line] = reader.readLine()) != null) {
                System.out.println(tempString[line++]);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //为图片重新规划位置
        for (int i = 0; i < picBtnS.length; i++) {
            int num=tempString[0].charAt(i)-'0';
            int x=((num-1)%level)*picInfo.getWidth();
            int y=((num-1)/level)*picInfo.getHeight();
            picBtnS[i].setLocation(x,y);
        }

        //设置为保存的剩余步数
        count=Integer.parseInt(tempString[1]);
        GameFrame.countLb.setText(String.valueOf(count));

        //添加鼠标监听器
        if(addMouse){
            for (int i = 0; i < picBtnS.length; i++) {
                picBtnS[i].addMouseListener(this);
            }
            addMouse=false;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }
    @Override
    public void mouseReleased(MouseEvent e) {

    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
