package cn.happy.day08.demo1file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 序列化和反序列化
 * @author liutao
 * @data 2018年5月21日 上午11:31:13
 */
public class Day04 {
	
	public static void main(String[] args) throws Exception {
		
		InputStream is=new FileInputStream("save.bin");
		ObjectInputStream ois=new ObjectInputStream(is);
		
		List<Book> list=(List<Book>)ois.readObject();
		
		for (Book book : list) {
			System.out.println(book.getBookname());
			System.out.println(book.getBookprice());
		}
		
		/*OutputStream os=new FileOutputStream("save.bin");
		ObjectOutputStream oos=new ObjectOutputStream(os);
		
		List<Book> list1=new ArrayList<>();
		
		Book book1=new Book();
		book1.setBookname("深入理解jvm");
		book1.setBookprice(58);
		
		Book book2=new Book();
		book2.setBookname("http详解");
		book2.setBookprice(58);
		
		list1.add(book1);
		list1.add(book2);
		
		oos.writeObject(list1);
		System.out.println("success");
		
		oos.close();
		os.close();*/
	}

}
