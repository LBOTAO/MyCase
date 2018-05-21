package cn.happy.day06.demo3;

/**
 * @author liutao
 * @data 2018年5月13日 下午7:33:26
 */
public class Dog {
	
	private String name;
	private int age;
	
	@Override
	public int hashCode() {
		int h=85;
		h = 31 * h + age;
		return h;
	}
	
	@Override
	public boolean equals(Object obj) {
		Dog d=(Dog)obj;
		if (d.getAge()==this.age) {
			return true;
		}else {
			return false;
		}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	

}
