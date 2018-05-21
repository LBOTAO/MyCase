package cn.happy.day05.demo01mianshiti;

/**
 * @author liutao
 * @data 2018年5月9日 下午12:18:01
 */
public class Ti02 {
	static int test() {
		int x = 1;
		try {
			x++;
			return x; // 新开一块空间 ，将x的值保存一份，以方便方法调度放获取该值。
		} finally {
			++x;
		}
	}

}
