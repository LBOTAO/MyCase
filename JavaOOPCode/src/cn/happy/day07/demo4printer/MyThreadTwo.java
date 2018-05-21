package cn.happy.day07.demo4printer;

/**
 * @author liutao
 * @data 2018年5月18日 下午12:04:03
 */
public class MyThreadTwo extends Thread{

	Printer printer;
	@Override
	public void run() {
		printer.p2();
	}
	
	

}
