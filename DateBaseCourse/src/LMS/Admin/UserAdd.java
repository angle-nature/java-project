package LMS.Admin;

import LMS.DBUtils;

import javax.swing.*;

public class UserAdd {

    public UserAdd() {
        String[] userSex=new String[]{"男","女"};
        String[] lendNum=new String[20];
        for (int i=0;i<20;i++)
            lendNum[i]= String.valueOf(i+1);
        JFrame jf=new JFrame("用户注册");
        JPanel jPanel=new JPanel(null);

        JLabel IDLabel=new JLabel("用户编号：  ");
        JLabel nameLabel=new JLabel("用户姓名：  ");
        JLabel sexLabel=new JLabel("用户性别：  ");
        JLabel deptLabel=new JLabel("用户专业：  ");
        JLabel lendNumLabel=new JLabel("可借数量：  ");

        JTextField IDTf=new JTextField(12);
        JTextField nameTf=new JTextField(12);
        JComboBox sexJcb=new JComboBox(userSex);
        JTextField deptTf=new JTextField(12);
        JComboBox lendNumJcb=new JComboBox(lendNum);
        JButton btn1=new JButton("注册");
        JButton btn2=new JButton("取消");

        IDLabel.setBounds(15,10,75,30);
        nameLabel.setBounds(15,40,75,30);
        sexLabel.setBounds(15,70,75,30);
        deptLabel.setBounds(15,100,75,30);
        lendNumLabel.setBounds(15,130,75,30);
        IDTf.setBounds(90,10,140,25);
        nameTf.setBounds(90,40,140,25);
        sexJcb.setBounds(90,70,140,25);
        deptTf.setBounds(90,100,140,25);
        lendNumJcb.setBounds(90,130,140,25);
        btn1.setBounds(45,170,60,30);
        btn2.setBounds(140,170,60,30);

        jPanel.add(IDLabel);
        jPanel.add(IDTf);
        jPanel.add(nameLabel);
        jPanel.add(nameTf);
        jPanel.add(sexLabel);
        jPanel.add(sexJcb);
        jPanel.add(deptLabel);
        jPanel.add(deptTf);
        jPanel.add(lendNumLabel);
        jPanel.add(lendNumJcb);
        jPanel.add(btn1);
        jPanel.add(btn2);

        jf.add(jPanel);
        jf.setBounds(700, 300, 260, 250);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(jf.DISPOSE_ON_CLOSE);
        jf.setVisible(true);

        btn1.addActionListener(e -> {
            String userID=IDTf.getText().strip();
            String name=nameTf.getText().strip();
            String sex=sexJcb.getSelectedItem().toString();
            String dept=deptTf.getText().strip();
            String lendNum1 =lendNumJcb.getSelectedItem().toString();

            if("".equals(userID))
                JOptionPane.showMessageDialog(null, "用户编号为空！");
            else if("".equals(name))
                JOptionPane.showMessageDialog(null, "用户姓名为空！");
            else{
                String insertSql="insert into reader values('"+userID+"','"+name+"','"+sex+"','"+dept+"',"+ lendNum1 +",'"+userID+"')";
                if(new DBUtils().executeUpdateSql(insertSql)){
                    jf.dispose();
                    JOptionPane.showMessageDialog(null, "注册成功！");
                }
                else
                    JOptionPane.showMessageDialog(null, "注册失败！", "提示",JOptionPane.ERROR_MESSAGE);
            }
        });

        btn2.addActionListener(e -> jf.dispose());
    }
}
