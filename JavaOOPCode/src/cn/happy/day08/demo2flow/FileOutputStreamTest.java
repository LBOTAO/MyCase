package cn.happy.day08.demo2flow;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节流写入数据 
 * @author liutao
 * @data 2018年5月20日 上午10:48:31
 */
public class FileOutputStreamTest {
	
	//字节流

	public static void main(String[] args) throws IOException {
		/**
		 * fileoutputStream 输出流 写入文件
		 */
		/*
		 * FileOutputStream fos = null;
		 * 
		 * String str = "好好学习java"; byte[] words = str.getBytes(); // 字节数组 //
		 * 创建流对象 以追加方式写入文件 try { fos = new
		 * FileOutputStream("E:\\data.txt",true); // 写入文件
		 * 
		 * fos.write(words, 0, words.length); System.out.println("文件已更新"); }
		 * catch (IOException e) { // TODO Auto-generated catch block
		 * System.out.println("创建文件时出错！"); e.printStackTrace(); }finally {
		 * 
		 * try { if (fos!=null) { fos.close(); } } catch (IOException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); } }
		 */

		FileOutputStream fos = new FileOutputStream("E:\\写入测试.txt");
		String str = "写入成功啦！！";
		byte[] bytes = str.getBytes();
		fos.write(bytes);
		fos.close();
		System.out.println("写入成功！");

	}
}
