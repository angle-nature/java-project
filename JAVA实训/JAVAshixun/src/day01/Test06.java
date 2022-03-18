package day01;

import java.util.Random;
import java.util.Scanner;

public class Test06 {
	public static void main(String[] args) {
		Random random=new Random();
		int randomNumber=random.nextInt(1000)+1;//0~1000
		Scanner scanner=new Scanner(System.in);
		while(true) {
			System.out.println("请输入一个整数：");
			try {
//                scanner = new Scanner(System.in);
				int inputNumber = scanner.nextInt(); //输入整型数据;
				if (inputNumber > randomNumber) {
					System.out.println("猜大了！");
				} else if (inputNumber < randomNumber) {
					System.out.println("猜小了");
				} else {
					System.out.println("猜对了！");
					break;
				}
			} catch (Exception e) {
				scanner.next(); //捕获异常输入，防止其在输入流一直等待
				System.out.println("输入错误！");
			} finally {
//                scanner.close(); //不能在此关闭，关闭将使标准输入流无法再被打开
			}
		}
		scanner.close(); //最后关闭标准输入流
	}
}
