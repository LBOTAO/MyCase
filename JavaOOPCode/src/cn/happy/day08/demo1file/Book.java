package cn.happy.day08.demo1file;

import java.io.Serializable;

/**
 * @author liutao
 * @data 2018年5月21日 上午11:35:42
 */
public class Book implements Serializable{
	
	private String bookname;
	private Integer bookprice;
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public Integer getBookprice() {
		return bookprice;
	}
	public void setBookprice(Integer bookprice) {
		this.bookprice = bookprice;
	}
	
	

}
