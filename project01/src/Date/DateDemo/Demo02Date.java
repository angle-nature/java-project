package Date.DateDemo;

import java.util.Date;

public class Demo02Date {
    public static void main(String[] args) {
        getDate01();
        getDate02();
        getDate03();
    }

    private static void getDate01(){
        Date date = new Date();
        System.out.println(date); //Sun Mar 28 17:27:18 CST 2021 (CST：中国标准时间)
    }

    private static void getDate02(){
        /*
        * Date类带参数的构造方法：
        *   Date(long date)：传递毫秒值，把毫秒值转换为Date日期
        * */
        Date date = new Date(System.currentTimeMillis());
        System.out.println(date); //Sun Mar 28 17:27:18 CST 2021 (CST：中国标准时间)
    }

    private static void getDate03(){
        /*
         * long getTime()
         *   返回自时间原点到现在的毫秒值
         * */
        Date date = new Date();
        long time = date.getTime(); // 等价于 System.currentTimeMillis();
        System.out.println(time); //Sun Mar 28 17:27:18 CST 2021 (CST：中国标准时间)
    }
}
