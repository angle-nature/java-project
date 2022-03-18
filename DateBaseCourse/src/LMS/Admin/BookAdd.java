package LMS.Admin;

import LMS.DBUtils;

import javax.swing.*;

public class BookAdd {

    public BookAdd() {
        JFrame jf=new JFrame("图书添加");
        JPanel jPanel=new JPanel(null);

        JLabel IDLabel=new JLabel("图书编号：  ");
        JLabel nameLabel=new JLabel("图书名称：  ");
        JLabel authorLabel=new JLabel("图书作者：  ");
        JLabel priceLabel=new JLabel("图书价格：  ");
        JLabel categoryLabel=new JLabel("所属类别：  ");
        JLabel quantityLabel=new JLabel("库存数量：  ");

        JTextField IDTf=new JTextField();
        JTextField nameTf=new JTextField();
        JTextField authorTf=new JTextField();
        JTextField priceTf=new JTextField();
        JTextField categoryTf=new JTextField();
        JTextField quantityTf=new JTextField();
        JButton btn1=new JButton("添加");
        JButton btn2=new JButton("取消");

        IDLabel.setBounds(15,10,75,30);
        nameLabel.setBounds(15,40,75,30);
        authorLabel.setBounds(15,70,75,30);
        priceLabel.setBounds(15,100,75,30);
        categoryLabel.setBounds(15,130,75,30);
        quantityLabel.setBounds(15,160,75,30);
        IDTf.setBounds(90,10,140,25);
        nameTf.setBounds(90,40,140,25);
        authorTf.setBounds(90,70,140,25);
        priceTf.setBounds(90,100,140,25);
        categoryTf.setBounds(90,130,140,25);
        quantityTf.setBounds(90,160,140,25);
        btn1.setBounds(45,200,60,30);
        btn2.setBounds(140,200,60,30);

        jPanel.add(IDLabel);
        jPanel.add(IDTf);
        jPanel.add(nameLabel);
        jPanel.add(nameTf);
        jPanel.add(authorLabel);
        jPanel.add(authorTf);
        jPanel.add(priceLabel);
        jPanel.add(priceTf);
        jPanel.add(categoryLabel);
        jPanel.add(categoryTf);
        jPanel.add(quantityLabel);
        jPanel.add(quantityTf);
        jPanel.add(btn1);
        jPanel.add(btn2);

        jf.add(jPanel);
        jf.setBounds(700, 300, 260, 280);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(jf.DISPOSE_ON_CLOSE);
        jf.setVisible(true);

        btn1.addActionListener(e -> {
            String bookID=IDTf.getText().strip();
            String bookName=nameTf.getText().strip();
            String author=authorTf.getText().strip();
            String price=priceTf.getText().strip();
            String category=categoryTf.getText().strip();
            String quantity=quantityTf.getText().strip();

            if("".equals(bookID)||"".equals(bookName)||"".equals(author)||"".equals(price)||"".equals(category)||"".equals(quantity))
                JOptionPane.showMessageDialog(null, "请填写完整信息！");
            else{
                String insertSql="insert into book values('"+bookID+"','"+bookName+"','"+author+"',"+price+",'"+category+"',"+quantity+")";
                if(new DBUtils().executeUpdateSql(insertSql)){
                    jf.dispose();
                    JOptionPane.showMessageDialog(null, "图书添加成功！");
                }
                else
                    JOptionPane.showMessageDialog(null, "图书添加失败！", "提示",JOptionPane.ERROR_MESSAGE);
            }
        });

        btn2.addActionListener(e -> jf.dispose());
    }
}
