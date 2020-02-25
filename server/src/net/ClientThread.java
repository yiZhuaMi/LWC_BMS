package net;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Vector;

import model.Book;
import operator.Operator;
import operator.Record;

public class ClientThread extends Thread{
	
	public Socket tcpConnection;
	
	byte[] buffer = new byte[256]; 
	private Vector<Book> booklist=new Vector<Book>();

	public ClientThread(Socket tcpConnection) {

		
		this.tcpConnection = tcpConnection;
			
	
	}
	public Socket getTcpConnection() {
		return tcpConnection;
	}

	public void setTcpConnection(Socket tcpConnection) {
		this.tcpConnection = tcpConnection;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void run()
	{
		
		try{
			InputStream in = null;
			OutputStream out = null;
			in = tcpConnection.getInputStream();
			out = tcpConnection.getOutputStream();
			ObjectOutputStream os = null;  		
			while(true)
			{
				int count = in.read(buffer);
				String keywords = null;
	
		        keywords = new String(buffer,0,count);
		        
		        System.out.println("keyword:"+keywords);
	             
	            String[] temp = new String[6];
	            
	            temp = keywords.split(",");
	            
	            switch(temp[0])
	            {
	            	case "add":System.out.println("Operation:"+temp[0]+"    Bookname:"+temp[1]+"    Author:"+temp[2]+"    Price:"+temp[3]+"    Category:"+temp[4]+"    Remark:"+temp[5]+"    bookinof:"+temp[6]);break;
	            	
	            	case"delete":System.out.println("Operation:"+temp[0]+"    Value:"+temp[1]+"    Col:"+temp[2]+"    Bookid:"+temp[3]);break;
	            	
	            	case"modify":System.out.println("Operation:"+temp[0]+"    NewValue:"+temp[1]+"    Col:"+temp[2]+"    Bookid:"+temp[3]);break;
	            	
	            	case"search":System.out.println("Operation:"+temp[0]+"    keyword:"+temp[1]);break;
	            	
	            	case"refresh":System.out.println("Operation:"+temp[0]+"    keyword:"+temp[1]);break;
	            }
	            
//	            if(temp[0].equals("add"))
//	            {
//	            	System.out.println("����:"+temp[0]+"    bookname:"+temp[1]+"    author:"+temp[2]+"    price:"+temp[3]+"    category:"+temp[4]+"    remark:"+temp[5]);
//	            }
//	            else
//	            {
//	            	System.out.println("����:"+temp[0]+"    value:"+temp[1]+"    col:"+temp[2]+"    bookid:"+temp[3]);
//	            }
	            
	            Record record = new Record();
	            record.writeToTxt(temp,tcpConnection);
	            
	            switch(temp[0])
	            {
		            case "add":	  Operator add = new Operator();
		            			  add.add(temp[1],temp[2],Float.valueOf(temp[3]),temp[4],temp[5],temp[6]);
		            			  break;
		            case "delete":Operator delete = new Operator();
		            			  delete.delete(Integer.valueOf(temp[3]),Integer.valueOf(temp[2]));
		            			  break;
		            case "modify":Operator modify = new Operator();
		            			  booklist = modify.modify(Integer.valueOf(temp[2]),(Object)temp[1],Integer.valueOf(temp[3]));
		            			  break;
		            case "search":Operator search = new Operator();
		            			  booklist = search.search(temp[1]);
		            			  break;
	            }
	            
	            
				 
	            os = new ObjectOutputStream(tcpConnection.getOutputStream());  
		        os.writeObject(booklist);  
		        os.flush(); 
		
	//	        if(in!=null)in.close();
	//			if(out!=null)out.close();
	//			//if(tcpConnection!=null)tcpConnection.close();
	//			if(os!=null)os.close();
	//			System.out.println("��F�����ѹر�");
			}
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
//		finally
//		{
//			try {
//					if(in!=null)in.close();
//					if(out!=null)out.close();
//					//if(tcpConnection!=null)tcpConnection.close();
//					if(os!=null)os.close();
//					System.out.println("��F�����ѹر�");
//			   
//			
//				} catch (IOException e) {	
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
