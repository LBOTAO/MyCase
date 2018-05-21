package cn.happy.day04.demo01;

/**
 * @author liutao
 * @data 2018年5月7日 上午11:22:26
 */
public class MyMain {
	/**
	 * 接口
	 * @param args
	 */

	public static void main(String[] args) {
		
		SecurityDoor door=new SecurityDoor();
		
		door.openDoor();
		
		door.closeDoor();
		
		door.bell();
		
		door.openLock();

		door.closeLock();
		
		
	}

}
