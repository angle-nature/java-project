package work;

public class WithdrawThread extends Thread{

	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		try {
			while(true){
				Bent.count+=80;
				System.out.println(super.getName()+"正在存入80元，剩余余额："+Bent.count);
				Thread.sleep(450);
			}

		}catch(Exception e) {
			
		}
	}

}
