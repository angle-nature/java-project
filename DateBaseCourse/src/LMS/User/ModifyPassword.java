package LMS.User;

import LMS.DBUtils;

import javax.swing.*;

public class ModifyPassword {
    private String userID;

    public ModifyPassword(String userID) {
        this.userID = userID;

        JFrame jf=new JFrame("修改密码");
        jf.setBounds(800, 300, 250, 230);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(jf.DISPOSE_ON_CLOSE);

        JPanel jp=new JPanel(null); //自由布局
        JLabel jlb1=new JLabel("原密码：");
        JLabel jlb2=new JLabel("新密码：");
        JLabel jlb3=new JLabel("确认新密码：");

        JPasswordField jpf1=new JPasswordField();
        JPasswordField jpf2=new JPasswordField();
        JPasswordField jpf3=new JPasswordField();

        jpf1.setEchoChar('\0'); //修改密码框可见

        JButton jbtn1=new JButton("确认");
        JButton jbtn2=new JButton("取消");

        jlb1.setBounds(15,12,75,30);
        jlb2.setBounds(15,52,75,30);
        jlb3.setBounds(15,92,100,30);
        jpf1.setBounds(90,15,140,25);
        jpf2.setBounds(90,55,140,25);
        jpf3.setBounds(90,92,140,25);
        jbtn1.setBounds(45,150,60,30);
        jbtn2.setBounds(140,150,60,30);

        jp.add(jlb1);
        jp.add(jlb2);
        jp.add(jlb3);
        jp.add(jpf1);
        jp.add(jpf2);
        jp.add(jpf3);
        jp.add(jbtn1);
        jp.add(jbtn2);

        jf.add(jp);
        jf.setVisible(true);

        //确认修改密码
        jbtn1.addActionListener(e -> {
            String[] userInfo=new DBUtils().returnUserInfo(userID);
            String inputOriginPassword=new String(jpf1.getPassword()).strip();
            String newPassword1=new String(jpf2.getPassword()).strip();
            String newPassword2=new String(jpf3.getPassword()).strip();

            if(!userInfo[5].equals(inputOriginPassword))
                JOptionPane.showMessageDialog(null, "原密码不正确！", "提示",JOptionPane.ERROR_MESSAGE);
            else if("".equals(newPassword1))
                JOptionPane.showMessageDialog(null, "新密码为空！", "提示",JOptionPane.WARNING_MESSAGE);
            else if(!newPassword1.equals(newPassword2))
                JOptionPane.showMessageDialog(null, "两次输入的新密码不相同！", "提示",JOptionPane.WARNING_MESSAGE);
            else{
                boolean isModify=new DBUtils().modifyPassword(userID,newPassword1);
                if(isModify){
                    jf.dispose();
                    JOptionPane.showMessageDialog(null, "密码修改成功！", "提示",JOptionPane.WARNING_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(null, "密码修改失败！", "提示",JOptionPane.WARNING_MESSAGE);
            }
        });

        //取消修改密码
        jbtn2.addActionListener(e -> jf.dispose());
    }
}
