package cn.happy.entity;

import cn.happy.service.CallService;
import cn.happy.service.SendService;

/**
 * 话痨套餐类
 * @author liutao
 * @data 2018年5月23日 上午10:24:15
 */
public class TalkPackage extends ServicePackage implements CallService,SendService{
	//通话时长  
    private int talkTime;  
    //短信条数  
    private int smsCount;  
    //套餐月资费  
    private double price;
    
    
    
	/**
	 * 
	 */
	public TalkPackage() {
		super();
	}
	/**
	 * @param talkTime
	 * @param smsCount
	 * @param price
	 */
	public TalkPackage(int talkTime, int smsCount, double price) {
		super();
		this.talkTime = talkTime;
		this.smsCount = smsCount;
		this.price = price;
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
		
	}
	/**
	 * 
	 */
	@Override
	public int send(int count, MobileCard card) {
		return 0;
	}
	
	@Override
	public int call(int mainCount, MobileCard card) {
		return 0;
	}  
    
    
    

}
