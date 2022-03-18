package package05;

public class Demo01InnerClass {
    public static void main(String[] args) {
        Outer.Inner obj = new Outer().new Inner();
        obj.methodInner();
    }

}
