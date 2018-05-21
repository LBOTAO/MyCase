package cn.happy.day07.demo1sleep;

/**
 * @author liutao
 * @data 2018年5月18日 上午11:08:03
 */
public class MyMain {
	
	public static void main(String[] args) {
		Runnable d1=new Day01();
		Thread t1=new Thread(d1);
		
		Day02 d2=new Day02();
		
		t1.start();
		d2.start();
	}

}
