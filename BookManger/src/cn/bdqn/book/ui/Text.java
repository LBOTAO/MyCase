/**
 * 
 */
package cn.bdqn.book.ui;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import cn.bdqn.book.biz.BookManageBiz;
import cn.bdqn.book.biz.impl.BookManageBizImpl;
import cn.bdqn.book.entity.BookManage;

/**
 * 图书管理
 * @author Administrator
 *
 */
public class Text {
	
	static Scanner input = new Scanner(System.in);
	static BookManageBiz biz = new BookManageBizImpl();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean is = true;
		do {
			System.out.println("请选择：1.查看\t2.新增\t3.删除\t4.退出");
			int num = input.nextInt();
			switch (num) {
			case 1:
				selectBook();
				break;
			case 2:
				addBook();
				break;
			case 3:
				deleteBook();
				selectBook();
				break;
			case 4:
				System.out.println("欢迎再次使用！");
				is = false;
				break;
			default:
				System.out.println("选择有误，请从新输入：");
				break;
			}
		} while (is);
		
	}
	
	/**
	 * 查看所有图书
	 */
	public static void selectBook(){
		List<BookManage> list = biz.getAllManagers();
		System.out.println("查看图书");
		System.out.println("图书编号\t\t图书名称\t\t图书作者\t\t购买时间\t\t图书分类");
		for (BookManage bookManage : list) {
			System.out.println(bookManage.getB_Id()+"\t\t"+bookManage.getB_name()+"\t\t"+bookManage.getB_author()+"\t\t"+bookManage.getB_time()+"\t"+bookManage.getB_type());
		}
	}
	
	/**
	 * 添加图书信息
	 */
	public static void addBook(){
		BookManage bookmanage = new BookManage();
		System.out.println("请输入图书编号：");
		bookmanage.setB_Id(input.nextInt());
		System.out.println("请输入图书名称：");
		bookmanage.setB_name(input.next());
		System.out.println("请输入图书作者：");
		bookmanage.setB_author(input.next());
		System.out.println("请输入购买日期：");	
		try {
			String time = input.next();
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    //解析一个包含日期的字符串，并返回该日期与1970年1月1日午夜之间所间隔的毫秒数。
			Date date = sdf.parse(time);
			//Calendar日历对象      new 一定要生成一个新对象，分配内存；getInstance（）则不一定要再次创建，它可以把一个已存在的引用给你使用，这在效能上优于new；
			Calendar calender = Calendar.getInstance();
			// 方法设置日历的时间为给定的日期 Date.
			calender.setTime(date);
			//SimpleDateFormat的format转换赋值给times
			String times = sdf.format(date);
			//System.out.println(times);
			bookmanage.setB_time(date);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("请输入图书分类：");
		bookmanage.setB_type(input.next());
		boolean addBook = biz.addBookManage(bookmanage);
		if(addBook){
			System.out.println("添加成功！");
		}else{
			System.out.println("添加失败！！！");
		}
	}
	
	/**
	 * 删除图书
	 */
	public static void deleteBook(){
		System.out.println("请输入要删除图书的编号：");
		int number = input.nextInt();
		boolean delete = biz.deleteBookManage(number);
		if(delete){
			System.out.println("成功删除图书！");
		}else{
			System.out.println("删除图书失败！！！");
		}
	}
}
