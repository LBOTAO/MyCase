package cn.happy.entity;

import java.io.Serializable;

import cn.happy.service.NetService;

/**
 * 网虫套餐类
 * 
 * @author liutao
 * @data 2018年5月23日 上午10:27:49
 */
public class NetPackage extends ServicePackage implements NetService,Serializable {
	/**
	 * 上网流量
	 */
	private int flow;
	/**
	 * 套餐月资费
	 */
	private double price;

	/**
	 * 封装属性 无参方法
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

	public NetPackage() {
		this.flow = 3;
		this.price = 68;
	}

	/**
	 * 返回上网信息
	 */
	@Override
	public void showInfo() {
		System.out.println("网虫套餐：上网流量为：" + this.getFlow() + "GB/月," + "资费为：" + this.getPrice() + "元/月");
	}

	@Override
	public int netPlay(int flow, MobileCard card) throws Exception {

		int temp = flow;
		for (int i = 0; i < flow; i++) {
			if (this.flow - card.getRealFlow() >= 1) {
				// 第一种情况：流量剩余够 1 MB
				card.setRealFlow(card.getRealFlow() + 1);
			} else if (card.getMoney() >= 0.1) {
				// 第二种情况：套餐内流量已经用完，剩下话费够支付 1 MB的流量
				card.setRealFlow(card.getRealFlow() + 1); // 实际短信数加 1 条
				// 账户余额消费0.1元，（1MB流量）
				card.setMoney(card.getMoney() - 0.1);
				card.setConsumAmout(card.getConsumAmout() + 0.1); // 当月消费金额 +
																	// 0.1
			} else {
				temp = i; // 记录使用流量多少MB
				throw new Exception("流量已经使用" + i + "MB，您的余额不足，请充值后再使用！");
			}
		}
		return temp;
	}

}
