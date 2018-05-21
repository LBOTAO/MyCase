package cn.happy.day08.demo1file;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 二进制文件的 对读写
 * @author liutao
 * @data 2018年5月21日 上午10:59:33
 */
public class Day03 {
	
	public static void main(String[] args) throws Exception {
		InputStream fis=new FileInputStream("E:\\image\\th.jpg");
		DataInputStream dis=new DataInputStream(fis);
		
		OutputStream fos=new FileOutputStream("E:\\aiqiyi");
		DataOutputStream dos=new DataOutputStream(fos);
		byte[] bytes=new byte[1024];
		int data=0;
		while ((data=fis.read(bytes))!=-1) {
			dos.write(bytes,0,data);
		}
		
		dos.close();
		dis.close();
		fos.close();
		fis.close();
		
		System.out.println("success");
		
	}

}
