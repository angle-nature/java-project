package LMS.User;

import LMS.DBUtils;

import javax.swing.*;
import java.util.Vector;

public class LendBookInfo {
    private String userID;
    private String[] bookInfo;


    public LendBookInfo(String userID,String[] bookInfo) {
        this.userID=userID;
        this.bookInfo=bookInfo;
        Vector timeVector=new Vector();
        timeVector.add("<-请选择时长(天)->");
        for(int i=1;i<=60;i++)
            timeVector.add(i);

        JFrame jf=new JFrame("是否确认");
        jf.setBounds(750, 300, 250, 230);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(jf.DISPOSE_ON_CLOSE);

        JPanel jp=new JPanel(null); //自由布局
        JLabel jlb1=new JLabel("图书编号：");
        JLabel jlb2=new JLabel("图书名称：");
        JLabel jlb3=new JLabel("借出时长：");

        JTextField jtf1=new JTextField(bookInfo[0]);
        JTextField jtf2=new JTextField(bookInfo[1]);
//        JTextField jtf3=new JTextField();
        JComboBox jcb=new JComboBox(timeVector);

        JButton jbtn1=new JButton("确认");
        JButton jbtn2=new JButton("取消");

        jlb1.setBounds(15,12,75,30);
        jlb2.setBounds(15,52,75,30);
        jlb3.setBounds(15,92,100,30);
        jtf1.setBounds(90,15,140,25);
        jtf2.setBounds(90,55,140,25);
        jcb.setBounds(90,92,140,25);
        jbtn1.setBounds(45,150,60,30);
        jbtn2.setBounds(140,150,60,30);

        jtf1.setEditable(false); //文本框设置为不可编辑
        jtf2.setEditable(false);


        jp.add(jlb1);
        jp.add(jlb2);
        jp.add(jlb3);
        jp.add(jtf1);
        jp.add(jtf2);
        jp.add(jcb);
        jp.add(jbtn1);
        jp.add(jbtn2);

        jf.add(jp);
        jf.setVisible(true);

        //确认事件
        jbtn1.addActionListener(e -> {

            if(jcb.getSelectedIndex()==0)
                JOptionPane.showMessageDialog(null, "请选择时长");
            else{
                int time=Integer.valueOf(jcb.getSelectedItem().toString());
                boolean isInsert=new DBUtils().insertIntoLendBook(userID.strip(),bookInfo[0].strip(),time);
                if(isInsert){
                    jf.dispose();
                    JOptionPane.showMessageDialog(null, "成功借出");
                }else
                    JOptionPane.showMessageDialog(null, "您已借过此书");
            }
        });

        //取消事件
        jbtn2.addActionListener(e -> jf.dispose());
    }
}
