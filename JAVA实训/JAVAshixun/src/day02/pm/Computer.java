package day02.pm;

public class Computer {

	public void useUSB(Usb u){
		u.connect();
		u.readandwrite();
		u.disconnect();
		
	}
	
}
