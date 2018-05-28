package cn.happy.entity;

import java.io.Serializable;

import cn.happy.service.CallService;
import cn.happy.service.SendService;
import cn.happy.util.Common;

/**
 * 话痨套餐类
 * 
 * @author liutao
 * @data 2018年5月23日 上午10:24:15
 */
public class TalkPackage extends ServicePackage implements CallService, SendService,Serializable {
	// 通话时长
	private int talkTime;
	// 短信条数
	private int smsCount;
	// 套餐月资费
	private double price;

	/**
	 * @param talkTime
	 * @param smsCount
	 * @param price
	 */
	public TalkPackage() {
		this.talkTime = 500;
		this.smsCount = 30;
		this.price = 58;
	}

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	/***
	 * 输出话痨套餐信息
	 */
	@Override
	public void showInfo() {
		System.out.println("话唠套餐：通话时长为：" + this.getTalkTime() + "分钟/月,短信条数为：" + this.getSmsCount() + "条/月,资费为："
				+ this.getPrice() + "元/月");
	}

	/**
	 * @throws Exception
	 * 
	 */
	@Override
	public int send(int count, MobileCard card) throws Exception {
		int temp = count;
		for (int i = 0; i < count; i++) {
			if (this.smsCount - card.getRealSMSCount() >= 1) {
				card.setRealSMSCount(card.getRealSMSCount() + 1);
			} else if (card.getMoney() >= 0.1) {
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

	@Override
	public int call(int mainCount, MobileCard card) throws Exception {
		int temp = mainCount;
		for (int i = 0; i < mainCount; i++) {
			if (this.talkTime - card.getRealTakTime() >= 1) {
				card.setRealTakTime(card.getRealTakTime() + 1); // 实际通话数据加1
			} else if (card.getMoney() >= 0.2) {
				card.setRealTakTime(card.getRealTakTime() + 1); // 实际通话时长1分钟
				// 账户余额消费0.2元（1分钟 额外通话）
				card.setMoney(Common.sub(card.getMoney(), 0.2));
				card.setConsumAmout(card.getConsumAmout() + 0.2);
			} else {
				temp = i;
				throw new Exception("本次通话" + i + "分钟，您的余额不足，请充值后再使用！");
			}
		}
		return temp;
	}

}
