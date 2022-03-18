package work;

public class SaveThread extends Thread {

	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		try {
			while(true) {
				if(Bent.count>=100) {
					Bent.count-=100;
					System.out.println(super.getName()+"正在取100元……  剩余余额："+Bent.count);
				}
				else {
					System.out.println("账户余额不足100元，请充值！");
				}
				super.sleep(500);
			}
		}catch(Exception e) {
			
		}
	}

}
