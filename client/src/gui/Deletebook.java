package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import model.Book;
import net.Client;
import net.Package;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Deletebook extends JFrame {

	private JPanel contentPane;
	private JTable booktable;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JTextField textField;
	private Vector<Book> booklist=new Vector<Book>();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deletebook frame = new Deletebook();
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
	public Deletebook() {
		setTitle("删除图书");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel KWLabel = new JLabel("请输入关键字");
		KWLabel.setBounds(34, 24, 108, 18);
		KWLabel.setFont(new Font("微软雅黑",0,15));
		contentPane.add(KWLabel);
		
		textField = new JTextField();
		textField.setBounds(135, 22, 281, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel tips = new JLabel("单击选择需要删除的项目");
		tips.setFont(new Font("微软雅黑",0,12));
		tips.setForeground(Color.gray);
		tips.setBounds(14, 309, 210, 18);
		contentPane.add(tips);
		
		JButton button = new JButton("返回");
		button.setBounds(414, 305, 79, 27);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				AdmInterface jiemian = new AdmInterface();
				jiemian.setVisible(true);
				Deletebook.this.setVisible(false);
			}
		});
		
		
		JScrollPane js = new JScrollPane();
		js.setBounds(14, 59, 479, 242);
		contentPane.add(js);
		
		String[] headers = {"图书编号","图书名称", "图书作者","图书价格", "图书分类","备注"};
		Object[][] cellData =null;
		@SuppressWarnings("serial")
		final DefaultTableModel model = new DefaultTableModel(cellData, headers) {
		  public boolean isCellEditable(int row, int column) 
		  {
			  return false;
		  }
		};
		
        
		booktable = new JTable(model);
		booktable.setBounds(14, 59, 479, 242);
		//booklist.setRowHeight(2, 200);
		booktable.setRowHeight(20);
		js.setViewportView(booktable);
		model.setColumnCount(6);
		model.setRowCount(0);
		
		RowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);  
		booktable.setRowSorter(sorter);  
		
		JButton searchButton = new JButton("搜索");
		searchButton.setBounds(430, 21, 63, 27);
		contentPane.add(searchButton);
		searchButton.addActionListener(new ActionListener()
		{
				public void actionPerformed(ActionEvent arg0)
			{
				model.setRowCount(0);
				System.out.println("开始查询");
				Package pk = new Package();
				booklist = pk.packaging("search", textField.getText());
				
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
		
		
		JButton refresh = new JButton("刷新");
		refresh.setBounds(228, 305, 79, 27);
		contentPane.add(refresh);
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				model.setRowCount(0);
				System.out.println("开始刷新");
				Package pk = new Package();
				booklist = pk.packaging("refresh", textField.getText());
				
				if(booklist==null){JOptionPane.showMessageDialog(null, "墨子都没有刷新到~");}
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
					System.out.println("刷新成功！");

				}
			}
		});
		
		btnNewButton = new JButton("删除");
		btnNewButton.setBounds(321, 305, 79, 27);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				final int row=booktable.getSelectedRow();
				final int col=booktable.getSelectedColumn()+1;
				if(col==2||col==3||col==4||col==5){JOptionPane.showMessageDialog(null, "禁止删除");}
				else
				{
					int res = JOptionPane.showConfirmDialog(null,"确认删除？","⚠️警告️",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					if(res==JOptionPane.YES_OPTION)
					{
						System.out.println("开始删除！");
						final int bookorder = Integer.parseInt(String.valueOf(booktable.getValueAt(row,0)));
						System.out.println("ָ删除所在行"+row);
						System.out.println("ָ删除所在列"+col);
						System.out.println("删除所在的编号"+bookorder);
						System.out.println("删除的值"+booktable.getValueAt(row,col-1));
						try
						{
							Package pk = new Package();
							pk.packaging("delete", booktable.getValueAt(row, col).toString(),String.valueOf(col),String.valueOf(bookorder));
							
							JOptionPane.showMessageDialog(null, "删除成功！");
						}
						catch(Exception f) 
						{
							f.printStackTrace();
							JOptionPane.showMessageDialog(null, "删除失败！");
						}
						
					}
					else if(res==JOptionPane.NO_OPTION)
					{
						System.out.println("取消了删除！");
					}
					else if(res==JOptionPane.CLOSED_OPTION)
					{    
						System.out.println ("关闭了删除！");
					}	
						
				}
				
			}
		});
		
		
		
	
	
	
		
		
		
	}
}
