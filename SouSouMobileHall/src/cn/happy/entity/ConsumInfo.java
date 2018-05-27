package cn.happy.entity;

/**
 * 消费信息类
 * @author liutao
 * @data 2018年5月23日 上午10:31:54
 */
public class ConsumInfo {
	
	//卡号  
    private String number;  
    //消费类型  
    private String type;  
    //短信条数 上网(MB)  
    private int consumData;
    
    
    
    
	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getConsumData() {
		return consumData;
	}


	public void setConsumData(int consumData) {
		this.consumData = consumData;
	}


	/**
	 * @param number
	 * @param type
	 * @param consumData
	 */
	public ConsumInfo(String number, String type, int consumData) {
		super();
		this.number = number;
		this.type = type;
		this.consumData = consumData;
	} 
    
    
    

}
