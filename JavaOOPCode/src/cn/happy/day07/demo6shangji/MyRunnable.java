package cn.happy.day07.demo6shangji;

/**
 * 上机二  使用实现Runnable实现多线程
 * @author liutao
 * @data 2018年5月18日 下午3:21:55
 */
public class MyRunnable implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i <=20; i++) {
			System.out.println(i+".你好，来自线程"+Thread.currentThread().getName());
		}
	}
	
	public static void main(String[] args) {
		Runnable r1=new MyRunnable();
		Thread t1=new Thread(r1);
		
		Runnable r2=new MyRunnable();
		Thread t2=new Thread(r2);
		
		t1.start();
		t2.start();
	}

}
