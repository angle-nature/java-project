package SIMS.AdminForm;

import SIMS.DBOperator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class CourseManage {
    private String cID=null;
    private DefaultTableModel tableModel=null;
    String[] header={"课程代码","课程名称","任课老师","开课院系","学时"};
    private int row=-1;

    public CourseManage() {

        Vector colleges=new DBOperator().getCollege(); //图书类别
        colleges.add(0,"<-请选择->");

        JFrame jf = new JFrame("课程信息管理");
        JPanel jp = new JPanel(new BorderLayout());
        JPanel jp1 = new JPanel(new FlowLayout());

        JLabel courseIDLabel = new JLabel("    课程代码");
        JLabel courseNameLabel = new JLabel("    课程名称");
        JLabel collegesLabel = new JLabel("    开课院系");

        JTextField courseIDText = new JTextField(5);
        JTextField courseNameText = new JTextField(8);
        JComboBox collegesJcb=new JComboBox(colleges);

        JButton searchButton = new JButton("搜索");
        JButton deleteButton = new JButton("删除");

        jp1.add(courseIDLabel);
        jp1.add(courseIDText);
        jp1.add(courseNameLabel);
        jp1.add(courseNameText);
        jp1.add(collegesLabel);
        jp1.add(collegesJcb);
        jp1.add(searchButton);
        jp1.add(deleteButton);

        String sql = "select * from course";
        tableModel = new DBOperator().getTableData(sql, header);
        JTable jTable = new JTable(tableModel);
        // 设置列表头不可被用户重新拖动排列
        jTable.getTableHeader().setReorderingAllowed(false);
        JScrollPane jsp = new JScrollPane(jTable);

        jp.add(jp1, BorderLayout.NORTH);
        jp.add(jsp, BorderLayout.CENTER);
        jf.add(jp);
        jf.setSize(600, 400);
        jf.setLocation(450, 150);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setVisible(true);

        jTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {//仅当鼠标单击时响应
                //得到选中的行列的索引值
                row = jTable.getSelectedRow(); //行
                //得到选中的单元格的值，表格中都是字符串
                cID = jTable.getValueAt(row, 0).toString();
            }
        });

        //搜索事件
        searchButton.addActionListener(e -> {
            String sqlSearch = "select * from course where 1=1";
            String sqlCourseID = "";
            String sqlCourseName = "";
            String sqlCollege = "";

            String courseID = courseIDText.getText().strip();
            String courseName = courseNameText.getText().strip();

            if (!"".equals(courseID))
                sqlCourseID = " and courseID='" + courseID + "'";
            if (!"".equals(courseName))
                sqlCourseName = " and cName='" + courseName + "'";
            if(collegesJcb.getSelectedIndex()!=0)
                sqlCollege=" and college='"+collegesJcb.getSelectedItem()+"'";

            sqlSearch = sqlSearch + sqlCourseID + sqlCourseName + sqlCollege;
            tableModel = new DBOperator().getTableData(sqlSearch, header);
            jTable.setModel(tableModel);
            jTable.revalidate();
        });

        //删除事件
        deleteButton.addActionListener(e -> {
            int n = JOptionPane.showConfirmDialog(null, "是否删除该记录", "", JOptionPane.YES_NO_OPTION);
            if (n == 0) {
                String delSql = "delete from course where courseID='" + cID +"'";
                new DBOperator().executeUpdateSql(delSql);
                int row = jTable.getSelectedRow();
                if (row != -1)
                    tableModel.removeRow(row);
            }
        });
    }
}
