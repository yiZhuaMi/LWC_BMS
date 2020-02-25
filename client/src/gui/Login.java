package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.Client;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usrname;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_1;
	private JButton exitbutton;
	private JLabel lblNewLabel_2;
	private int startX;
    private int endX;
    private int startY;
    private int endY;
    private JLabel imagelabel;
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					frame.setResizable(false);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
		try { 
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) { 
				if ("Nimbus".equals(info.getName())) { 
				UIManager.setLookAndFeel(info.getClassName()); 
				break; 
				} 
				} 
				} catch (Exception e) { 
				// If Nimbus is not available, you can set the GUI to another look and feel. 
				}
		
		//String lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";//windows���
		//String lookAndFeel = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";//motif���
		//String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
//		String lookAndFeel = "javax.swing.plaf.metal.MetalLookAndFeel";
//		try {
//			UIManager.setLookAndFeel(lookAndFeel);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (UnsupportedLookAndFeelException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	
	}

	
	 
	public Login() {
		setBackground(Color.RED);

		setTitle("登录界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 385);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_2 = new JLabel("小白云牌图书管理系统");
		lblNewLabel_2.setBounds(99, 118, 320, 54);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("微软雅黑",1,30));
//		lblNewLabel_2.setFont(new Font("����С����_GBK",1,30));
//		lblNewLabel_2.setFont(new Font("������̱����μ���",1,30));
//		lblNewLabel_2.setFont(new Font("�������_GBK",1,30));
		lblNewLabel_2.setForeground(Color.white);
		
		JLabel lblNewLabel = new JLabel("用户名");
		lblNewLabel.setBounds(116, 226, 45, 18);
		lblNewLabel.setFont(new Font("微软雅黑",0,15));
		lblNewLabel.setForeground(Color.gray);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("密码");
		lblNewLabel_1.setBounds(131, 257, 30, 18);
		lblNewLabel_1.setFont(new Font("微软雅黑",0,15));
		lblNewLabel_1.setForeground(Color.gray);
		contentPane.add(lblNewLabel_1);
		
		usrname = new JTextField();
		usrname.setBounds(167, 224, 187, 24);
//		usrname.setText("�û���");
		usrname.setForeground(Color.gray);
		contentPane.add(usrname);
		usrname.setColumns(10);
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(165, 261, 189, 24);
		//passwordField.setText("����");
		contentPane.add(passwordField);
		
		JButton login = new JButton("登录");
		login.setForeground(SystemColor.window);
		login.setBackground(new Color(51, 153, 102));
		login.setBounds(165, 298, 189, 27);
		login.setFont(new Font("微软雅黑", Font.BOLD, 16));
		//login.setForeground(Color.blue);
		contentPane.add(login);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				String un = usrname.getText();
				String pw = String.valueOf(passwordField.getPassword());
				//System.out.println("�û���"+un);
				//System.out.println("����"+pw);
				if(un.equals("administrator")&&pw.equals("920725"))
				{
					new Client();
					AdmInterface ai = new AdmInterface();
					ai.setVisible(true);
					Login.this.setVisible(false);
				}
				else if(un.equals("user")&&pw.equals("920725"))
				{
					new Client();
					UserInterface ui = new UserInterface();
					ui.setVisible(true);
					Login.this.setVisible(false);
				}
				else if(true)
				{
					JOptionPane.showMessageDialog(null, "用户名或密码错误");
				}
				
			}
		});
		
		imagelabel = new JLabel("New label");
		imagelabel.setVerticalAlignment(SwingConstants.TOP);
		imagelabel.setBounds(0, 0, 558, 382);
		contentPane.add(imagelabel);
//		ImageIcon icon=new ImageIcon("/Users/mach/Documents/workspace/java/LWCBMS/20160514最终版.exe/material/login-bg.jpg");
		ImageIcon icon=new ImageIcon("src/material/login-bg.jpg");
		icon.setImage(icon.getImage().getScaledInstance(550,200,Image.SCALE_DEFAULT));
		imagelabel.setIcon(icon);
		
	}
}
