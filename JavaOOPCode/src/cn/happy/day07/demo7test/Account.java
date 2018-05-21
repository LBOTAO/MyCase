package cn.happy.day07.demo7test;

//银行账户类
public class Account {
	private int balance = 500; // 余额

	public int getBalance() {
		return balance;
	}

	// 取款
	public void withdraw(int amount) {
		balance = balance - amount;
	}
}