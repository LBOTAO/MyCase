package cn.happy.day08.demo1file;

import java.io.File;

/**
 * @author liutao
 * @data 2018年5月20日 上午9:53:42
 */
public class FileMethods {
	/**
	 * 使用file获取文件属性
	 * @param args
	 */

	public static void main(String[] args) {
		FileMethods fm = new FileMethods();
		File file = new File("E:\\data.txt");
		
		fm.showFileInfo(file);
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
