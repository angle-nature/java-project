package work;

public class WithdrawThread extends Thread{

	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		try {
			while(true){
				Bent.count+=80;
				System.out.println(super.getName()+"���ڴ���80Ԫ��ʣ����"+Bent.count);
				Thread.sleep(450);
			}

		}catch(Exception e) {
			
		}
	}

}
