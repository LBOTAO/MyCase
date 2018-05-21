package cn.happy.day07.demo5;

/**
 * @author liutao
 * @data 2018年5月18日 下午2:37:59
 */
public class Movie {
	
	private String name;
	private String info;
	private boolean flag=true;  //设置标志位  控制生产者生产 消费者消费
	public String getName() {
		return name;
	}
	
	public String getInfo() {
		return info;
	}
	
	
	public synchronized void set(String name,String info){
		if (!flag) {
			try {
				super.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.name=name;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.info=info;
		flag=false;  //重置标志位  让消费者消费
		super.notify();    //唤醒
	}
	public synchronized void get(){
		if (flag) {
			try {
				super.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(this.getName()+"-"+this.getInfo());
		flag=true;
		super.notify();
	}
	
	
	

}
