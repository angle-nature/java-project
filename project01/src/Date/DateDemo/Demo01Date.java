package Date.DateDemo;
/*
* 把日期转换为毫秒：
*   时间原点：1970 年 1 月 1 日 00:00:00 (英国格林威治的标准时间) (3742767540068L)
* 注意：
*   中国属于东八区，时间增加 8 个小时
*   1970 年 1 月 1 日 08:00:00
* */
public class Demo01Date {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis()); // 获取当前时间（毫秒值）
    }
}
