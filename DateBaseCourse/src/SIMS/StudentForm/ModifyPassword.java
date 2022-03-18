package SIMS.StudentForm;

import SIMS.DBOperator;

import javax.swing.*;

public class ModifyPassword {
    private String stuID=null;

    public ModifyPassword(String stuID) {
        this.stuID = stuID;

        JFrame jf=new JFrame("修改密码");
        jf.setBounds(800, 300, 250, 230);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(jf.DISPOSE_ON_CLOSE);

        JPanel jp=new JPanel(null); //自由布局
        JLabel initialPwdLabel=new JLabel("原密码：");
        JLabel newPwd1Label=new JLabel("新密码：");
        JLabel newPwd2Label=new JLabel("确认新密码：");

        JPasswordField initialPwdPf=new JPasswordField();
        JPasswordField newPwdPf1=new JPasswordField();
        JPasswordField newPwdPf2=new JPasswordField();

        initialPwdPf.setEchoChar('\0'); //修改密码框可见

        JButton comfirmBtn=new JButton("确认");
        JButton cancelBtn=new JButton("取消");

        initialPwdLabel.setBounds(15,12,75,30);
        newPwd1Label.setBounds(15,52,75,30);
        newPwd2Label.setBounds(15,92,100,30);
        initialPwdPf.setBounds(90,15,140,25);
        newPwdPf1.setBounds(90,55,140,25);
        newPwdPf2.setBounds(90,92,140,25);
        comfirmBtn.setBounds(45,150,60,30);
        cancelBtn.setBounds(140,150,60,30);

        jp.add(initialPwdLabel);
        jp.add(newPwd1Label);
        jp.add(newPwd2Label);
        jp.add(initialPwdPf);
        jp.add(newPwdPf1);
        jp.add(newPwdPf2);
        jp.add(comfirmBtn);
        jp.add(cancelBtn);

        jf.add(jp);
        jf.setVisible(true);

        //确认修改密码
        comfirmBtn.addActionListener(e -> {
            String[] stuInfo=new DBOperator().getStuInfo(stuID);
            String inputOriginPassword=new String(initialPwdPf.getPassword()).strip();
            String newPassword1=new String(newPwdPf1.getPassword()).strip();
            String newPassword2=new String(newPwdPf2.getPassword()).strip();

            if(!stuInfo[6].equals(inputOriginPassword))
                JOptionPane.showMessageDialog(null, "原密码不正确！", "提示",JOptionPane.ERROR_MESSAGE);
            else if("".equals(newPassword1))
                JOptionPane.showMessageDialog(null, "新密码为空！", "提示",JOptionPane.WARNING_MESSAGE);
            else if(!newPassword1.equals(newPassword2))
                JOptionPane.showMessageDialog(null, "两次输入的新密码不相同！", "提示",JOptionPane.WARNING_MESSAGE);
            else{
                boolean isModify=new DBOperator().modifyPassword(stuID,newPassword1);
                if(isModify){
                    jf.dispose();
                    JOptionPane.showMessageDialog(null, "密码修改成功！", "提示",JOptionPane.WARNING_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(null, "密码修改失败！", "提示",JOptionPane.WARNING_MESSAGE);
            }
        });

        //取消修改密码
        cancelBtn.addActionListener(e -> jf.dispose());
    }
}
