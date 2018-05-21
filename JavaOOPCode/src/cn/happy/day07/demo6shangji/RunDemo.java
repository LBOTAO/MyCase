package cn.happy.day07.demo6shangji;

/**
 * 接力
 * @author liutao
 * @data 2018年5月18日 下午4:46:05
 */
public class RunDemo implements Runnable {

	private int meters =1000;  //共跑了1000米
	@Override
	public void run() {
	
		while (true) {
			synchronized (this) {
				if (meters<=100) {
					break;
				}
				System.out.println(Thread.currentThread().getName()+"拿到接力棒！");
				for (int i = 0; i < 100; i+=10) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+"跑了"+(i+10)+"米！");
				}
				meters-=100;
			}
		}
		
	}
	
	public static void main(String[] args) {
		RunDemo r1=new RunDemo();
		for (int i = 0; i <5; i++) {
			new Thread(r1,(i+1)+"号选手").start();;
		}
	}
	
	

}
