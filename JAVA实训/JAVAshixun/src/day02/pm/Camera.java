package day02.pm;

public class Camera implements Usb {

	@Override
	public void connect() {
		System.out.println("照相机连接PC设备...");

	}

	@Override
	public void readandwrite() {
		System.out.println("通过USB接口读写照相机内信息....");

	}

	@Override
	public void disconnect() {
		System.out.println("照相机断开与PC设备的连接...");

	}

}
