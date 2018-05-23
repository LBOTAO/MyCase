package cn.happy.service;

import cn.happy.entity.MobileCard;

/**
 * 服务接口
 * @author liutao
 * @data 2018年5月23日 上午10:45:39
 */
public interface CallService {
	
	/**
	 * 通话
	 * @param mainCount
	 * @param card
	 * @return
	 */
	public int call(int mainCount,MobileCard card);

}
