package shiyan;

import  java.applet.*;
import  java.awt.*;

public class AppLife extends Applet{
		static  int  a,b,c,d;
		int  x1=150,y1=50,x2=300,y2=50;
		public  void  paint  (Graphics  g) {
			g.drawLine(x1,y1,x1,y2);	
			g.drawLine(x1,y1,x1,y1+a);
			g.drawString ("init",x1,y1);
			g.drawLine(x1+50,y1,x1+50,y1+b);
			g.drawString("start",x1+50,y1);
			g.drawLine(x1+100,y1,x1+100,y1+c);
			g.drawString("stop",x1+100,y1);
			g.drawLine(x1+150,y1,x1+150,y1+d);
			g.drawString("destory",x2,y2);
		}
		public  void  init() {
	         a+=50;
	         repaint();
		}
		public  void  start() {
	         b+=50;
	         repaint();
		}
		public  void  stop() {
	         c+=50;
	         repaint();
		}
		public  void  destroy() {
	         d+=50;
	         repaint();
		}

}
