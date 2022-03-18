package SIMS.AdminForm;

import SIMS.DBOperator;

import javax.swing.*;

public class AddStudent {

    public AddStudent() {
        String[] userSex=new String[]{"男","女"};
        JFrame jf=new JFrame("添加学生");
        JPanel jPanel=new JPanel(null);

        JLabel IDLabel=new JLabel("学号：  ");
        JLabel nameLabel=new JLabel("姓名：  ");
        JLabel deptLabel=new JLabel("专业：  ");
        JLabel sexLabel=new JLabel("性别：  ");
        JLabel ageLabel=new JLabel("年龄：  ");
        JLabel addressLabel=new JLabel("家庭住址：");

        JTextField IDTf=new JTextField(12);
        JTextField nameTf=new JTextField(12);
        JTextField deptTf=new JTextField(12);
        JComboBox sexJcb=new JComboBox(userSex);
        JTextField ageTf=new JTextField(12);
        JTextField addressTf=new JTextField(12);
        JButton addButton=new JButton("添加");
        JButton cancelButton=new JButton("取消");

        IDLabel.setBounds(15,10,75,30);
        nameLabel.setBounds(15,40,75,30);
        deptLabel.setBounds(15,70,75,30);
        sexLabel.setBounds(15,100,75,30);
        ageLabel.setBounds(15,130,75,30);
        addressLabel.setBounds(15,160,75,30);
        IDTf.setBounds(90,10,140,25);
        nameTf.setBounds(90,40,140,25);
        deptTf.setBounds(90,70,140,25);
        sexJcb.setBounds(90,100,140,25);
        ageTf.setBounds(90,130,140,25);
        addressTf.setBounds(90,160,140,25);
        addButton.setBounds(45,230,60,30);
        cancelButton.setBounds(140,230,60,30);

        jPanel.add(IDLabel);
        jPanel.add(IDTf);
        jPanel.add(nameLabel);
        jPanel.add(nameTf);
        jPanel.add(deptLabel);
        jPanel.add(deptTf);
        jPanel.add(sexLabel);
        jPanel.add(sexJcb);
        jPanel.add(ageLabel);
        jPanel.add(ageTf);
        jPanel.add(addressLabel);
        jPanel.add(addressTf);
        jPanel.add(addButton);
        jPanel.add(cancelButton);

        jf.add(jPanel);
        jf.setBounds(700, 300, 260, 310);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(jf.DISPOSE_ON_CLOSE);
        jf.setVisible(true);

        addButton.addActionListener(e -> {
            String stuID=IDTf.getText().strip();
            String name=nameTf.getText().strip();
            String dept=deptTf.getText().strip();
            String sex=sexJcb.getSelectedItem().toString();
            String age =ageTf.getText().strip();
            String address =addressTf.getText().strip();

            if("".equals(stuID)||"".equals(name)||"".equals(dept)||"".equals(age)||"".equals(address))
                JOptionPane.showMessageDialog(null, "请填写完整！");
            else if(new DBOperator().isExistStuID(stuID))
                JOptionPane.showMessageDialog(null, "学号已存在！");
            else{
                String insertSql="insert into student values('"+stuID+"','"+name+"','"+dept+"','"+sex+"',"+ age +",'"+ address +"','"+stuID+"')";
                if(new DBOperator().executeUpdateSql(insertSql)){
                    jf.dispose();
                    JOptionPane.showMessageDialog(null, "添加成功！");
                }
                else
                    JOptionPane.showMessageDialog(null, "添加失败！", "提示",JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelButton.addActionListener(e -> jf.dispose());
    }
}
