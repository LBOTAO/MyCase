package cn.happy.day09.demo1;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

/**
 * @author liutao
 * @data 2018年5月21日 下午3:03:19
 */
public class Day03JDOM {
	
	public static void main(String[] args) throws Exception, IOException {
		long lasting = System.currentTimeMillis();
		SAXBuilder builder=new SAXBuilder();
		Document doc=builder.build(new File("address.xml"));
		Element foo = doc.getRootElement();
		List list = foo.getChildren();
		for (int i = 0; i < list.size(); i++) {
			System.out.println("车牌号码："+((Element)list.get(i)).getChild("NO").getText());
			System.out.println("车主地址："+((Element)list.get(i)).getChild("ADDR").getText());
		}
		System.out.println("运行时间：" +(System.currentTimeMillis()- lasting) +"毫秒");

	}

}
