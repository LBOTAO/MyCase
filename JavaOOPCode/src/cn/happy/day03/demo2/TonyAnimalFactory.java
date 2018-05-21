package cn.happy.day03.demo2;

/**
 * 动物玩具工厂
 * @author liutao
 * @data 2018年5月7日 上午10:05:16
 */
public class TonyAnimalFactory {
	
	public static TonyAnimal getIntance(String type){
		TonyAnimal adAnimal=null;
		switch (type) {
		case "chicken":
			adAnimal=new ChickenAnimal();
			break;

		case "lion":
			adAnimal=new LionAnimal();
			break;
		}
		return adAnimal;
	}

}
