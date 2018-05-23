package cn.happy.day08.demo1file;

import java.io.File;
import java.io.IOException;

/**
 * @author liutao
 * @data 2018年5月20日 上午10:06:24
 */
public class FileMethods2 {
	/**
	 * file
	 * 删除  创建 
	 * @param args
	 */
	
	public static void main(String[] args) {
		//创建对象
		FileMethods2 fm=new FileMethods2();
		File file=new File("E:\\hello.txt");
		//调用方法
		fm.create(file);
		fm.showFileInfo(file);
		//fm.delete(file);
	}
	
	
	/**
	 * 创建文件 
	 * @param file
	 */
	public void create(File file){
		if (!file.exists()) {
			try {
				file.createNewFile();
				System.out.println("文件已存在！");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	/**
	 * 删除文件
	 * @param file
	 */
	public void delete(File file){
		if (file.exists()) {
			file.delete();
			System.out.println("文件已删除");
		}
	}
	/**
	 * 显示文件信息
	 */
	public void showFileInfo(File file) {
		if (file.exists()) {  //判断文件或目录是否存在
			if (file.isFile()) {  //如果是文件
				System.out.println("名称："+file.getName());
				System.out.println("相对路径："+file.getPath());
				System.out.println("绝对路径："+file.getAbsolutePath());
				System.out.println("文件大小："+file.length()+"字节");
				
			}
			if (file.isDirectory()) {
				System.out.println("此文件是目录");
			}
		}else {
			System.out.println("文件不存在！");
		}
	}

}
