package cn.happy.entity;

/**
 * 使用场景类
 * 
 * @author liutao
 * @data 2018年5月23日 上午10:32:59
 */
public class Scene {

	private String type; // 场景类型
	private int data; // 场景消费数据
	private String description; // 场景描述
	
	
	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public int getData() {
		return data;
	}



	public void setData(int data) {
		this.data = data;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	/**
	 * @param type
	 * @param data
	 * @param description
	 */
	public Scene(String type, int data, String description) {
		super();
		this.type = type;
		this.data = data;
		this.description = description;
	}
	
	

}
