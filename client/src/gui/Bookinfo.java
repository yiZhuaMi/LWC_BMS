package gui;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Bookinfo extends JFrame {

	private JPanel contentPane;
	private static int bookid;
	private static String name;
	private static String author;
	private static float price;
	private static String category;
	private static String remark;
	private static String bookinof;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//System.out.println("��ִ����main����");
					
					
					System.out.println("main name:"+name);
				    System.out.println("main author:"+author);
				    System.out.println("main price:"+price);
				    System.out.println("main category:"+category);
				    System.out.println("main remark:"+remark);
					
					   
					Bookinfo frame = new Bookinfo(bookid,name,author,price,category,remark,bookinof);
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


//	public void setTemp(String name,String author,float price,String category,String remark) {
//		this.name = name;
//		this.author = author;
//		this.price = price;
//		this.category = category;
//		this.remark = remark;
//		
//	}


	/**
	 * Create the frame.
	 */
	public Bookinfo(int bookid,String name,String author,float price,String category,String remark,String bookinof) {
		
		setTitle("详细信息");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel imageLabel = new JLabel("");
		imageLabel.setBounds(357, 13, 113, 141);
		contentPane.add(imageLabel);
		ImageIcon icon=new ImageIcon("src/material/oc.jpg");
		icon.setImage(icon.getImage().getScaledInstance(113,141,Image.SCALE_DEFAULT));
		imageLabel.setIcon(icon);
		
		JButton button = new JButton("返回");
		button.setBounds(414, 305, 79, 27);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				Bookinfo.this.setVisible(false);
			}
		});
		
		JLabel nameLabel = new JLabel("图书名称");
		nameLabel.setBounds(26, 28, 79, 18);
		contentPane.add(nameLabel);
		
		JLabel authorLabel = new JLabel("图书作者");
		authorLabel.setBounds(26, 59, 79, 18);
		contentPane.add(authorLabel);
		
		JLabel priceLabel = new JLabel("图书价格");
		priceLabel.setBounds(26, 90, 79, 18);
		contentPane.add(priceLabel);
		
		JLabel categoryLabel = new JLabel("图书分类");
		categoryLabel.setBounds(168, 90, 79, 18);
		contentPane.add(categoryLabel);
		
		JLabel idLabel = new JLabel("图书编号");
		idLabel.setBounds(26, 121, 79, 18);
		contentPane.add(idLabel);
		
		JLabel remarkLabel = new JLabel("图书备注");
		remarkLabel.setBounds(168, 121, 79, 18);
		contentPane.add(remarkLabel);
		
		JLabel nameLabel2 = new JLabel();
		nameLabel2.setText(name);
		nameLabel2.setBounds(97, 28, 150, 18);
		contentPane.add(nameLabel2);
		
		JLabel authorLabel2 = new JLabel();
		authorLabel2.setText(author);
		authorLabel2.setBounds(97, 59, 150, 18);
		contentPane.add(authorLabel2);
		
		JLabel priceLabel2 = new JLabel();
		priceLabel2.setText(String.valueOf(price));
		priceLabel2.setBounds(97, 90, 65, 18);
		contentPane.add(priceLabel2);
		
		JLabel categoryLabel2 = new JLabel();
		categoryLabel2.setText(category);
		categoryLabel2.setBounds(242, 90, 124, 18);
		contentPane.add(categoryLabel2);
		
		JLabel remarkLabel2 = new JLabel();
		remarkLabel2.setText(remark);
		remarkLabel2.setBounds(239, 121, 127, 18);
		contentPane.add(remarkLabel2);
		
		JLabel idLabel2 = new JLabel();
		idLabel2.setText(String.valueOf(bookid));
		idLabel2.setBounds(97, 121, 54, 18);
		contentPane.add(idLabel2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 170, 444, 121);
		contentPane.add(scrollPane);
	    
	    JTextArea inofArea= new JTextArea();
	    scrollPane.setViewportView(inofArea);
	    inofArea.setText(bookinof);
	    inofArea.setLineWrap(true);
	    inofArea.setEditable(false);
		
		
		
	}
}
