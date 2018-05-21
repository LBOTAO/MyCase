package cn.happy.day06.demo3;

/**
 * @author liutao
 * @data 2018年5月13日 下午7:34:25
 */
public class MyMain {

	public static void main(String[] args) {
	   // String s1 = "小黑";
		//String s2 = "小黑";
	    
		String s1=new String("小黑");
	    String s2=new String("小黑");
		
		if (s1==s2) {   //内存地址
			System.out.println("==  true");
		}
		
		if (s1.equals(s2)) {   //值
			System.out.println("equals  true");
		}
		
		/*Set<Dog> set=new HashSet<>();
		Dog d1=new Dog();
		d1.setName("小王");
		d1.setAge(16);
		
		Dog d2=new Dog();
		d2.setName("小啦");
		d2.setAge(16);
		
		set.add(d1);
		set.add(d2);
		
		System.out.println(set.size());
		*/
	}

}
