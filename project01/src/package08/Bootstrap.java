package package08;
import red.RedPacketFrame;
/*
* 场景说明：
*   红包发出去之后，所有人都有红包，大家抢完了之后，最后一个红包给群主自己
*
* 红包分发的策略：
*   1、普通红包（平均）：totalMoney / totalNumber,余数放在最后一个红包当中
*   2、收起红包（随机）：最少1分钱，最多不超过平均数的二倍
* */
public class Bootstrap {
    public static void main(String[] args) {
        MyRed myRed = new MyRed("红包");
    }

}
