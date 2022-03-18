package day04.am;

import java.util.Date;

public class Test02 {

	public static void main(String[] args) {
 		 Dot[] dots=new Dot[3];
 		 dots[3]=new Dot(20,30.5);   //泛型擦除    Integer->Object ,Double->Object
//		 Dot<Integer,String> dot1=new Dot<Integer,String> (20, "45度");
//		 Dot<String,String> dot2=new Dot<String,String>("东经38度", "北纬18度");
//		 Dot<Date,Location> dot3=new Dot<Date,Location>(new Date(), new Location("东经38度", "北纬18度"));
//		 dots[0]=dot1;
//		 dots[1]=dot2;
//		 dots[2]=dot3;
//		 for (int i = 0; i < dots.length; i++) {
//			System.out.println(dots[i].getX() +" , "+ dots[i].getY());
//		}
//		 
		 
		//Dot<Integer,String>[] dots=new Dot[3];
		// dots[0]=new Dot<Integer,String>(20,"45度");
		// dots[1]=new Dot<Integer,String>(30,"20度");
		// dots[3]=new Dot<Date,Location>(new Date(), new Location("东经38度", "北纬18度"));
		 
	}

}
