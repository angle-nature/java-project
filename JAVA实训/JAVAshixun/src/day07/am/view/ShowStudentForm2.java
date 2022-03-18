package day07.am.view;

import day07.am.control.StudentDao;
import day07.am.model.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ShowStudentForm2 extends JFrame {
    private JTable tb;
    private ArrayList<Student> stuList=null;
    private String[] tbHead=new String[]{"学号","姓名","性别","年龄","专业"};

    public ShowStudentForm2(){
        tb=new JTable();
        JScrollPane jScrollPane=new JScrollPane(tb);

        showStuInfo();
        this.setLayout(new BorderLayout());
        this.add(jScrollPane);
        this.setTitle("显示学生信息");
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setBounds(200,200,500,500);
        this.setVisible(true);
    }

    private void showStuInfo(){
        stuList=new ArrayList<>();
        stuList=new StudentDao().doSelectAll();
        Iterator<Student> it=stuList.iterator();
        String[][] tbBody=new String[stuList.size()][5];
        int currentRow=0;
        while (it.hasNext()){
            Student s=it.next();
            tbBody[currentRow][0]=String.valueOf(s.getsID());
            tbBody[currentRow][1]=s.getsName();
            if(s.getsSex()==0)
                tbBody[currentRow][2]="男";
            else
                tbBody[currentRow][2]="女";
            tbBody[currentRow][3]=String.valueOf(s.getsAge());
            tbBody[currentRow][4]=s.getsMajor();
            currentRow++;
        }
        tb.setModel(new DefaultTableModel(tbBody,tbHead));
    }
}
