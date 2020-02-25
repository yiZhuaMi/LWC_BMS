package operator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JOptionPane;
//import com.wy.DBConnection;
import database.DBConnection;

import model.Book;
import net.Server;

public class Operator<booklist> 
{

	private Vector<Book> booklist=new Vector<Book>();
	
	public Operator() 
	{
		
	}

	public static void main(String[] args) 
	{
		
	}

	public boolean add(String bookname,String author,float price,String category,String remark,String bookinfo)
	{
		Connection conn = DBConnection.getConnection();
		Statement s=null;
		try
		{
			s = conn.createStatement();
			String sql =null;
			sql = "insert into booktable values('"+bookname+"','"+author+"','"+price+"','"+category+"','"+remark+"','"+bookinfo+"')";
			s.executeUpdate(sql);
			System.out.println("添加成功!");
			DBConnection.closeConnection( s, conn);
			
		 } 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	
		
	}

	public void delete(int bookorder,int col)
	{
		Connection conn = DBConnection.getConnection();
		Statement s=null;
		try 
		{
			s = conn.createStatement();
			String sql =null;
			
			switch(col)
			{
				case 1:sql = "delete from booktable where bookid ="+ bookorder+"";break;
				
				case 3:sql = "update booktable set author = null where bookid = "+ bookorder+"";break;
				
				case 4:sql = "update booktable set price = null where bookid ="+ bookorder+"";break;
				
				case 5:sql = "update booktable set category = null where bookid ="+ bookorder+"";break;
				
				case 6:sql = "update booktable set remark = null where bookid ="+ bookorder+"";break;
			}
			
			s.executeUpdate(sql);
			System.out.println("修改成功!");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			
		}
		
		DBConnection.closeConnection( s, conn);
		
		
	}

	public Vector<Book> modify(int col,Object newvalue,int bookorder)
	{
		Connection conn = DBConnection.getConnection();
		Statement s=null;
		System.out.println("开始修改!");
		System.out.println("所在行："+col);
		System.out.println("新值："+newvalue);
		System.out.println("id："+bookorder);
		try 
		{
			s = conn.createStatement();
			String sql =null;
			switch(col)
			{
				case 2 :sql = "update booktable set bookname = '"+newvalue+"'where bookid = "+bookorder+"";break;
			
				case 3 :sql = "update booktable set author = '"+newvalue+"'where bookid = "+bookorder+"";break;
					
				case 4 :sql = "update booktable set price = '"+newvalue+"'where bookid = "+bookorder+"";break;	
				
				case 5 :sql = "update booktable set category = '"+newvalue+"'where bookid = "+bookorder+"";break;	
				
				case 6 :sql = "update booktable set remark = '"+newvalue+"'where bookid = "+bookorder+"";break;	
			
				//default : JOptionPane.showMessageDialog(null, "��ֵ�Ƿ���");break;
			}
			
			
			s.executeUpdate(sql);
			System.out.println("修改成功!");
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DBConnection.closeConnection( s, conn);
		return booklist;
		
	}

	int count;

	public Vector<Book> search(String keywords)
	{
		
		Connection conn = DBConnection.getConnection();
		Vector<Book> empty = null;
		try 
		{
		
			Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			String sql =null;
			if(!keywords.equals("'empty'"))
			{
				sql = "select * from booktable where bookname like'%"+keywords+"%' or price like'%"+keywords+"%' or author like'%"+keywords+"%' or category like'%"+keywords+"%'  or remark like'%"+keywords+"%' or bookinfo like'%"+keywords+"%'";
			}
			else
			{
				sql = "select * from booktable ";
			}
			
			ResultSet rs1 = s.executeQuery(sql);
			rs1.last();
			count = rs1.getRow();
			ResultSet rs = s.executeQuery(sql);
			
			if(rs.next())
			{	
				Book book = new Book(Integer.parseInt(rs.getString(1)),rs.getString(2),rs.getString(3),Float.valueOf(rs.getString(4)),rs.getString(5),rs.getString(6),rs.getString(7));
				getBooklist().add(book);
				try 
				{
					while(rs.next())
					{	
						Book book1 = new Book(Integer.parseInt(rs.getString(1)),rs.getString(2),rs.getString(3),Float.valueOf(rs.getString(4)),rs.getString(5),rs.getString(6),rs.getString(7));
						getBooklist().add(book1);
				    }
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
				
				DBConnection.closeConnection(rs, s, conn);
				
				//return true;
			}
			else
			{
				System.out.println("什么也没有找到。。。");

				DBConnection.closeConnection(rs, s, conn);
				
				return empty;
			}
			
			System.out.println("booklist已返回");
			
			return booklist;
			
		} 
		catch (SQLException e)
		{
			
			 e.printStackTrace();
			 
			 return empty;
		}
		
		
	}
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}


	public static boolean add() {
		// TODO Auto-generated method stub
		return false;
	}

	public Vector<Book> getBooklist() {
		return booklist;
	}

	public void setBooklist(Vector<Book> booklist) {
		this.booklist = booklist;
	}
}
