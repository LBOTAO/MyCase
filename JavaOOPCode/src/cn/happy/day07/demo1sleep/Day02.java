package cn.happy.day07.demo1sleep;

/**
 * @author liutao
 * @data 2018年5月18日 上午11:06:48
 */
public class Day02 extends Thread{

	@Override
	public void run() {
		for (int i = 1; i <=3; i++) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"\t\t"+i);
		}
		
	}

	
}
