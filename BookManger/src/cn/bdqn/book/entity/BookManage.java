package cn.bdqn.book.entity;

import java.util.Date;

public class BookManage {
	private int b_Id;
	private String b_name;
	private String b_author;
	private Date b_time;
	private String b_type;
	public int getB_Id() {
		return b_Id;
	}
	public void setB_Id(int b_Id) {
		this.b_Id = b_Id;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getB_author() {
		return b_author;
	}
	public void setB_author(String b_author) {
		this.b_author = b_author;
	}
	public Date getB_time() {
		return b_time;
	}
	public void setB_time(Date b_time) {
		this.b_time = b_time;
	}
	public String getB_type() {
		return b_type;
	}
	public void setB_type(String b_type) {
		this.b_type = b_type;
	}
	
	
}
