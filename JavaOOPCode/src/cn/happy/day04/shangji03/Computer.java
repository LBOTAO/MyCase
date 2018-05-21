package cn.happy.day04.shangji03;

/**
 * @author liutao
 * @data 2018年5月7日 下午3:16:42
 */
public class Computer {
	CPU cpu;
	EMS ems;
	HardDisk hardDisk;
	
	/**
	 * @param cpu
	 * @param ems
	 * @param hardDisk
	 */
	public Computer(CPU cpu, EMS ems, HardDisk hardDisk) {
		this.cpu = cpu;
		this.ems = ems;
		this.hardDisk = hardDisk;
	}
	
	public void showInfo(){
		System.out.println("计算机的信息如下"+"\nCPU的品牌是"+cpu.getCPUBrand()+"\nCPU的主频是"+cpu.getFrequency()+"\n硬盘容量是"+hardDisk.getCapacity()+"\n内存容量是"+ems.getSize());
	}

}
