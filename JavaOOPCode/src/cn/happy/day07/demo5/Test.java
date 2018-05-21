package cn.happy.day07.demo5;

/**
 * 生产者和消费者
 * @author liutao
 * @data 2018年5月18日 下午2:48:21
 */
public class Test {
	public static void main(String[] args) {
		Movie movie=new Movie();
		Thread producer=new Thread(new Producer(movie));
		Thread customer=new Thread(new Consumer(movie));
		
		producer.start();
		customer.start();
	}
}
