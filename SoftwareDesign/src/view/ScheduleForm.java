package view;

import dao.*;
import po.Course;
import po.Schedule;
import po.Student;
import po.Teacher;
import util.SwingUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ScheduleForm {
    private Schedule schedule;
    private JTable jTable=null;
    private DefaultTableModel tableModel=null;
    String[] header={"课程名称","授课老师","上课教室","上课时间","限制人数","已选人数"};

    public ScheduleForm(Student student){
        schedule=new Schedule();
        JFrame jf=new JFrame("开课信息");
        JPanel jp=new JPanel(new BorderLayout());
        JPanel jp1=new JPanel(new FlowLayout()); //流式布局

        JLabel jbl1=new JLabel("课程名称     ");
        JLabel jbl2=new JLabel("授课老师     ");

        JTextField jtf1=new JTextField(12);
        JTextField jtf2=new JTextField(12);
        JButton jbt1=new JButton("搜索");
        JButton jbt2=new JButton("选课");

        jp1.add(jbl1);
        jp1.add(jtf1);
        jp1.add(jbl2);
        jp1.add(jtf2);
        jp1.add(jbt1);
        jp1.add(jbt2);

        jTable= SwingUtil.returnJTable(new ScheduleDao().queryAllSchedule(),header,"Schedule");
        jTable.setRowHeight(30);
        AtomicReference<TableColumn> column= new AtomicReference<>(jTable.getColumnModel().getColumn(3));
        column.get().setPreferredWidth(140);

        JScrollPane jsp = new JScrollPane(jTable);

        jp.add(jp1,BorderLayout.NORTH);
        jp.add(jsp,BorderLayout.CENTER);
        jf.add(jp);
        jf.setSize(800,550);
        jf.setLocation(300,150);
        jf.setIconImage(new ImageIcon("images/选课.png").getImage());
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setVisible(true);

        jTable.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {//仅当鼠标单击时响应
                //得到选中的行列的索引值
                int r= jTable.getSelectedRow();
                //得到选中的单元格的值，表格中都是字符串
                schedule.setCourseID(new CourseDao().queryCourseByIdOrName(null,jTable.getValueAt(r, 0).toString()).getId());
                schedule.setTeacherID(new TeacherDao().queryTeacherByIDorName(null,jTable.getValueAt(r, 1).toString()).getId());
                schedule.setClassroom(jTable.getValueAt(r, 2).toString());
                schedule.setTime(jTable.getValueAt(r, 3).toString());
            }
        });

        //搜索事件
        jbt1.addActionListener(e -> {
            String courseName=jtf1.getText().strip();
            String teacherName=jtf2.getText().strip();
            String courseID=null;
            String teacherID=null;
            if (courseName!=null&&!"".equals(courseName)){
                Course course=new CourseDao().queryCourseByIdOrName(null,courseName);
                if (course!=null){
                    courseID=course.getId();
                }else{
                    courseID="not found";
                }
            }
            if (teacherName!=null&&!"".equals(teacherName)){
                Teacher teacher=new TeacherDao().queryTeacherByIDorName(null,teacherName);
                if (teacher!=null){
                    teacherID=teacher.getId();
                }else{
                    teacherID="not found";
                }
            }

            List schedules=new ScheduleDao().queryScheduleByCourseIDorTeacherID(courseID,teacherID);
            tableModel=SwingUtil.returnDefaultTableModel(schedules,header);
            jTable.setModel(tableModel);
            column.set(jTable.getColumnModel().getColumn(3));
            column.get().setPreferredWidth(140);
            jTable.getTableHeader().setReorderingAllowed(false);
            //设置表格中文字居中
            DefaultTableCellRenderer render = new DefaultTableCellRenderer();
            render.setHorizontalAlignment(SwingConstants.CENTER);
            for (String columnName:header){
                jTable.getColumn(columnName).setCellRenderer(render);
            }
            jTable.revalidate();
        });

        //选课
        jbt2.addActionListener(e -> {
            Schedule schedule1=new ScheduleDao().querySchedule(schedule.getCourseID(),schedule.getTeacherID(),schedule.getTime());
            int selectedNumber=schedule1.getSelectedNumber();
            int limitation=schedule1.getLimitation();
            if(selectedNumber>=limitation)
                JOptionPane.showMessageDialog(null, "人数已满！");
            else if(jTable.getSelectedRow()==-1)
                JOptionPane.showMessageDialog(null, "请选择课程！");
            else{
                if (new TimeTableDao().selectCourse(student.getId(), schedule.getCourseID(), schedule.getTeacherID(),schedule.getClassroom(),schedule.getTime())){
                    JOptionPane.showMessageDialog(null, "选课成功！");
                }else{
                    JOptionPane.showMessageDialog(null, "选课失败！你可能已经选过该课程了");
                }
            }
        });
    }
}
