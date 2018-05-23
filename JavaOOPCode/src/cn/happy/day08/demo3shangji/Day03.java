package cn.happy.day08.demo3shangji;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

/**
 * @author liutao
 * @data 2018年5月21日 下午5:36:03
 */
public class Day03 {
	
	public static void main(String[] args) throws Exception {
		
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
