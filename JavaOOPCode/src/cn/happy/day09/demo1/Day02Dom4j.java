package cn.happy.day09.demo1;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @author liutao
 * @data 2018年5月21日 下午2:54:58
 */
public class Day02Dom4j {
	
	public static void main(String[] args) throws Exception {
		long lasting=System.currentTimeMillis();
		File f=new File("address.xml");
		SAXReader reader=new SAXReader();
		Document doc = reader.read(f);
		Element root = doc.getRootElement();
		Element foo;
		for (Iterator i=root.elementIterator("VALUE");i.hasNext();) {
			foo=(Element)i.next();
			System.out.println("车牌号码 ："+foo.elementText("NO"));
			System.out.println("车主地址 ："+foo.elementText("ADDR"));
		}
		System.out.println("运行时间：" +(System.currentTimeMillis()- lasting) +"毫秒");
	}

}
