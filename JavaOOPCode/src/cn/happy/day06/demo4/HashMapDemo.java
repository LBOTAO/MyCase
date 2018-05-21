package cn.happy.day06.demo4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author liutao
 * @data 2018年5月14日 下午2:20:05
 */
public class HashMapDemo {
	
	/**
	 * map 集合遍历方式
	 * @param args
	 */

	public static void main(String[] args) {

		Map<String, String> map=new HashMap<>();
		map.put("CN", "中华人民共和国");
		map.put("USA", "美利坚合众国");
		map.put("HB", "河北");
		map.put("SJZ", "石家庄");
		
		//方式一：key 遍历
		for (String key : map.keySet()) {
			System.out.print(key+"==========>");
			String gj = map.get(key);
			System.out.println(gj);
		}
		System.out.println("======方式一=======");
		//方式二 entry
		Set<Entry<String, String>> entrySet = map.entrySet();
		for (Entry<String, String> entry : entrySet) {
			System.out.println(entry.getKey()+"======>"+entry.getValue());
		}
		System.out.println("------------方式二--------------");
		
		
		//方式三  键值对  values
		for (String valu : map.values()) {
			System.out.println(valu);
		}
		System.out.println("---------------方式三--------------------");
		//迭代器方式  iterator   key
		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			String next = iterator.next();
			System.out.println(next+"========"+map.get(next));
		}
		//迭代器方式  iterator   values
		System.out.println("===============方式四=========================");
		Iterator<String> iterator2 = map.values().iterator();
		while (iterator2.hasNext()) {
			String values = iterator2.next();
			System.out.println(values);
		}
		System.out.println("=================方式五===============");
		Iterator<Entry<String, String>> iterator3 = map.entrySet().iterator();
		while (iterator3.hasNext()) {
			Entry<String, String> entry = iterator3.next();
			System.out.println(entry.getKey()+entry.getValue());
		}
		System.out.println("-----------------");
		String ky = map.get("CN");
		System.out.println(ky);
	}

}
