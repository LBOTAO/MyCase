package cn.happy.day08.demo1file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

/**
 * 带缓存区的字符流写入读取数据
 * @author liutao
 * @data 2018年5月21日 上午10:13:10
 */
public class Day02 {
	
	public static void main(String[] args) throws Exception {
		readerData();
		//writerData();
	}

	/**
	 * 写入数据 
	 * @throws Exception 
	 * 
	 */
	private static void writerData() throws Exception {
		Writer writer=new FileWriter("E:\\data.txt",true);
		BufferedWriter bw=new BufferedWriter(writer);
		bw.write("123");
		bw.newLine();
		bw.write("456");
		
		bw.close();
		writer.close();
	}

	/**
	 * 读取数据
	 * @throws Exception 
	 * 
	 */
	private static void readerData() throws Exception {
		
		Reader reader=new FileReader("C:\\Windows\\win.ini");
		BufferedReader br=new BufferedReader(reader);
		String line = br.readLine();
		while (line!=null) {
			System.out.println(line);
			line=br.readLine();
		}
		
		br.close();
		reader.close();
	
		
	}
	
	

}
