package package03;

public class DemoMain {
    public static void main(String[] args) {
        Laptop laptop = new Laptop();
        laptop.powerOn();
        USB usb = new Mouse(); //多态写法
        laptop.usbDevice(usb);
        Keyboard keyboard = new Keyboard();
        laptop.usbDevice(keyboard); //正确写法 keyboard 向上转型为 USB
        laptop.powerOff();
    }
}
