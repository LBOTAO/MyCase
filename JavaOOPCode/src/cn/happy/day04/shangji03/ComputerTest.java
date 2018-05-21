package cn.happy.day04.shangji03;

/**
 * @author liutao
 * @data 2018年5月7日 下午3:23:39
 */
public class ComputerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InterlFactory interlFactory=new InterlFactory();
		
		Computer cm=new Computer(interlFactory,interlFactory,interlFactory);
		
		cm.showInfo();
	}

}
