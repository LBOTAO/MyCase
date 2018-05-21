package cn.happy.day07.demo4printer;

/**
 * @author liutao
 * @data 2018年5月18日 下午12:01:03
 */
public class MyMain {
	public static void main(String[] args) {
		Printer printer=new Printer();
		MyThread t1=new MyThread();
		t1.printer=printer;
		t1.start();
		
		MyThreadTwo t2=new MyThreadTwo();
		t2.printer=printer;
		t2.start();
		
		
	}

}
