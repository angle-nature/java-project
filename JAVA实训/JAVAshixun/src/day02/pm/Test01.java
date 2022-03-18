package day02.pm;

public class Test01 {
      //面向功能扩展开放，面向代码修改关闭
	   // 面向接口编程（接口回调）
	public static void main(String[] args) {
         Computer c1=new Computer();
         Camera camera=new Camera();
          MP3 mp3=new MP3();
         
         c1.useUSB(camera);    
         c1.useUSB(mp3); 

	}

}
