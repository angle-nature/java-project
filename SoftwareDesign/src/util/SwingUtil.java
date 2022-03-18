package util;

import dao.CourseDao;
import dao.TeacherDao;
import po.*;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Vector;

public class SwingUtil {
    public static JTable returnJTable(List tableList,String[] headerArr,String tableType){
        DefaultTableModel defaultTableModel=null;
        JTable jTable=null;

        Vector header=new Vector();
        for(int i=0;i<headerArr.length;i++)
            header.add(headerArr[i]);

        Vector everyRow=null;
        Vector table=new Vector();

        for (Object obj:tableList){
            everyRow=new Vector();
            if ("Schedule".equals(tableType)){
                Schedule schedule=(Schedule) obj;
                String courseName= new CourseDao().queryCourseByIdOrName(schedule.getCourseID(),null).getName();
                String teacherName= new TeacherDao().queryTeacherByIDorName(schedule.getTeacherID(),null).getName();
                everyRow.add(courseName);
                everyRow.add(teacherName);
                everyRow.add(schedule.getClassroom());
                everyRow.add(schedule.getTime());
                everyRow.add(schedule.getLimitation());
                everyRow.add(schedule.getSelectedNumber());
            }else if ("Grade".equals(tableType)){
                Grade grade=(Grade)obj;
                String courseName= new CourseDao().queryCourseByIdOrName(grade.getCourseID(),null).getName();
                String teacherName= new TeacherDao().queryTeacherByIDorName(grade.getTeacherID(),null).getName();
                everyRow.add(courseName);
                everyRow.add(teacherName);
                everyRow.add(grade.getExamScore());
                everyRow.add(grade.getUsualScore());
                everyRow.add(grade.getTotalScore());
            }else if ("Course".equals(tableType)){
                Course course=(Course)obj;
                everyRow.add(course.getId());
                everyRow.add(course.getName());
                everyRow.add(course.getCredit());
                everyRow.add(course.getPreviousID());
                everyRow.add(course.getHour());
            }else if ("TimeTable".equals(tableType)){
                TimeTable timeTable=(TimeTable)obj;
                String courseName= new CourseDao().queryCourseByIdOrName(timeTable.getCourseID(),null).getName();
                String teacherName= new TeacherDao().queryTeacherByIDorName(timeTable.getTeacherID(),null).getName();
                everyRow.add(courseName);
                everyRow.add(teacherName);
                everyRow.add(timeTable.getClassroom());
                everyRow.add(timeTable.getTime());
            }else if ("Teacher".equals(tableType)){
                Teacher teacher=(Teacher)obj;
                everyRow.add(teacher.getId());
                everyRow.add(teacher.getName());
                everyRow.add(teacher.getOffice());
                everyRow.add(teacher.getPosition());
                everyRow.add(teacher.getSex());
                everyRow.add(teacher.getMobilePhone());
            }
            table.add(everyRow);
        }

        defaultTableModel=new DefaultTableModel(table,header);

        jTable=new JTable(defaultTableModel){
            public boolean isCellEditable(int row, int column) { return false; }//表格不允许被编辑
        };
        // 设置列表头不可被用户重新拖动排列
        jTable.getTableHeader().setReorderingAllowed(false);
        //设置表格中文字居中
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setHorizontalAlignment(SwingConstants.CENTER);
        for (String columnName:headerArr){
            jTable.getColumn(columnName).setCellRenderer(render);
        }
        return jTable;
    }

    public static DefaultTableModel returnDefaultTableModel(List tableList,String[] headerArr){
        DefaultTableModel defaultTableModel=null;

        Vector header=new Vector();
        for(int i=0;i<headerArr.length;i++)
            header.add(headerArr[i]);
        Vector everyRow=null;
        Vector table=new Vector();

        for (Object obj:tableList) {
            everyRow = new Vector();
            Schedule schedule = (Schedule) obj;
            String courseName = new CourseDao().queryCourseByIdOrName(schedule.getCourseID(), null).getName();
            String teacherName = new TeacherDao().queryTeacherByIDorName(schedule.getTeacherID(), null).getName();
            everyRow.add(courseName);
            everyRow.add(teacherName);
            everyRow.add(schedule.getClassroom());
            everyRow.add(schedule.getTime());
            everyRow.add(schedule.getLimitation());
            everyRow.add(schedule.getSelectedNumber());

            table.add(everyRow);
        }
        defaultTableModel=new DefaultTableModel(table,header);
        return defaultTableModel;
    }
}
