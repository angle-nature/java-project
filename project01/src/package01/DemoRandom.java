package package01;

import java.util.Random;

public class DemoRandom {
    public static void main(String[] args){
        Random random=new Random();

        for(int i=0;i<10;i++){
            System.out.println(random.nextInt(10));  //取值范围[0,10)
        }
    }
}
