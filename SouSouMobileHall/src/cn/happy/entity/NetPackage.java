package cn.happy.entity;

import cn.happy.service.NetService;

/**
 * 网虫套餐类
 * 
 * @author liutao
 * @data 2018年5月23日 上午10:27:49
 */
public class NetPackage extends ServicePackage implements NetService {

	/**
	 * 上网流量
	 */
	private int flow;
	/**
	 * 套餐月资费
	 */
	private double price;

	/**
	 * 封装属性 无参带参方法
	 * 
	 * @return
	 */

	public int getFlow() {
		return flow;
	}

	public void setFlow(int flow) {
		this.flow = flow;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * 
	 */
	public NetPackage() {
		super();
	}

	/**
	 * @param flow
	 * @param price
	 */
	public NetPackage(int flow, double price) {
		super();
		this.flow = flow;
		this.price = price;
	}

	/**
	 * 返回上网信息
	 */
	@Override
	public void showInfo() {

	}

	@Override
	public int netPlay(int flow, MobileCard card) {

		return 0;
	}

}
