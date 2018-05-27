package cn.happy.service;

import cn.happy.entity.MobileCard;

/**
 * 发送服务接口
 * @author liutao
 * @data 2018年5月23日 上午10:47:09
 */
public interface SendService {
	/**
	 * 发送短信
	 * @param count
	 * @param card
	 * @return
	 * @throws Exception 
	 */
	public int send(int count,MobileCard card) throws Exception;

}
