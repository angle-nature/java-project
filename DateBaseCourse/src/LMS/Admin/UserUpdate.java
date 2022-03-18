package LMS.Admin;

import LMS.DBUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class UserUpdate {

    private String[] userInfo=new String[6];
    private DefaultTableModel tableModel=null;
    String[] header={"用户编号","用户姓名","用户性别","用户专业","可借阅数量","登录密码"};
    private int row=-1;
    public UserUpdate(){

        Vector dept=new DBUtils().getDept(); //用户专业
        dept.add(0,"<-请选择->");

        JFrame jf=new JFrame("用户信息管理");
        JPanel jp=new JPanel(new BorderLayout());
        JPanel jp1=new JPanel(new FlowLayout()); //流式布局

        JLabel jbl1=new JLabel("用户编号     ");
        JLabel jbl2=new JLabel("用户姓名     ");
        JLabel jbl4=new JLabel("用户专业     ");

        JTextField jtf1=new JTextField(5);
        JTextField jtf2=new JTextField(12);
        JComboBox jcb=new JComboBox(dept);
        JButton jbt1=new JButton("搜索");
        JButton jbt2=new JButton("注销");
        JButton jbt3=new JButton("提交更改");

        jp1.add(jtf1);
        jp1.add(jbl1);
        jp1.add(jtf2);
        jp1.add(jbl2);
        jp1.add(jcb);
        jp1.add(jbl4);
        jp1.add(jbt1);
        jp1.add(jbt2);
        jp1.add(jbt3);

        String sql="select * from reader";
        tableModel=new DBUtils().getTableData(sql,header);
        JTable jTable=new JTable(tableModel);
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
                row= jTable.getSelectedRow(); //行
                //得到选中的单元格的值，表格中都是字符串
                userInfo[0]= jTable.getValueAt(row, 0).toString();
            }
        });

        //搜索事件
        jbt1.addActionListener(e -> {
            String sqlSearch="select * from reader where 1=1";
            String sqlID="";
            String sqlRName="";
            String sqldept="";

            String userID=jtf1.getText().strip();
            String userName=jtf2.getText().strip();

            if(!"".equals(userID))
                sqlID=" and RID='"+userID+"'";
            if(!"".equals(userName))
                sqlRName=" and Rname='"+userName+"'";
            if(jcb.getSelectedIndex()!=0)
                sqldept=" and Rdept='"+jcb.getSelectedItem()+"'";

            sqlSearch=sqlSearch+sqlID+sqlRName+sqldept;

            tableModel=new DBUtils().getTableData(sqlSearch,header);
            jTable.setModel(tableModel);
            jTable.revalidate();
//                jf.setVisible(true);
        });

        //删除事件
        jbt2.addActionListener(e -> {
            int n = JOptionPane.showConfirmDialog(null, "是否注销该用户", "",JOptionPane.YES_NO_OPTION);
            if(n==0) {
                String delSql="delete from reader where RID='"+userInfo[0]+"'";
                new DBUtils().executeUpdateSql(delSql);
                int row = jTable.getSelectedRow();
                if (row != -1)
                    tableModel.removeRow(row);
            }
        });

        //修改用户数据
        jbt3.addActionListener(e -> {
            if(row!=-1){
                userInfo[1]= jTable.getValueAt(row, 1).toString();
                userInfo[3]= jTable.getValueAt(row, 3).toString();
                userInfo[4]= jTable.getValueAt(row, 4).toString();
                userInfo[5]= jTable.getValueAt(row, 5).toString();
                String alterSql="update reader set Rname='"+userInfo[1]+"',Rdept='" +userInfo[3]
                        +"',RLendNumber='"+userInfo[4]+"',Rpassword='"+userInfo[5]+"' where RID='"+userInfo[0]+"'";
                if(new DBUtils().executeUpdateSql(alterSql))
                    JOptionPane.showMessageDialog(null, "更改已提交成功！");
                else
                    JOptionPane.showMessageDialog(null, "更改提交失败！", "提示",JOptionPane.ERROR_MESSAGE);
            }

        });
    }
}
