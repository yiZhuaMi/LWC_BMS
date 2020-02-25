package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.ImageView;

import net.Client;

import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class UserInterface extends JFrame {

	private JPanel contentPane;
	private JLabel imagelabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface frame = new UserInterface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserInterface() {
		setTitle("欢迎来到小白云图书管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 385);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("欢迎来到小白云图书管理系统");
		label.setForeground(Color.WHITE);
		label.setBounds(104, 78, 299, 49);
		label.setFont(new Font("微软雅黑",1,20));
		label.setBackground(Color.WHITE);
		contentPane.add(label);
				
		JButton button_3 = new JButton("查询图书");
		button_3.setForeground(Color.DARK_GRAY);
		button_3.setBackground(SystemColor.menu);
		button_3.setBounds(182, 218, 140, 43);
		button_3.setLocale(null);
		button_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		contentPane.add(button_3);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				Searchbook searchbook = new Searchbook("user");
				searchbook.setVisible(true);
				UserInterface.this.setVisible(false);
			}
		});
		
		JButton backtologinButton = new JButton("注销");
		backtologinButton.setForeground(Color.LIGHT_GRAY);
		backtologinButton.setBackground(Color.WHITE);
		backtologinButton.setBounds(213, 298, 79, 27);
		backtologinButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		contentPane.add(backtologinButton);
		backtologinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				Login login = new Login();
				login.setVisible(true);
				UserInterface.this.setVisible(false);
			}
		});
		
		imagelabel = new JLabel("New label");
		imagelabel.setBackground(SystemColor.control);
		imagelabel.setVerticalAlignment(SwingConstants.TOP);
		imagelabel.setBounds(0, 0, 507, 338);
		contentPane.add(imagelabel);
//		ImageIcon icon=new ImageIcon(System.getProperty("user.dir")+"material/login-bg.jpg");
//		ImageIcon icon=new ImageIcon(this.getClass().getResource("material/login-bg.jpg"));
		ImageIcon icon=new ImageIcon("src/material/login-bg.jpg");
		icon.setImage(icon.getImage().getScaledInstance(550,200,Image.SCALE_DEFAULT));
		imagelabel.setIcon(icon);

	}

}
