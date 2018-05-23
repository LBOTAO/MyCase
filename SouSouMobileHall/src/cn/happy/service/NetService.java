package cn.happy.service;

import cn.happy.entity.MobileCard;

/**
 * 网络服务接口
 * @author liutao
 * @data 2018年5月23日 上午10:49:00
 */
public interface NetService {
	
	/**
	 * 上网
	 * @param flow
	 * @param card
	 * @return
	 */
	public int netPlay(int flow,MobileCard card);

}
