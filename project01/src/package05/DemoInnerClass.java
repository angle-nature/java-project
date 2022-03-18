package package05;

/*
* 如果一个事物的内部包含另一个事物，那么这就是一个类内部包含另一个类
*
* 分类：
* 1、成员内部类
* 2、局部内部类（包括匿名内部类）
*
* 成员内部类的定义格式：
* 修饰符 class 外部类名称{
*   修饰符 class 内部类名称{
*       //...
*   }
*   //...
* }
*
* 注意：内用外，随意访问；外用内，需要内部对象。
* */

public class DemoInnerClass {
    public static void main(String[] args) {
        Body body = new Body();
        body.setName("张三");
        // 通过外部类的对象，调用外部类的方法，里面再间接使用内部类Heart
        body.methodBody();
        Body.Heart heart = new Body().new Heart(); // 或 body.new Heart()
    }
}
