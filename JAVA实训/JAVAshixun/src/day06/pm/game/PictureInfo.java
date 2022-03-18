package day06.pm.game;

public class PictureInfo {
    public int width;
    public int height;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public PictureInfo(int level) {
        if(level==3){
            width=138;
            height=116;
        }else if(level==4){
            width=150;
            height=126;
        }else if(level==5){
            width=130;
            height=104;
        }
    }
}
