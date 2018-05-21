package cn.happy.day07.demo6shangji;

/**
 * 上机三  使用多线程模拟多人徒步爬山
 * @author liutao
 * @data 2018年5月18日 下午3:26:31
 */
public class ClimbThread extends Thread{
	private int time;  //爬100米 的时间
	private int num;    //爬多少个100米
	/**
	 * @param time
	 * @param num
	 */
	public ClimbThread(String name,int time,int kilometer) {
		super(name);
		this.time = time;
		this.num = kilometer*1000/100;  //将千米数转换为多少个100米
	}
	
	public void run(){
		while (num>0) {
			try {
				Thread.sleep(this.time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"爬完100米");
			num--;
		}
		System.out.println(Thread.currentThread().getName()+"到达终点");
	}
	
	
	public static void main(String[] args) {
		//两人爬山 均为1千米 速度不同
		ClimbThread youngMan=new ClimbThread("明", 500, 1);
		ClimbThread oldMan=new ClimbThread("天", 1500, 1);
		
		System.out.println("-----------开始爬山---------------");
		youngMan.start();
		oldMan.start();
		
		
		
		
		
		
		
		
		
	}

}
