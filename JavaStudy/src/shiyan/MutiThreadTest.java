package shiyan;

import java.util.Random;

public class MutiThreadTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WorkStudents ws1 = new WorkStudents(1,10);
		WorkStudents ws2 = new WorkStudents(2,20);
		WorkStudents ws3 = new WorkStudents(3,30);
		WorkStudents ws4 = new WorkStudents(4,40);
		new Thread(ws1).start();
		new Thread(ws2).start();
		new Thread(ws3).start();
		new Thread(ws4).start();
	}

}

class ZhuoYi{
	int[] desk=new int[5];
	int[] chair=new int[5];
	private int chairCount=500;
	private int deskCount=500;
	public synchronized Boolean distribute (int id,long sleeptime){
		int chairs = 1;
		int desks = 1;
		Random rdm = new Random (System.currentTimeMillis());
		if (rdm.nextInt()%2==0) {
			if(chairCount>0) {	
				chairs--;
				while(chairs<0) {
					try{
						wait ();
					}catch(Exception e){
					
					}
				}
				System.out.println("student "+id+": wiping desk "+chairCount--);
				chair[id]+=1;
				chairs++;
				notifyAll ();
			}			
		}else {
			if(deskCount>0) {
				desks--;
				while (desks<0) {
					try {
						wait () ;
					}catch(InterruptedException e) {
					
					}
				}			
				System.out.println("student "+id+": wiping desk "+deskCount--);
				desk[id]+=1;
				desks++;
				notifyAll();
			}
		}
		
		if(chairCount==0&&deskCount==0)
			return true;
		else
			return false ;
	}
}

class WorkStudents implements Runnable{
	private long sleepTime;
	private int id;
	static ZhuoYi zy=new ZhuoYi();
	
	public WorkStudents(int id,long time) {
		super();
		this.sleepTime=time;
		this.id=id;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!zy.distribute(id, sleepTime)) {
			try {
				Thread.sleep(sleepTime);
			}catch(Exception  e) {
				e.printStackTrace();
			}						
		}
		System.out.println("Result: Student "+id+" wiped "+zy.desk[id] +"desks and" +zy.chair[id]+" chairs.");				
	}
}
