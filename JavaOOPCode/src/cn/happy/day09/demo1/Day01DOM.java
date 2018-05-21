package cn.happy.day09.demo1;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * @author liutao
 * @data 2018年5月21日 下午2:37:38
 */
public class Day01DOM {
	
	public static void main(String[] args) throws Exception {
		long lasting = System.currentTimeMillis();
		File f=new File("address.xml");
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=factory.newDocumentBuilder();
		Document doc=builder.parse(f);
		NodeList n1=doc.getElementsByTagName("VALUE");
		for (int i = 0; i < n1.getLength(); i++) {
			System.out.println("车牌号码:"+doc.getElementsByTagName("NO").item(i).getFirstChild().getNodeValue());
			System.out.println("车主地址:"+doc.getElementsByTagName("ADDR").item(i).getFirstChild().getNodeValue());
		}
		System.out.println("运行时间：" +(System.currentTimeMillis()- lasting) +"毫秒");
	}

}
