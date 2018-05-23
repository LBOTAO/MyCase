package cn.happy.entity;

/**
 * 品牌套餐类
 * 
 * @author liutao
 * @data 2018年5月23日 上午10:34:39
 */
public abstract class ServicePackage {

	// 月资费
	private double price;

	public abstract void showInfo();

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	

	/**
	 * 
	 */
	public ServicePackage() {
		super();
	}

	/**
	 * @param price
	 */
	public ServicePackage(double price) {
		super();
		this.price = price;
	}

}
