package cn.happy.day03.demo01;

/**
 * @author liutao
 * @data 2018年5月7日 上午9:15:05
 */
public class Day01 {
	//什么叫做多态
	//解析：不同的对象对于同一种操作做出的响应不同
	/**
	 * 父类作为方法参数  实现多态
	 * @param args
	 */
	public static void main(String[] args) {
		Employee emp = new Employee();
		Traffic traffic = new Car();
		emp.goHome(traffic);
	}

}