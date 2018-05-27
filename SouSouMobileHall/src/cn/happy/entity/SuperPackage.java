package cn.happy.entity;

import cn.happy.service.CallService;
import cn.happy.service.NetService;
import cn.happy.service.SendService;

/**
 * 超人套餐类
 * 
 * @author liutao
 * @data 2018年5月23日 上午10:29:31
 */
public class SuperPackage extends ServicePackage implements CallService, SendService, NetService {

	// 通话时长
	private int talkTime;
	// 短信条数
	private int smsCount;
	// 上网流量
	private int flow;
	// 套餐月资费
	private double price;

	/**
	 * 封装属性 带参无参方法
	 * 
	 * @return
	 */

	public int getTalkTime() {
		return talkTime;
	}

	public void setTalkTime(int talkTime) {
		this.talkTime = talkTime;
	}

	public int getSmsCount() {
		return smsCount;
	}

	public void setSmsCount(int smsCount) {
		this.smsCount = smsCount;
	}

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

	public SuperPackage() {
		this.talkTime = 200;
		this.smsCount = 50;
		this.flow = 1;
		this.price = 78;
	}

	/**
	 * 输出超人套餐信息
	 */
	@Override
	public void showInfo() {
		System.out.println("超人套餐：通话时长为" + this.getTalkTime() + "分钟/月," + "短信条数为" + this.getSmsCount() + "条/月,上网流量为"
				+ this.getFlow() + "GB/月,资费" + this.getPrice() + "/月。");
	}

	/**
	 * 返回实际发送短信数
	 * 
	 * @throws Exception
	 */
	@Override
	public int send(int count, MobileCard card) throws Exception {
		int temp = count;
		for (int i = 0; i < count; i++) {
			if (this.smsCount - card.getRealSMSCount() >= 1) {
				// 第一种情况：套餐剩余短信数能够发送一个短信
				card.setRealSMSCount(card.getRealSMSCount() + 1);
			} else if (card.getMoney() >= 0.1) {
				// 第二种情况：套餐内短信已经用完，剩下话费能够允许发一条短信
				card.setRealSMSCount(card.getRealSMSCount() + 1); // 实际短信数加 1 条
				// 账户余额消费0.1元，（一条短信）
				card.setMoney(card.getMoney() - 0.1);
				card.setConsumAmout(card.getConsumAmout() + 0.1); // 当月消费金额 +
																	// 0.1
			} else {
				temp = i; // 记录发短信条数
				throw new Exception("短信已经发送" + i + "条，您的余额不足，请充值后再使用！");
			}
		}
		return temp;
	}

	/**
	 * 返回通话时长
	 * 
	 * @throws Exception
	 */
	@Override
	public int call(int mainCount, MobileCard card) throws Exception {
		int temp = mainCount;
		for (int i = 0; i < mainCount; i++) {
			if (this.talkTime - card.getRealTakTime() >= 1) {
				// 第一种情况：套餐剩余通话时长可以支持1分钟通话
				card.setRealTakTime(card.getRealTakTime() + 1);
			} else if (card.getMoney() >= 0.2) {
				// 第二种情况：套餐通话时长已用完，账户余额可以支付1分钟通话，使用账户余额支付
				card.setRealTakTime(card.getRealTakTime() + 1); // 实际使用通话时长1分钟
				// 账户余额消费0.2元（1分钟 额外通话）
				card.setMoney(card.getMoney() - 0.2);
				card.setConsumAmout(card.getConsumAmout() + 0.2); // 当月消费金额 +
																	// 0.2
			} else {
				temp = i; // 记录实际通话分钟数
				throw new Exception("本次已经通话" + i + "分钟，您的余额不足，请充值后再使用！");
				// System.err.println("本次已经通话" + i + "分钟，您的余额不足，请充值后再使用！");
			}
		}
		return temp;
	}

	/**
	 * 返回使用流量数
	 * 
	 * @throws Exception
	 */
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
