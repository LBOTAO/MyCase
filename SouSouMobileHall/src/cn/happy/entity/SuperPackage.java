package cn.happy.entity;

import cn.happy.service.CallService;
import cn.happy.service.NetService;
import cn.happy.service.SendService;

/**
 * 超人套餐类
 * @author liutao
 * @data 2018年5月23日 上午10:29:31
 */
public class SuperPackage extends ServicePackage implements CallService,SendService,NetService{
	
	 //通话时长  
    private int talkTime;  
    //短信条数  
    private int smsCount;  
    //上网流量  
    private int flow;  
    //套餐月资费  
    private double price;


   
	/**
	 * 封装属性  带参无参方法
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

	/**
	 * @param talkTime
	 * @param smsCount
	 * @param flow
	 * @param price
	 */
	public SuperPackage(int talkTime, int smsCount, int flow, double price) {
		super();
		this.talkTime = talkTime;
		this.smsCount = smsCount;
		this.flow = flow;
		this.price = price;
	}
	
	

	/**
	 * 
	 */
	public SuperPackage() {
		super();
	}
	
	
	 /**
     * 输出超人套餐信息
     */
	@Override
	public void showInfo() {
		// TODO Auto-generated method stub
		
	}

   
	/**
	 * 返回实际发送短信数
	 */
	@Override
	public int send(int count, MobileCard card) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 返回通话时长
	 */
	@Override
	public int call(int mainCount, MobileCard card) {
		// TODO Auto-generated method stub
		return 0;
	}


	/**
	 * 返回使用流量数
	 */
	@Override
	public int netPlay(int flow, MobileCard card) {
		return 0;
	}  
	
	
	
	
	

}
