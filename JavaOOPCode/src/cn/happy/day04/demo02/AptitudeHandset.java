package cn.happy.day04.demo02;

/**
 * @author liutao
 * @data 2018年5月7日 下午12:02:44
 */
public class AptitudeHandset extends Handset implements NetWork, PlayWiring {
	
	@Override
	public void play() {
		System.out.println("播放小时代");

	}

	@Override
	public void netWork() {
		System.out.println("已经启动移动网路");
	}

	@Override
	public void brand() {
		System.out.println("这是一款型号为HTC的I9100手机");
	}

}
