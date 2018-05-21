package cn.happy.day05.demo02log4j;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author liutao
 * @data 2018年5月11日 上午9:23:28
 */
public class Log4jDemo {
	/**
	 *
	 * 	public static final Level OFF = new Level(0x7fffffff, "OFF", 0);
	    public static final Level FATAL = new Level(50000, "FATAL", 0);
	    public static final Level ERROR = new Level(40000, "ERROR", 3);
	    public static final Level WARN = new Level(30000, "WARN", 4);
	    public static final Level INFO = new Level(20000, "INFO", 6);
	    public static final Level DEBUG = new Level(10000, "DEBUG", 7);
	    public static final Level TRACE = new Level(5000, "TRACE", 7);
	    public static final Level ALL = new Level(0x80000000, "ALL", 7);
	 * 
	 * DEBUG：输出调试信息；指出细粒度信息事件对调试应用程序是非常有帮助的。 
	 * INFO：输出提示信息；消息在粗粒度级别上突出强调应用程序的运行过程。
	 * WARN： 输出警告信息；表明会出现潜在错误的情形。
	 * ERROR：输出错误信息；指出虽然发生错误事件，但仍然不影响系统的继续运行。 
	 * FATAL：输出致命错误；指出每个严重的错误事件将会导致应用程序的退出。 
	 * ALL level：打开所有日志记录开关；是最低等级的，用于打开所有日志记录。
	 * OFF level：关闭所有日志记录开关；是最高等级的，用于关闭所有日志记录。
	 * TRACE:是追踪，就是程序推进以下，你就可以写个trace输出，所以trace应该会特别多，不过没关系，我们可以设置最低日志级别不让他输出。
	 * 按照范围从小到大排序：OFF level > FATAL > ERROR > WARN > INFO > DEBUG >TRACE > ALL level；
	 * 范围大的会包含范围小的，例如日志设置为INFO级别的话则FATAL、ERROR、WARN、INFO的日志开关都是打开的，而DEBUG的日志开关将是关闭的。
	 * 
	 * Log4j建议只使用四个级别，优先级从高到低分别是 ERROR、WARN、INFO、DEBUG。
	 */
	
	//log4j的
	//private static Logger logger = Logger.getLogger(Log4jDemo.class.getName());
	
	//logback
	private static Logger logger=LoggerFactory.getLogger(Log4jDemo.class.getName());

	/**
	 * throws声明异常，抛给调用者处理，调用者必须进行try..catch 位置： 方法名后面进行 声明异常，多个异常使用逗号隔开
	 * 
	 */
	public static void divid() {

		try {
			Scanner input = new Scanner(System.in);
			System.out.print("请输入第一个整数：");
			int num1 = input.nextInt();// 1）输入不是整数类型 2）除法 输入 0
			logger.debug("输入第一个整数" + num1);
			System.out.print("请输入第二个整数：");
			int num2 = input.nextInt();
			logger.debug("输入第二个整数" + num2);
			int jg = num1 / num2;// 输入num2可能输入 0
			String str = String.format("%d/%d=%d", num1, num2, num1 / num2);
			logger.debug("输出结果：" + str);
			System.out.println(jg);
		} catch (InputMismatchException e) {
			logger.error(e.getMessage() + "输入不匹配");
		} catch (ArithmeticException e) {
			logger.error(e.getMessage() + "除数不能为0");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// 调用处不处理，抛给了java虚拟机继续处理
		divid();

		
	}

}
