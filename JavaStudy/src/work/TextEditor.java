package work;

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class TextEditor {
	
	private static Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard(); //剪贴板 
	
	private static void createAndShowGUI() {			
		JFrame f = new JFrame("简易文本编辑器");
		f.setSize(700,450);
		f.setLocation(300,200); //窗口出现位置
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();

		JMenu menu1 = new JMenu("文件(F)");
		JMenu menu2 = new JMenu("编辑(E)");
		JMenu menu3 = new JMenu("格式(O)");
		JMenu menu4 = new JMenu("查看(V)");
		JMenu menu5 = new JMenu("帮助(H)");
		
		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.add(menu3);
		menuBar.add(menu4);
		menuBar.add(menu5);

		JMenuItem item1 = new JMenuItem("新建(Ctrl+N)");
		JMenuItem item2 = new JMenuItem("保存(Ctrl+S)");
		JMenuItem item3 = new JMenuItem("另存为(Ctrl+D)");
		
		JMenuItem item4 = new JMenuItem("打开(Ctrl+O)");
		JMenuItem item5 = new JMenuItem("退出(Ctrl+E)");
		JMenuItem item6 = new JMenuItem("复制(ctrl+C)");
		JMenuItem item7 = new JMenuItem("粘贴(ctrl+V)");
		JMenuItem item8 = new JMenuItem("剪切(ctrl+X)");
		JMenuItem item9 = new JMenuItem("全选(ctrl+A)");
		
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

		JTextArea tf = new JTextArea(30,20); //文本区域
		tf.setFont(new Font("宋体", Font.PLAIN, 20));
		f.add(tf);
	
		SortCut(f,tf);
		scrollpane(f,tf);
		
		item1.addActionListener(e->{
			CreateNew(); //新建
		});
		
		item2.addActionListener(e->{
			WriteData(f,tf); //保存
		});
		
		item3.addActionListener(e->{
			WriteOther(f,tf); //另存为
		}); 
		
		item4.addActionListener(e->{
			ReadData(f,tf); //打开
		});
		
		item5.addActionListener(e->{
			Exit(); //退出
		});
		
		item6.addActionListener(e->{
			Copy(f,tf); //复制
		});
		
		item7.addActionListener(e->{
			Paste(f,tf); //粘贴
		});
		
		item8.addActionListener(e->{
			Shear(f,tf); //剪切
		});

		item9.addActionListener(e->{
			SelectAll(f,tf); //全选
		});
		
		f.setJMenuBar(menuBar);
	}
	
	public static void SortCut(JFrame f,JTextArea tf) {
		
		tf.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				
				if((e.isControlDown()==true)&&(e.getKeyCode() == KeyEvent.VK_N)) {
					CreateNew();
					System.out.println("新建");
				}
				if((e.isControlDown()==true)&&(e.getKeyCode() == KeyEvent.VK_E)) {
					Exit();
					System.out.println("退出");
				}
				if((e.isControlDown()==true)&&(e.getKeyCode() == KeyEvent.VK_S)) {
					WriteData(f,tf);
					System.out.println("保存");
				}
				if((e.isControlDown()==true)&&(e.getKeyCode() == KeyEvent.VK_D)) {
					WriteOther(f,tf);
					System.out.println("另存为");
				}
				if((e.isControlDown()==true)&&(e.getKeyCode() == KeyEvent.VK_O)) {
					ReadData(f,tf);
					System.out.println("打开");
				}
				if((e.isControlDown()==true)&&(e.getKeyCode() == KeyEvent.VK_A)) {
					SelectAll(f,tf);
					System.out.println("全选");
				}
				if((e.isControlDown()==true)&&(e.getKeyCode() == KeyEvent.VK_C)) {
					Copy(f,tf);
					System.out.println("复制");
				}
				if((e.isControlDown()==true)&&(e.getKeyCode() == KeyEvent.VK_V)) {
					Paste(f,tf);
					System.out.println("粘贴");
				}
				if((e.isControlDown()==true)&&(e.getKeyCode() == KeyEvent.VK_X)) {
					Shear(f,tf);
					System.out.println("剪切");
				}
			}	
					
		});				
	}
	
	public static void HaveSaved() { //确认保存
		JFrame f = new JFrame("简易文本编辑器");
		f.setLayout(new FlowLayout(FlowLayout.LEFT,100,30));
		f.setSize(300,200);
		f.setLocation(500, 400);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Button btn=new Button("确认且退出");
		btn.setBounds(115,100,50,25);
		
		JLabel label = new JLabel("已保存");
		label.setFont(new Font("宋体", Font.PLAIN, 24));
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
		
	public static void ReadData(JFrame f,JTextArea tf) { //打开文件
			try {
				FileDialog fileDialog = new FileDialog(f);
				fileDialog.setVisible(true);
				String directory = fileDialog.getDirectory();//获取目录路径
				String file = fileDialog.getFile();//获取文件路径
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
	
	public static void WriteData(JFrame f,JTextArea tf){  //保存
			try {
				FileWriter out = new FileWriter("F:\\java-2020-06\\WorkSpace\\JavaStudy\\myText.txt");
				String str = tf.getText();
				out.write(str);
				out.close();
				HaveSaved();
			}catch(Exception x) {}
	}
	
	public static void WriteOther(JFrame f,JTextArea tf){ //另存为
			try {
				FileDialog fileDialog = new FileDialog(f);
				fileDialog.setVisible(true);
				String directory = fileDialog.getDirectory();//获取目录路径
				String file = fileDialog.getFile();//获取文件路径
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

	public static void CreateNew() {  //新建窗口
			createAndShowGUI();
	}
	public static void Exit() {  //退出
		System.exit(0);
	}
	
	public static void Copy(JFrame f,JTextArea tf) { //复制	
		cb.setContents(new StringSelection(tf.getSelectedText()), null);
	}
	
	public static void Paste(JFrame f,JTextArea tf) { //粘贴	
		try {
			tf.setForeground(Color.black);
			Transferable content=cb.getContents(null);
			String st=(String)content.getTransferData(DataFlavor.stringFlavor);
			tf.replaceRange(st,tf.getSelectionStart(),tf.getSelectionEnd());
		}catch(Exception e) {		
			
		}
	}
	
	public static void Shear(JFrame f,JTextArea tf) { //剪切	
		cb.setContents(new StringSelection(tf.getSelectedText()), null);
		tf.replaceRange("",tf.getSelectionStart(),tf.getSelectionEnd());
	}
	
	public static void SelectAll(JFrame f,JTextArea tf) { //全选
		tf.setSelectionStart(0);
		tf.setSelectionEnd(tf.getText().length());
		tf.setForeground(Color.blue);
	}

	public static void main(String[] args) throws Exception {
		SwingUtilities.invokeLater(TextEditor::createAndShowGUI); 
	}
}
