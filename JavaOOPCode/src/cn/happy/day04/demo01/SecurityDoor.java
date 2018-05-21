package cn.happy.day04.demo01;

/**
 * 
 * 
 * 防盗门
 * @author liutao
 * @data 2018年5月7日 上午11:18:22
 */
public class SecurityDoor extends Door implements Lock,DoorBell{

	@Override
	public void openLock() {
		System.out.println("开锁了");
		
	}

	@Override
	public void closeLock() {
		System.out.println("上锁了");
	}

	@Override
	public void openDoor() {
		System.out.println("开门啦");
	}

	@Override
	public void closeDoor() {
		System.out.println("关门啦");
	}

	@Override
	public void bell() {
		System.out.println("按门铃");
	}
	
	

}
