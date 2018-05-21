package cn.happy.day06.demo1custom;

/**
 * @author liutao
 * @data 2018年5月13日 上午9:44:51
 */
public class Person {
	
	private String name;
	
	private String gender;
	
	

	/**
	 * @param name
	 * @param gender
	 */
	public Person(String name, String gender) {
		super();
		this.name = name;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	

}
