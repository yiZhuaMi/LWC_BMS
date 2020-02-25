package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import model.Book;
import net.Client;
import net.Package;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class Searchbook extends JFrame {

	private JPanel contentPane;
	private JTable resulttable;
	private JTextField KWtextField;
	private Vector<Book> booklist=new Vector<Book>();
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
					Searchbook frame = new Searchbook();
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
	public Searchbook() 
	{
		setTitle("查询图书");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 385);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane js = new JScrollPane();
		js.setBounds(24, 59, 469, 242);
		contentPane.add(js);
		
		String[] headers = {"图书编号","图书名称", "图书作者","图书价格", "图书分类","备注"};
		Object[][] cellData =null;
		final DefaultTableModel model = new DefaultTableModel(cellData, headers) {
		  public boolean isCellEditable(int row, int column) {
		    return false;
		  }
		};
		resulttable = new JTable(model);
		resulttable.setBounds(14, 59, 479, 242);
		resulttable.setRowHeight(20);
		js.setViewportView(resulttable);
		model.setColumnCount(6);
		model.setRowCount(0);

		RowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);  
		resulttable.setRowSorter(sorter);  
	
		
		KWtextField = new JTextField();
		KWtextField.setBounds(135, 22, 281, 24);
		contentPane.add(KWtextField);
		KWtextField.setColumns(10);
		
		JLabel KWLabel = new JLabel("请输入关键字");
		KWLabel.setBounds(34, 24, 108, 18);
		KWLabel.setFont(new Font("微软雅黑",0,15));
		contentPane.add(KWLabel);
		
		JButton returnbutton = new JButton("返回");
		returnbutton.setBounds(414, 311, 79, 27);
		contentPane.add(returnbutton);
		returnbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				AdmInterface jiemian = new AdmInterface();
				jiemian.setVisible(true);
				Searchbook.this.setVisible(false);
			}
		});
		
		
	
		
		JButton searchButton = new JButton("搜索");
		searchButton.setBounds(430, 21, 63, 27);
		contentPane.add(searchButton);
		searchButton.addActionListener(new ActionListener()
		{
				public void actionPerformed(ActionEvent arg0)
			{
				
				model.setRowCount(0);
				System.out.println("开始查询！");
		
				Package pk = new Package();
				booklist = pk.packaging("search", KWtextField.getText());
				
				if(booklist==null){JOptionPane.showMessageDialog(null, "墨子都没有找到~");}
				else
				{
				
					int count = booklist.size();
					String[][] result =new String[count][6] ;
					for(int i = 0;i<count;i++)
					{
						result[i][0]=Integer.toString(booklist.get(i).bookid);
						result[i][1]=booklist.get(i).bookname;
						result[i][2]=booklist.get(i).author;
						result[i][3]=String.valueOf(booklist.get(i).price);
						result[i][4]=booklist.get(i).category;
						result[i][5]=booklist.get(i).remark;
					}
					for(int i = 0;i<count;i++)
					{
						Object[]str = new Object[6*count];
						for(int j = 0;j<6;j++)
						{
							str[j]=result[i][j];		
						}
						model.addRow(str);
						
					}
					System.out.println("查询成功！");

				}
				
				
			}
			
			
		});
		
		resulttable.addMouseListener(new MouseAdapter() 
		{
			   public void mouseClicked(MouseEvent e) 
			   {
				   if (e.getButton() == MouseEvent.BUTTON1) 
			   		{
					   if (e.getClickCount() == 2)
					   {
						   //int col = resulttable.getModel().getColumnCount();
						   int row = resulttable.getSelectedRow();
						   System.out.println("row:"+(row+1));
						   
						   int bookid =Integer.valueOf(resulttable.getModel().getValueAt(row, 0).toString());
						   String name =resulttable.getModel().getValueAt(row, 1).toString();
						   String author =resulttable.getModel().getValueAt(row, 2).toString();
						   float price =Float.valueOf(resulttable.getModel().getValueAt(row, 3).toString());
						   String category =resulttable.getModel().getValueAt(row, 4).toString();
						   String remark;
						   if(resulttable.getModel().getValueAt(row, 5)!=null)
						   {
							   remark =resulttable.getModel().getValueAt(row, 5).toString();
						   }
						   else
						   {
							   remark = "（空）";
						   }
						 //  String bookinof = resulttable.getModel().getValueAt(row, 6).toString();
						   String bookinfo =booklist.get(row).bookinfo;
						   Bookinfo info = new Bookinfo(bookid,name,author,price,category,remark,bookinfo);
						   info.setVisible(true);
					   }
			   		}
			   }
		});
		
		
		
		
	}
	
	
	public Searchbook(String user) 
	{
		setTitle("查询图书");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 385);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane js = new JScrollPane();
		js.setBounds(24, 59, 469, 242);
		contentPane.add(js);
		
		String[] headers = {"图书编号","图书名称", "图书作者","图书价格", "图书分类","备注"};
		Object[][] cellData =null;
		final DefaultTableModel model = new DefaultTableModel(cellData, headers) {
		  public boolean isCellEditable(int row, int column) {
		    return false;
		  }
		};
		resulttable = new JTable(model);
		resulttable.setBounds(14, 59, 479, 242);
		resulttable.setRowHeight(20);
		js.setViewportView(resulttable);
		model.setColumnCount(6);
		model.setRowCount(0);

		RowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);  
		resulttable.setRowSorter(sorter);  
	
		
		KWtextField = new JTextField();
		KWtextField.setBounds(135, 22, 281, 24);
		contentPane.add(KWtextField);
		KWtextField.setColumns(10);
		
		JLabel KWLabel = new JLabel("请输入关键字");
		KWLabel.setBounds(34, 24, 108, 18);
		KWLabel.setFont(new Font("微软雅黑",0,15));
		contentPane.add(KWLabel);
		
		JButton returnbutton = new JButton("注销");
		returnbutton.setBounds(414, 311, 79, 27);
		contentPane.add(returnbutton);
		returnbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				Login login = new Login();
				login.setVisible(true);
				Searchbook.this.setVisible(false);
			}
		});
		
		
		
	
		
		JButton searchButton = new JButton("搜索");
		searchButton.setBounds(430, 21, 63, 27);
		contentPane.add(searchButton);
		searchButton.addActionListener(new ActionListener()
		{
				public void actionPerformed(ActionEvent arg0)
			{
				
				model.setRowCount(0);
				System.out.println("开始查询！");
			
				Package pk = new Package();
				booklist = pk.packaging("search", KWtextField.getText());
				
				if(booklist==null){JOptionPane.showMessageDialog(null, "墨子都没有找到~");}
				else
				{
				
					int count = booklist.size();
					String[][] result =new String[count][6] ;
					for(int i = 0;i<count;i++)
					{
						result[i][0]=Integer.toString(booklist.get(i).bookid);
						result[i][1]=booklist.get(i).bookname;
						result[i][2]=booklist.get(i).author;
						result[i][3]=String.valueOf(booklist.get(i).price);
						result[i][4]=booklist.get(i).category;
						result[i][5]=booklist.get(i).remark;
					}
					for(int i = 0;i<count;i++)
					{
						Object[]str = new Object[6*count];
						for(int j = 0;j<6;j++)
						{
							str[j]=result[i][j];		
						}
						model.addRow(str);
						
					}
					System.out.println("查询成功！");

				}
				
				
			}
			
			
		});
		
		resulttable.addMouseListener(new MouseAdapter() 
		{
			   public void mouseClicked(MouseEvent e) 
			   {
				   if (e.getButton() == MouseEvent.BUTTON1) 
			   		{
					   if (e.getClickCount() == 2)
					   {
						   //int col = resulttable.getModel().getColumnCount();
						   int row = resulttable.getSelectedRow();
						   System.out.println("row:"+(row+1));
						   
						   int bookid =Integer.valueOf(resulttable.getModel().getValueAt(row, 0).toString());
						   String name =resulttable.getModel().getValueAt(row, 1).toString();
						   String author =resulttable.getModel().getValueAt(row, 2).toString();
						   float price =Float.valueOf(resulttable.getModel().getValueAt(row, 3).toString());
						   String category =resulttable.getModel().getValueAt(row, 4).toString();
						   String remark;
						   if(resulttable.getModel().getValueAt(row, 5)!=null)
						   {
							   remark =resulttable.getModel().getValueAt(row, 5).toString();
						   }
						   else
						   {
							   remark = "（空）";
						   }
						 //  String bookinof = resulttable.getModel().getValueAt(row, 6).toString();
						   String bookinfo =booklist.get(row).bookinfo;
						   Bookinfo info = new Bookinfo(bookid,name,author,price,category,remark,bookinfo);
						   info.setVisible(true);
					   }
			   		}
			   }
		});
		
		
		
		
	}
}
