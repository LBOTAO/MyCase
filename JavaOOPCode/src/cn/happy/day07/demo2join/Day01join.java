package cn.happy.day07.demo2join;

/**
 * 线程的礼让
 * @author liutao
 * @data 2018年5月18日 上午11:10:47
 */
public class Day01join {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 1; i <= 50; i++) {
					Thread.currentThread().setName("A1");
					System.out.println(Thread.currentThread().getName() + "\t\t" + i);
				}

			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 1; i <= 50; i++) {
					Thread.currentThread().setName("A2");
					System.out.println(Thread.currentThread().getName() + "\t\t" + i);
					if (i==3) {
						try {
							t1.join();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		});

		t1.start();
		t2.start();
	}

}
