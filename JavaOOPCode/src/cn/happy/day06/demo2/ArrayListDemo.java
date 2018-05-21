package cn.happy.day06.demo2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liutao
 * @data 2018年5月13日 下午4:02:54
 */
public class ArrayListDemo {
	
	/**
	 * arraylist
	 * @param args
	 */
	
	public static void main(String[] args) {
		List<Person> list=new ArrayList<>();
		
		Person p1=new Person("张三", "男");
		Person p2=new Person("小黑", "女");
		
		list.add(p1);
		list.add(p2);
		
		for (Person item : list) {
			System.out.println("====="+item.getName());
		}
		
		int size = list.size();
		System.out.println("size:"+size);
		
		boolean flag = list.contains(p1);
		System.out.println(flag);
		
	}
	

}
