package work;

public class SaveThread extends Thread {

	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		try {
			while(true) {
				if(Bent.count>=100) {
					Bent.count-=100;
					System.out.println(super.getName()+"����ȡ100Ԫ����  ʣ����"+Bent.count);
				}
				else {
					System.out.println("�˻�����100Ԫ�����ֵ��");
				}
				super.sleep(500);
			}
		}catch(Exception e) {
			
		}
	}

}
