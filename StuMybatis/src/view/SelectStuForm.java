package view;

import dao.CheckValiData;
import dao.SessionMethod;
import pojo.InputOptionValue;
import pojo.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class SelectStuForm extends JFrame {
    private JTable tb;
    private DefaultTableModel dfModel=null;
    JPanel p1_1=null;
    private List<Student> stuList=null;
    private String[] tbHead=new String[]{"学号","姓名","性别","年龄","专业"};
    private JRadioButton allRbt,optionRbt;
    private JComboBox<String> optionCb;
    private JTextField inputTxt;
    private JButton searchBtn,deleteBtn,modifyBtn;

    public SelectStuForm(){
        allRbt=new JRadioButton("全部学生信息查询");
        optionRbt=new JRadioButton("按照指定条件查询学生信息");
        optionCb=new JComboBox<String>(tbHead);
        ButtonGroup btg=new ButtonGroup();
        btg.add(allRbt);
        btg.add(optionRbt);
        allRbt.setSelected(true);
        inputTxt=new JTextField(15);
        searchBtn=new JButton("查询");
        deleteBtn=new JButton("删除");
        modifyBtn=new JButton("修改");
        deleteBtn.setEnabled(false);
        modifyBtn.setEnabled(false);

        tb=new JTable();
        JScrollPane jScrollPane=new JScrollPane(tb);

        JPanel p1=new JPanel(new GridLayout(3,1));
        p1.add(allRbt);
        p1.add(optionRbt);
        p1_1=new JPanel(new FlowLayout(FlowLayout.LEFT));
        p1_1.add(new JLabel("选择查询方式："));
        p1_1.add(optionCb);
        p1_1.add(new JLabel("  输入查询内容："));
        p1_1.add(inputTxt);
        p1_1.setVisible(false);
        p1_1.add(searchBtn);
        p1.add(p1_1);
        p1.setBorder(BorderFactory.createTitledBorder("查询选择"));

        JPanel topPanel=new JPanel(new BorderLayout());
        topPanel.add(p1,BorderLayout.WEST);
        topPanel.add(searchBtn,BorderLayout.EAST);

        JPanel bottomPanel=new JPanel();
        bottomPanel.add(deleteBtn);
        bottomPanel.add(modifyBtn);

        this.setLayout(new BorderLayout());
        this.add(topPanel,BorderLayout.NORTH);
        this.add(jScrollPane,BorderLayout.CENTER);
        this.add(bottomPanel,BorderLayout.SOUTH);

        optionRbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p1_1.setVisible(true);
            }
        });

        allRbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p1_1.setVisible(false);
            }
        });

        this.setTitle("查询学生信息");
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setBounds(200,200,500,500);
        this.setVisible(true);

        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stuList=new ArrayList<>();
                String selectStr=null;
                InputOptionValue inputOptionValue=null;
                if(allRbt.isSelected()){
                    selectStr="dao.StudentMapper.doSelectAll";
                    inputOptionValue=new InputOptionValue<Student>(selectStr,null);
                    stuList=new SessionMethod<Student,Student>().selectListObject(inputOptionValue);
                }else{
                    if (optionCb.getSelectedIndex()==0){ //按学号查询
                        String stuIDTxt=inputTxt.getText().trim();
                        if(!CheckValiData.checkIsNull(stuIDTxt)&&CheckValiData.checkIsNumber(stuIDTxt)){
                            int stuID=Integer.parseInt(stuIDTxt);
                            selectStr="dao.StudentMapper.doSelectByStuID";
                            inputOptionValue=new InputOptionValue<Integer>(selectStr,stuID);
                            stuList.add(new SessionMethod<Integer,Student>().selectOneObject(inputOptionValue));
                        }
                    }else if (optionCb.getSelectedIndex()==1){  //按姓名查询
                        String sName=inputTxt.getText().trim();
                        selectStr="dao.StudentMapper.doSelectByStuName";
                        inputOptionValue=new InputOptionValue<String>(selectStr,sName);
                        stuList=new SessionMethod<String,Student>().selectListObject(inputOptionValue);
                    }else if (optionCb.getSelectedIndex()==2){  //按性别查询
                        int stuSex=-1;
                        if("男".equals(inputTxt.getText().trim()))
                            stuSex=0;
                        else if ("女".equals(inputTxt.getText().trim()))
                            stuSex=1;
                        selectStr="dao.StudentMapper.doSelectByStuSex";
                        inputOptionValue=new InputOptionValue<Integer>(selectStr,stuSex);
                        stuList=new SessionMethod<Integer,Student>().selectListObject(inputOptionValue);
                    }else if (optionCb.getSelectedIndex()==3){  //按年龄查询
                        String stuAge=inputTxt.getText().trim();
                        if(!CheckValiData.checkIsNull(stuAge)&&CheckValiData.checkIsNumber(stuAge)){
                            selectStr="dao.StudentMapper.doSelectByStuAge";
                            inputOptionValue=new InputOptionValue<Integer>(selectStr,Integer.parseInt(stuAge));
                            stuList=new SessionMethod<Integer,Student>().selectListObject(inputOptionValue);
                        }
                    }else if (optionCb.getSelectedIndex()==4){  //按专业查询
                        String sMajor=inputTxt.getText().trim();
                        selectStr="dao.StudentMapper.doSelectByStuMajor";
                        inputOptionValue=new InputOptionValue<String>(selectStr,sMajor);
                        stuList=new SessionMethod<String,Student>().selectListObject(inputOptionValue);
                    }
                }

                showStuInfo();
            }
        });

        tb.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int rowIndex=tb.getSelectedRow();
                if(tb.getValueAt(rowIndex,0)!=null){
                    deleteBtn.setEnabled(true);
                    modifyBtn.setEnabled(true);
                }else{
                    deleteBtn.setEnabled(false);
                    modifyBtn.setEnabled(false);
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowIndex=tb.getSelectedRow();
                if(tb.getValueAt(rowIndex,0)!=null){
                    String sIDStr=(String)tb.getValueAt(rowIndex,0);
                    int sID=Integer.parseInt(sIDStr);
                    int flag=JOptionPane.showConfirmDialog(deleteBtn,"确定删除学号为"+sID+"的信息吗？","删除提示信息",JOptionPane.YES_NO_OPTION);
                    if(flag==JOptionPane.YES_OPTION) {
                        String str="dao.StudentMapper.doDeleteByStuID";
                        InputOptionValue inputOptionValue=new InputOptionValue<Integer>(str,sID);
                        if(new SessionMethod<Integer,String>().doDelete(inputOptionValue)){
                            JOptionPane.showMessageDialog(deleteBtn,"删除学生信息成功","删除提示",JOptionPane.INFORMATION_MESSAGE);
                            dfModel.removeRow(rowIndex);
                        }else{
                            JOptionPane.showMessageDialog(deleteBtn,"删除学生信息失败","删除提示",JOptionPane.ERROR_MESSAGE);
                        }

                    }
                }

            }
        });

        modifyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowIndex=tb.getSelectedRow();
                if(tb.getValueAt(rowIndex,0)!=null) {
                    String sIDStr=(String)tb.getValueAt(rowIndex,0);
                    int stuID=Integer.parseInt(sIDStr);
                    String selectStr="dao.StudentMapper.doSelectByStuID";
                    InputOptionValue inputOptionValue=new InputOptionValue<Integer>(selectStr,stuID);
                    Student student=new SessionMethod<Integer,Student>().selectOneObject(inputOptionValue);
                    new ModifyStuForm(student);
                }
            }
        });
    }

    private void showStuInfo(){
        deleteBtn.setEnabled(false);
        modifyBtn.setEnabled(false);
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
        dfModel=new DefaultTableModel(tbBody,tbHead);
        tb.setModel(dfModel);
    }
}
