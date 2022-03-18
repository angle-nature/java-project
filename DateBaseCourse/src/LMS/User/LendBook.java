package LMS.User;

import LMS.DBUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class LendBook {
    private String userID;
    private String[] bookInfo=new String[3];
    private DefaultTableModel tableModel=null;
    String[] header={"图书编号","图书名称","作者","价格","所属类别","库存数量"};

    public LendBook(String userID){
        this.userID=userID;

        Vector bookCategory=new DBUtils().getCategory(); //图书类别
        bookCategory.add(0,"<-请选择->");

        JFrame jf=new JFrame("借书管理");
        JPanel jp=new JPanel(new BorderLayout());
        JPanel jp1=new JPanel(new FlowLayout()); //流式布局

        JLabel jbl1=new JLabel("图书编号     ");
        JLabel jbl2=new JLabel("图书名称     ");
        JLabel jbl3=new JLabel("图书作者     ");
        JLabel jbl4=new JLabel("图书类别     ");

        JTextField jtf1=new JTextField(5);
        JTextField jtf2=new JTextField(12);
        JTextField jtf3=new JTextField(8);
        JComboBox jcb=new JComboBox(bookCategory);
        JButton jbt1=new JButton("搜索");
        JButton jbt2=new JButton("借书");

        jp1.add(jtf1);
        jp1.add(jbl1);
        jp1.add(jtf2);
        jp1.add(jbl2);
        jp1.add(jtf3);
        jp1.add(jbl3);
        jp1.add(jcb);
        jp1.add(jbl4);
        jp1.add(jbt1);
        jp1.add(jbt2);

        String sql="select * from book";
        tableModel=new DBUtils().getTableData(sql,header);
        JTable jTable=new JTable(tableModel){
            public boolean isCellEditable(int row, int column) { return false; }//表格不允许被编辑
        };
        // 设置列表头不可被用户重新拖动排列
        jTable.getTableHeader().setReorderingAllowed(false);
        JScrollPane jsp = new JScrollPane(jTable);

        jp.add(jp1,BorderLayout.NORTH);
        jp.add(jsp,BorderLayout.CENTER);
        jf.add(jp);
        jf.setSize(800,500);
        jf.setLocation(450,150);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setVisible(true);

        jTable.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {//仅当鼠标单击时响应
                //得到选中的行列的索引值
                int r= jTable.getSelectedRow();
                //得到选中的单元格的值，表格中都是字符串
                bookInfo[0]= jTable.getValueAt(r, 0).toString();
                bookInfo[1]= jTable.getValueAt(r, 1).toString();
                bookInfo[2]= jTable.getValueAt(r, 5).toString().strip();
            }
        });

        //搜索事件
        jbt1.addActionListener(e -> {
            String sqlSearch="select * from book where 1=1";
            String sqlID="";
            String sqlBName="";
            String sqlAuthor="";
            String sqlCategory="";

            String BID=jtf1.getText().strip();
            String Bname=jtf2.getText().strip();
            String Bauthor=jtf3.getText().strip();

            if(!"".equals(BID))
                sqlID=" and BID='"+BID+"'";
            if(!"".equals(Bname))
                sqlBName=" and Bname='"+Bname+"'";
            if(!"".equals(Bauthor))
                sqlAuthor=" and Bauthor='"+Bauthor+"'";
            if(jcb.getSelectedIndex()!=0)
                sqlCategory=" and Bcategory='"+jcb.getSelectedItem()+"'";

            sqlSearch=sqlSearch+sqlID+sqlBName+sqlAuthor+sqlCategory;

            tableModel=new DBUtils().getTableData(sqlSearch,header);
            jTable.setModel(tableModel);
            jTable.revalidate();
//                jf.setVisible(true);
        });

        //借书事件
        jbt2.addActionListener(e -> {
            int lendNumber=new DBUtils().getRLendNumber(userID);
            if(lendNumber<=0)
                JOptionPane.showMessageDialog(null, "您的借书次数已用完！");
            else if(jTable.getSelectedRow()==-1)
                JOptionPane.showMessageDialog(null, "请选择书籍！");
            else if(Integer.valueOf(bookInfo[2])<=0)
                JOptionPane.showMessageDialog(null, "库存数量不足！");
            else
                new LendBookInfo(userID,bookInfo);
        });
    }
}
