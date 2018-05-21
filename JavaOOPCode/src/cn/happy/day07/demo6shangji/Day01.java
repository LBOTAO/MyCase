package cn.happy.day07.demo6shangji;

/**
 * 上机一    使用继承Thread实现多线程
 * @author liutao
 * @data 2018年5月18日 下午2:58:31
 */
public class Day01 extends Thread{

	@Override
	public void run() {
		for (int i = 1; i <=20; i++) {
			System.out.println(i+".你好，来自线程"+Thread.currentThread().getName());
		}
	}
	
	public static void main(String[] args) {
		Day01 d1=new Day01();
		Day01 d2=new Day01();
		d1.start();
		d2.start();
	}
	

}
