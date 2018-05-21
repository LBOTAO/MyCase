package cn.happy.day07.demo4printer;

/**
 * @author liutao
 * @data 2018年5月18日 下午12:01:17
 */
public class Printer {

	public void p1() {
		synchronized (this) {
			for (int i = 1; i < 50; i++) {
				System.out.print("淘");
				System.out.print("气");
				System.out.print("爷");
				System.out.print("孙");
				System.out.println("");
			}
		}
	}

	public void p2() {
		synchronized (this) {
			for (int i = 1; i < 50; i++) {
				System.out.print("很");
				System.out.print("好");
				System.out.print("看");
				System.out.println();
			}
		}
	}
}
