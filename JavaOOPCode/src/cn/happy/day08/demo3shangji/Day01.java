package cn.happy.day08.demo3shangji;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 字节输入输出流
 * @author liutao
 * @data 2018年5月21日 下午4:46:49
 */
public class Day01 {
	
	public static void main(String[] args) throws Exception {
		//创建输入流对象   负责读取data.txt文件
		FileInputStream fis=new FileInputStream("E:\\data.txt");
		//创建输出流对象  负责将文件的内容写入到指定路径
		FileOutputStream fos=new FileOutputStream("F:\\myPrime.txt");
		//创建中转站数组 存放每次读取的内容
		byte[] bytes=new byte[1024];
		//通过循环实现文件读写
		while ((fis.read(bytes))!=-1) {
			fis.read(bytes);   //读取文件
			fos.write(bytes,0,bytes.length); //写入文件 
		}
		System.out.println("success");
		
		//关闭流
		fos.close();
		fis.close();
	}

}
