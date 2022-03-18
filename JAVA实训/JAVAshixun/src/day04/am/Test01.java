package day04.am;

import java.util.Date;

public class Test01 {

	public static void main(String[] args) {
	//   Dot<Double> dot1=new Dot<Double>(10.2, 20.5);
	//   Dot<Integer> dot2=new Dot<Integer> (5, 8);   //int->double  隐式类型转换
//	   
	  Dot<Integer,String> dot3=new Dot<Integer,String> (20, "45度");  //点是极坐标中的点(20,45度)
//	  Dot dot4=new Dot("东经38度", "北纬18度");  //点是GIS坐标中的点("东经38度","北纬18度") 
//	  Dot dot5=new Dot(new Date(), new Location("东经38度", "北纬18度"));  //系统中自定义的点，（时间轴，位置），位置是自己定义的类
	

	  System.out.println(dot3.getX()+dot3.getY());
	
	}

}


//5->int->Integer->Object    对象上转型      ->Double  对象下转型基本要求：下转型的对象必须是由相应的类创建的
//double->Double->Object
//String->Object
//Date->Object
//Location->Object
//泛型：对象->类