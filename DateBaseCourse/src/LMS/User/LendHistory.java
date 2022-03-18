package LMS.User;

import LMS.DBUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class LendHistory {
    private String userID;
    private String sql=null;
    private DefaultTableModel tableModel=null;
    String[] header={"图书编号","图书名称","图书类别","借出时间（天）","归还时间","借出时长","罚金"};

    public LendHistory(String userID){
        this.userID=userID;

        Vector bookCategory=new DBUtils().getCategory(); //图书类别
        bookCategory.add(0,"<-请选择->");

        JFrame jf=new JFrame("借书历史");
        JPanel jp=new JPanel(new BorderLayout());
        JPanel jp1=new JPanel(new FlowLayout()); //流式布局

        JLabel jbl1=new JLabel("图书编号     ");
        JLabel jbl2=new JLabel("图书名称     ");
        JLabel jbl4=new JLabel("图书类别     ");

        JTextField jtf1=new JTextField(5);
        JTextField jtf2=new JTextField(12);
        JComboBox jcb=new JComboBox(bookCategory);
        JButton jbt1=new JButton("搜索");

        jp1.add(jtf1);
        jp1.add(jbl1);
        jp1.add(jtf2);
        jp1.add(jbl2);
        jp1.add(jcb);
        jp1.add(jbl4);
        jp1.add(jbt1);

        sql="select BID,Bname,BCATEGORY,lendDate,returnDate,lendTime,fine from book natural join bookLend"+
                " where RID = '"+userID+"' and returnStatus='已还'";
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
        jf.setLocation(500,150);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setVisible(true);

        //搜索事件
        jbt1.addActionListener(e -> {
            sql="select BID,Bname,BCATEGORY,lendDate,returnDate,lendTime,fine from book natural join bookLend"+
                    " where RID = '"+userID+"' and returnStatus='已还'";
            String sqlID="";
            String sqlBName="";
            String sqlAuthor="";
            String sqlCategory="";

            String BID=jtf1.getText().strip();
            String Bname=jtf2.getText().strip();

            if(!"".equals(BID))
                sqlID=" and BID='"+BID+"'";
            if(!"".equals(Bname))
                sqlBName=" and Bname='"+Bname+"'";
            if(jcb.getSelectedIndex()!=0)
                sqlCategory=" and Bcategory='"+jcb.getSelectedItem()+"'";

            sql=sql+sqlID+sqlBName+sqlAuthor+sqlCategory;

            tableModel=new DBUtils().getTableData(sql,header);
            jTable.setModel(tableModel);
            jTable.revalidate();
//                jf.setVisible(true);
        });
    }
}
