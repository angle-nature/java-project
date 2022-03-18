package shiyan10;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Register {

	private JFrame register; //��¼����
	private JLabel prompt;  //�û�������ʾ��ǩ
	private JLabel userName;  //�û���ʾ��ǩ
	private JLabel password;  //������ʾ��ǩ
	private JTextField idText; //�û������
	private JPasswordField pwdText; //���������
	private JButton submit; //��¼��ť
	private JButton reset; //���ð�ť
	private JLabel loginStatus; //��¼״̬
		
	public Register() {
		
		prompt=new JLabel("�û���Ϊѧ�ţ���ʼ����Ϊ��������",JLabel.CENTER);
		userName=new JLabel("�û�����",JLabel.CENTER);  //�����û�����ʾ��Ϣ
		idText=new JTextField(15); //�����û��������
		password=new JLabel("    ���룺",JLabel.CENTER); //����������ʾ��Ϣ
		pwdText=new JPasswordField(15); //�������������
		submit=new JButton("��¼");
		reset=new JButton("����");
		loginStatus=new JLabel("",JLabel.CENTER);
		
		JPanel promptPanel=new JPanel(); //��ʾ��Ϣ���
		JPanel userPanel=new JPanel(); //�û����
		JPanel pwdPanel=new JPanel(); //�������
		JPanel buttonPanel=new JPanel(); //��ť���
		JPanel statusPanel=new JPanel(); //״̬���
		
		promptPanel.add(prompt);
		userPanel.add(userName);
		userPanel.add(idText);
		pwdPanel.add(password);
		pwdPanel.add(pwdText);
		buttonPanel.add(submit);
		buttonPanel.add(reset);
		
		//Font font=new Font("����",Font.BOLD+Font.PLAIN,20);
		//loginStatus.setFont(font);
		loginStatus.setForeground(Color.red);
		statusPanel.add(loginStatus);
		
		register=new JFrame("ѧ����¼����");
		register.setLayout(new GridLayout(5,1));
		register.add(promptPanel);
		register.add(userPanel);
		register.add(pwdPanel);
		register.add(buttonPanel);
		register.add(statusPanel);
		register.setSize(500,300); //���ڴ�С
		register.setLocation(300,200); //���ڳ���λ��
		register.setVisible(true);
		register.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user=idText.getText();
				String password=new String (pwdText.getPassword());
				
				LoginCheck loginCheck =new LoginCheck(user,password);  //����¼
				
				if(!loginCheck.checkUser())
					loginStatus.setText("�û��������ڣ�");
				else if(!loginCheck.checkpwd())
					loginStatus.setText("�������");
				else {
					loginStatus.setForeground(Color.green);
					loginStatus.setText("��¼�ɹ���");
					new MainForm(); //����������
					register.dispose();  //�˳���ǰ����
				}
			}
		});
		
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				idText.setText("");
				pwdText.setText("");
				loginStatus.setForeground(Color.blue);
				loginStatus.setText("���������룡");
			}
		});
	}
	
	public static void main(String[] args) {
		new Register();
	}
}
