package cn.happy.day07.demo8callable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author liutao
 * @data 2018年5月20日 下午4:03:19
 */
public class CallableTest implements Callable<Integer> {

	/**
	 * 1. 创建 Callable 接口的实现类，并实现 call() 方法，该 call() 方法将作为线程执行体，并且有返回值。
	 * 2. 创建 Callable 实现类的实例，使用 FutureTask 类来包装 Callable 对象，该 FutureTask 对象封装了该 Callable 对象的 call() 方法的返回值。
	 * 3. 使用 FutureTask 对象作为 Thread 对象的 target创建并启动新线程。
	 * 4. 调用 FutureTask 对象的 get() 方法来获得子线程执行结束后的返回值。
	 */
	
	@Override
	public Integer call() throws Exception {
		int i=0;
		for (; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+"------"+i);
		}
		return i;
	}
	
	public static void main(String[] args) {
		CallableTest c1=new CallableTest();
		FutureTask<Integer> ft1=new FutureTask<>(c1);
		
		FutureTask<Integer> ft2=new FutureTask<>(c1);
		Thread t1=new Thread(ft1);
		Thread t2=new Thread(ft2);
		
		t1.start();
		t2.start();
	}

}
