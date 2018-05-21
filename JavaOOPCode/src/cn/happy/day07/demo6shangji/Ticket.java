package cn.happy.day07.demo6shangji;

/**
 * 出票
 * @author liutao
 * @data 2018年5月18日 下午4:58:35
 */
public class Ticket implements Runnable {
	private int num = 0; // 出票数
	private int count = 10; // 剩余票数
	boolean flag = false;

	@Override
	public void run() {
		while (true) {
			synchronized (this) {
				// 如果没有余票 跳出循环
				if (count <= 0) {
					break;
				}
				num++;
				count--;
				try {
					Thread.sleep(500); // 模拟网络延迟
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("出票信息：" + Thread.currentThread().getName() + "抢到第" + num + "张票,剩余" + count + "张票");
			}
		}
	}

	public static void main(String[] args) {
		Ticket ticket = new Ticket();
		// 实例化几个抢票用户
		Thread ming = new Thread(ticket, "小明");

		Thread liang = new Thread(ticket, "小亮");

		ming.start();

		liang.start();

	}

}
