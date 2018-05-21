package cn.happy.day09.demo1;

import java.util.Stack;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author liutao
 * @data 2018年5月21日 下午3:16:55
 */
public class Day04SAX extends DefaultHandler {

	Stack tags = new Stack();

	public static void main(String[] args) throws Exception, SAXException {
		long lasting = System.currentTimeMillis();
		SAXParserFactory sf = SAXParserFactory.newInstance();
		SAXParser sp = sf.newSAXParser();
		Day04SAX sax = new Day04SAX();
		sp.parse(new InputSource("address.xml"), sax);

		System.out.println("运行时间：" +(System.currentTimeMillis()- lasting) +"毫秒");

	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		tags.push(qName);
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String tag = (String) tags.peek();
		if (tag.equals("NO")) {
			System.out.println("车牌号码：" + new String(ch, start, length));
		}
		if (tag.equals("ADDR")) {
			System.out.println("地址：" + new String(ch, start, length));
		}
	}

}
