package cn.happy.day04.demo02;

/**
 * @author liutao
 * @data 2018年5月7日 下午12:05:21
 */
public class MyTest {
	public static void main(String[] args) {
		CommonHandset comm=new CommonHandset();
		comm.brand();
		comm.play();
		
		AptitudeHandset ap=new AptitudeHandset();
		ap.brand();
		ap.netWork();
		ap.play();
	}

}
