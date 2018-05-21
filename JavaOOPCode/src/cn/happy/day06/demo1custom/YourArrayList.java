package cn.happy.day06.demo1custom;

import java.util.ArrayList;

/**
 * @author liutao
 * @data 2018年5月13日 上午9:42:31
 */
public class YourArrayList<E> extends ArrayList<E>{
	
	 public synchronized boolean add(E e) {
	        return  super.add(e);
	    }
}
