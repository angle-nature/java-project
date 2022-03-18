package day02.pm;

public class MP3 implements Usb {

	@Override
	public void connect() {
		System.out.println("MP3连接PC设备...");

	}

	@Override
	public void readandwrite() {
		System.out.println("通过USB接口读写MP3内信息....");

	}

	@Override
	public void disconnect() {
		System.out.println("MP3断开与PC设备的连接...");

	}
}
