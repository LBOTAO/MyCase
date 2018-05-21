package cn.happy.day04.demo01;

/**
 * 锁
 * @author liutao
 * @data 2018年5月7日 上午11:15:44
 */
public interface Lock {
	/**
	 * 接口里的方法都是抽象方法 
	 * 接口里的变量都是静态常量 
	 */
	
	/**
	 * 开锁
	 */
	public abstract void openLock();
	
	/**
	 * 关锁
	 */
	public abstract void closeLock();

	

}
