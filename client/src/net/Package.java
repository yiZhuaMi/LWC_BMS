package net;

import java.util.Vector;

import model.Book;

public class Package {
	private Vector<Book> booklist=new Vector<Book>();
	
	public Vector<Book> packaging(String action,String keyword)
	{
		String temp = null;
		if(action.equals("search"))
		{
			if(keyword.equals(""))
			{
				temp = "search,'empty'";
			}
			else
			{
				temp = "search,"+keyword;
			}
			
		}
		else 
		{
			if(keyword.equals(""))
			{
				temp = "refresh,'empty'";
			}
			else
			{
				temp = "refresh,"+keyword;
			}
		}
		
		Client client = new Client();
		
		booklist = client.client(temp);
		
		return booklist;
	}

	public void packaging(String action,String name,String author,String price,String category,String remark,String info)
	{
		String temp = "add,"+name+","
				+author+","
				+price+","
				+category+","
				+remark+","
				+info;
		
		Client client = new Client();
		
		client.client(temp);
	}
	
	public Vector<Book> packaging(String action,String value,String col,String order)
	{
		String IdColvalue;
		if(action.equals("modify"))
		{
			IdColvalue = "modify,"+value+","+col+","+order;
		}
		else
		{
			IdColvalue = "delete,"+value+","+col+","+order;
		}
		Client client = new Client();
		
		booklist = client.client(IdColvalue);
		
		return booklist;
	}

	
	public static void main(String[] args) {
	

	}

}
