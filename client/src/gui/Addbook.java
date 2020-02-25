package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Book;
import net.Client;
import net.Package;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Addbook extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField bookname;
	private JTextField author;
	private JTextField price;
	private JTextArea bookinfo;
	boolean isSuccess;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addbook frame = new Addbook();
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
	}

	/**
	 * Create the frame.
	 */
	public static boolean isNum(String str){
		return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
	}
	
	public Addbook() {
		setTitle("添加图书");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("图书名称");
		label.setBounds(47, 79, 72, 18);
		label.setFont(new Font("微软雅黑",0,15));
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("图书作者");
		lblNewLabel.setBounds(47, 122, 72, 18);
		lblNewLabel.setFont(new Font("微软雅黑",0,15));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("图书价格");
		lblNewLabel_1.setBounds(47, 168, 72, 18);
		lblNewLabel_1.setFont(new Font("微软雅黑",0,15));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("图书分类");
		lblNewLabel_2.setBounds(47, 207, 72, 18);
		lblNewLabel_2.setFont(new Font("微软雅黑",0,15));
		contentPane.add(lblNewLabel_2);
		
		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(116, 205, 125, 24);
		comboBox.addItem("计算机");
		comboBox.addItem("数学");
		comboBox.addItem("生活");
		comboBox.addItem("哲学");
		comboBox.addItem("心理学");
		comboBox.addItem("英语");
		comboBox.addItem("体育");
		comboBox.addItem("管理");
		comboBox.addItem("政治");
		comboBox.addItem("经济");
		comboBox.addItem("法律");
		comboBox.addItem("军事");
		comboBox.addItem("社会科学");
		comboBox.addItem("人文科学");
		contentPane.add(comboBox);
		comboBox.setSelectedIndex(-1);
		
		final JTextArea remark = new JTextArea();
		remark.setBounds(116, 248, 125, 24);
		contentPane.add(remark);
		
		JLabel lblNewLabel_3 = new JLabel("图书备注");
		lblNewLabel_3.setBounds(47, 249, 72, 18);
		lblNewLabel_3.setFont(new Font("微软雅黑",0,15));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("详细信息");
		lblNewLabel_4.setBounds(255, 80, 72, 18);
		contentPane.add(lblNewLabel_4);
		
		bookname = new JTextField();
		bookname.setBounds(116, 76, 125, 24);
		contentPane.add(bookname);
		bookname.setColumns(10);
		//String bn = bookname.getText();
		
		
		author = new JTextField();
		author.setBounds(116, 119, 125, 24);
		contentPane.add(author);
		author.setColumns(10);
		//String au = bookname.getText();
	  
		
		price = new JTextField();
		price.setBounds(116, 162, 125, 24);
		contentPane.add(price);
		price.setColumns(10);		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(255, 100, 238, 167);
		contentPane.add(scrollPane);
		
	    bookinfo= new JTextArea();
		scrollPane.setViewportView(bookinfo);
		bookinfo.setLineWrap(true);
	
		
		JButton reset = new JButton("重置");
		reset.setBounds(228, 298, 79, 27);
		contentPane.add(reset);
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				bookname.setText("");
				author.setText("");
				price.setText("");
				remark.setText("");
				comboBox.setSelectedIndex(-1);
				bookinfo.setText("");
			}
		});
	
		
		JLabel label_1 = new JLabel("欢迎来到图书添加界面");
		label_1.setBounds(14, 13, 182, 18);
		contentPane.add(label_1);
		label_1.setForeground(Color.gray);
		//label_1.setFont(new Font("����ϸ�ڼ���",0,20));
		//label_1.setFont(new Font("����",0,20));
		JButton button = new JButton("返回");
		button.setBounds(414, 298, 79, 27);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				AdmInterface jiemian = new AdmInterface();
				jiemian.setVisible(true);
				Addbook.this.setVisible(false);
			}
		});
		
		JButton button1 = new JButton("添加");
		button1.setBounds(321, 298, 79, 27);
		contentPane.add(button1);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				if(isNum(price.getText()))
				{
					if(bookname.getText().trim().length()>=1&&author.getText().trim().length()>=1&&price.getText().trim().length()>=1&&remark.getText().trim().length()>=1)
					{
						try
						{
							
							Package pk = new Package();
							pk.packaging("add", bookname.getText(), author.getText(), price.getText(),comboBox.getSelectedItem().toString(), remark.getText(), bookinfo.getText());
							

							JOptionPane.showMessageDialog(null, "添加成功！");
						}
						catch(Exception f)
						{
							f.printStackTrace();
							JOptionPane.showMessageDialog(null, "添加失败！");
						}
					}
					else{JOptionPane.showMessageDialog(null, "不能有空值！");}
					
					
				}
				else{JOptionPane.showMessageDialog(null, "价格必须为数字！");}
				
				
			}
		});
	}
}
