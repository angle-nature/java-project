package SIMS.StudentForm;

import SIMS.DBOperator;

import javax.swing.*;

public class StuInfo {
    private String stuID=null;
    private String[] stuInfo=null;
    public StuInfo(String stuID) {
        this.stuID = stuID;

        stuInfo=new DBOperator().getStuInfo(stuID);
        JFrame jf=new JFrame("修改个人信息");
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
        JTextField sexTf=new JTextField(12);
        JTextField ageTf=new JTextField(12);
        JTextField addressTf=new JTextField(12);
        JButton addButton=new JButton("修改");
        JButton cancelButton=new JButton("取消");

        IDTf.setText(stuInfo[0]);
        IDTf.setEditable(false);
        nameTf.setText(stuInfo[1]);
        deptTf.setText(stuInfo[2]);
        sexTf.setText(stuInfo[3]);
        sexTf.setEditable(false);
        ageTf.setText(stuInfo[4]);
        addressTf.setText(stuInfo[5]);

        IDLabel.setBounds(15,10,75,30);
        nameLabel.setBounds(15,40,75,30);
        deptLabel.setBounds(15,70,75,30);
        sexLabel.setBounds(15,100,75,30);
        ageLabel.setBounds(15,130,75,30);
        addressLabel.setBounds(15,160,75,30);
        IDTf.setBounds(90,10,140,25);
        nameTf.setBounds(90,40,140,25);
        deptTf.setBounds(90,70,140,25);
        sexTf.setBounds(90,100,140,25);
        ageTf.setBounds(90,130,140,25);
        addressTf.setBounds(90,160,140,25);
        addButton.setBounds(45,200,60,30);
        cancelButton.setBounds(140,200,60,30);

        jPanel.add(IDLabel);
        jPanel.add(IDTf);
        jPanel.add(nameLabel);
        jPanel.add(nameTf);
        jPanel.add(deptLabel);
        jPanel.add(deptTf);
        jPanel.add(sexLabel);
        jPanel.add(sexTf);
        jPanel.add(ageLabel);
        jPanel.add(ageTf);
        jPanel.add(addressLabel);
        jPanel.add(addressTf);
        jPanel.add(addButton);
        jPanel.add(cancelButton);

        jf.add(jPanel);
        jf.setBounds(700, 300, 260, 280);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(jf.DISPOSE_ON_CLOSE);
        jf.setVisible(true);

        addButton.addActionListener(e -> {
            String name=nameTf.getText().strip();
            String dept=deptTf.getText().strip();
            String sex=sexTf.getText().strip();
            String age =ageTf.getText().strip();
            String address =addressTf.getText().strip();

            if("".equals(stuID)||"".equals(name)||"".equals(dept)||"".equals(age)||"".equals(address))
                JOptionPane.showMessageDialog(null, "信息不能为空！");
            else{
                String insertSql="update student set sName='"+name+"',dept='"+dept+"',sex='"+sex+"',age="+age+",address='"+address+"'"+
                        "where stuID='"+stuID+"'";
                if(new DBOperator().executeUpdateSql(insertSql)){
                    jf.dispose();
                    JOptionPane.showMessageDialog(null, "修改成功！");
                }
                else
                    JOptionPane.showMessageDialog(null, "修改失败！", "提示",JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelButton.addActionListener(e -> jf.dispose());
    }
}
