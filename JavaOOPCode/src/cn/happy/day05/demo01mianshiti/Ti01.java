package cn.happy.day05.demo01mianshiti;

/**
 * @author liutao
 * @data 2018年5月9日 下午12:15:54
 */
public class Ti01 {
	public static void main(String[] args) {
		int result=test();
		System.out.println(result);
	}
	@SuppressWarnings({ "unused", "finally" })
	static int test() {
		int x = 1;

		try {
			int result = 5 / 0;
			x++;
		} catch (Exception ex) {
			return x++; // 1
		} finally {
			return ++x;
		}
	}

}
