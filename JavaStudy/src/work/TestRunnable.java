package work;

import java.applet.*;
import java.awt.*;
@SuppressWarnings("deprecation")
public class TestRunnable  implements Runnable{

	Label prompt1=new Label("the first thread");
	Label prompt2=new Label("the second thread");
	TextField threadFirst=new TextField(14);
	TextField threadSecond=new TextField(14);
	Thread thread1, thread2;
	int count1=0,count2=0;
	/*public void inin() {
		 add(prompt1);
		 add(threadFirst);
		 add(prompt2);
		 add(threadSecond);
	 }*/
	public void start() {
		 thread1=new Thread(this, "FirstThread");
		 thread2=new Thread(this, "SecondThread");
		 thread1.start();
		 thread2.start();
	}
	public void run() {
		 String currentRunning;
		 while(true) {
			 try{
				 Thread.sleep((int)(Math.random()*10000));
			 }
			 catch(Exception e) {}
			 currentRunning=Thread.currentThread().getName();
			 if(currentRunning.equals("FirstTheard"))
			 {
				 count1++;
				 threadFirst.setText("the first thread"+count1+"use");
			 }
			 else if(currentRunning.equals("SecondThread"))
			 {
				 count2++;
				 threadSecond.setText("the second thread"+count2+"use");
			 }
		 }
	}
}


