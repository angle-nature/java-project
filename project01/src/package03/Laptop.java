package package03;

public class Laptop {

    public void powerOn(){
        System.out.println("笔记本开机");
    }

    public void powerOff()
    {
        System.out.println("笔记本关机");
    }

    public void usbDevice(USB usb)
    {
        usb.open();
        if(usb instanceof Mouse){
            ((Mouse) usb).click();  //向下转型
        }

        if(usb instanceof Keyboard){
            ((Keyboard) usb).type();
        }
        usb.close();
    }
}
