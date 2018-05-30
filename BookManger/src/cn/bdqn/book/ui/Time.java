/**
 * 
 */
package cn.bdqn.book.ui;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Administrator
 *
 */
public class Time {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String time = sdf.format(date);
		System.out.println(time);
	}

}
