package LMS.Admin;

import LMS.DBUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class BookUpdate {

    private String[] bookInfo=new String[6];
    private DefaultTableModel tableModel=null;
    String[] header={"图书编号","图书名称","作者","价格","所属类别","库存数量"}; //表头
    private int row=-1;
    public BookUpdate(){

        Vector category=new DBUtils().getCategory(); //图书类别
        category.add(0,"<-请选择->");

        JFrame jf=new JFrame("图书信息管理");
        JPanel jp=new JPanel(new BorderLayout());
        JPanel jp1=new JPanel(new FlowLayout()); //流式布局

        JLabel jbl1=new JLabel("图书编号     ");
        JLabel jbl2=new JLabel("图书名称     ");
        JLabel jbl3=new JLabel("图书作者     ");
        JLabel jbl4=new JLabel("图书类别     ");

        JTextField jtf1=new JTextField(5);
        JTextField jtf2=new JTextField(12);
        JTextField jtf3=new JTextField(8);
        JComboBox jcb=new JComboBox(category);
        JButton jbt1=new JButton("搜索");
        JButton jbt2=new JButton("删除");
        JButton jbt3=new JButton("提交更改");

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
        jp1.add(jbt3);

        String sql="select * from book";
        tableModel=new DBUtils().getTableData(sql,header);
        JTable jTable=new JTable(tableModel);
        // 设置列表头不可被用户重新拖动排列
        jTable.getTableHeader().setReorderingAllowed(false);
        JScrollPane jsp = new JScrollPane(jTable);

        jp.add(jp1,BorderLayout.NORTH);
        jp.add(jsp,BorderLayout.CENTER);
        jf.add(jp);
        jf.setSize(890,500);
        jf.setLocation(450,150);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setVisible(true);

        jTable.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {//仅当鼠标单击时响应
                //得到选中的行列的索引值
                row= jTable.getSelectedRow(); //行
                //得到选中的单元格的值，表格中都是字符串
                bookInfo[0]= jTable.getValueAt(row, 0).toString();
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

        //删除事件
        jbt2.addActionListener(e -> {
            int n = JOptionPane.showConfirmDialog(null, "是否删除该图书", "",JOptionPane.YES_NO_OPTION);
            if(n==0) {
                String delSql="delete from book where BID='"+bookInfo[0]+"'";
                new DBUtils().executeUpdateSql(delSql);
                int row = jTable.getSelectedRow();
                if (row != -1)
                    tableModel.removeRow(row);
            }
        });

        //修改图书数据
        jbt3.addActionListener(e -> {
            if(row!=-1){
                bookInfo[1]= jTable.getValueAt(row, 1).toString();
                bookInfo[2]= jTable.getValueAt(row, 2).toString();
                bookInfo[3]= jTable.getValueAt(row, 3).toString();
                bookInfo[4]= jTable.getValueAt(row, 4).toString();
                bookInfo[5]= jTable.getValueAt(row, 5).toString();
                String alterSql="update book set Bname ='"+bookInfo[1]+"',Bauthor ='" +bookInfo[2]+"',Bprice ='" +bookInfo[3]
                        +"',Bcategory ='"+bookInfo[4]+"',Bquantity ='"+bookInfo[5]+"' where BID='"+bookInfo[0]+"'";
                if(new DBUtils().executeUpdateSql(alterSql))
                    JOptionPane.showMessageDialog(null, "更改已提交成功！");
                else
                    JOptionPane.showMessageDialog(null, "更改提交失败！", "提示",JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
