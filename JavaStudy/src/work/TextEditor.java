package work;

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class TextEditor {
	
	private static Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard(); //������ 
	
	private static void createAndShowGUI() {			
		JFrame f = new JFrame("�����ı��༭��");
		f.setSize(700,450);
		f.setLocation(300,200); //���ڳ���λ��
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();

		JMenu menu1 = new JMenu("�ļ�(F)");
		JMenu menu2 = new JMenu("�༭(E)");
		JMenu menu3 = new JMenu("��ʽ(O)");
		JMenu menu4 = new JMenu("�鿴(V)");
		JMenu menu5 = new JMenu("����(H)");
		
		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.add(menu3);
		menuBar.add(menu4);
		menuBar.add(menu5);

		JMenuItem item1 = new JMenuItem("�½�(Ctrl+N)");
		JMenuItem item2 = new JMenuItem("����(Ctrl+S)");
		JMenuItem item3 = new JMenuItem("���Ϊ(Ctrl+D)");
		
		JMenuItem item4 = new JMenuItem("��(Ctrl+O)");
		JMenuItem item5 = new JMenuItem("�˳�(Ctrl+E)");
		JMenuItem item6 = new JMenuItem("����(ctrl+C)");
		JMenuItem item7 = new JMenuItem("ճ��(ctrl+V)");
		JMenuItem item8 = new JMenuItem("����(ctrl+X)");
		JMenuItem item9 = new JMenuItem("ȫѡ(ctrl+A)");
		
		menu1.add(item1);
		menu1.addSeparator();  
		menu1.add(item2);
		menu1.addSeparator();  
		menu1.add(item3);
		menu1.addSeparator();  
		menu1.add(item4);
		menu1.addSeparator();  
		menu1.add(item5);
		menu2.add(item6);
		menu2.addSeparator();  
		menu2.add(item7);
		menu2.addSeparator();  
		menu2.add(item8);
		menu2.addSeparator();  
		menu2.add(item9);
		menu2.addSeparator();  

		JTextArea tf = new JTextArea(30,20); //�ı�����
		tf.setFont(new Font("����", Font.PLAIN, 20));
		f.add(tf);
	
		SortCut(f,tf);
		scrollpane(f,tf);
		
		item1.addActionListener(e->{
			CreateNew(); //�½�
		});
		
		item2.addActionListener(e->{
			WriteData(f,tf); //����
		});
		
		item3.addActionListener(e->{
			WriteOther(f,tf); //���Ϊ
		}); 
		
		item4.addActionListener(e->{
			ReadData(f,tf); //��
		});
		
		item5.addActionListener(e->{
			Exit(); //�˳�
		});
		
		item6.addActionListener(e->{
			Copy(f,tf); //����
		});
		
		item7.addActionListener(e->{
			Paste(f,tf); //ճ��
		});
		
		item8.addActionListener(e->{
			Shear(f,tf); //����
		});

		item9.addActionListener(e->{
			SelectAll(f,tf); //ȫѡ
		});
		
		f.setJMenuBar(menuBar);
	}
	
	public static void SortCut(JFrame f,JTextArea tf) {
		
		tf.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				
				if((e.isControlDown()==true)&&(e.getKeyCode() == KeyEvent.VK_N)) {
					CreateNew();
					System.out.println("�½�");
				}
				if((e.isControlDown()==true)&&(e.getKeyCode() == KeyEvent.VK_E)) {
					Exit();
					System.out.println("�˳�");
				}
				if((e.isControlDown()==true)&&(e.getKeyCode() == KeyEvent.VK_S)) {
					WriteData(f,tf);
					System.out.println("����");
				}
				if((e.isControlDown()==true)&&(e.getKeyCode() == KeyEvent.VK_D)) {
					WriteOther(f,tf);
					System.out.println("���Ϊ");
				}
				if((e.isControlDown()==true)&&(e.getKeyCode() == KeyEvent.VK_O)) {
					ReadData(f,tf);
					System.out.println("��");
				}
				if((e.isControlDown()==true)&&(e.getKeyCode() == KeyEvent.VK_A)) {
					SelectAll(f,tf);
					System.out.println("ȫѡ");
				}
				if((e.isControlDown()==true)&&(e.getKeyCode() == KeyEvent.VK_C)) {
					Copy(f,tf);
					System.out.println("����");
				}
				if((e.isControlDown()==true)&&(e.getKeyCode() == KeyEvent.VK_V)) {
					Paste(f,tf);
					System.out.println("ճ��");
				}
				if((e.isControlDown()==true)&&(e.getKeyCode() == KeyEvent.VK_X)) {
					Shear(f,tf);
					System.out.println("����");
				}
			}	
					
		});				
	}
	
	public static void HaveSaved() { //ȷ�ϱ���
		JFrame f = new JFrame("�����ı��༭��");
		f.setLayout(new FlowLayout(FlowLayout.LEFT,100,30));
		f.setSize(300,200);
		f.setLocation(500, 400);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Button btn=new Button("ȷ�����˳�");
		btn.setBounds(115,100,50,25);
		
		JLabel label = new JLabel("�ѱ���");
		label.setFont(new Font("����", Font.PLAIN, 24));
		f.add(label);
		f.add(btn);
		
		btn.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
		
	public static void ReadData(JFrame f,JTextArea tf) { //���ļ�
			try {
				FileDialog fileDialog = new FileDialog(f);
				fileDialog.setVisible(true);
				String directory = fileDialog.getDirectory();//��ȡĿ¼·��
				String file = fileDialog.getFile();//��ȡ�ļ�·��
				String path = directory + file;
				FileReader in = new FileReader(path);
				
				int len = 0;
				while((len=in.read())!=-1)
				{
					String s = String.valueOf((char)len);
					tf.append(s);
				}
				in.close();
			}catch(Exception x) {
				x.printStackTrace();
			}
	}
	
	public static void WriteData(JFrame f,JTextArea tf){  //����
			try {
				FileWriter out = new FileWriter("F:\\java-2020-06\\WorkSpace\\JavaStudy\\myText.txt");
				String str = tf.getText();
				out.write(str);
				out.close();
				HaveSaved();
			}catch(Exception x) {}
	}
	
	public static void WriteOther(JFrame f,JTextArea tf){ //���Ϊ
			try {
				FileDialog fileDialog = new FileDialog(f);
				fileDialog.setVisible(true);
				String directory = fileDialog.getDirectory();//��ȡĿ¼·��
				String file = fileDialog.getFile();//��ȡ�ļ�·��
				String path = directory + file;
				FileWriter out = new FileWriter(path);		
				
				String str = tf.getText();
				out.write(str);
				out.close();
				//HaveSaved();
			}catch(Exception x) {}
	}
	
	public static void scrollpane(JFrame f,JTextArea tf) {
		JScrollPane scrollPane = new JScrollPane(tf);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		f.add(scrollPane);
	}

	public static void CreateNew() {  //�½�����
			createAndShowGUI();
	}
	public static void Exit() {  //�˳�
		System.exit(0);
	}
	
	public static void Copy(JFrame f,JTextArea tf) { //����	
		cb.setContents(new StringSelection(tf.getSelectedText()), null);
	}
	
	public static void Paste(JFrame f,JTextArea tf) { //ճ��	
		try {
			tf.setForeground(Color.black);
			Transferable content=cb.getContents(null);
			String st=(String)content.getTransferData(DataFlavor.stringFlavor);
			tf.replaceRange(st,tf.getSelectionStart(),tf.getSelectionEnd());
		}catch(Exception e) {		
			
		}
	}
	
	public static void Shear(JFrame f,JTextArea tf) { //����	
		cb.setContents(new StringSelection(tf.getSelectedText()), null);
		tf.replaceRange("",tf.getSelectionStart(),tf.getSelectionEnd());
	}
	
	public static void SelectAll(JFrame f,JTextArea tf) { //ȫѡ
		tf.setSelectionStart(0);
		tf.setSelectionEnd(tf.getText().length());
		tf.setForeground(Color.blue);
	}

	public static void main(String[] args) throws Exception {
		SwingUtilities.invokeLater(TextEditor::createAndShowGUI); 
	}
}
