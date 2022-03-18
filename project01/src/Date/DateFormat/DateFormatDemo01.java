package Date.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
*   java.text.DateFormat:是日期/时间格式化子类的抽象类
*   作用：
*       格式化（也就是日期 -> 文本）、解析（文本 -> 日期）
*   成员方法：
*       String format(Date date) 按照指定的模式，把Date日期，格式化为符合模式的字符串
*       Date parse(String source) 把符合模式的字符串，解析为Date日期
*   DateFormat 是一个抽象类 有子类 SimpleDateFormat
*
*   SimpleDateFormat 构造方法：
*       SimpleDateFormat(String pattern) 用给定的模式和默认语言环境的日期格式符号构造 SimpleDateFormat
*       参数：
*           String pattern:传递指定的模式
*       模式：区分大小写：
*           y   年
*           M   月
*           d   日
*           H   时
*           m   分
*           s   秒
*       写对应的模式，会把模式替换成对应的日期和时间
*           如：
*           "yyyy-MM-dd HH:mm:ss"
*           "yyyy年MM月dd日 HH时mm分ss秒"
*       注意：模式串中的字母不能更改，连接模式的符号可以改变
* */
public class DateFormatDemo01 {
    public static void main(String[] args) {
        method01();
        method02();
    }

    private static void method01() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String textDate = sdf.format(date);
        System.out.println(date);
        System.out.println(textDate);
    }

    private static void method02(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        try {
            Date date = sdf.parse("2021年04月07日 22时34分33秒");
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
