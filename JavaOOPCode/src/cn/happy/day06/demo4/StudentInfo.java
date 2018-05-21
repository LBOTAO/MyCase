package cn.happy.day06.demo4;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author liutao
 * @data 2018年5月14日 下午4:05:46
 */
public class StudentInfo {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("张三	", 100);
		map.put("张四", 85);
		map.put("张五", 90);
		
		for (Entry<String, Integer> values : map.entrySet()) {
			System.out.println(values.getKey()+"===="+values.getValue());
		}
		map.put("张四", 86);
		System.out.println("修改后================");
		for (Entry<String, Integer> values : map.entrySet()) {
			System.out.println(values.getKey()+"===="+values.getValue());
		}
	}

}
