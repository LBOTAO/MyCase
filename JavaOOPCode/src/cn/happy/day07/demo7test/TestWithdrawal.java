package cn.happy.day07.demo7test;

public class TestWithdrawal {
	public static void main(String[] args) {
		// 创建两个线程
		TestAccount r = new TestAccount();
		Thread one = new Thread(r);
		Thread two = new Thread(r);
		one.setName("张三");
		two.setName("张三的妻子");
		// 启动线程
		one.start();
		two.start();
	}
}