package cn.happy.day06.demo1custom;


/**
 * @author liutao
 * @data 2018年5月13日 上午9:44:21
 */
public class MyArrayList {
	public static void main(String[] args) {
		YourArrayList<Person> list=new YourArrayList<>();
		Person p1=new Person("小明", "男");
		Person p2=new Person("小弘", "女");
		Person p3=new Person("小张", "男");
		
		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		for (Person person : list) {
			
			System.out.println(person.getName());
		}
		
		System.out.println("=====================");
		System.out.println(list.get(2).getName());
	}
 
}
