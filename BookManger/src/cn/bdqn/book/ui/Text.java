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
 * ͼ�����
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
			System.out.println("��ѡ��1.�鿴\t2.����\t3.ɾ��\t4.�˳�");
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
				System.out.println("��ӭ�ٴ�ʹ�ã�");
				is = false;
				break;
			default:
				System.out.println("ѡ��������������룺");
				break;
			}
		} while (is);
		
	}
	
	/**
	 * �鿴����ͼ��
	 */
	public static void selectBook(){
		List<BookManage> list = biz.getAllManagers();
		System.out.println("�鿴ͼ��");
		System.out.println("ͼ����\t\tͼ������\t\tͼ������\t\t����ʱ��\t\tͼ�����");
		for (BookManage bookManage : list) {
			System.out.println(bookManage.getB_Id()+"\t\t"+bookManage.getB_name()+"\t\t"+bookManage.getB_author()+"\t\t"+bookManage.getB_time()+"\t"+bookManage.getB_type());
		}
	}
	
	/**
	 * ���ͼ����Ϣ
	 */
	public static void addBook(){
		BookManage bookmanage = new BookManage();
		System.out.println("������ͼ���ţ�");
		bookmanage.setB_Id(input.nextInt());
		System.out.println("������ͼ�����ƣ�");
		bookmanage.setB_name(input.next());
		System.out.println("������ͼ�����ߣ�");
		bookmanage.setB_author(input.next());
		System.out.println("�����빺�����ڣ�");	
		try {
			String time = input.next();
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    //����һ���������ڵ��ַ����������ظ�������1970��1��1����ҹ֮��������ĺ�������
			Date date = sdf.parse(time);
			//Calendar��������      new һ��Ҫ����һ���¶��󣬷����ڴ棻getInstance������һ��Ҫ�ٴδ����������԰�һ���Ѵ��ڵ����ø���ʹ�ã�����Ч��������new��
			Calendar calender = Calendar.getInstance();
			// ��������������ʱ��Ϊ���������� Date.
			calender.setTime(date);
			//SimpleDateFormat��formatת����ֵ��times
			String times = sdf.format(date);
			//System.out.println(times);
			bookmanage.setB_time(date);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("������ͼ����ࣺ");
		bookmanage.setB_type(input.next());
		boolean addBook = biz.addBookManage(bookmanage);
		if(addBook){
			System.out.println("��ӳɹ���");
		}else{
			System.out.println("���ʧ�ܣ�����");
		}
	}
	
	/**
	 * ɾ��ͼ��
	 */
	public static void deleteBook(){
		System.out.println("������Ҫɾ��ͼ��ı�ţ�");
		int number = input.nextInt();
		boolean delete = biz.deleteBookManage(number);
		if(delete){
			System.out.println("�ɹ�ɾ��ͼ�飡");
		}else{
			System.out.println("ɾ��ͼ��ʧ�ܣ�����");
		}
	}
}
