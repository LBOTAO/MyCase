package cn.happy.util;

import java.text.DecimalFormat;

/**
 * @author liutao
 * @data 2018年5月27日 下午5:32:07
 */
public class Common {
	
	 /** 
     * double类型格式化方法 
     * @param data 
     * @return 
     */  
    public static String dataFormat(double data) {  
        DecimalFormat format=new DecimalFormat("#0.00");  
        return format.format(data);  
    }  
    /** 
     * 类型两数相减 
     * @param sum1 
     * @param sum2 
     * @return 
     */  
    public static double sub(double sum1, double sum2) {  
        return (sum1*10-sum2*10)/10;  
    }  

}
