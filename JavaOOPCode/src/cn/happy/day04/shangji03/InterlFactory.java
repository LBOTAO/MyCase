package cn.happy.day04.shangji03;

/**
 * @author liutao
 * @data 2018年5月7日 下午3:55:02
 */
public class InterlFactory implements CPU,EMS,HardDisk{

	@Override
	public int getCapacity() {
		return 100;
	}

	@Override
	public String getEMSType() {
		return "cc";
	}

	@Override
	public int getSize() {
		return 10;
	}

	
	@Override
	public String getCPUBrand() {
		return "hh";
	}


	@Override
	public Float getFrequency() {
		return (float) 13.8;
	}

}
