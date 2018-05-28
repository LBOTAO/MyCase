package cn.happy.day09.demo2;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * DOM方式解析xml文件
 * 
 * @author liutao
 * @data 2018年5月28日 上午9:56:23
 */
public class DomXmlTest {

	public static void main(String[] args) throws Exception {
		// readXML();
		// createXML();
		// update();
		del();
	}

	/**
	 * @throws Exception
	 * 
	 */
	private static void del() throws Exception {
		// 创建工厂
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		// 创建解析器
		DocumentBuilder builder = factory.newDocumentBuilder();

		// 解析
		Document document = builder.parse("address.xml");

		Element address = (Element) document.getElementsByTagName("VALUE").item(3); // 子节点

		document.getElementsByTagName("RESULT").item(0).removeChild(address); // 父节点

		// 传输工厂
		TransformerFactory tf = TransformerFactory.newInstance();
		// 传输器 传输工具
		Transformer newTransformer = tf.newTransformer();

		Source source = new DOMSource(document);

		Result result = new StreamResult("address.xml");
		// 传输方法
		newTransformer.transform(source, result);

		System.out.println("DEL success!");

	}

	/**
	 * 修改节点
	 * 
	 * @throws Exception
	 */
	private static void update() throws Exception {
		// 创建工厂
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		// 创建解析器
		DocumentBuilder builder = factory.newDocumentBuilder();

		// 解析
		Document document = builder.parse("address.xml");

		Element address = (Element) document.getElementsByTagName("VALUE").item(3);

		address.getElementsByTagName("ADDR").item(0).setTextContent("河北省石家庄省会");

		// 传输工厂
		TransformerFactory tf = TransformerFactory.newInstance();
		// 传输器 传输工具
		Transformer newTransformer = tf.newTransformer();

		Source source = new DOMSource(document);

		Result result = new StreamResult("address.xml");
		// 传输方法
		newTransformer.transform(source, result);

		System.out.println("UPDATE success!");
	}

	/**
	 * 增加节点
	 * 
	 * @throws Exception
	 */
	private static void createXML() throws Exception {

		// 创建工厂
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		// 创建解析器
		DocumentBuilder builder = factory.newDocumentBuilder();

		// 解析
		Document document = builder.parse("address.xml");

		Element element = document.createElement("VALUE");
		element.setAttribute("type", "s4");

		Element no = document.createElement("NO");
		no.setTextContent("d1234");

		Element addr = document.createElement("ADDR");
		addr.setTextContent("河北石家庄");

		element.appendChild(no);
		element.appendChild(addr);

		// 将value节点和整个文件建立关联
		document.getElementsByTagName("RESULT").item(0).appendChild(element);

		// 传输工厂
		TransformerFactory tf = TransformerFactory.newInstance();
		// 传输器 传输工具
		Transformer newTransformer = tf.newTransformer();

		Source source = new DOMSource(document);

		Result result = new StreamResult("address.xml");
		// 传输方法
		newTransformer.transform(source, result);

		System.out.println("save success!");
	}

	/**
	 * 解析xml
	 * 
	 * @throws Exception
	 */
	public static void readXML() throws Exception {
		// 创建工厂
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		// 创建解析器
		DocumentBuilder builder = factory.newDocumentBuilder();

		// 解析
		Document document = builder.parse("address.xml");
		NodeList list = document.getElementsByTagName("VALUE");

		for (int i = 0; i < list.getLength(); i++) {
			Element item = (Element) list.item(i);
			String no = item.getElementsByTagName("NO").item(0).getTextContent();
			String addr = item.getElementsByTagName("ADDR").item(0).getTextContent();
			String attribute = item.getAttribute("type");
			System.out.println(no);
			System.out.println(addr);
			System.out.println(attribute);

			System.out.println("==================");
		}
	}

}
