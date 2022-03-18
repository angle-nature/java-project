package package02;

import java.util.Arrays;

public class Demo01Arrays {
    public static void main(String[] args) {
        int[] intArray = {10,20,30};
        //Arrays.toString() 将数组转换为[元素1,元素2,元素3.....]的字符串形式
        String intString= Arrays.toString(intArray);
        System.out.println(intString);

    }
}
