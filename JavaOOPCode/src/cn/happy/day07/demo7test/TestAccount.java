package cn.happy.day07.demo7test;

//取款的线程类
public class TestAccount implements Runnable {
	// 所有用TestAccount对象创建的线程共享同一个账户对象
	private Account acct = new Account();

	public void run() {
		for (int i = 0; i < 5; i++) {
			makeWithdrawal(100); // 取款
			if (acct.getBalance() < 0) {
				System.out.println("账户透支了!");
			}
		}
	}

	private synchronized void makeWithdrawal(int amt) {
		if (acct.getBalance() >= amt) {
			System.out.println(Thread.currentThread().getName() + " 准备取款");
			try {
				Thread.sleep(500); // 0.5秒后实现取款
			} catch (InterruptedException ex) {
			}
			// 如果余额足够，则取款
			acct.withdraw(amt);
			System.out.println(Thread.currentThread().getName() + " 完成取款");
		} else {
			// 余额不足给出提示
			System.out.println("余额不足以支付" + Thread.currentThread().getName() + " 的取款，余额为 " + acct.getBalance());
		}
	}
}
