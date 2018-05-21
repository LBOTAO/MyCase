package cn.happy.day07.demo6shangji;

/**
 * 显示 设置线程优先级
 * 
 * @author liutao
 * @data 2018年5月18日 下午3:38:46
 */
public class PriorityDemo implements Runnable {
	@Override
	public void run() {

		System.out.println("子线程名：" + Thread.currentThread().getName() + "优先级：" + Thread.currentThread().getPriority());

	}

	public static void main(String[] args) {

		System.out.println("主线程名：" + Thread.currentThread().getName() + "优先级：" + Thread.currentThread().getPriority());
		PriorityDemo p1 = new PriorityDemo();
		Thread t1 = new Thread(p1);
		System.out.println("子线程名：" + t1.getName() + "优先级：" + t1.getPriority());
		System.out.println("----修改后-----");

		t1.setPriority(1);
		Thread.currentThread().setPriority(10);
		System.out.println("子线程名：" + Thread.currentThread().getName()+ "优先级：" + Thread.currentThread().getPriority());
		t1.start();
	}
}
