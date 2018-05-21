package cn.happy.day06.demo2;

import java.util.LinkedList;

/**
 * @author liutao
 * @data 2018年5月13日 下午4:42:28
 */
public class LinkedListDemo {
	/**
	 * linkedlist
	 * @param args
	 */

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();

		list.add("小红");
		list.add("校长");
		System.out.println("======华丽分割线========");
		for (String item : list) {
			System.out.println(item);
		}
		list.addFirst("lala");
		list.addLast("enen");
		System.out.println("======华丽分割线========");
		System.out.println("======华丽分割线========");
		for (String item : list) {
			System.out.println(item);
		}
		
		String first = list.getFirst();
		System.out.println("======华丽分割线getFirst========");
		System.out.println(first);
		
		String last = list.removeLast();
		System.out.println("======华丽分割线removelast========");
		for (String item : list) {
			System.out.println(item);
		}
	}

}
