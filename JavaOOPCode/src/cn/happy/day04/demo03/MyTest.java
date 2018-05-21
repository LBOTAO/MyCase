package cn.happy.day04.demo03;

/**
 * @author liutao
 * @data 2018年5月7日 下午12:18:24
 */
public class MyTest {
	/**
	 * 接口实现多态
	 * @param args
	 */
	public static void main(String[] args) {
		Teach[] te=new Teach[2];
		Teach pro=new Professor();
		
		Teach ex=new Expert();
		
		te[0]=pro;
		te[1]=ex;
		
		for (Teach item : te) {
			item.teach();
		}
	}

}
