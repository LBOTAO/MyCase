package cn.happy.day04.demo02;

/**
 * @author liutao
 * @data 2018年5月7日 下午12:00:13
 */
public class CommonHandset extends Handset implements PlayWiring{

	@Override
	public void play() {
		System.out.println("开始播放音乐热血");
		
	}

	@Override
	public void brand() {
		System.out.println("这是一款g502c的索尼爱立信手机");
	}

}
