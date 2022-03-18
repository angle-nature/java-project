package package06;

public class DemoMain {
    public static void main(String[] args) {
        // 匿名内部类 （没有类名称）
        MyInterface objA = new MyInterface() {
            @Override
            public void method() {
                System.out.println("匿名内部类重写了接口方法！");
            }
        }; // 注意分号

        objA.method();
    }
}
