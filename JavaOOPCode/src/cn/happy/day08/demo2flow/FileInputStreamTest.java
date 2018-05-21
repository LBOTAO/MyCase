package cn.happy.day08.demo2flow;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 
 * 字节流  读取数据
 * @author liutao
 * @data 2018年5月20日 上午10:21:04
 */
public class FileInputStreamTest {
	/**
	 *  
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			readDataFormDisk();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 字节流读取数据
	 * 
	 * @throws IOException
	 */
	private static void readDataFormDisk() throws IOException {
		FileInputStream fis = new FileInputStream("E:\\data.txt");
		// 创建缓存区 大小是1k
		byte[] bytes = new byte[1024];
		int data = 0;
		StringBuffer sb = new StringBuffer();
		while ((data = fis.read(bytes)) != -1) { // read方法返回读取的字节个数 如果读完会返回-1   把字节存入到数组缓存区中  一下读取一个数组缓存区   一下读取一个数组缓存区  
			String temp = new String(bytes, 0, data);
			sb.append(temp);
			System.out.println(data + "----------------");
		}
		System.out.println(sb.toString());
		fis.close();

	}

}
