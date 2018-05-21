package cn.happy.day08.demo1file;

/**
 * @author liutao
 * @data 2018年5月20日 下午5:14:57
 */
public class Demo1 {
	
	public static void main(String[] args) {
		StringBuffer buf=new StringBuffer("Hard ");
		String aString = "Waxworks";
		System.out.println(buf.append(aString,3,6));
	}

}
