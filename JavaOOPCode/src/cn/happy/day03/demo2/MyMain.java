package cn.happy.day03.demo2;

/**
 * @author liutao
 * @data 2018年5月7日 上午10:08:07
 */
public class MyMain {
	
	public static void main(String[] args) {
		TonyAnimal lion=TonyAnimalFactory.getIntance("lion");
		TonyAnimal chicken=TonyAnimalFactory.getIntance("chicken");
		
		TonyAnimal[] animals=new TonyAnimal[2];
		animals[0]=lion;
		animals[1]=chicken;
		
		for (TonyAnimal item : animals) {
			item.playedBySomeBody();
		}
	}
}
