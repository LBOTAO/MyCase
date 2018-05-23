package cn.happy.day08.demo1file;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符流   写入数据
 * @author liutao
 * @data 2018年5月21日 上午9:55:44
 */
public class Day01 {

	public static void main(String[] args) throws IOException {
		
		FileWriter fw=new FileWriter("E:\\data.txt",true);
		String str="hehe";
		fw.write(str);
		fw.close();
		System.out.println("write success!");
		
		/*FileReader fw=new FileReader("E:\\data.txt");
		char[] ch=new char[1024];
		int data=0;
		StringBuffer sb=new StringBuffer();
		while((data=fw.read(ch))!=-1){
			String str=new String(ch, 0, data);
			sb.append(str);
		}
		System.out.println(sb.toString());
		fw.close();*/
	}

}
