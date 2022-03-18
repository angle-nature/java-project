package shiyan10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainForm implements ActionListener{
	
	JFrame frame=new JFrame("ѧ����Ϣ����ϵͳ");
	JMenuBar bar=new JMenuBar();  //�˵���
	
	JMenu menuStu=new JMenu("������Ϣ����");
	JMenu menuClass=new JMenu("�γ���Ϣ����");
	JMenu menuGrade=new JMenu("�ɼ�����");
	
	JMenuItem disAll=new JMenuItem("��ʾ����ѧ����Ϣ");
	JMenuItem queStu=new JMenuItem("��ѯ������Ϣ");
	
	JMenuItem queClass=new JMenuItem("��ѯ�γ���Ϣ");
	JMenuItem addOrDelClass=new JMenuItem("��ӻ�ɾ���γ���Ϣ");

	
	JMenuItem queGrade=new JMenuItem("��ѯ�ɼ�");
	JMenuItem addOrModifyGrade=new JMenuItem("¼����޸ĳɼ�");
	JMenuItem queAvg=new JMenuItem("��ѯƽ���ɼ�");
	JMenuItem queSta=new JMenuItem("�鿴�ɼ�ͳ��");
	
	public MainForm() {
		
		bar.add(menuStu);
		bar.add(menuClass);
		bar.add(menuGrade);
				
		menuStu.add(disAll);
		disAll.addActionListener(this);
		menuStu.add(queStu);
		queStu.addActionListener(this);
		
		menuClass.add(queClass);
		queClass.addActionListener(this);
		menuClass.add(addOrDelClass);
		addOrDelClass.addActionListener(this);

		menuGrade.add(queGrade);
		queGrade.addActionListener(this);
		menuGrade.add(addOrModifyGrade);
		addOrModifyGrade.addActionListener(this);
		menuGrade.add(queAvg);
		queAvg.addActionListener(this);
		menuGrade.add(queSta);
		queSta.addActionListener(this);
		
		frame.setJMenuBar(bar);
		frame.setBounds(350,250,300,200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		if(e.getSource()==disAll) {	//��ʾ����ѧ����Ϣ	
			new MenuStudent().showAll();
		}else if(e.getSource()==queStu) { //��ѯ������Ϣ
			new MenuStudent().findStu();
		}else if(e.getSource()==queClass) { //��ѯ�γ�
			new MenuClass().queClass();
		}else if(e.getSource()==addOrDelClass) { //��ӻ�ɾ���γ�
			new MenuClass().addOrDelClass();
		}else if(e.getSource()==queGrade) { //��ѯ�ɼ�
			new MenuGrade().queGrade();
		}else if(e.getSource()==addOrModifyGrade) { //¼����޸ĳɼ�
			new MenuGrade().addOrModifyGrade();
		}else if(e.getSource()==queAvg) { //��ѯƽ���ɼ�
			new MenuGrade().average();
		}else if(e.getSource()==queSta) { //����ͳ��
			new MenuGrade().gradeStatics();
		}
	}
	
	public static void main(String[] args) {
		new MainForm();
	}
	
}
