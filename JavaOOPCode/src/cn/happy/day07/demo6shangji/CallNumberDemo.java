package cn.happy.day07.demo6shangji;

/**
 * 模拟叫号看病
 * @author liutao
 * @data 2018年5月18日 下午4:23:51
 */
public class CallNumberDemo{
	
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 1; i <= 10; i++) {
					
					System.out.println("特需号：" + i + "号病人在看病！");
				}

			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 1; i <= 50; i++) {
					System.out.println("普通号：" + i + "号病人在看病！");
					t1.setPriority(10);
					try {
						t1.sleep(2000);
						
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (i==10) {
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
