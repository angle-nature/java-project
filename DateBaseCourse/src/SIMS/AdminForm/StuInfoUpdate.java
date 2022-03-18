package SIMS.AdminForm;

import SIMS.DBOperator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class StuInfoUpdate {

    private String[] stuInfo=new String[7];
    private DefaultTableModel tableModel=null;
    String[] header={"学号","姓名","专业","性别","年龄","家庭住址","账号密码"};
    private int row=-1;
    public StuInfoUpdate(){
        Vector dept=new DBOperator().getDept(); //学生专业
        dept.add(0,"<-请选择->");

        JFrame jf=new JFrame("学生信息管理");
        JPanel jp=new JPanel(new BorderLayout()); //边界布局
        JPanel jp1=new JPanel(new FlowLayout()); //流式布局

        JLabel stuIDLabel=new JLabel("学号     ");
        JLabel sNameLabel=new JLabel("姓名     ");
        JLabel deptLabel=new JLabel("专业     ");

        JTextField stuIDText=new JTextField(5);
        JTextField sNameText=new JTextField(12);
        JComboBox deptComboBox=new JComboBox(dept);
        JButton searchButton=new JButton("搜索");
        JButton deleteButton=new JButton("删除");
        JButton updateButton=new JButton("提交更改");

        jp1.add(stuIDText);
        jp1.add(stuIDLabel);
        jp1.add(sNameText);
        jp1.add(sNameLabel);
        jp1.add(deptComboBox);
        jp1.add(deptLabel);
        jp1.add(searchButton);
        jp1.add(deleteButton);
        jp1.add(updateButton);

        String sql="select * from student";
        tableModel=new DBOperator().getTableData(sql,header);
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
                stuInfo[0]= jTable.getValueAt(row, 0).toString();
            }
        });

        //搜索事件
        searchButton.addActionListener(e -> {
            String sqlSearch="select * from student where 1=1";
            String sqlID="";
            String sqlsname="";
            String sqldept="";

            String stuID=stuIDText.getText().strip();
            String sname=sNameText.getText().strip();

            if(!"".equals(stuID))
                sqlID=" and stuID='"+stuID+"'";
            if(!"".equals(sname))
                sqlsname=" and sname='"+sname+"'";
            if(deptComboBox.getSelectedIndex()!=0)
                sqldept=" and dept='"+deptComboBox.getSelectedItem()+"'";

            sqlSearch=sqlSearch+sqlID+sqlsname+sqldept;

            tableModel=new DBOperator().getTableData(sqlSearch,header);
            jTable.setModel(tableModel);
            jTable.revalidate();
        });

        //删除事件
        deleteButton.addActionListener(e -> {
            int n = JOptionPane.showConfirmDialog(null, "是否删除该学生", "",JOptionPane.YES_NO_OPTION);
            if(n==0) {
                String delSql="delete from student where stuID='"+stuInfo[0]+"'";
                new DBOperator().executeUpdateSql(delSql);
                int row = jTable.getSelectedRow();
                if (row != -1)
                    tableModel.removeRow(row);
            }
        });

        //修改学生数据
        updateButton.addActionListener(e -> {
            if(row!=-1){
                stuInfo[1]= jTable.getValueAt(row, 1).toString();
                stuInfo[2]= jTable.getValueAt(row, 2).toString();
                stuInfo[3]= jTable.getValueAt(row, 3).toString();
                stuInfo[4]= jTable.getValueAt(row, 4).toString();
                stuInfo[5]= jTable.getValueAt(row, 5).toString();
                stuInfo[6]= jTable.getValueAt(row, 6).toString();
                String alterSql="update student set sName='"+stuInfo[1]+"',dept='" +stuInfo[2]+"',sex='"+stuInfo[3]
                        +"',age='"+stuInfo[4]+"',address='"+stuInfo[5]+"',password='"+stuInfo[6]+"' where stuID='"+stuInfo[0]+"'";
                if(new DBOperator().executeUpdateSql(alterSql))
                    JOptionPane.showMessageDialog(null, "更改已提交成功！");
                else
                    JOptionPane.showMessageDialog(null, "更改提交失败！", "提示",JOptionPane.ERROR_MESSAGE);
            }

        });
    }
}
