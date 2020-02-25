package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.LookAndFeel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import net.Client;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.SystemColor;

public class AdmInterface extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel imagelabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdmInterface frame = new AdmInterface();
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
			
				}
	}

	/**
	 * Create the frame.
	 */
	public AdmInterface() {
		setBackground(new Color(255, 0, 0));
		setTitle("欢迎来到小白云图书管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 385);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//ImageIcon icon=new ImageIcon("E:\\sj\\�ز�\\2.jpg");
		
		
		
		JButton button = new JButton("查询图书");
		button.setForeground(Color.BLACK);
		button.setBackground(Color.WHITE);
		button.setBounds(80, 177, 140, 43);
		button.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				Searchbook searchbook = new Searchbook();
				searchbook.setVisible(true);
				AdmInterface.this.setVisible(false);
			}
		});
		
		JButton button_1 = new JButton("添加图书");
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(289, 177, 140, 43);
		button_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		contentPane.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				Addbook addbook = new Addbook();
				addbook.setVisible(true);
				AdmInterface.this.setVisible(false);
			}
		});
		
		JButton button_2 = new JButton("修改图书");
		button_2.setBackground(Color.WHITE);
		button_2.setBounds(80, 247, 140, 43);
		button_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		contentPane.add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				Modifybook modifybook = new Modifybook();
				modifybook.setVisible(true);
				AdmInterface.this.setVisible(false);
			}
		});
		
		JButton button_3 = new JButton("删除图书");
		button_3.setBackground(Color.WHITE);
		button_3.setBounds(289, 247, 140, 43);
		button_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		contentPane.add(button_3);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				Deletebook deletebook = new Deletebook();
				deletebook.setVisible(true);
				AdmInterface.this.setVisible(false);
			}
		});
		
		JButton backtologinButton = new JButton("注销");
		backtologinButton.setForeground(Color.WHITE);
		backtologinButton.setBackground(new Color(102, 153, 255));
		backtologinButton.setBounds(214, 302, 79, 27);
		backtologinButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		contentPane.add(backtologinButton);
		backtologinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				Login login = new Login();
				login.setVisible(true);
				AdmInterface.this.setVisible(false);
			}
		});
		
//		JButton button_4 = new JButton("�˳�ϵͳ");
//		button_4.setBackground(Color.WHITE);
//		button_4.setBounds(201, 298, 113, 27);
//		button_4.setFont(new Font("���� Light", Font.PLAIN, 15));
//		contentPane.add(button_4);
//		button_4.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0)
//			{
//				Client client = new Client();
//				client.closeconnection();
//				System.exit(0);
//			}
//		});
		
		
		imagelabel = new JLabel("New label");
		imagelabel.setVerticalAlignment(SwingConstants.TOP);
		imagelabel.setBounds(0, 108, 572, 302);
//		ImageIcon icon=new ImageIcon(this.getClass().getResource("material/login-bg2.jpg"));
		ImageIcon icon=new ImageIcon("src/material/login-bg2.jpg");
		icon.setImage(icon.getImage().getScaledInstance(550,380,Image.SCALE_DEFAULT));
		contentPane.add(imagelabel);
		imagelabel.setIcon(icon);
		
		JLabel label = new JLabel("欢迎来到小白云牌图书管理系统");
		label.setForeground(Color.DARK_GRAY);
		label.setBounds(117, 29, 299, 49);
		label.setFont(new Font("微软雅黑",1,20));
		label.setBackground(Color.BLACK);
		contentPane.add(label);
		
		
		

	}
}
