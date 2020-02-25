package model;

import java.io.Serializable;

public class Book implements Serializable
{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int bookid;
	public String bookname;
	public String author;
	public Float price;
	public String category;
	public String remark;
	public String bookinfo;

	
	public Book(int bookid,String bookname,String author,Float price,String category,String Remark,String bookinfo) 
	{
		this.bookid=bookid;
		this.bookname=bookname;
		this.author=author;
		this.price=price;
		this.category=category;
		this.remark=Remark;
		this.bookinfo=bookinfo;
		
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
